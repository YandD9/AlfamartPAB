package com.if4b.alfamartina;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterCard extends RecyclerView.Adapter<AdapterCard.CardViewHolder>{
    private ArrayList<Alfamart> dataAlfamart;

    public AdapterCard(ArrayList<Alfamart> dataAlfamart) {
        this.dataAlfamart = dataAlfamart;
    }

    public interface OnItemClickCallBack {

        void onItemClicked(Alfamart alfamart);
    }

    private AdapterCard.OnItemClickCallBack callBack;
    public void setOnItemClickCallBack(AdapterCard.OnItemClickCallBack callBack){
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_alfamart_ina, parent, false);
        return new CardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Alfamart alfa = dataAlfamart.get(position);

        holder.tvNamaAlfam.setText(alfa.getNama());
        holder.tvTentangAlfam.setText(alfa.getAlamat());

        Glide.with(holder.itemView.getContext())
                .load(alfa.getFoto())
                .into(holder.ivAlfamart);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                callBack.onItemClicked(dataAlfamart.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataAlfamart.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
        ImageView ivAlfamart;
        TextView tvNamaAlfam, tvTentangAlfam;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAlfamart = itemView.findViewById(R.id.iv_alfamart);
            tvNamaAlfam = itemView.findViewById(R.id.tv_nama_alfam);
            tvTentangAlfam = itemView.findViewById(R.id.tv_tentang_alfam);
        }
    }
}
