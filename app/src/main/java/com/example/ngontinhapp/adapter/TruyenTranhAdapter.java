package com.example.ngontinhapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ngontinhapp.R;
import com.example.ngontinhapp.object.TruyenTranh;

import java.util.List;

public class TruyenTranhAdapter extends RecyclerView.Adapter<TruyenTranhAdapter.ViewHolder> {
    private List<TruyenTranh> truyenTranhs;
    private List<TruyenTranh> truyenTranhsGoc;
    private Context context;

    public TruyenTranhAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<TruyenTranh> truyenTranhs) {
        this.truyenTranhs = truyenTranhs;
        this.truyenTranhsGoc = truyenTranhs;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TruyenTranhAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_truyen, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TruyenTranhAdapter.ViewHolder holder, int position) {
        TruyenTranh truyenTranh = truyenTranhs.get(position);

        holder.tvTenChap.setText(truyenTranh.getTenChap());
        holder.tvTenTruyen.setText(truyenTranh.getTenTruyen());
        Glide.with(context).load(truyenTranh.getLinkAnh()).into(holder.imgAnh);
    }

    @Override
    public int getItemCount() {
        if (truyenTranhs == null) {
            return 0;
        } else
            return truyenTranhs.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTenTruyen, tvTenChap;
        ImageView imgAnh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenChap = itemView.findViewById(R.id.txvtenChap);
            tvTenTruyen = itemView.findViewById(R.id.txvtenTruyen);
            imgAnh = itemView.findViewById(R.id.imgAnh);
        }
    }


}
