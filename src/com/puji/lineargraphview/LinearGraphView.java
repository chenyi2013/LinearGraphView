package com.puji.lineargraphview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

/**
 * 
 * @author Kevin Chen
 * @date 2014/9/28
 * @email chenyi_de_email@163.com
 * @QQ 252019161
 */

public class LinearGraphView extends View {

	/**
	 * ͼ�α���
	 */
	private String mGraphTitle;

	/**
	 * ͼ�α�����ɫ
	 */
	private int mGraphTitleColor = Color.BLACK;

	/**
	 * ͼ�α��������С
	 */
	private int mGraphTitleTextSize = convertSpToPxValue(18);

	/**
	 * ˮƽ��ǩ��ɫ
	 */
	private int mHorzontalLableColor = Color.BLACK;

	/**
	 * ˮƽ��ǩ�����С
	 */
	private int mHorzontalLabelTextSize = convertSpToPxValue(12);

	/**
	 * ��ֱ��ǩ��ɫ
	 */
	private int mVertialLabelColor = Color.BLACK;

	/**
	 * ��ֱ��ǩ�����С
	 */
	private int mVertialLabelTextSize = convertSpToPxValue(12);

	/**
	 * ˮƽ�̶���
	 */
	private int mHorizontalLabelCount = 7;

	/**
	 * ��X�᷽��Ŀ�ʼ�̶�ֵ
	 */
	private int mHorizontalStartTick;

	/**
	 * ��X�᷽��Ľ����̶�ֵ
	 */
	private int mHorizontalEndTick;

	/**
	 * ������ɫ
	 */
	private int mGridColor = Color.BLACK;

	/**
	 * ������
	 */
	private int mGridWeight = getPxValue(1);

	/**
	 * �������ɫ
	 */
	private int mPointColor = Color.RED;

	/**
	 * ����㴦СԲ�İ뾶
	 */
	private int mPointRadius = getPxValue(5);

	/**
	 * �Ƿ��������㴦��СԲ
	 */
	private boolean isDrawPoint = false;

	/**
	 * �Ƿ��������ͼ�εı���
	 */
	private boolean isDrawBackground = false;

	/**
	 * ����ͼ�εı�����ɫ
	 */
	private int mGraphBackgroundColor = Color.RED;

	/**
	 * ��Ҫ����ͼ�ε�����Դ
	 */
	private GraphViewData[] mData;

	/**
	 * ͼ�α�����ͼ��֮��ļ������
	 */
	private int mSpaceingOfTitleWithGraph = getPxValue(5);

	/**
	 * ��ֱ��ǩ��ͼ��֮��ļ������
	 */
	private int mSpaceingOfVerticalLabelWithGraph = getPxValue(5);

	/**
	 * ˮƽ��ǩ��ͼ��֮��ļ������
	 */
	private int mSpaceingOfHorizontalLabelWithGraph = getPxValue(5);

	/**
	 * ��������ı�ˢ
	 */
	private Paint mGridPaint = new Paint();

	/**
	 * �������ֵı�ˢ
	 */
	private Paint mTextPaint = new Paint();

	/**
	 * ˮƽ��ǩ���ֵĶ��뷽ʽ
	 */
	private Align mHorizontalLabelAlign = Align.LEFT;

	/**
	 * ��ֱ��ǩ�Ķ��뷽ʽ
	 */
	private Align mVerticalLabelAlign = Align.LEFT;

	/**
	 * ͼ�α���Ķ��뷽ʽ
	 */
	private Align mGraphTitleAlign = Align.CENTER;

	/**
	 * ˮƽ��ǩ
	 */
	private String[] mHorizontalLables;

	/**
	 * �õ�ͼ�α���
	 * 
	 * @return
	 */
	public String getGraphTitle() {
		return mGraphTitle;
	}

	/**
	 * ����ͼ�α���
	 * 
	 * @param mGraphTitle
	 */
	public void setGraphTitle(String mGraphTitle) {
		this.mGraphTitle = mGraphTitle;
	}

