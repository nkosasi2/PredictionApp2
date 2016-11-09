package com.fivethirtyeight.predictionapp.detail_UI;

//help us display images and texts in our Detail View


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    private Context c;
    String[] leader={"Donald J. Trump","Hilary Clinton","Gary Johnson"};
    String[] winprob={"Republican Party","Democratic Party","Liberatan Party"};
    int[] images={R.drawable.trump,R.drawable.hilary,R.drawable.johnson};
    ;  public CustomAdapter(Context ctx) {
        // TODO Auto-generated constructor stub
        this.c=ctx;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return leader.length;
    }
    @Override
    public Object getItem(int pos) {
        // TODO Auto-generated method stub
        return leader[pos];
    }
    @Override
    public long getItemId(int pos) {
        // TODO Auto-generated method stub
        return pos;
    }
    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.player, null);
        }
        //GET VIEWS
        TextView leaderTxt=(TextView) convertView.findViewById(R.id.leaderTv);
        TextView winprobTxt=(TextView) convertView.findViewById(R.id.winprobTv);
        ImageView img=(ImageView) convertView.findViewById(R.id.imageView1);
        //SET DATA
        leaderTxt.setText(leader[pos]);
        winprobTxt.setText(winprob[pos]);
        img.setImageResource(images[pos]);
        return convertView;
    }
}