package one.media.pager;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import one.media.R;
import one.media.model.Product;
import one.media.utils.Extenso;

public class RvProduct extends RecyclerView.Adapter<RvProduct.MyViewHoder> {
    private Context mContext;
    private List<Product> mData;

    public RvProduct(Context mContext, List<Product> mData ) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHoder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_product, viewGroup,false);

        MyViewHoder viewHoder = new MyViewHoder(v);

        return viewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHoder holder, final int position) {
        holder.tvPrice.setText(new Extenso(mData.get(position).getPrice()).toString());
        holder.tvName.setText(mData.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHoder extends RecyclerView.ViewHolder{

        private TextView tvName, tvPrice;
        public MyViewHoder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvPrice = itemView.findViewById(R.id.tv_price);
        }
    }
}