	/**
	 * �õ�ͼ�α�����ɫ
	 * 
	 * @return
	 */
	public int getGraphTitleColor() {
		return mGraphTitleColor;
	}

	/**
	 * ����ͼ�α�����ɫ
	 * 
	 * @param mGraphTitleColor
	 */
	public void setGraphTitleColor(int mGraphTitleColor) {
		this.mGraphTitleColor = mGraphTitleColor;
	}

	/**
	 * �õ�ͼ�α��������С
	 * 
	 * @return
	 */
	public int getGraphTitleTextSize() {
		return mGraphTitleTextSize;
	}

	/**
	 * ����ͼ�α��������С
	 * 
	 * @param mGraphTitleTextSize
	 */
	public void setGraphTitleTextSize(int mGraphTitleTextSize) {
		this.mGraphTitleTextSize = convertSpToPxValue(mGraphTitleTextSize);
	}

	/**
	 * �õ�ˮƽ��ǩ������ɫ
	 * 
	 * @return
	 */
	public int getHorzontalLableColor() {
		return mHorzontalLableColor;
	}

	/**
	 * ����ˮƽ��ǩ������ɫ
	 * 
	 * @param mHorzontalLableColor
	 */
	public void setHorzontalLableColor(int mHorzontalLableColor) {
		this.mHorzontalLableColor = mHorzontalLableColor;
	}

	/**
	 * �õ�ˮƽ��ǩ�����С
	 * 
	 * @return
	 */
	public int getHorzontalLabelTextSize() {
		return mHorzontalLabelTextSize;
	}

	/**
	 * ����ˮƽ��ǩ�����С
	 * 
	 * @param mHorzontalLabelTextSize
	 */
	public void setHorzontalLabelTextSize(int mHorzontalLabelTextSize) {
		this.mHorzontalLabelTextSize = convertSpToPxValue(mHorzontalLabelTextSize);
	}

	/**
	 * �õ���ֱ��ǩ������ɫ
	 * 
	 * @return
	 */
	public int getVertialLabelColor() {
		return mVertialLabelColor;
	}

	/**
	 * ���ô�ֱ��ǩ������ɫ
	 * 
	 * @param mVertialLabelColor
	 */
	public void setVertialLabelColor(int mVertialLabelColor) {
		this.mVertialLabelColor = mVertialLabelColor;
	}

	/**
	 * �õ���ֱ��ǩ�����С
	 * 
	 * @return
	 */
	public int getVertialLabelTextSize() {
		return mVertialLabelTextSize;
	}

	/**
	 * ���ô�ֱ��ǩ�����С
	 * 
	 * @param mVertialLabelTextSize
	 */
	public void setVertialLabelTextSize(int mVertialLabelTextSize) {
		this.mVertialLabelTextSize = convertSpToPxValue(mVertialLabelTextSize);
	}

	/**
	 * �õ�ˮƽ��ǩ����
	 * 
	 * @return
	 */
	public int getHorizontalLabelCount() {
		return mHorizontalLabelCount;
	}

	/**
	 * ����ˮƽ��ǩ����
	 * 
	 * @param mHorizontalLabelCount
	 */
	public void setHorizontalLabelCount(int mHorizontalLabelCount) {
		this.mHorizontalLabelCount = mHorizontalLabelCount;
	}

	/**
	 * �õ�ˮƽ�������ʼ�̶�
	 * 
	 * @return
	 */
	public int getHorizontalStartTick() {
		return mHorizontalStartTick;
	}

	/**
	 * ����ˮƽ�������ʼ�̶�
	 * 
	 * @param mHorizontalStartTick
	 */
	public void setHorizontalStartTick(int mHorizontalStartTick) {
		this.mHorizontalStartTick = mHorizontalStartTick;
	}

	/**
	 * �õ�ˮƽ����Ľ����̶�
	 * 
	 * @return
	 */
	public int getHorizontalEndTick() {
		return mHorizontalEndTick;
	}

