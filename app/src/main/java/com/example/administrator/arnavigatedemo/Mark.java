package com.example.administrator.arnavigatedemo;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.palmaplus.nagrand.view.overlay.OverlayCell;

/**
 * Created by stone on 2017/6/13.
 */

public class Mark extends LinearLayout implements OverlayCell {
    private TextView mPosX;
    private TextView mPosY;
    private TextView mPosId;

    private double X;
    private double Y;

    private int mId;

    private TextView mark_id;

    private ImageView mIconView;
    /**
     * Mark所属楼层的楼层id.
     */
    private long mFloorId;
    /**
     * Mark的世界坐标
     */
    private double[] mGeoCoordinate;

    public Mark(Context context) {
        super(context);

        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_mark, this);
        mIconView = (ImageView) findViewById(R.id.mark_icon);
        mark_id = (TextView) findViewById(R.id.mark_id);
    }

    public void SetXY(double x, double y){
        X =x;
        Y =y;
    }

    public void MarkLog(){
        if (mPosX != null && mPosY != null){
            Log.e("Mark-X>>>>>>>>>>:" , X+"");
            Log.e("Mark-Y>>>>>>>>>>:" , Y+"");
        }
    }

    public void setMark(int resId) {
        mIconView.setBackgroundResource(resId);
    }

    public void setMark(int id, double x, double y) {
        mId = id;
        mark_id.setText(String.valueOf(id));
//        mPosX.setText("x: " + x + "");
//        mPosY.setText("y: " + y + "");
    }

    public void setMarkId(int id){
        mId = id;
        mark_id.setText(String.valueOf(id));
    }

    public void setIcon(int resId) {
        mIconView.setImageResource(resId);
    }

    @Override
    public void init(double[] doubles) {
        mGeoCoordinate = doubles;
    }

    @Override
    public double[] getGeoCoordinate() {
        return mGeoCoordinate;
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void position(double[] doubles) {
        setX((float) doubles[0] - mIconView.getWidth() / 2);
        setY((float) doubles[1] - mIconView.getHeight() / 2 - mIconView.getHeight() / 4 - mIconView.getHeight() / 8);
    }

    @Override
    public long getFloorId() {
        return mFloorId;
    }

    public void setFloorId(long floorId) {
        mFloorId = floorId;
    }
}
