package com.puji.lineargraphview;

import com.puji.lineargraphview.LinearGraphView.GraphViewData;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		LinearGraphView mGraphView = (LinearGraphView) findViewById(R.id.linear_graph_view);

		GraphViewData[] data = new GraphViewData[6];

		data[0] = new GraphViewData(0, 5);
		data[1] = new GraphViewData(1, 4);
		data[2] = new GraphViewData(2, 2);
		data[3] = new GraphViewData(3, 9);
		data[4] = new GraphViewData(4, 8);
		data[5] = new GraphViewData(5, 20);

		mGraphView.setData(data);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
