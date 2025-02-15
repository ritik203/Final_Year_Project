package com.example.mobileshop.Utils;

import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mobileshop.Activity.DetailsActivity;
import com.example.mobileshop.Entity.Mobile;
import com.example.mobileshop.R;

import java.util.List;

public class MobileListAdapter extends RecyclerView.Adapter<MobileListAdapter.MyViewHolder> {
Context context;
List<Mobile> mobileList;



    public MobileListAdapter(Context context, List<Mobile> mobileList) {
        this.context = context;
        this.mobileList = mobileList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(context).inflate(R.layout.mobiles_lists,null);
      return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Mobile mobile=mobileList.get(position);
        holder.textName.setText(mobile.getName());
        holder.textPrice.setText("Rs _"+mobile.getPrice());
        Glide
                .with(context)
                .load(Constants.BASE_URL + "/images/" + mobile.getImage())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mobileList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
       TextView textName,textPrice;
       ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            textName=itemView.findViewById(R.id.textName);
            textPrice=itemView.findViewById(R.id.textPrice);
            imageView=itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(v -> {
                Intent intent=new Intent(context, DetailsActivity.class);
                intent.putExtra(Constants.MOBILE,mobileList.get(getAdapterPosition()));
                context.startActivity(intent);
            });



        }
    }
}
