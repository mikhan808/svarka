package com.example.mikhan808.svarka;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements OnTouchListener, View.OnClickListener {

    Integer[] digits = new Integer[10];
    float startX, endX, startY, endY;
    Button upPreset, downPreset, upLevel1, downLevel1;
    Preset currentPreset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentPreset = JSONWork.readPreset();
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 10; i++)
            digits[i] = i;
        View view = findViewById(R.id.viewMain);
        view.setOnTouchListener(this);
        upLevel1 = findViewById(R.id.buttonUpLevel1);
        upLevel1.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        if (button == upLevel1) {
            currentPreset.setFirst_level(currentPreset.getFirst_level() + 1);
        }
        JSONWork.writePreset(currentPreset);
        updateUI();
    }

    @SuppressLint("WrongViewCast")
    void updateUI() {
        for (int i = 0; i < Preset.elements.length; i++) {
            EditText view = findViewById(getIdTextEditFromNumber(i));
            view.setText(String.valueOf(currentPreset.getObjectOfNumber(i)));
        }
    }

    int getIdTextEditFromNumber(int number) {
        switch (number) {
            case Preset.NAME:
                return R.id.presetView;
            case Preset.FIRST_LEVEL:
                return R.id.level1View;
            case Preset.SECOND_LEVEL:
                return R.id.level2View;
            case Preset.DURATION:
                return R.id.durationView;
            case Preset.PRESSURE:
                return R.id.pressureView;
            default:
                return -1;
        }
    }

}
