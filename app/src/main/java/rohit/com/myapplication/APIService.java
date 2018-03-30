package rohit.com.myapplication;

import org.json.JSONArray;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIService {

    @FormUrlEncoded
    @POST("Postuserlist")
    Call<Users> userLogin(
            @Field("subscriptionId") String email,
            @Field("RoleID") String password
    );

//    //getting messages
//    @GET("messages/{id}")
//    Call<Messages> getMessages(@Path("id") int id);

}
