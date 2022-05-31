package com.example.cookieclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Shopping extends AppCompatActivity {

    int currentScore;
    int total_clicks;
    int cookies_per_click;
    int upgrades_bought;
    int max_cookie_amount_in_bank;
    int colour_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        Button grandma_buy_button = (Button)findViewById(R.id.grandma_buy_button);
        Button farm_buy_button = (Button)findViewById(R.id.farm_buy_button);
        Button mine_buy_button = (Button)findViewById(R.id.mine_buy_button);
        Button factory_buy_button = (Button)findViewById(R.id.factory_buy_button);
        Button bank_buy_button = (Button)findViewById(R.id.bank_buy_button);
        Button temple_buy_button = (Button)findViewById(R.id.temple_buy_button);
        Button alchemy_lab_buy_button = (Button)findViewById(R.id.alchemy_lab_buy_button);
        Button portal_buy_button = (Button)findViewById(R.id.portal_buy_button);
        Button cookie_button = (Button)findViewById(R.id.cookie_button);
        Button stat_button = (Button)findViewById(R.id.stat_button);
        Button setting_button = (Button)findViewById(R.id.setting_button);
        LinearLayout background = (LinearLayout)findViewById(R.id.background);

        grandma_buy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentScore >= 10) {
                    cookies_per_click++;
                    upgrades_bought++;
                    currentScore = currentScore - 10;
                }
                else {
                    Toast.makeText(Shopping.this, "You don't have enough cookies. ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        farm_buy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentScore >= 50) {
                    cookies_per_click = cookies_per_click + 5;
                    upgrades_bought++;
                    currentScore = currentScore - 50;
                }
                else {
                    Toast.makeText(Shopping.this, "You don't have enough cookies. ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mine_buy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentScore >= 250) {
                    cookies_per_click = cookies_per_click + 10;
                    upgrades_bought++;
                    currentScore = currentScore - 250;
                }
                else {
                    Toast.makeText(Shopping.this, "You don't have enough cookies. ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        factory_buy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentScore >= 1000) {
                    cookies_per_click = cookies_per_click + 25;
                    upgrades_bought++;
                    currentScore = currentScore - 1000;
                }
                else {
                    Toast.makeText(Shopping.this, "You don't have enough cookies. ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bank_buy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentScore >= 5000) {
                    cookies_per_click = cookies_per_click + 50;
                    upgrades_bought++;
                    currentScore = currentScore - 5000;
                }
                else {
                    Toast.makeText(Shopping.this, "You don't have enough cookies. ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        temple_buy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentScore >= 10000) {
                    cookies_per_click = cookies_per_click + 100;
                    upgrades_bought++;
                    currentScore = currentScore - 10000;
                }
                else {
                    Toast.makeText(Shopping.this, "You don't have enough cookies. ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        alchemy_lab_buy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentScore >= 100000) {
                    cookies_per_click = cookies_per_click + 250;
                    upgrades_bought++;
                    currentScore = currentScore - 100000;
                }
                else {
                    Toast.makeText(Shopping.this, "You don't have enough cookies. ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        portal_buy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentScore >= 5000000) {
                    cookies_per_click = cookies_per_click + 500;
                    upgrades_bought++;
                    currentScore = currentScore - 5000000;
                }
                else {
                    Toast.makeText(Shopping.this, "You don't have enough cookies. ", Toast.LENGTH_SHORT).show();
                }
            }
        });

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

    }
}