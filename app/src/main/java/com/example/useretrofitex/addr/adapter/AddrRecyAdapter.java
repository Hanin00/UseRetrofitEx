package com.example.useretrofitex.addr.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useretrofitex.R;
import com.example.useretrofitex.addr.model.AddressResponse;

import java.util.ArrayList;

public class AddrRecyAdapter extends RecyclerView.Adapter<AddrRecyAdapter.ViewHolder> {

    private ArrayList<AddressResponse> mAddrList;
    private Context context;

    public AddrRecyAdapter(ArrayList<AddressResponse> data, Context context) {
        this.mAddrList = data;
        this.context = context;
    }

    @NonNull
    @Override
    public AddrRecyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new AddrRecyAdapter.ViewHolder(inflater.inflate(R.layout.item_addr_list, parent, false));
    }

    @Override
    public int getItemCount() {
        return mAddrList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull AddrRecyAdapter.ViewHolder holder, int position) {
        holder.tvNumber.setText(mAddrList.get(position).getNumber());
        holder.tvAddress.setText(mAddrList.get(position).getAddress());

        holder.btn.setOnClickListener((v)->{

            Toast.makeText(context,"승강기 번호 : "+mAddrList.get(position).getNumber(), Toast.LENGTH_SHORT).show();
        });
    }

    /*
        public void setmAddrList(ArrayList<AddressResponse> list){
            this.mAddrList = list;
            notifyDataSetChanged();
        }
        */
    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView btn;
        TextView tvNumber;
        TextView tvAddress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btn = (ImageView) itemView.findViewById(R.id.list_addr_btn_next);
            tvNumber = (TextView) itemView.findViewById(R.id.list_addr_tv_number);
            tvAddress = (TextView) itemView.findViewById(R.id.list_addr_tv_addr);
        }


    }
}