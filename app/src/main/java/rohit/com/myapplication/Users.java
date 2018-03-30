package rohit.com.myapplication;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Users {

    private Boolean error;

    @SerializedName("Success")
    private int Success;

    @SerializedName("data")
    private ArrayList<Product> products;

    public Users() {


    }

    public Boolean getError() {
        if(Success!=0){
            error = false;
        }else{
            error = true;
        }
        return error;
    }
    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
