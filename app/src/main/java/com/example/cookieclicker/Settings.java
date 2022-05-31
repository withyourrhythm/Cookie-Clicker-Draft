package com.example.cookieclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

public class Settings extends AppCompatActivity {

    int currentScore;
    int total_clicks;
    int cookies_per_click;
    int upgrades_bought;
    int max_cookie_amount_in_bank;
    int colour_no;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button cookie_button = (Button)findViewById(R.id.cookie_button);
        Button shopping_button = (Button)findViewById(R.id.shopping_button);
        Button stat_button = (Button)findViewById(R.id.stat_button);
        Switch music_switch = (Switch)findViewById(R.id.music_switch);
        Button white_bg_button = (Button)findViewById(R.id.white_bg_button);
        Button light_blue_bg_button = (Button)findViewById(R.id.light_blue_bg_button);
        Button light_green_bg_button = (Button)findViewById(R.id.light_green_bg_button);
        Button light_pink_bg_button = (Button)findViewById(R.id.light_pink_bg_button);
        Button light_purple_bg_button = (Button)findViewById(R.id.light_purple_bg_button);
        Button light_red_bg_button = (Button)findViewById(R.id.light_red_bg_button);
        Button light_orange_bg_button = (Button)findViewById(R.id.light_orange_bg_button);
        Button light_yellow_bg_button = (Button)findViewById(R.id.light_yellow_bg_button);
        Button aqua_bg_button = (Button)findViewById(R.id.aqua_bg_button);
        Button black_bg_button = (Button)findViewById(R.id.black_bg_button);
        LinearLayout background = (LinearLayout)findViewById(R.id.background);

        player = MediaPlayer.create(this, R.raw.cookie_clicker_song);

        music_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    player.setLooping(true);
                    player.setVolume(100,100);
                    player.start();
                }
                else {
                    player.stop();
                    player.reset();
                }
            }
        });

        white_bg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                background.setBackgroundResource(R.color.white);
                colour_no = 0;
            }
        });

        light_blue_bg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                background.setBackgroundResource(R.color.light_blue);
                colour_no = 1;
            }
        });

        light_green_bg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                background.setBackgroundResource(R.color.light_green);
                colour_no = 2;
            }
        });

        light_pink_bg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                background.setBackgroundResource(R.color.light_pink);
                colour_no = 3;
            }
        });

        light_purple_bg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                background.setBackgroundResource(R.color.light_purple);
                colour_no = 4;
            }
        });

        light_red_bg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                background.setBackgroundResource(R.color.light_red);
                colour_no = 5;
            }
        });

        light_orange_bg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                background.setBackgroundResource(R.color.light_orange);
                colour_no = 6;
            }
        });

        light_yellow_bg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                background.setBackgroundResource(R.color.light_yellow);
                colour_no = 7;
            }
        });

        aqua_bg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                background.setBackgroundResource(R.color.aqua);
                colour_no = 8;
            }
        });

        black_bg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                background.setBackgroundResource(R.color.black);
                colour_no = 9;
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

        stat_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3= new Intent(getApplicationContext(),Statistics.class);
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
        colour_no = get_intent.getIntExtra("Colour", 0);

        if (colour_no == 0) {
            background.setBackgroundColor(0xFFFFFFFF);
        }

        else if (colour_no == 1) {
            background.setBackgroundColor(0xBECDFF);
        }

        else if (colour_no == 2) {
            background.setBackgroundColor(0xB1FA9C);
        }

        else if (colour_no == 3) {
            background.setBackgroundColor(0xF1B5EB);
        }

        else if (colour_no == 4) {
            background.setBackgroundColor(0xE1BEFA);
        }

        else if (colour_no == 5) {
            background.setBackgroundColor(0xFFB2B2);
        }

        else if (colour_no == 6) {
            background.setBackgroundColor(0xFFDCBE);
        }

        else if (colour_no == 7) {
            background.setBackgroundColor(0xF8FAC2);
        }

        else if (colour_no == 8) {
            background.setBackgroundColor(0xCDFFF3);
        }

        else if (colour_no == 9) {
            background.setBackgroundColor(0x272727);
        }

    }
}