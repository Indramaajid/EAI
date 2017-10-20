package com.example.ina.eai;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by INA on 10/3/2017.
 */

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.MyViewHolder> {
    private Context context;
    private List<Shop> shopList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView namaBarang;
        public ImageView gambarBarang;
        public TextView hargaBarang;
        public CardView cardView;
        public SharedPreferences pref;

        public MyViewHolder(View view) {
            super(view);
            namaBarang = (TextView) view.findViewById(R.id.product_text);
            hargaBarang = (TextView) view.findViewById(R.id.product_price);
            gambarBarang = (ImageView) view.findViewById(R.id.menu_image);
            cardView = (CardView) view.findViewById(R.id.shopCardview);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                        if (position == 0) {
                            Intent i = new Intent(context, DetailActivity.class);
                            i.putExtra("tag","1");
                            context.startActivity(i);
                    } else if (position == 1) {
                            Intent i = new Intent(context, DetailActivity.class);
                            i.putExtra("tag","2");
                            context.startActivity(i);
                    } else if (position == 2) {
                            Intent i = new Intent(context, DetailActivity.class);
                            i.putExtra("tag","3");
                            context.startActivity(i);
                    } else if (position == 3) {
                            Intent i = new Intent(context, DetailActivity.class);
                            i.putExtra("tag","4");
                            context.startActivity(i);
                        }
                }
            });

        }
    }

    public ShopAdapter(Context context, List<Shop> shopList) {
        this.context = context;
        this.shopList = shopList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shop_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Shop menu = shopList.get(position);
        holder.gambarBarang.setImageResource(menu.getThumbnail());
        holder.namaBarang.setText(menu.getNama_produk());
        holder.hargaBarang.setText(menu.getHarga_produk());
    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }
}
