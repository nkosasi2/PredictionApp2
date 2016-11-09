package com.fivethirtyeight.predictionapp;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 *
 * -----------------------ROLES-------------------------
 * 1.CONNECT TO NETWORK
 * 2.DOWNLOAD DATA IN BACKGROUND THREAD
 * 3.SEND THE DATA TO PARSER TO BE PARSED
 */

import com.fivethirtyeight.predictionapp.CustomAdapter;
import com.fivethirtyeight.predictionapp.detail_UI.LeaderActivity;

public class MainActivity extends Activity {

	ArrayList < State > stateList;

	StateAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		stateList = new ArrayList < State > ();
		new JSONAsyncTask().execute("http://projects.fivethirtyeight.com/2016-election-forecast/summary.json");

		ListView listview = (ListView) findViewById(R.id.list);
		adapter = new StateAdapter(getApplicationContext(), R.layout.row, stateList);

		listview.setAdapter(adapter);

		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView << ? > arg0, View arg1, int position,
									long id) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), stateList.get(position).getLeader(), Toast.LENGTH_LONG).show();
			}
		});
	}


	class JSONAsyncTask extends AsyncTask < String, Void, Boolean > {

		ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog = new ProgressDialog(MainActivity.this);
			dialog.setMessage("Loading, please wait");
			dialog.setTitle("Connecting server");
			dialog.show();
			dialog.setCancelable(false);
		}

		@Override
		protected Boolean doInBackground(String...urls) {
			try {
				//------------------>>

				HttpGet httppost = new HttpGet(urls[0]);
				HttpClient httpclient = new DefaultHttpClient();
				HttpResponse response = httpclient.execute(httppost);

				// StatusLine stat = response.getStatusLine();
				int status = response.getStatusLine().getStatusCode();

				if (status == 200) {
					HttpEntity entity = response.getEntity();
					String data = EntityUtils.toString(entity);


					JSONObject jObj = new JSONObject(data);
					JSONArray jarray = jObj.getJSONArray("state");

					for (int i = 0; i < jarray.length(); i++) {
						JSONObject object = jarray.getJSONObject(i);

						State state = new State();

						state.setLeader(object.getString("leader"));
						state.setState(object.getString("state"));
						state.setWinprob(object.getString("winprob"));
						state.setImage(object.getString("image"));

						stateList.add(state);
					}
					return true;
				}

				//------------------>>

			} catch (ParseException e1) {
				e1.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return false;
		}

		protected void onPostExecute(Boolean result) {
			dialog.cancel();
			adapter.notifyDataSetChanged();

			if (result == false)
				Toast.makeText(getApplicationContext(), "Unable to fetch data from server", Toast.LENGTH_LONG).show();

		}

		ListView lv;
		lv = (ListView) findViewById(R.id.ListView1);

	}

	//ADAPTER
	CustomAdapter adapter = new CustomAdapter(this);
	lv.setAdapter(adapter);

	//EVENTS

	lv.setOnItemClickListener(new onItemClickListener() {

		@Override
		public void onItemClick(AdapterView <?> arg0, View v, int pos, long id) {
			Intent intent = new Intent(getApplicationContext(), LeaderActivity.class);

			//PASS INDEX OR POS
			intent.putExtra("Position", pos);
			startActivity(i);
		}
	};

}