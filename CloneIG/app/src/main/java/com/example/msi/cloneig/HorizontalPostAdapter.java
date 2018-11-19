package com.example.msi.cloneig;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HorizontalPostAdapter extends RecyclerView.Adapter<HorizontalPostAdapter.ViewHolder> {
    public static final String TAG="RecyclerViewAdapter";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImagesUrl = new ArrayList<>();
    private Context mContext;

    public HorizontalPostAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public HorizontalPostAdapter(ArrayList<String> mNames, ArrayList<String> mImagesUrl, Context mContext) {
        this.mNames = mNames;
        this.mImagesUrl = mImagesUrl;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called");

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_horizontal_post_adapter,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");

        Glide.with(mContext).asBitmap().load(mImagesUrl.get(position)).into(holder.mImages);
        holder.mTextNama.setText(mNames.get(position));

        holder.mImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,mNames.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return mImagesUrl.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView mImages;
        TextView mTextNama;

        public ViewHolder(View itemView) {
            super(itemView);
            mImages = itemView.findViewById(R.id.imagess);
            mTextNama = itemView.findViewById(R.id.txt_nama);
        }
    }

}
