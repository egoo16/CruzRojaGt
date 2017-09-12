package com.lotus.cruzroja.view.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lotus.cruzroja.R;
import com.lotus.cruzroja.view.DetailActivity;
import com.lotus.cruzroja.view.Lesson1Activity;
import com.lotus.cruzroja.view.model.Picture;

import java.util.ArrayList;

/**
 * Created by lotus on 14/08/17.
 */

public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder>{

    private ArrayList<Picture> pictures;
    private int resource;
    private Activity activity;

    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);

        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PictureViewHolder holder, final int position) {
        Picture picture = pictures.get(position);
        holder.pictureCard.setImageResource(picture.getPicture());
        holder.title.setText(picture.getTitle());
        holder.subTitle.setText(picture.getSubtitle());

        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent ;
                switch (position){
                    case 0:
                        intent = new Intent(activity, Lesson1Activity.class);
                        LanzarAPP(intent,v);
                        break;
                    case 1:
                        intent = new Intent(activity, DetailActivity.class);
                        LanzarAPP(intent,v);
                        break;
                   /* case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;*/
                }


            }
        });
    }

    public void LanzarAPP(Intent intent, View v)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            Explode explode = new Explode();
            explode.setDuration(1000);
            activity.getWindow().setExitTransition(explode);
            activity.startActivity(intent,
                    ActivityOptionsCompat.makeSceneTransitionAnimation(activity,v,activity.getString(R.string.transicionName_picture))
                            .toBundle());
        }
        else
        {
            activity.startActivity(intent);
        }
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder{

        private ImageView pictureCard;
        private TextView title;
        private TextView subTitle;


        public PictureViewHolder(View itemView) {
            super(itemView);

            pictureCard = (ImageView) itemView.findViewById(R.id.pictureCard);
            title       = (TextView) itemView.findViewById(R.id.title_textCard);
            subTitle    = (TextView) itemView.findViewById(R.id.subtitle_textCard);
        }
    }

}
