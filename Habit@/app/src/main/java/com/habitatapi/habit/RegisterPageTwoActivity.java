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

    private Boolean car, bus, bike, motorcycle;
    private Button myButton;
    private int checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page_two);

        car = true;
        bus = true;
        bike = true;
        motorcycle = true;
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

        if(bike){
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

    public void onClickMotorcycleButton(View v){
        ImageButton btn = (ImageButton)findViewById(R.id.motorcyclebutton);

        if(motorcycle){
            btn.setImageResource(R.mipmap.motorcyclebuttoncheck);
            motorcycle = false;
            checked++;
        }else{
            btn.setImageResource(R.mipmap.motorcyclebutton);
            motorcycle = true;
            checked--;
        }

        if(checked != 0){
            myButton.setEnabled(true);
        }else{
            myButton.setEnabled(false);
        }

    }

    public void onClickNext(View v){
        //if car is selected, redirect to car page
        if(!car && motorcycle) {
            Intent i = new Intent(this, RegisterPageThreeActivity.class);
            i.putExtra("motorcycle", false);
            startActivity(i);

            //if motorcycle is selected but not car, redirect to motorcycle page
        }else if(car && !motorcycle){
            Intent i = new Intent(this, RegisterPageFourActivity.class);
            startActivity(i);
        }else if(!car && !motorcycle){
            Intent i = new Intent(this, RegisterPageThreeActivity.class);
            i.putExtra("motorcycle", true);
            startActivity(i);
        //else, redirect to home survey page
        }else{
            Intent i = new Intent(this, RegisterPageFiveActivity.class);
            startActivity(i);
        }


    }
}
