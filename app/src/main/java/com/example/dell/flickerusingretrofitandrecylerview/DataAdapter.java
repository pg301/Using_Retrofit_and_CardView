package com.example.dell.flickerusingretrofitandrecylerview;


import android.graphics.drawable.Drawable;
import android.support.annotation.IntDef;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<AndroidVersion> android;
    Drawable background_chem,background_maths,background_physics;
    public DataAdapter(ArrayList<AndroidVersion> android) {
        this.android = android;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        background_chem = viewGroup.getContext().getResources().getDrawable(R.drawable.card_background_chemistry);
        background_maths = viewGroup.getContext().getResources().getDrawable(R.drawable.card_background_maths);
        background_physics = viewGroup.getContext().getResources().getDrawable(R.drawable.card_background_physics);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.tv_name.setText(android.get(i).getName());
        viewHolder.tv_version.setText(android.get(i).getVer());
        viewHolder.tv_api_level.setText(android.get(i).getApi());


       if(i%5==0)
        {
            viewHolder.iv_background.setBackground(background_chem);
        }

        else  if(i%2==0)
        {
            viewHolder.iv_background.setBackground(background_maths);
        }
        else

            viewHolder.iv_background.setBackground(background_physics);


    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name,tv_version,tv_api_level;
        private ImageView iv_background;

        public ViewHolder(View view) {
            super(view);

            tv_name = (TextView)view.findViewById(R.id.tv_name);
            tv_version = (TextView)view.findViewById(R.id.tv_version);
            tv_api_level = (TextView)view.findViewById(R.id.tv_api_level);
            iv_background=(ImageView)view.findViewById(R.id.card_background_image);




        }
    }

}