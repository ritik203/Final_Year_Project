package com.example.mobileshop.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mobileshop.Entity.Mobile;
import com.example.mobileshop.R;
import com.example.mobileshop.Utils.MobileListAdapter;
import com.example.mobileshop.Utils.RetrofitClient;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MobileListFragment extends Fragment {
  RecyclerView recyclerView;
  MobileListAdapter mobileListAdapter;
   List<Mobile> mobileList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_mobile_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mobileList=new ArrayList<>();
        mobileList.add(new Mobile(0,"Mob2",0,0,"Comp2",2000,""));
        mobileListAdapter=new MobileListAdapter(getContext(),mobileList);

        recyclerView=view.findViewById(R.id.recyclearView);
        Log.e("onViewCreated: ", recyclerView.toString());
        recyclerView.setAdapter(mobileListAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
    }
    @Override
    public void onStart() {
        getAllMobiles();
        super.onStart();
    }
    public void getAllMobiles(){
        RetrofitClient.getInstance().getApi().getAllMobiles().enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(response.body().get("status").getAsString().equals("success")){
                    JsonArray array = response.body().get("data").getAsJsonArray();
                    mobileList.clear();
                    for(JsonElement element : array)
                    {
                        Mobile mobile = new Mobile();
                        JsonObject jsonObject = element.getAsJsonObject();
                        mobile.setId(jsonObject.get("id").getAsInt());
                        mobile.setName(jsonObject.get("name").getAsString());
                        mobile.setCompany(jsonObject.get("company").getAsString());
                        mobile.setRam(jsonObject.get("ram").getAsInt());
                        mobile.setStorage(jsonObject.get("storage").getAsInt());
                        mobile.setPrice(jsonObject.get("price").getAsDouble());
                        mobile.setImage(jsonObject.get("image").getAsString());
                        mobileList.add(mobile);
                    }
                    mobileListAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable throwable) {
                Toast.makeText(getContext(), "Something went wrong...", Toast.LENGTH_SHORT).show();

            }
        });
    }
}