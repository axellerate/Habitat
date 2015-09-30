package com.habitatapi.habit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class RegisterPageTwoActivity extends AppCompatActivity {

    private Boolean car, bus, bike, person;
    private Button myButton;
    private int checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page_two);

        car = true;
        bus = true;
        bike = true;
        person = true;
        myButton = (Button)findViewById(R.id.next_button_2);
        myButton.setEnabled(false);
        checked = 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register_page_two, menu);
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

    public void onClickCarButton(View v){
        ImageButton btn = (ImageButton)findViewById(R.id.carbutton);

        if(car == true){
            btn.setImageResource(R.mipmap.carbuttonchecked);
            car = false;
            checked++;
        }else{
            btn.setImageResource(R.mipmap.carbutton);
            car = true;
            checked--;
        }

        if(checked != 0){
            myButton.setEnabled(true);
        }else{
            myButton.setEnabled(false);
        }

    }

    public void onClickBusButton(View v){
        ImageButton btn = (ImageButton)findViewById(R.id.busbutton);

        if(bus == true){
            btn.setImageResource(R.mipmap.busbuttonchecked);
            bus = false;
            checked++;
        }else{
            btn.setImageResource(R.mipmap.busbutton);
            bus = true;
            checked--;
        }

        if(checked != 0){
            myButton.setEnabled(true);
        }else{
            myButton.setEnabled(false);
        }

        if(checked != 0){
            myButton.setEnabled(true);
        }else{
            myButton.setEnabled(false);
        }

    }

    public void onClickBikeButton(View v){
        ImageButton btn = (ImageButton)findViewById(R.id.bikebutton);

        if(bike == true){
            btn.setImageResource(R.mipmap.bikebuttonchecked);
            bike = false;
            checked++;
        }else{
            btn.setImageResource(R.mipmap.bikebutton);
            bike = true;
            checked--;
        }

        if(checked != 0){
            myButton.setEnabled(true);
        }else{
            myButton.setEnabled(false);
        }
    }

    public void onClickPersonButton(View v){
        ImageButton btn = (ImageButton)findViewById(R.id.personbutton);

        if(person == true){
            btn.setImageResource(R.mipmap.personbuttonchecked);
            person = false;
            checked++;
        }else{
            btn.setImageResource(R.mipmap.personbutton);
            person = true;
            checked--;
        }

        if(checked != 0){
            myButton.setEnabled(true);
        }else{
            myButton.setEnabled(false);
        }

    }

    public void onClickNext(View v){
        //if car == true, redirect to car page
        if(car == false){
            Intent i = new Intent(this, RegisterPageThreeActivity.class);
            startActivity(i);

        //else, redirect to home survey page
        }else{
            Intent i = new Intent(this, RegisterPageFourActivity.class);
            startActivity(i);
        }


    }
}
