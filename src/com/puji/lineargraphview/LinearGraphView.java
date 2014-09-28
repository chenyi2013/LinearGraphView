package com.puji.lineargraphview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
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
	 * 图形标题
	 */
	private String mGraphTitle;

	/**
	 * 图形标题颜色
	 */
	private int mGraphTitleColor = Color.BLACK;

	/**
	 * 图形标题字体大小
	 */
	private int mGraphTitleTextSize = convertSpToPxValue(18);

	/**
	 * 水平标签颜色
	 */
	private int mHorzontalLableColor = Color.BLACK;

	/**
	 * 水平标签字体大小
	 */
	private int mHorzontalLabelTextSize = convertSpToPxValue(12);

	/**
	 * 垂直标签颜色
	 */
	private int mVertialLabelColor = Color.BLACK;

	/**
	 * 垂直标签字体大小
	 */
	private int mVertialLabelTextSize = convertSpToPxValue(12);

	/**
	 * 水平刻度数
	 */
	private int mHorizontalLabelCount;

	/**
	 * 在X轴方向的开始刻度值
	 */
	private int mHorizontalStartTick;

	/**
	 * 在X轴方向的结束刻度值
	 */
	private int mHorizontalEndTick;

	/**
	 * 网格颜色
	 */
	private int mGridColor = Color.BLACK;

	/**
	 * 网格厚度
	 */
	private int mGridWeight = getPxValue(1);

	/**
	 * 座标点颜色
	 */
	private int mPointColor = Color.RED;

	/**
	 * 座标点处小圆的半径
	 */
	private int mPointRadius = getPxValue(5);

	/**
	 * 是否绘制座标点处的小圆
	 */
	private boolean isDrawPoint = false;

	/**
	 * 是否填充所画图形的背景
	 */
	private boolean isDrawBackground = false;

	/**
	 * 所画图形的背景颜色
	 */
	private int mGraphBackgroundColor = Color.RED;

	/**
	 * 所要绘制图形的数据源
	 */
	private GraphViewData[] mData;

	/**
	 * 图形标题与图形之间的间隔距离
	 */
	private int mSpaceingOfTitleWithGraph = getPxValue(5);

	/**
	 * 垂直标签与图形之间的间隔距离
	 */
	private int mSpaceingOfVerticalLabelWithGraph = getPxValue(5);

	/**
	 * 水平标签与图形之间的间隔距离
	 */
	private int mSpaceingOfHorizontalLabelWithGraph = getPxValue(5);

	/**
	 * 绘制网格的笔刷
	 */
	private Paint mGridPaint = new Paint();

	/**
	 * 绘制文字的笔刷
	 */
	private Paint mTextPaint = new Paint();

	/**
	 * 水平标签文字的对齐方式
	 */
	private Align mHorizontalLabelAlign = Align.LEFT;

	/**
	 * 垂直标签的对齐方式
	 */
	private Align mVerticalLabelAlign = Align.LEFT;

	/**
	 * 图形标题的对齐方式
	 */
	private Align mGraphTitleAlign = Align.CENTER;

	/**
	 * 得到图形标题
	 * 
	 * @return
	 */
	public String getGraphTitle() {
		return mGraphTitle;
	}

	/**
	 * 设置图形标题
	 * 
	 * @param mGraphTitle
	 */
	public void setGraphTitle(String mGraphTitle) {
		this.mGraphTitle = mGraphTitle;
	}

	/**
	 * 得到图形标题颜色
	 * 
	 * @return
	 */
	public int getGraphTitleColor() {
		return mGraphTitleColor;
	}

	/**
	 * 设置图形标题颜色
	 * 
	 * @param mGraphTitleColor
	 */
	public void setGraphTitleColor(int mGraphTitleColor) {
		this.mGraphTitleColor = mGraphTitleColor;
	}

	/**
	 * 得到图形标题字体大小
	 * 
	 * @return
	 */
	public int getGraphTitleTextSize() {
		return mGraphTitleTextSize;
	}

	/**
	 * 设置图形标题字体大小
	 * 
	 * @param mGraphTitleTextSize
	 */
	public void setGraphTitleTextSize(int mGraphTitleTextSize) {
		this.mGraphTitleTextSize = convertSpToPxValue(mGraphTitleTextSize);
	}

	/**
	 * 得到水平标签字体颜色
	 * 
	 * @return
	 */
	public int getHorzontalLableColor() {
		return mHorzontalLableColor;
	}

	/**
	 * 设置水平标签字体颜色
	 * 
	 * @param mHorzontalLableColor
	 */
	public void setHorzontalLableColor(int mHorzontalLableColor) {
		this.mHorzontalLableColor = mHorzontalLableColor;
	}

	/**
	 * 得到水平标签字体大小
	 * 
	 * @return
	 */
	public int getHorzontalLabelTextSize() {
		return mHorzontalLabelTextSize;
	}

	/**
	 * 设置水平标签字体大小
	 * 
	 * @param mHorzontalLabelTextSize
	 */
	public void setHorzontalLabelTextSize(int mHorzontalLabelTextSize) {
		this.mHorzontalLabelTextSize = convertSpToPxValue(mHorzontalLabelTextSize);
	}

	/**
	 * 得到垂直标签字体颜色
	 * 
	 * @return
	 */
	public int getVertialLabelColor() {
		return mVertialLabelColor;
	}

	/**
	 * 设置垂直标签字体颜色
	 * 
	 * @param mVertialLabelColor
	 */
	public void setVertialLabelColor(int mVertialLabelColor) {
		this.mVertialLabelColor = mVertialLabelColor;
	}

	/**
	 * 得到垂直标签字体大小
	 * 
	 * @return
	 */
	public int getVertialLabelTextSize() {
		return mVertialLabelTextSize;
	}

	/**
	 * 设置垂直标签字体大小
	 * 
	 * @param mVertialLabelTextSize
	 */
	public void setVertialLabelTextSize(int mVertialLabelTextSize) {
		this.mVertialLabelTextSize = convertSpToPxValue(mVertialLabelTextSize);
	}

	/**
	 * 得到水平标签个数
	 * 
	 * @return
	 */
	public int getHorizontalLabelCount() {
		return mHorizontalLabelCount;
	}

	/**
	 * 设置水平标签个数
	 * 
	 * @param mHorizontalLabelCount
	 */
	public void setHorizontalLabelCount(int mHorizontalLabelCount) {
		this.mHorizontalLabelCount = mHorizontalLabelCount;
	}

	/**
	 * 得到水平方向的起始刻度
	 * 
	 * @return
	 */
	public int getHorizontalStartTick() {
		return mHorizontalStartTick;
	}

	/**
	 * 设置水平方向的起始刻度
	 * 
	 * @param mHorizontalStartTick
	 */
	public void setHorizontalStartTick(int mHorizontalStartTick) {
		this.mHorizontalStartTick = mHorizontalStartTick;
	}

	/**
	 * 得到水平方向的结束刻度
	 * 
	 * @return
	 */
	public int getHorizontalEndTick() {
		return mHorizontalEndTick;
	}

	/**
	 * 设置水平方向的结束刻度
	 * 
	 * @param mHorizontalEndTick
	 */
	public void setHorizontalEndTick(int mHorizontalEndTick) {
		this.mHorizontalEndTick = mHorizontalEndTick;
	}

	/**
	 * 得到网格颜色
	 * 
	 * @return
	 */
	public int getGridColor() {
		return mGridColor;
	}

	/**
	 * 设置网络颜色
	 * 
	 * @param mGridColor
	 */
	public void setGridColor(int mGridColor) {
		this.mGridColor = mGridColor;
	}

	/**
	 * 得到网络厚度
	 * 
	 * @return
	 */
	public int getGridWeight() {
		return mGridWeight;
	}

	/**
	 * 设置网络厚度
	 * 
	 * @param mGridWeight
	 */
	public void setGridWeight(int mGridWeight) {
		this.mGridWeight = getPxValue(mGridWeight);
	}

	/**
	 * 得到座标点小圆的填充颜色
	 * 
	 * @return
	 */
	public int getPointColor() {
		return mPointColor;
	}

	/**
	 * 设置座标点小圆的填充颜色
	 * 
	 * @param mPointColor
	 */
	public void setPointColor(int mPointColor) {
		this.mPointColor = mPointColor;
	}

	/**
	 * 得到座标点处小圆的半径
	 * 
	 * @return
	 */
	public int getPointRadius() {
		return mPointRadius;
	}

	/**
	 * 设置座标点处小圆的半径
	 * 
	 * @param mPointRadius
	 */
	public void setPointRadius(int mPointRadius) {
		this.mPointRadius = getPxValue(mPointRadius);
	}

	/**
	 * 得到是否绘制座标点处的小圆，true代表绘制，false代表不绘制
	 * 
	 * @return
	 */
	public boolean isDrawPoint() {
		return isDrawPoint;
	}

	/**
	 * 设置是否绘制座标点处的小圆，true代表绘制，false代表不绘制
	 * 
	 * @param isDrawPoint
	 */
	public void setDrawPoint(boolean isDrawPoint) {
		this.isDrawPoint = isDrawPoint;
	}

	/**
	 * 得到是否绘制图形背景，true代表绘制，false代表不绘制
	 * 
	 * @return
	 */
	public boolean isDrawBackground() {
		return isDrawBackground;
	}

	/**
	 * 设置是否绘制图形背景，true代表绘制，false代表不绘制
	 * 
	 * @param isDrawBackground
	 */
	public void setDrawBackground(boolean isDrawBackground) {
		this.isDrawBackground = isDrawBackground;
	}

	/**
	 * 得到图形背景颜色
	 * 
	 * @return
	 */
	public int getGraphBackgroundColor() {
		return mGraphBackgroundColor;
	}

	/**
	 * 设置图形背景颜色
	 * 
	 * @param mGraphBackgroundColor
	 */
	public void setGraphBackgroundColor(int mGraphBackgroundColor) {
		this.mGraphBackgroundColor = mGraphBackgroundColor;
	}

	/**
	 * 得到所要绘制图形的数据源
	 * 
	 * @return
	 */
	public GraphViewData[] getData() {
		return mData;
	}

	/**
	 * 设置所要绘制图形的数据源
	 * 
	 * @param mData
	 */
	public void setData(GraphViewData[] mData) {
		this.mData = mData;
	}

	/**
	 * 得到图形与图形标题之间的间隔距离
	 * 
	 * @return
	 */
	public int getSpaceingOfTitleWithGraph() {
		return mSpaceingOfTitleWithGraph;
	}

	/**
	 * 设置图形与图形标题之间的间隔距离
	 * 
	 * @param mSpaceingOfTitleWithGraph
	 */
	public void setSpaceingOfTitleWithGraph(int mSpaceingOfTitleWithGraph) {
		this.mSpaceingOfTitleWithGraph = mSpaceingOfTitleWithGraph;
	}

	/**
	 * 得到图形与垂直标签的间隔距离
	 * 
	 * @return
	 */
	public int getSpaceingOfVerticalLabelWithGraph() {
		return mSpaceingOfVerticalLabelWithGraph;
	}

	/**
	 * 设置图形与垂直标签的间隔距离
	 * 
	 * @param mSpaceingOfVerticalLabelWithGraph
	 */
	public void setSpaceingOfVerticalLabelWithGraph(
			int mSpaceingOfVerticalLabelWithGraph) {
		this.mSpaceingOfVerticalLabelWithGraph = mSpaceingOfVerticalLabelWithGraph;
	}

	/**
	 * 得到图形与水平标签的间隔距离
	 * 
	 * @return
	 */
	public int getSpaceingOfHorizontalLabelWithGraph() {
		return mSpaceingOfHorizontalLabelWithGraph;
	}

	/**
	 * 设置图形与水平标签的间隔距离
	 * 
	 * @param mSpaceingOfHorizontalLabelWithGraph
	 */
	public void setSpaceingOfHorizontalLabelWithGraph(
			int mSpaceingOfHorizontalLabelWithGraph) {
		this.mSpaceingOfHorizontalLabelWithGraph = mSpaceingOfHorizontalLabelWithGraph;
	}

	/**
	 * 得到水平标签文字的对齐方式
	 * 
	 * @return
	 */
	public Align getHorizontalLabelAlign() {
		return mHorizontalLabelAlign;
	}

	/**
	 * 设置水平标签文字的对齐方式
	 * 
	 * @param mHorizontalLabelAlign
	 */
	public void setHorizontalLabelAlign(Align mHorizontalLabelAlign) {
		this.mHorizontalLabelAlign = mHorizontalLabelAlign;
	}

	/**
	 * 得到垂直标签文字的对齐方式
	 * 
	 * @return
	 */
	public Align getVerticalLabelAlign() {
		return mVerticalLabelAlign;
	}

	/**
	 * 设置垂直标签文字的对齐方式
	 * 
	 * @param mVerticalLabelAlign
	 */
	public void setVerticalLabelAlign(Align mVerticalLabelAlign) {
		this.mVerticalLabelAlign = mVerticalLabelAlign;
	}

	/**
	 * 得到图形文字标题的对齐方式
	 * 
	 * @return
	 */
	public Align getGraphTitleAlign() {
		return mGraphTitleAlign;
	}

	/**
	 * 设置图形文字标题的对齐方式
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

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

	}

	/**
	 * 得到字体高度
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
	 * 得到文字的宽度
	 * 
	 * @return
	 */
	private int getFontWidth(float fontSize) {
		Paint paint = new Paint();
		paint.setTextSize(fontSize);
		return (int) paint.measureText("0000000000");
	}

	/**
	 * 将以dp为单位表示的值转化成以px为单位的值
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
	 * 将以sp为单位表示的值转化成以px为单位的值
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