	/**
	 * ����ˮƽ����Ľ����̶�
	 * 
	 * @param mHorizontalEndTick
	 */
	public void setHorizontalEndTick(int mHorizontalEndTick) {
		this.mHorizontalEndTick = mHorizontalEndTick;
	}

	/**
	 * �õ�������ɫ
	 * 
	 * @return
	 */
	public int getGridColor() {
		return mGridColor;
	}

	/**
	 * ����������ɫ
	 * 
	 * @param mGridColor
	 */
	public void setGridColor(int mGridColor) {
		this.mGridColor = mGridColor;
	}

	/**
	 * �õ�������
	 * 
	 * @return
	 */
	public int getGridWeight() {
		return mGridWeight;
	}

	/**
	 * ����������
	 * 
	 * @param mGridWeight
	 */
	public void setGridWeight(int mGridWeight) {
		this.mGridWeight = getPxValue(mGridWeight);
	}

	/**
	 * �õ������СԲ�������ɫ
	 * 
	 * @return
	 */
	public int getPointColor() {
		return mPointColor;
	}

	/**
	 * ���������СԲ�������ɫ
	 * 
	 * @param mPointColor
	 */
	public void setPointColor(int mPointColor) {
		this.mPointColor = mPointColor;
	}

	/**
	 * �õ�����㴦СԲ�İ뾶
	 * 
	 * @return
	 */
	public int getPointRadius() {
		return mPointRadius;
	}

	/**
	 * ��������㴦СԲ�İ뾶
	 * 
	 * @param mPointRadius
	 */
	public void setPointRadius(int mPointRadius) {
		this.mPointRadius = getPxValue(mPointRadius);
	}

	/**
	 * �õ��Ƿ��������㴦��СԲ��true������ƣ�false��������
	 * 
	 * @return
	 */
	public boolean isDrawPoint() {
		return isDrawPoint;
	}

	/**
	 * �����Ƿ��������㴦��СԲ��true������ƣ�false��������
	 * 
	 * @param isDrawPoint
	 */
	public void setDrawPoint(boolean isDrawPoint) {
		this.isDrawPoint = isDrawPoint;
	}

	/**
	 * �õ��Ƿ����ͼ�α�����true������ƣ�false��������
	 * 
	 * @return
	 */
	public boolean isDrawBackground() {
		return isDrawBackground;
	}

	/**
	 * �����Ƿ����ͼ�α�����true������ƣ�false��������
	 * 
	 * @param isDrawBackground
	 */
	public void setDrawBackground(boolean isDrawBackground) {
		this.isDrawBackground = isDrawBackground;
	}

	/**
	 * �õ�ͼ�α�����ɫ
	 * 
	 * @return
	 */
	public int getGraphBackgroundColor() {
		return mGraphBackgroundColor;
	}

	/**
	 * ����ͼ�α�����ɫ
	 * 
	 * @param mGraphBackgroundColor
	 */
	public void setGraphBackgroundColor(int mGraphBackgroundColor) {
		this.mGraphBackgroundColor = mGraphBackgroundColor;
	}

	/**
	 * �õ���Ҫ����ͼ�ε�����Դ
	 * 
	 * @return
	 */
	public GraphViewData[] getData() {
		return mData;
	}

	/**
	 * ������Ҫ����ͼ�ε�����Դ
	 * 
	 * @param mData
	 */
	public void setData(GraphViewData[] mData) {
		this.mData = mData;
		invalidate();
	}

	/**
	 * �õ�ͼ����ͼ�α���֮��ļ������
	 * 
	 * @return
	 */
	public int getSpaceingOfTitleWithGraph() {
		return mSpaceingOfTitleWithGraph;
	}

	/**
	 * ����ͼ����ͼ�α���֮��ļ������
	 * 
	 * @param mSpaceingOfTitleWithGraph
	 */
	public void setSpaceingOfTitleWithGraph(int mSpaceingOfTitleWithGraph) {
		this.mSpaceingOfTitleWithGraph = mSpaceingOfTitleWithGraph;
	}

