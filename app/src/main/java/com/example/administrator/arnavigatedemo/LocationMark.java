package com.example.administrator.arnavigatedemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.palmaplus.nagrand.core.Types;
import com.palmaplus.nagrand.view.MapView;

/**
 * Created by 王天明 on 2016/6/20.
 * 定位图标
 */
public class LocationMark extends ImageView implements ExFloorMark {

    private final static boolean DEBUG = false;

    private double[] position;
    protected MapView mapView;

    //private ObjectAnimator objectAnimatorX, objectAnimatorY;

    private long floorId;

    private static final int ANIM_TIME = 3000;

    private AnimatorSet animationSet;


    public LocationMark(Context context, MapView mapView) {
        super(context);
        this.mapView = mapView;
//        setImageResource(R.mipmap.location2);
//        setImageResource(R.mipmap.location);
        setImageResource(R.mipmap.ico_map_location);
    }

    @Override
    public void init(double[] doubles) {
        position = doubles;
    }

    /**
     * 屏幕坐标
     *
     * @param x
     * @param y
     */
    public void init(double x, double y) {
        Types.Point point = mapView.converToWorldCoordinate(x, y);
        init(new double[]{point.x, point.y});
    }

    public void animTo(double x, double y) {
        if (null == position || (getX() == 0 && getY() == 0)) {
            return;
        }
        if (getVisibility() != VISIBLE) {
            setVisibility(View.VISIBLE);
        }
//        cancelAnim();
        animationSet = new AnimatorSet();
        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(this, "X", (float) (x - getWidth() / 2)).setDuration(ANIM_TIME);
        ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(this, "Y", (float) (y - getHeight() / 2)).setDuration(ANIM_TIME);
        animationSet.play(objectAnimatorX);
        animationSet.play(objectAnimatorY).with(objectAnimatorX);
        animationSet.setInterpolator(new LinearInterpolator());
        animationSet.start();
    }

    @Override
    public double[] getGeoCoordinate() {
        return position;
    }

    @Override
    public void position(double[] doubles) {
        cancelAnim();
        setX((float) doubles[0] - getWidth() / 2);
        setY((float) doubles[1] - getHeight() / 2);
    }

    private void cancelAnim() {
        if (animationSet != null) {
            animationSet.cancel();
        }
        animationSet = null;
    }

    @Override
    public long getFloorId() {
        return floorId;
    }

    public void setFloorId(long floorId) {
        this.floorId = floorId;
    }

    public void setRotation(float rotation) {
        super.setRotation(rotation);
    }
    /*@Override
    public void setRotation(float rotation) {
       int degree = (int) (180 * rotation / Math.PI);
        super.setRotation(degree);
        RotateAnimation ra = new RotateAnimation(degree, -rotation,
               Animation.RELATIVE_TO_SELF, 0.5f,
              Animation.RELATIVE_TO_SELF, 0.5f);
        //旋转过程持续时间
        ra.setDuration(200);
        //罗盘图片使用旋转动画
        this.startAnimation(ra);
        *//*currentDegree = -rotation;
        super.setRotation(rotation);
        this.rotation = rotation;*//*
        invalidate();
    }*/

    public void rotationAnim(float angle) {
        if (angle < 0) {
            angle = 360 + angle;
        }
        ObjectAnimator.ofFloat(this, "rotation", angle).setDuration(500).start();
        /*if (angle < 0) {
            angle += 360;
        }
        float currentAngle = this.getRotation(); //0
        float finalAngle = angle; // +350
        float offsetAngle = angle - currentAngle; // +350
        if (Math.abs(offsetAngle) > 180) { //true
            float finalOffsetAngle;
            if (offsetAngle < 0) { // 从大角度转到小角度 正转
                finalOffsetAngle = 360 - Math.abs(offsetAngle); // 360 -350 = 10
            }else{ //从小角度转到大角度 反转
                finalOffsetAngle = -(360 - Math.abs(offsetAngle));
            }
            finalAngle = currentAngle + finalOffsetAngle; // 0+10
        }
        ObjectAnimator.ofFloat(this, "rotation", finalAngle).setDuration(1000).start();*/

    }

    @Override
    public void setImageResource(int resId) {
        super.setImageResource(resId);
    }

//    @Override
//    protected void onDraw(Canvas canvas) {
////        super.onDraw(canvas);
//        canvas.drawColor(Color.TRANSPARENT);
//        double w = getWidth();
//        double h = getHeight();
//        Rect rect = new Rect();
//        getDrawingRect(rect);
////        int degrees = (int) (180 * rotation / Math.PI);
//        canvas.rotate(rotation, rect.width() / 2, rect.height() / 2);
//        canvas.drawBitmap(imageBitmap, //
//                (float) ((rect.width() - w) / 2),//
//                (float) ((rect.height() - h) / 2),//
//                paint);
//    }

}