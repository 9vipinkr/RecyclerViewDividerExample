package com.vipinkr.recyclerviewdividerexample;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Vipin K R on 25-01-2017.
 */

public class RecyclerClickListener extends RecyclerView.SimpleOnItemTouchListener {
    Context context;
    OnRecyclerListener onRecyclerListener;
    GestureDetectorCompat gestureDetectorCompat;

    public RecyclerClickListener(Context context, final RecyclerView rv, final OnRecyclerListener onRecyclerListener) {
        this.onRecyclerListener = onRecyclerListener;
        this.context = context;
        gestureDetectorCompat = new GestureDetectorCompat(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if (child != null && onRecyclerListener != null) {
                    onRecyclerListener.click(child, rv.getChildAdapterPosition(child));
                }
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                super.onLongPress(e);
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if (child != null && onRecyclerListener != null) {
                    onRecyclerListener.longClick(child, rv.getChildAdapterPosition(child));
                }
            }
        });
    }

    public interface OnRecyclerListener {
        public void click(View view, int position);

        public void longClick(View view, int position);
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        if(gestureDetectorCompat!=null){
            boolean result=gestureDetectorCompat.onTouchEvent(e);
            return result;
        }
        else{
            return false;
        }
    }
}

