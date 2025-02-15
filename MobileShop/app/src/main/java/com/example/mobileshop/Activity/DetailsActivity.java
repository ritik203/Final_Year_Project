package com.example.mobileshop.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.mobileshop.Entity.Mobile;
import com.example.mobileshop.Entity.Order;
import com.example.mobileshop.R;
import com.example.mobileshop.Utils.Constants;
import com.example.mobileshop.Utils.RetrofitClient;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {
    TextView textName, textCompany, textPrice, textRam, textStorage;
    ImageView imageView;
    Mobile mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setContentView(R.layout.activity_details);
        textName = findViewById(R.id.textName);
        textCompany = findViewById(R.id.textCompany);
        textPrice = findViewById(R.id.textPrice);
        textRam = findViewById(R.id.textRam);
        textStorage = findViewById(R.id.textStorage);
        imageView = findViewById(R.id.imageView);

        mobile= (Mobile) getIntent().getSerializableExtra(Constants.MOBILE);
        textName.setText("Name_"+mobile.getName());
        textCompany.setText("Company - " + mobile.getCompany());
        textPrice.setText("Rs - " + mobile.getPrice());
        textRam.setText("Ram - " + mobile.getRam());
        textStorage.setText("Storage - " + mobile.getStorage());
        Glide.with(this).load(Constants.BASE_URL + "/images/" + mobile.getImage()).into(imageView);


    }
    public void buy(View view){
        int mid = mobile.getId();
        int uid = getSharedPreferences(Constants.Shared_Prefrence_File,MODE_PRIVATE)
                .getInt(Constants.User_id,0);
        Order order = new Order(0,uid,mid);
        RetrofitClient.getInstance().getApi().placeOrder(order).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.body().get("status").getAsString().equals("success")){
                    Toast.makeText(DetailsActivity.this, "Order Placed Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable throwable) {
                Toast.makeText(DetailsActivity.this, "Something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });



    }


}