	/**
	 * �õ�ͼ���봹ֱ��ǩ�ļ������
	 * 
	 * @return
	 */
	public int getSpaceingOfVerticalLabelWithGraph() {
		return mSpaceingOfVerticalLabelWithGraph;
	}

	/**
	 * ����ͼ���봹ֱ��ǩ�ļ������
	 * 
	 * @param mSpaceingOfVerticalLabelWithGraph
	 */
	public void setSpaceingOfVerticalLabelWithGraph(
			int mSpaceingOfVerticalLabelWithGraph) {
		this.mSpaceingOfVerticalLabelWithGraph = mSpaceingOfVerticalLabelWithGraph;
	}

	/**
	 * �õ�ͼ����ˮƽ��ǩ�ļ������
	 * 
	 * @return
	 */
	public int getSpaceingOfHorizontalLabelWithGraph() {
		return mSpaceingOfHorizontalLabelWithGraph;
	}

	/**
	 * ����ͼ����ˮƽ��ǩ�ļ������
	 * 
	 * @param mSpaceingOfHorizontalLabelWithGraph
	 */
	public void setSpaceingOfHorizontalLabelWithGraph(
			int mSpaceingOfHorizontalLabelWithGraph) {
		this.mSpaceingOfHorizontalLabelWithGraph = mSpaceingOfHorizontalLabelWithGraph;
	}

	/**
	 * �õ�ˮƽ��ǩ���ֵĶ��뷽ʽ
	 * 
	 * @return
	 */
	public Align getHorizontalLabelAlign() {
		return mHorizontalLabelAlign;
	}

	/**
	 * ����ˮƽ��ǩ���ֵĶ��뷽ʽ
	 * 
	 * @param mHorizontalLabelAlign
	 */
	public void setHorizontalLabelAlign(Align mHorizontalLabelAlign) {
		this.mHorizontalLabelAlign = mHorizontalLabelAlign;
	}

	/**
	 * �õ���ֱ��ǩ���ֵĶ��뷽ʽ
	 * 
	 * @return
	 */
	public Align getVerticalLabelAlign() {
		return mVerticalLabelAlign;
	}

	/**
	 * ���ô�ֱ��ǩ���ֵĶ��뷽ʽ
	 * 
	 * @param mVerticalLabelAlign
	 */
	public void setVerticalLabelAlign(Align mVerticalLabelAlign) {
		this.mVerticalLabelAlign = mVerticalLabelAlign;
	}

	/**
	 * �õ�ͼ�����ֱ���Ķ��뷽ʽ
	 * 
	 * @return
	 */
	public Align getGraphTitleAlign() {
		return mGraphTitleAlign;
	}

	/**
	 * ����ͼ�����ֱ���Ķ��뷽ʽ
	 * 
	 * @param mGraphTitleAlign
	 */
	public void setGraphTitleAlign(Align mGraphTitleAlign) {
		this.mGraphTitleAlign = mGraphTitleAlign;
	}

	public LinearGraphView(Context context) {
		super(context);

	}

	public LinearGraphView(Context context, AttributeSet attrs) {
		super(context, attrs);

	}

	public LinearGraphView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		if (mData == null) {
			return;
		}

		int startX = 100 + mSpaceingOfHorizontalLabelWithGraph;
		int startY = getFontHeight(mGraphTitleTextSize)
				+ mSpaceingOfHorizontalLabelWithGraph;

		int validWidth = getWidth() - startX - getPaddingRight();
		int validHeight = getHeight() - startY
				- mSpaceingOfHorizontalLabelWithGraph
				- mSpaceingOfTitleWithGraph;

		mGridPaint.setAntiAlias(true);
		mGridPaint.setColor(mGridColor);
		mGridPaint.setStyle(Paint.Style.STROKE);
		mGridPaint.setStrokeWidth(mGridWeight);

