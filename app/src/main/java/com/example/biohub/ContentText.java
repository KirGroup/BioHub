package com.example.biohub;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ContentText extends AppCompatActivity {
    private TextView text_content;
    private Typeface font1;
    private ImageView imageView;
    private int category;
    private int position;
    private Toolbar toolbar;

    private SharedPreferences preference;

    private int [] array_supplements = {R.string.supplements_fill_0_zink,
            R.string.supplements_fill_1_magnesium, R.string.supplements_fill_2_curcumin,
            R.string.supplements_fill_3_tianin, R.string.supplements_fill_4_bioperine, R.string.supplements_fill_5_vitaminD3,
            R.string.supplements_fill_6_Iodine, R.string.supplements_fill_7_Omega3, R.string.supplements_fill_8_Bacopa,
            R.string.supplements_fill_9_Glycine, R.string.supplements_fill_10_5htp, R.string.supplements_fill_11_Lutein,
            R.string.supplements_fill_12_Copper, R.string.supplements_fill_13_VitaminB};
//    private int [] images_supplements = {R.drawable.ic_supplements,
//            R.drawable.ic_bundles, R.drawable.ic_calendar,
//            };
    private int [] title_supplements = {R.string.Zink, R.string.Magnesium, R.string.Curcumin,
            R.string.L_Theanin, R.string.Bioperine, R.string.Vitamin_D3,
            R.string.Iodine, R.string.Omega_3, R.string.Bacopa,
            R.string.Glycine, R.string.Five_htp, R.string.Lutein, R.string.Copper, R.string.Vitamin_B};

    private int [] array_nootropics = {R.string.nootropics_fill_0,
            R.string.nootropics_fill_1, R.string.nootropics_fill_2};


    private int [] array_bundles = {R.string.bundles_fill_0,
            R.string.bundles_fill_1};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        init();
        receiveIntent();

    }

    private void receiveIntent(){
        Intent i = getIntent();

        if (i != null){
            category = i.getIntExtra("category", 0);
            position = i.getIntExtra("position", 0);
        }
        switch(category){
            case 0:
                text_content.setText(array_supplements[position]);
//                imageView.setImageResource(images_supplements[position]);
//                toolbar.setTitle(title_supplements[position]);
                break;
            case 1:
                text_content.setText(array_nootropics[position]);
//                imageView.setImageResource(images_nootropics[position]);
//                toolbar.setTitle(title_supplements[position]);
                break;
            case 2:
                text_content.setText(array_bundles[position]);
//                imageView.setImageResource(images_bundles[position]);
//                toolbar.setTitle(title_supplements[position]);
                break;
//            case 3:
//
//                break;
//            case 4:
//
//                break;
//            case 5:
//
//                break;

        }
    }

    private void init(){
        preference = PreferenceManager.getDefaultSharedPreferences(this);
        String text = preference.getString("main_text_size", "Средний текст");

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.supplements);
        setSupportActionBar(toolbar);

        text_content = findViewById(R.id.text_fill);
//        imageView = findViewById(R.id.imageContent);
        font1 = Typeface.createFromAsset(this.getAssets(), "fonts/Montserrat-Regular.ttf");
        text_content.setTypeface(font1);

        if(text!=null) {
            switch (text) {
                case "Маленький текст":
                    text_content.setTextSize(8);
                    break;
                case "Средний текст":
                    text_content.setTextSize(18);
                    break;
                case "Большой текст":
                    text_content.setTextSize(24);
                    break;
            }
        }
    }
}