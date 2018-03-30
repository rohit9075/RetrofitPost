package rohit.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Property;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    ArrayList<Product> productList;
    Bundle bd1;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//int a= bd1.describeContents();
//
  //      Log.d("TAG", "onCreate: "+a);
        bd1 = getIntent().getExtras();

        if(bd1!=null)
        {
            productList = bd1.getParcelableArrayList("data");

        }
      //  Toast.makeText(getApplicationContext(),productList.toString(),Toast.LENGTH_LONG).show();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));





ProductAdapter adapter=new ProductAdapter(R.layout.card_row,this,productList);
recyclerView.setAdapter(adapter);

    }
}
