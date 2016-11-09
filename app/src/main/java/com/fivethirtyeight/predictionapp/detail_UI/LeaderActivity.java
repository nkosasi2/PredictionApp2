package com.fivethirtyeight.predictionapp.detail_UI;

     //This captures the information for the detail view

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

public class LeaderActivity extends Activity {
    int pos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader);

        //GET PASSED DATA
        Intent i=getIntent();
        pos=i.getExtras().getInt("Position");

        //GET VIEWS
        final CustomAdapter adapter=new CustomAdapter(this);
        final ImageView img=(ImageView) findViewById(R.id.imageView1);
        final TextView leaderTv=(TextView)findViewById(R.id.leaderTxt);
        final TextView winprobTv=(TextView) findViewById(R.id.winprobTxt);

        //SET DATA
        img.setImageResource(adapter.images[pos]);
        leaderTv.setText(adapter.leader[pos]);
        winprobTv.setText(adapter.winprob[pos]);
        Button nextBtn=(Button) findViewById(R.id.button1);

        //NEXT CLICKED
        nextBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                int position=pos+1;
                //set data
                img.setImageResource(adapter.images[position]);
                leaderTv.setText("Leader: "+adapter.leader[position]);
                winprobTv.setText("Probability: "+adapter.winprob[position]);
                if(!(position>=adapter.getCount()-1))
                {
                    pos +=1;
                }else
                {
                    pos = -1;
                }
            }
        });
    }
}