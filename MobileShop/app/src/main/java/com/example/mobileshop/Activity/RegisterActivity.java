package com.example.mobileshop.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mobileshop.Entity.User;
import com.example.mobileshop.R;
import com.example.mobileshop.Utils.RetrofitClient;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText editName,editEmail,editPassword,editConfirmPassword,editMobile;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editName=findViewById(R.id.editName);
        editEmail=findViewById(R.id.editEmail);
        editPassword=findViewById(R.id.editPassword);
        editConfirmPassword=findViewById(R.id.editConfirmPassword);
        editMobile=findViewById(R.id.editMobile);



    }





    public void register(View view){
        String name,email,password,confirmPassword,mobile;

        name=editName.getText().toString();
        email=editEmail.getText().toString();
        password=editPassword.getText().toString();
        confirmPassword=editConfirmPassword.getText().toString();
        mobile=editMobile.getText().toString();

        if(name.equals("")){
            Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
        }
        else if(email.equals("")){
            Toast.makeText(this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
        }
        else if(password.equals("")){
            Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
        }
        else if(confirmPassword.equals("")){
            Toast.makeText(this, "Confirm Password cannot be empty", Toast.LENGTH_SHORT).show();
        }
        else if(mobile.equals("")){
            Toast.makeText(this, "Mobile cannot be empty", Toast.LENGTH_SHORT).show();
        }
        else if(!password.equals(confirmPassword)){
            Toast.makeText(this, "Password and Confirm Password doesn't match", Toast.LENGTH_SHORT).show();
        }
        else{
            user =new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setMobile(mobile);
            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();

        }  if(user!=null){
            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
            RetrofitClient.getInstance().getApi().registerUser(user).enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    if(response.body().get("status").getAsString().equals("success")){
                    Toast.makeText(RegisterActivity.this, "User Registered Sucessfully", Toast.LENGTH_SHORT).show();
                   finish();
                }else {
                        Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                    }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable throwable) {
                    Toast.makeText(RegisterActivity.this, "Something went Wrong", Toast.LENGTH_SHORT).show();
                }
            });
        }




    }
}