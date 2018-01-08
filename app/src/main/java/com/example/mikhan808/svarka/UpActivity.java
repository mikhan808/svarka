package com.example.mikhan808.svarka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class UpActivity extends AppCompatActivity implements View.OnTouchListener {

    float startX, endX, startY, endY;
    float delta = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up);
        View view = findViewById(R.id.linear);
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
                break;
            case MotionEvent.ACTION_UP: // отпускание
            case MotionEvent.ACTION_CANCEL:
                endX = x;
                endY = y;
                int direction = Swipe.getDirection(startX, startY, endX, endY);
                switch (direction) {
                    case Swipe.UP:
                    case Swipe.DOWN:
                        Intent intent = new Intent(this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        break;
                    case Swipe.RIGHT:
                    case Swipe.LEFT:
                    default:
                        break;
                }
        }
        return true;
    }
}
