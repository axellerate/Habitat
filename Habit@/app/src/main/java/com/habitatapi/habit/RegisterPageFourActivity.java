package com.habitatapi.habit;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;


public class RegisterPageFourActivity extends ActionBarActivity {

    private boolean checkedButton;
    private Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page_four);
        checkedButton = false;
        myButton = (Button)findViewById(R.id.button4);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register_page_four, menu);
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

    public void onClickRadio(View view){

        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radio125:
                if (checked)
                    myButton.setEnabled(true);
                    break;
            case R.id.radio300:
                if (checked)
                    myButton.setEnabled(true);
                    break;
            case R.id.radio500:
                if (checked)
                    myButton.setEnabled(true);
                    break;
            case R.id.radio750:
                if (checked)
                    myButton.setEnabled(true);
                    break;
            case R.id.radio1000:
                if (checked)
                    myButton.setEnabled(true);
                    break;
            case R.id.radio1300:
                if (checked)
                    myButton.setEnabled(true);
                    break;
            case R.id.radio1600:
                if (checked)
                    myButton.setEnabled(true);
                    break;
            case R.id.radio1601p:
                if (checked)
                    myButton.setEnabled(true);
                    break;
        }
    }

    public void onClickNext(View v){
        Intent i = new Intent(this, RegisterPageFiveActivity.class);
        startActivity(i);
    }
}
