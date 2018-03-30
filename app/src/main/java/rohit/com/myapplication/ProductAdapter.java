package rohit.com.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import static android.widget.Toast.*;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {


    private static final String TAG = "Adapter";
    //this context we will use to inflate the layout
    private Context mCtx;
    private int listItemLayout;

    //we are storing all the products in a list
    private List<Product> productList;

    //getting the context and product list with constructor
    public ProductAdapter(int listItemLayout,Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.listItemLayout = listItemLayout;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
//        View view = inflater.inflate(R.layout.activity_home, null);
//        return new ProductViewHolder(view);

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row,parent,false);
        return new ProductViewHolder(view);


    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        Product product = productList.get(position);



        //binding the data with the viewholder views
        holder.UserId.setText(product.getUserId());
        String userId = product.getUserId();
        Log.d(TAG, "onBindViewHolder: "+userId);
        makeText(mCtx,userId, LENGTH_LONG).show();
//        holder.FullName.setText(product.getFullName().toString());
//        holder.ProfileIcon.setText(product.getProfileIcon().toString());
//        holder.Email.setText(product.getEmail().toString());
//        holder.Mobile.setText(product.getMobile().toString());
//        holder.RoleID.setText(product.getRoleID().toString());
//        holder.RoleName.setText(product.getRoleName().toString());
//        holder.ManagerName.setText(product.getManagerName().toString());
//        holder.Status.setText(product.getStatus().toString());


    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

      TextView UserId;

        private ProductViewHolder(View itemView) {
            super(itemView);

            UserId = (TextView) itemView.findViewById(R.id.UserId);
//            FullName = (TextView)itemView.findViewById(R.id.FullName);
//            ProfileIcon =(TextView) itemView.findViewById(R.id.ProfileIcon);
//            Email = (TextView)itemView.findViewById(R.id.Email);
//            Mobile = (TextView)itemView.findViewById(R.id.Mobile);
//            RoleID = (TextView)itemView.findViewById(R.id.RoleID);
//            RoleName = (TextView)itemView.findViewById(R.id.RoleName);
//            ManagerName= (TextView)itemView.findViewById(R.id.ManagerName);
//            Status = (TextView)itemView.findViewById(R.id.Status);



        }
    }
}

