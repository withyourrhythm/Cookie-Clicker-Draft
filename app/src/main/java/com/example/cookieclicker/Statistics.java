package com.example.cookieclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Statistics extends AppCompatActivity {

    int currentScore;
    int total_clicks;
    int cookies_per_click;
    int upgrades_bought;
    int max_cookie_amount_in_bank;
    int colour_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        TextView total_click_stat = (TextView)findViewById(R.id.total_click_stat);
        TextView cookies_in_bank_stat = (TextView)findViewById(R.id.cookies_in_bank_stat);
        TextView cookies_per_click_stat = (TextView)findViewById(R.id.cookies_per_click_stat);
        TextView upgrades_bought_stat = (TextView)findViewById(R.id.upgrades_bought_stat);
        TextView max_cookie_amount_in_bank_stat = (TextView)findViewById(R.id.max_cookie_amount_in_bank_stat);
        Button cookie_button = (Button)findViewById(R.id.cookie_button);
        Button shopping_button = (Button)findViewById(R.id.shopping_button);
        Button setting_button = (Button)findViewById(R.id.setting_button);
        LinearLayout background = (LinearLayout)findViewById(R.id.background);

        cookie_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(getApplicationContext(), Cookie.class);
                intent1.putExtra("CurrentScore",currentScore);
                intent1.putExtra("CookiesPerClick",cookies_per_click);
                intent1.putExtra("UpgradesBought",upgrades_bought);
                intent1.putExtra("TotalClicks",total_clicks);
                intent1.putExtra("MaxCookieAmountInBank",max_cookie_amount_in_bank);
                intent1.putExtra("Colour", colour_no);
                startActivity(intent1);
            }
        });

        shopping_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2= new Intent(getApplicationContext(),Shopping.class);
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

        cookies_in_bank_stat.setText(String.valueOf(currentScore));
        total_click_stat.setText(String.valueOf(total_clicks));
        cookies_per_click_stat.setText(String.valueOf(cookies_per_click));
        upgrades_bought_stat.setText(String.valueOf(upgrades_bought));
        max_cookie_amount_in_bank_stat.setText(String.valueOf(max_cookie_amount_in_bank));


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

    }
}