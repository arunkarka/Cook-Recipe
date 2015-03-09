package com.example.arunkarka.cookrecipe;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class BonusActivity extends Activity{
    private static final String TOMATO_TAG = "tomato";
    private static final boolean IS_TOMATO_ADDED = false;
    private static final boolean IS_GREEN_CHILLI_ADDED = false;
    private static final boolean IS_LIME_ADDED = false;
    private static final boolean IS_ONION_ADDED = false;
    private static final boolean ARE_ALL_INGREDIENTS_ADDED = false;
    private static final int INGREDIENT_COUNT = 0;
    private static enum DragItemType {TOMATO, GREEN_CHILLI, LIME, ONION};
    private DragItemType dragItemType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus);
        final ImageView imageView = (ImageView)findViewById(R.id.tomago_drag);
        imageView.setTag(TOMATO_TAG);

        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                v.getTag();
                ClipData.Item item = new ClipData.Item((CharSequence)v.getTag());
                ClipData dragData = new ClipData((CharSequence)v.getTag(), new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},item);
                View.DragShadowBuilder myShadow = new MyDragShadowBuilder(imageView);
                imageView.startDrag(dragData, myShadow, v, 0);
                imageView.setVisibility(View.INVISIBLE);
                return true;
            }
        });

        ImageView bowl = (ImageView)findViewById(R.id.bowl_image);
        bowl.setOnDragListener(new MyDragListener());

        final TextView goodJob = (TextView) findViewById(R.id.good_job);
        findViewById(R.id.submit_teacher_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goodJob.setVisibility(View.VISIBLE);
            }
        });
    }

    private static class MyDragShadowBuilder extends View.DragShadowBuilder {
        private static Drawable shadow;

        public MyDragShadowBuilder(View view){
            super(view);
            shadow = new ColorDrawable(Color.LTGRAY);
        }

        @Override
        public void onProvideShadowMetrics (Point size, Point touch){
            int width, height;
            width = getView().getWidth()/2;
            height = getView().getHeight()/2;

            shadow.setBounds(0,0, width, height);
            size.set(width, height);
            touch.set(width/2, height/2);
        }

        @Override
        public void onDrawShadow(Canvas canvas){
            shadow.draw(canvas);
        }
    }

    class MyDragListener implements View.OnDragListener {
        Drawable enterShape = getResources().getDrawable(R.drawable.ic_tomato);
        Drawable normalShape = getResources().getDrawable(R.drawable.bowl);

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // do nothing
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    //v.setBackgroundDrawable(enterShape);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //v.setBackgroundDrawable(normalShape);
                    break;
                case DragEvent.ACTION_DROP:
                    // Dropped, reassign View to ViewGroup
                    /*View view = (View) event.getLocalState();
                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(view);
                    LinearLayout container = (LinearLayout) v;
                    container.addView(view);
                    view.setVisibility(View.VISIBLE); */
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    
                    //v.setBackgroundDrawable(normalShape);
                default:
                    break;
            }
            return true;
        }
    }
}
