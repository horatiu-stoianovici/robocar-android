package stoianovici.horatiu.rccar;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Communications c = new Communications();

        Button buttonLeft, buttonRight, buttonUp, buttonDown;

        buttonLeft = (Button)findViewById(R.id.buttonLeft);
        buttonRight = (Button)findViewById(R.id.buttonRight);
        buttonUp = (Button)findViewById(R.id.buttonUp);
        buttonDown = (Button)findViewById(R.id.buttonDown);

        buttonLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        c.startLeft();
                        break;
                    case MotionEvent.ACTION_UP:
                        c.stopLeft();
                        break;
                }

                return false;
            }
        });

        buttonRight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        c.startRight();
                        break;
                    case MotionEvent.ACTION_UP:
                        c.stopRight();
                        break;
                }
                return false;
            }
        });

        buttonUp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        c.startForward();
                        break;
                    case MotionEvent.ACTION_UP:
                        c.stopForward();
                        break;
                }
                return false;
            }
        });

        buttonDown.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        c.startBackward();
                        break;
                    case MotionEvent.ACTION_UP:
                        c.stopBackward();
                        break;
                }
                return false;
            }
        });

        c.startBackward();
        c.stopBackward();
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
