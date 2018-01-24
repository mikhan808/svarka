package com.example.mikhan808.svarka;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class MainActivity extends AppCompatActivity implements OnTouchListener {

    Integer[] digits = new Integer[10];
    float startX, endX, startY, endY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 10; i++)
            digits[i] = i;
        View view = findViewById(R.id.viewMain);
        view.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: // нажатие
                startX = x;
                startY = y;
                break;
            case MotionEvent.ACTION_MOVE: // движение
                //sMove = "Move: " + x + "," + y;
                break;
            case MotionEvent.ACTION_UP: // отпускание
            case MotionEvent.ACTION_CANCEL:
                endX = x;
                endY = y;
                int direction = Swipe.getDirection(startX, startY, endX, endY);
                switch (direction) {
                    case Swipe.UP:
                        Intent intent = new Intent(this, UpActivity.class);
                        startActivity(intent);
                        break;
                    case Swipe.DOWN:
                    case Swipe.RIGHT:
                    case Swipe.LEFT:
                    default:
                        break;
                }
                break;
        }
        return true;
    }
}