		for (int i = 0; i < mHorizontalLabelCount - 1; i++) {

			canvas.drawLine(startX + i * validWidth
					/ (mHorizontalLabelCount - 1), startY, startX + i
					* validWidth / (mHorizontalLabelCount - 1), startY
					+ validHeight, mGridPaint);

		}
		canvas.drawLine(startX + validWidth, startY, startX + validWidth,
				startY + validHeight, mGridPaint);

		for (int i = 0; i < mData.length - 1; i++) {

			canvas.drawLine(startX, startY + i * validHeight
					/ (mData.length - 1), startX + validWidth, startY + i
					* validHeight / (mData.length - 1), mGridPaint);

		}
		canvas.drawLine(startX, startY + validHeight, startX + validWidth,
				startY + validHeight, mGridPaint);

		Path path = new Path();
		path.moveTo(startX, startY + validHeight);

		mGridPaint.setColor(Color.RED);
		double maxY = getMaxYValue();
		for (int i = 1; i < mData.length; i++) {

			canvas.drawLine(startX + (i - 1) * validWidth
					/ (mHorizontalLabelCount - 1), (float) (startY
					+ validHeight - validHeight * (mData[i - 1].y / maxY)),
					startX + i * validWidth / (mHorizontalLabelCount - 1),
					(float) (startY + validHeight - validHeight
							* (mData[i].y / maxY)), mGridPaint);

			path.lineTo(startX + (i - 1) * validWidth
					/ (mHorizontalLabelCount - 1), (float) (startY
					+ validHeight - validHeight * (mData[i - 1].y / maxY)));

		}

		mGridPaint.setStyle(Paint.Style.FILL);
		path.lineTo(startX + (mData.length - 1) * validWidth
				/ (mHorizontalLabelCount - 1),
				(float) (startY + validHeight - validHeight
						* (mData[mData.length - 1].y / maxY)));
		path.lineTo(startX + (mData.length - 1) * validWidth
				/ (mHorizontalLabelCount - 1), startY + validHeight);
		canvas.drawPath(path, mGridPaint);

		mGridPaint.reset();
	}

	private double getMaxYValue() {

		double max = mData[0].y;

		for (int i = 0; i < mData.length; i++) {

			max = max > mData[i].y ? max : mData[i].y;
		}

		return max;
	}

	private String getMaxLengthString(String[] data) {

		int length = 0;
		int index = 0;

		for (int i = 0; i < data.length; i++) {
			if (length < data[i].length()) {
				length = data[i].length();
				index = i;
			}
		}
		return data[index];
	}

	/**
	 * �õ�����߶�
	 * 
	 * @param fontSize
	 * @return
	 */
	private int getFontHeight(float fontSize) {
		Paint paint = new Paint();
		paint.setTextSize(fontSize);
		FontMetrics fm = paint.getFontMetrics();
		return (int) Math.ceil(fm.descent - fm.top) + 2;
	}

	/**
	 * �õ����ֵĿ��
	 * 
	 * @return
	 */
	private int getFontWidth(float fontSize, String str) {
		Paint paint = new Paint();
		paint.setTextSize(fontSize);
		return (int) paint.measureText(str);
	}

	/**
	 * ����dpΪ��λ��ʾ��ֵת������pxΪ��λ��ֵ
	 * 
	 * @param dpValue
	 * @return
	 */
	private int getPxValue(int dpValue) {
		DisplayMetrics metrics = getResources().getDisplayMetrics();
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
				dpValue, metrics);
	}

	/**
	 * ����spΪ��λ��ʾ��ֵת������pxΪ��λ��ֵ
	 * 
	 * @param spValue
	 * @return
	 */
	private int convertSpToPxValue(int spValue) {
		DisplayMetrics metrics = getResources().getDisplayMetrics();
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
				spValue, metrics);
	}

	public static class GraphViewData {

		double x;
		double y;

		public GraphViewData(double x, double y) {
			this.x = x;
			this.y = y;
		}

		public double getX() {
			return x;
		}

		public void setX(double x) {
			this.x = x;
		}

		public double getY() {
			return y;
		}

		public void setY(double y) {
			this.y = y;
		}

	}

}
