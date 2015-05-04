package srt.com.starrealmstracker;

import srt.com.starrealmstracker.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.TextView;

public class HPTracker extends Activity {
    String maxHPStr = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hptracker);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            maxHPStr = extras.getString("max_hp");
        }
        final int maxHP = Integer.parseInt(maxHPStr);

        // Player 1
        final NumberPicker np1 = (NumberPicker) findViewById(R.id.numberpicker1);
        np1.setMaxValue(maxHP);
        np1.setMinValue(1);
        ImageButton plus1_btn = (ImageButton) findViewById(R.id.plus1_button);
        ImageButton minus1_btn = (ImageButton) findViewById(R.id.minus1_button);
        final TextView hp1 = (TextView) findViewById(R.id.player1HP);
        hp1.setText(Integer.toString(maxHP));
        plus1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = np1.getValue();
                int current = Integer.parseInt(hp1.getText().toString());
                current += value;
                if (current >= 100)
                    current = 99;
                else if (current < 0)
                    current = 0;
                hp1.setText(Integer.toString(current));
            }
        });
        minus1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = np1.getValue();
                int current = Integer.parseInt(hp1.getText().toString());
                current -= value;
                if (current >= 100)
                    current = 99;
                else if (current < 0)
                    current = 0;
                hp1.setText(Integer.toString(current));
            }
        });

        // Player 2
        final NumberPicker np2 = (NumberPicker) findViewById(R.id.numberpicker2);
        np2.setMaxValue(50);
        np2.setMinValue(1);
        ImageButton plus2_btn = (ImageButton) findViewById(R.id.plus2_button);
        ImageButton minus2_btn = (ImageButton) findViewById(R.id.minus2_button);
        final TextView hp2 = (TextView) findViewById(R.id.player2HP);
        hp2.setText(Integer.toString(maxHP));
        plus2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = np2.getValue();
                int current = Integer.parseInt(hp2.getText().toString());
                current += value;
                if (current >= 100)
                    current = 99;
                else if (current < 0)
                    current = 0;
                hp2.setText(Integer.toString(current));
            }
        });
        minus2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = np2.getValue();
                int current = Integer.parseInt(hp2.getText().toString());
                current -= value;
                if (current >= 100)
                    current = 99;
                else if (current < 0)
                    current = 0;
                hp2.setText(Integer.toString(current));
            }
        });

        Button reset_btn = (Button) findViewById(R.id.reset_button);
        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hp1.setText(Integer.toString(maxHP));
                hp2.setText(Integer.toString(maxHP));
            }
        });
    }

}
