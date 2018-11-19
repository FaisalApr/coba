package com.example.msi.cloneig;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class VerticalPostAdapter extends RecyclerView.Adapter<VerticalPostAdapter.ViewwHolderr> {
    Context contex;
    private ArrayList<user> mUser;
    private ArrayList<String> mImgUrl;

    public VerticalPostAdapter(Context contex, ArrayList<user> mUser,ArrayList<String> mImgUrl) {
        this.contex = contex;
        this.mUser = mUser;
        this.mImgUrl = mImgUrl;
    }

    @NonNull
    @Override
    public ViewwHolderr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_vertical_post_adapter,parent,false);

        ViewwHolderr vh = new ViewwHolderr(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewwHolderr holder, int position) {
        user usr = mUser.get(position);

        Glide.with(contex).asBitmap().load(usr.getImgProfil()).into(holder.mIcoProfil);
        holder.mtx_uname.setText(usr.getUsername());
        Glide.with(contex).asBitmap().load(usr.getImgPost()).into(holder.mImage);

    }

    @Override
    public int getItemCount() {
        return mUser.size();
    }

    public class ViewwHolderr extends RecyclerView.ViewHolder{

        public ImageView mImage;
        public CircleImageView mIcoProfil;
        public Button mBtn_Like, mBtn_comment, mBtn_share;
        public TextView mtx_uname;
        public ImageButton mBtn_more;

        public ViewwHolderr(View itemView) {
            super(itemView);

            mIcoProfil = itemView.findViewById(R.id.post_profil_icon);
            mtx_uname = itemView.findViewById(R.id.post_profil_name);
            mBtn_more = itemView.findViewById(R.id.btn_main_more);
            mImage = itemView.findViewById(R.id.img_main);
            mBtn_Like = itemView.findViewById(R.id.btn_main_like);
            mBtn_comment = itemView.findViewById(R.id.btn_main_comment);
            mBtn_share = itemView.findViewById(R.id.btn_main_share);
        }
    }
}
