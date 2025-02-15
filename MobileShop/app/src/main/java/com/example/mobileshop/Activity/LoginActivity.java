package com.example.mobileshop.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mobileshop.Entity.User;
import com.example.mobileshop.R;
import com.example.mobileshop.Utils.Constants;
import com.example.mobileshop.Utils.RetrofitClient;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText editEmail,editPassword;
     CheckBox checkBox;
    TextView textRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail=findViewById(R.id.editEmail);
        editPassword=findViewById(R.id.editPassword);
        textRegister=findViewById(R.id.textRegister);
        checkBox=findViewById(R.id.checkbox);
       if(getSharedPreferences(Constants.Shared_Prefrence_File,MODE_PRIVATE).getBoolean(Constants.LOGIN_STATUS,false)){
            startActivity(new Intent(this, HomeActivity.class));
           finish();
        }


       textRegister.setOnClickListener(v -> startActivity(new Intent(this, RegisterActivity.class)));



    }


    public void login(View view){
      String email=editEmail.getText().toString();
      String password=editPassword.getText().toString();

      if(email.isEmpty()){
          Toast.makeText(this, "Email Can't be Empty", Toast.LENGTH_SHORT).show();
      }else if (password.isEmpty()){
          Toast.makeText(this, "Password can't be Empty", Toast.LENGTH_SHORT).show();
      }
      else{

          RetrofitClient.getInstance().getApi().loginUser(new User(email,password)).enqueue(new Callback<JsonObject>() {
              @Override
              public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                  if(response.body().get("status").getAsString().equals("success")){
                      int id=response.body().get("data").getAsJsonObject().get("id").getAsInt();
                      SharedPreferences preferences=getSharedPreferences(Constants.Shared_Prefrence_File,MODE_PRIVATE);
                      preferences.edit().putInt(Constants.User_id,id).apply();
                      if(checkBox.isChecked()){
                          preferences.edit().putBoolean(Constants.LOGIN_STATUS,true).apply();
                          Toast.makeText(LoginActivity.this, "Login sucessfull", Toast.LENGTH_SHORT).show();
                          startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                          finish();
                      }else {
                          Toast.makeText(LoginActivity.this, "Invalid Credentails", Toast.LENGTH_SHORT).show();
                      }

                  }

              }

              @Override
              public void onFailure(Call<JsonObject> call, Throwable throwable) {
                  throwable.printStackTrace();
                  Toast.makeText(LoginActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
              }
          });

      }




    }
}