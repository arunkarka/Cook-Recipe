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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class BonusActivity extends Activity{
    private static final String TOMATO_TAG = "tomato";
    private static final String GREEN_CHILLI_TAG = "green_chilli";
    private static final String ONION_TAG = "onion";
    private static final String LIME_TAG = "lime";
    private static final String SALT_TAG = "salt";
    private HashMap<String, Boolean> ADDED_INGREDIENTS = new HashMap<String, Boolean>();
    private static final int ALL_INGREDIENTS_COUNT =5;
    private boolean ARE_ALL_INGREDIENTS_ADDED = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonus);

        final ImageView tomato = (ImageView)findViewById(R.id.tomago_drag);
        tomato.setTag(TOMATO_TAG);
        tomato.setOnLongClickListener(new MyDragSetterListener());

        final ImageView green_chilli = (ImageView)findViewById(R.id.green_chilli_drag);
        green_chilli.setTag(GREEN_CHILLI_TAG);
        green_chilli.setOnLongClickListener(new MyDragSetterListener());

        final ImageView onion = (ImageView)findViewById(R.id.onion_drag);
        onion.setTag(ONION_TAG);
        onion.setOnLongClickListener(new MyDragSetterListener());

        final ImageView lime = (ImageView)findViewById(R.id.lime_drag);
        lime.setTag(LIME_TAG);
        lime.setOnLongClickListener(new MyDragSetterListener());

        final ImageView salt = (ImageView)findViewById(R.id.salt_drag);
        salt.setTag(SALT_TAG);
        salt.setOnLongClickListener(new MyDragSetterListener());

        ImageView bowl = (ImageView)findViewById(R.id.bowl_image);
        bowl.setOnDragListener(new MyDragListener());

        final TextView goodJob = (TextView) findViewById(R.id.good_job);
        findViewById(R.id.submit_teacher_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ARE_ALL_INGREDIENTS_ADDED) {
                    goodJob.setVisibility(View.VISIBLE);
                } else {
                    goodJob.setText(getResources().getString(R.string.not_finished));
                    goodJob.setVisibility(View.VISIBLE);
                }

            }
        });
    }
    private static class MyDragSetterListener implements View.OnLongClickListener {
        @Override
        public boolean onLongClick(View v) {
            v.getTag();
            ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
            ClipData dragData = new ClipData((CharSequence) v.getTag(), new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN}, item);
            View.DragShadowBuilder myShadow = new MyDragShadowBuilder(v);
            v.startDrag(dragData, myShadow, v, 0);
            return true;
        }

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
                    //findViewById(R.id.lime_drag).setVisibility(View.VISIBLE);
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    //v.setBackgroundDrawable(enterShape);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //v.setBackgroundDrawable(normalShape);
                    break;
                case DragEvent.ACTION_DROP:

                    ClipData.Item item = event.getClipData().getItemAt(0);
                    String dragDataStr = (String)item.getText();
                    if (dragDataStr.equals(TOMATO_TAG)) {
                        findViewById(R.id.tomago_drag).setVisibility(View.INVISIBLE);
                    } else if (dragDataStr.equals(ONION_TAG)) {
                        findViewById(R.id.onion_drag).setVisibility(View.INVISIBLE);
                    } else if (dragDataStr.equals(LIME_TAG)) {
                        findViewById(R.id.lime_drag).setVisibility(View.INVISIBLE);
                    } else if (dragDataStr.equals(GREEN_CHILLI_TAG)) {
                        findViewById(R.id.green_chilli_drag).setVisibility(View.INVISIBLE);
                    }
                    else if (dragDataStr.equals(SALT_TAG)) {
                        findViewById(R.id.salt_drag).setVisibility(View.INVISIBLE);
                    }

                    // Invalidates the view to force a redraw
                    //v.invalidate();

                    // Returns true. DragEvent.getResult() will return true.

                    ImageView bowl = (ImageView)v;
                    if (ADDED_INGREDIENTS.get(dragDataStr)==null) {
                        ADDED_INGREDIENTS.put(dragDataStr, true);
                    }
                    if (ADDED_INGREDIENTS.size() == ALL_INGREDIENTS_COUNT) {
                        ARE_ALL_INGREDIENTS_ADDED = true;
                        bowl.setImageResource(R.drawable.ic_bowl_full);
                    }
                    // Dropped, reassign View to ViewGroup
                    /*View view = (View) event.getLocalState();
                    ViewGroup owner = (ViewGroup) view.getParent();
                    owner.removeView(view);
                    LinearLayout container = (LinearLayout) v;
                    container.addView(view);
                    view.setVisibility(View.VISIBLE); */
                    return true;
                case DragEvent.ACTION_DRAG_ENDED:

                    //v.setBackgroundDrawable(normalShape);
                default:
                    break;
            }
            return true;
        }
    }
}
