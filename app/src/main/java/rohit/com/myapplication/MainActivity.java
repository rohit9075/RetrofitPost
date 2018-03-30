package rohit.com.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText id,passwor;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = (EditText) findViewById(R.id.idEmail);
        passwor = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userSignIn();
            }
        });
    }

    private void userSignIn() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();

        String email = id.getText().toString().trim();
        String password = passwor.getText().toString().trim();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final APIService service = retrofit.create(APIService.class);

        Call<Users> call = service.userLogin(email, password);

        call.enqueue(new Callback<Users>() {
            @Override

            public void onResponse(Call<Users> call, Response<Users> response) {
                progressDialog.dismiss();
                if (!response.body().getError()) {
                    ArrayList <Product> data = response.body().getProducts();
                   // ArrayList arrayList = new ArrayList<>(Arrays.asList(data));


                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putParcelableArrayListExtra("data",(ArrayList<? extends Parcelable>) data);

                    startActivity(intent);

//                   Log.d("List Of Data", "onResponse: "+response.body().getProducts().get(0).getUserId());

//                    Toast.makeText(getApplicationContext(),data.toString(),Toast.LENGTH_SHORT).show();
//                    Toast.makeText(getApplicationContext(),String.valueOf(response.body().getProducts().get(0).toString()),Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid email or password", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {

            }
        });


//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(APIUrl.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        APIService api = retrofit.create(APIService.class);
//        api.userLogin(
//                id.getText().toString().trim(),
//                passwor.getText().toString().trim(),
//                new Callback<Response>() {
//
//                    @Override
//                    public void onResponse(Call<Response> call, Response<Response> response) {
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<Response> call, Throwable t) {
//
//                    }
//                }
//        );
    }

}
