package com.puji.lineargraphview;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import com.puji.lineargraphview.LinearGraphView.GraphViewData;

public class MainActivity extends Activity {

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

		String[] labels = new String[7];

		for (int i = 0; i < 7; i++) {
			labels[i] = i * 5 + "日";
		}

		mGraphView.setHorizontalLabelAlign(Paint.Align.CENTER);
		mGraphView.setHorizontalLables(labels);
		mGraphView.setGraphTitle("本年销售变化表");
		mGraphView.setGraphBackgroundColor(0x66ff0000);
		mGraphView.setData(data);
	}

}
