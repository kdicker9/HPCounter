package srt.com.starrealmstracker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.TextView;

import srt.com.starrealmstracker.R;

public class HPTracker_One_Player extends Activity {
    String maxHPStr = "";
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hptracker_one_player);

         Bundle extras = getIntent().getExtras();
         if (extras != null) {
             maxHPStr = extras.getString("max_hp");
         }
         final int maxHP = Integer.parseInt(maxHPStr);

        // Player 1
        final NumberPicker np1 = (NumberPicker) findViewById(R.id.numberpicker1single);
        np1.setMaxValue(maxHP);
        np1.setMinValue(1);
        ImageButton plus1_btn = (ImageButton) findViewById(R.id.plus1_buttonsingle);
        ImageButton minus1_btn = (ImageButton) findViewById(R.id.minus1_buttonsingle);
        final TextView hp1 = (TextView) findViewById(R.id.player1HPsingle);
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

         Button reset_btn = (Button) findViewById(R.id.reset_buttonsingle);
         reset_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 hp1.setText(Integer.toString(maxHP));
             }
         });
    }

}
