package com.example.android.harrimargono_1202151230_modul3;

/**
 * Created by work on 2/24/18.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

class AirAdapter extends RecyclerView.Adapter<AirAdapter.AirViewHolder>  {

    //Member variables
    private GradientDrawable mGradientDrawable;
    private ArrayList<Air> mAirData;
    private Context mContext;





    //konstruktor untuk mem-pass data dan konteks (airData ArrayList berisi data air) (Context berisi konteks aplikasi)
    AirAdapter(Context context, ArrayList<Air> airData) {
        this.mAirData = airData;
        this.mContext = context;

        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        //Make the placeholder same size as the images
        Drawable drawable = ContextCompat.getDrawable
                (mContext,R.drawable.aqua);
        if(drawable != null) {
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

    }



    //method untuk membuat objek viewholder
    @Override
    public AirViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AirViewHolder(mContext, LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false), mGradientDrawable);
    }



    //method yang dibutuhkan untuk meng-bind data ke viewholder
    @Override
    public void onBindViewHolder(AirAdapter.AirViewHolder holder, int position) {
        //Get current sport
        Air currentAir = mAirData.get(position);
        //Populate the textviews with data
        holder.bindTo(currentAir);

    }



    //method yang dibutuhkan untuk menentukan besar data set
    @Override
    public int getItemCount() {
        return mAirData.size();
    }




    //class viewholder yang mempresentasikan setiap baris data di RecyclerView
    static class AirViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        //Member Variables for the holder data
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mSportsImage;
        private Context mContext;
        private Air mCurrentAir;
        private GradientDrawable mGradientDrawable;


        //konstruktor ViewHolder
        AirViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);

            //Initialize the views
            mTitleText = (TextView)itemView.findViewById(R.id.title);
            mInfoText = (TextView)itemView.findViewById(R.id.subTitle);
            mSportsImage = (ImageView) itemView.findViewById(R.id.sportsImage);

            mContext = context;
            mGradientDrawable = gradientDrawable;

            itemView.setOnClickListener(this);

        }

        void bindTo(Air currentAir){
            //Populate the textviews with data
            mTitleText.setText(currentAir.getTitle());
            mInfoText.setText(currentAir.getInfo());

            //Get the current sport
            mCurrentAir = currentAir;

            //Load the images into the ImageView using the Glide library
            Glide.with(mContext).load(currentAir.
                    getImageResource()).placeholder(mGradientDrawable).into(mSportsImage);


            }

        @Override
        public void onClick(View view) {

            //Set up the detail intent
            Intent detailIntent = Air.starter(mContext, mCurrentAir.getTitle(),
                    mCurrentAir.getImageResource());


            //Start the detail activity
            mContext.startActivity(detailIntent);

        }
    }


}