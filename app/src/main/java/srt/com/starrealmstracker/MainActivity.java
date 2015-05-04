package srt.com.starrealmstracker;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText hp = (EditText) findViewById(R.id.editMaxHP);
        Button one_player_btn = (Button) findViewById(R.id.one_player_button);
        Button two_player_btn = (Button) findViewById(R.id.two_player_button);

        one_player_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String max_hp = hp.getText().toString();
                if (max_hp.length() < 1 || max_hp.length() > 2)
                    max_hp = "50";
                Intent i = new Intent(MainActivity.this, HPTracker_One_Player.class);
                i.putExtra("max_hp", max_hp);
                startActivity(i);
            }
        });

        two_player_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String max_hp = hp.getText().toString();
                if (max_hp.length() < 1 || max_hp.length() > 2)
                    max_hp = "50";
                Intent i = new Intent(MainActivity.this, HPTracker.class);
                i.putExtra("max_hp", max_hp);
                startActivity(i);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id==0) {
            
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
