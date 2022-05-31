package com.example.cookieclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Timer;
import java.util.TimerTask;

public class Cookie extends AppCompatActivity {

    int currentScore = 0;
    int total_clicks = 0;
    int cookies_per_click = 1;
    int upgrades_bought = 0;
    int max_cookie_amount_in_bank = 0;
    int colour_no = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookie);

        Button shopping_button = (Button)findViewById(R.id.shopping_button);
        Button stat_button = (Button)findViewById(R.id.stat_button);
        Button setting_button = (Button)findViewById(R.id.setting_button);
        TextView counterText = (TextView)findViewById(R.id.counter);
        ImageView cookieImage = (ImageView)findViewById(R.id.cookieImage);
        TextView scrollingText = (TextView)findViewById(R.id.scrollingText);
        LinearLayout background = (LinearLayout)findViewById(R.id.background);

        scrollingText.setSelected(true);

        cookieImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (upgrades_bought == 0) {
                    currentScore++;
                }
                else {
                    currentScore = currentScore + cookies_per_click;
                }
                total_clicks = total_clicks + 1;
                max_cookie_amount_in_bank = currentScore;
                counterText.setText(String.valueOf(currentScore));
            }
        });

        shopping_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(getApplicationContext(),Shopping.class);
                intent1.putExtra("CurrentScore",currentScore);
                intent1.putExtra("CookiesPerClick",cookies_per_click);
                intent1.putExtra("UpgradesBought",upgrades_bought);
                intent1.putExtra("TotalClicks",total_clicks);
                intent1.putExtra("MaxCookieAmountInBank",max_cookie_amount_in_bank);
                intent1.putExtra("Colour", colour_no);
                startActivity(intent1);
            }
        });

        stat_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent(getApplicationContext(),Statistics.class);
                intent2.putExtra("CurrentScore",currentScore);
                intent2.putExtra("CookiesPerClick",cookies_per_click);
                intent2.putExtra("UpgradesBought",upgrades_bought);
                intent2.putExtra("TotalClicks",total_clicks);
                intent2.putExtra("MaxCookieAmountInBank",max_cookie_amount_in_bank);
                intent2.putExtra("Colour", colour_no);
                startActivity(intent2);
            }
        });

        setting_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3= new Intent(getApplicationContext(),Settings.class);
                intent3.putExtra("CurrentScore",currentScore);
                intent3.putExtra("CookiesPerClick",cookies_per_click);
                intent3.putExtra("UpgradesBought",upgrades_bought);
                intent3.putExtra("TotalClicks",total_clicks);
                intent3.putExtra("MaxCookieAmountInBank",max_cookie_amount_in_bank);
                intent3.putExtra("Colour", colour_no);
                startActivity(intent3);
            }
        });

        Intent get_intent = getIntent();
        currentScore = get_intent.getIntExtra("CurrentScore", 0);
        total_clicks = get_intent.getIntExtra("TotalClicks", 0);
        cookies_per_click = get_intent.getIntExtra("CookiesPerClick", 1);
        upgrades_bought = get_intent.getIntExtra("UpgradesBought", 0);
        max_cookie_amount_in_bank = get_intent.getIntExtra("MaxCookieAmountInBank", 0);
        colour_no = get_intent.getIntExtra("Colour",0);

        if (colour_no == 0) {
            background.setBackgroundResource(R.color.white);
        }

        else if (colour_no == 1) {
            background.setBackgroundResource(R.color.light_blue);
        }

        else if (colour_no == 2) {
            background.setBackgroundResource(R.color.light_green);
        }

        else if (colour_no == 3) {
            background.setBackgroundResource(R.color.light_pink);
        }

        else if (colour_no == 4) {
            background.setBackgroundResource(R.color.light_purple);
        }

        else if (colour_no == 5) {
            background.setBackgroundResource(R.color.light_red);
        }

        else if (colour_no == 6) {
            background.setBackgroundResource(R.color.light_orange);
        }

        else if (colour_no == 7) {
            background.setBackgroundResource(R.color.light_yellow);
        }

        else if (colour_no == 8) {
            background.setBackgroundResource(R.color.aqua);
        }

        else if (colour_no == 9) {
            background.setBackgroundResource(R.color.black);
        }

        if (max_cookie_amount_in_bank <= 50) {
            scrollingText.setText("You feel like making cookies. But nobody wants to eat your cookies.   |   " +
                    "Your first batch goes in the trash. The neighborhood raccoon barely touches it.   |   ");
        }
        else if ((max_cookie_amount_in_bank > 50) && (max_cookie_amount_in_bank <= 250)) {
            scrollingText.setText("Your family accepts to try some of your cookies.   |   " +
                    "Absolutely disgusting. -grandma   |   ");
        }
        else if ((max_cookie_amount_in_bank > 250) && (max_cookie_amount_in_bank <= 1000)) {
            scrollingText.setText("People are starting to talk about your cookies.   |   " +
                    "Your cookies are talked about for miles around.   |   " +
                    "Why don't you visit more often? -grandma   |   ");
        }
        else if ((max_cookie_amount_in_bank > 1000) && (max_cookie_amount_in_bank <= 10000)) {
            scrollingText.setText("News : cookie factories linked to global warming!   |   " +
                    "Your cookies bring all the boys to the yard.   |   " +
                    "Your cookies now have their own website!   |   " +
                    "News : cookie farms suspected of employing undeclared elderly workforce!   |   ");
        }
        else if ((max_cookie_amount_in_bank > 10000) && (max_cookie_amount_in_bank <= 500000)) {
            scrollingText.setText("Your cookies sell very well in distant countries.   |   " +
                    "News : cookies slowly creeping up their way as a competitor to traditional currency!   |   " +
                    "Kings and queens from all over the world are enjoying your cookies.   |   " +
                    "There are now museums dedicated to your cookies.   |   " +
                    "News : most bakeries now fitted with ATMs to allow for easy cookie withdrawals and deposits.   |   ");
        }
        else if ((max_cookie_amount_in_bank > 500000) && (max_cookie_amount_in_bank <= 5000000)) {
            scrollingText.setText("News : Any sufficiently crude magic is indistinguishable from technology, claims renowned technowizard.'   |   " +
                    "History books now include a whole chapter about your cookies.   |   " +
                    "Your cookies have been placed under government surveillance.   |   " +
                    "News : chocolate-based organisms found on distant planet!   |   " +
                    "Strange creatures from neighboring planets wish to try your cookies.   |   " +
                    "Elder gods from the whole cosmos have awoken to taste your cookies.   |   ");
        }
        else {
            scrollingText.setText("Beings from other dimensions lapse into existence just to get a taste of your cookies.   |   " +
                    "News : nation worried as more and more unsettling creatures emerge from dimensional portals!   |   " +
                    "Your cookies have achieved sentience.   |   " +
                    "The universe has now turned into cookie dough, to the molecular level.   |   " +
                    "News : is another you living out their dreams in an alternate universe? Probably, you lazy bum!   |   " +
                    "Your cookies are rewriting the fundamental laws of the universe.   |   " +
                    "it's time to stop playing   |   " );

        }

    }

}