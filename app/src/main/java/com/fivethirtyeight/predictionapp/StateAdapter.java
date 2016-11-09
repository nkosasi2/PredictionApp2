package com.fivethirtyeight.predictionapp;
import java.io.InputStream;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 *
 * 1.RECEIVE DOWNLOADED DATA
 * 2.PARSE IT
 * 3.CALL ADAPTER CLASS TO BIND IT TO CUSTOM
 */



public class StateAdapter extends ArrayAdapter<State> {
    ArrayList<State> stateList;
    LayoutInflater vi;
    int Resource;
    ViewHolder holder;

    public StateAdapter(Context context, int resource, ArrayList<State> objects) {
        super(context, resource, objects);
        vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Resource = resource;
        stateList = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // convert view = design
        View v = convertView;
        if (v == null) {
            holder = new ViewHolder();
            v = vi.inflate(Resource, null);
            holder.imageview = (ImageView) v.findViewById(R.id.ivImage);
            holder.tvLeader = (TextView) v.findViewById(R.id.tvLeader);
            holder.tvState = (TextView) v.findViewById(R.id.tvState);
            holder.tvWinprob = (TextView) v.findViewById(R.id.tvWinprob);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        holder.imageview.setImageResource(R.drawable.ic_launcher);
        new DownloadImageTask(holder.imageview).execute(stateList.get(position).getImage());
        holder.tvLeader.setText(stateList.get(position).getLeader());
        holder.tvState.setText(stateList.get(position).getState());
        holder.tvWinprob.setText("Winning Probability: " + stateList.get(position).getWinprob());
        return v;

    }

    static class ViewHolder {
        public ImageView imageview;
        public TextView tvLeader;
        public TextView tvState;
        public TextView tvWinprob;

    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }

    }




}