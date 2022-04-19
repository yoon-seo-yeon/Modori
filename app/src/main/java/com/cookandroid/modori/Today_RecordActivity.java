package com.cookandroid.modori;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Today_RecordActivity extends AppCompatActivity {
    ImageView sad, gloom, impassive, joy, smile;
    ImageView snow, rain, cloudy, wind, sunny;
    ImageView friend, family, couple, acq, x;
    ImageView breakfast, lunch, dinner, late_meal;
    ImageView home, theater, amusement_park, shopping, picnic;

    ImageButton next;

    String profile;
    int feel, weather, person, meal, go = 0;
    String img1, img2, img3, img4, img5; //식사, 날씨, 사람, 식사, 외출

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.today_record);

        sad = findViewById(R.id.Img_sad2);
        gloom = findViewById(R.id.Img_gloom);
        impassive = findViewById(R.id.Img_impassive);
        joy = findViewById(R.id.Img_joy);
        smile = findViewById(R.id.Img_smile);
        snow = findViewById(R.id.Img_snow);
        rain = findViewById(R.id.Img_rain);
        cloudy = findViewById(R.id.Img_cloudy);
        wind = findViewById(R.id.Img_wind);
        sunny = findViewById(R.id.Img_sunny);
        friend = findViewById(R.id.Img_friend);
        family = findViewById(R.id.Img_family);
        couple = findViewById(R.id.Img_couple);
        acq = findViewById(R.id.Img_acq);
        x = findViewById(R.id.Img_x);
        breakfast = findViewById(R.id.Img_breakfast);
        lunch = findViewById(R.id.Img_lunch);
        dinner = findViewById(R.id.Img_dinner);
        late_meal = findViewById(R.id.Img_late_meal);
        home = findViewById(R.id.Img_home);
        theater = findViewById(R.id.Img_theater);
        amusement_park = findViewById(R.id.Img_amusement_park);
        shopping = findViewById(R.id.Img_shopping);
        picnic = findViewById(R.id.Img_picnic);
        next = findViewById(R.id.next);

        joy.setOnClickListener(new View.OnClickListener() { //행복
            @Override
            public void onClick(View view) {
                img1 = "행복";
                //Toast.makeText(getApplicationContext(), "행복을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        smile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //기쁨
                img1 = "기쁨";
                //Toast.makeText(getApplicationContext(), "기쁨을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        impassive.setOnClickListener(new View.OnClickListener() { //무표정
            @Override
            public void onClick(View view) {
                img1 = "무표정";
                //Toast.makeText(getApplicationContext(), "무표정을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        gloom.setOnClickListener(new View.OnClickListener() { //우울
            @Override
            public void onClick(View view) {
                img1 = "우울";
                //Toast.makeText(getApplicationContext(), "우울을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        sad.setOnClickListener(new View.OnClickListener() { //슬픔
            @Override
            public void onClick(View view) {
                img1 = "슬픔";
                //Toast.makeText(getApplicationContext(), "슬픔을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });

        /////////////////////날씨/////////////////////////////

        sunny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //맑음
                img2 = "맑음";
                //Toast.makeText(getApplicationContext(), "맑음를 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        wind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //바람
                img2 = "바람";
                //Toast.makeText(getApplicationContext(), "바람을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        cloudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //흐림
                img2 = "흐림";
                //Toast.makeText(getApplicationContext(), "흐림을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        rain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //비
                img2 = "비";
                //Toast.makeText(getApplicationContext(), "비를 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        snow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //눈
                img2 = "눈";
                //Toast.makeText(getApplicationContext(), "눈을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });

        /////////////////////사람/////////////////////////////

        friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //친구
                img3 = "친구";
                //Toast.makeText(getApplicationContext(), "친구를 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //가족
                img3 = "가족";
                //Toast.makeText(getApplicationContext(), "가족을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        couple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //연인
                img3 = "여인";
                //Toast.makeText(getApplicationContext(), "연인을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        acq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //지인
                img3 = "지인";
                //Toast.makeText(getApplicationContext(), "지인을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //X
                img3 = "X";
                //Toast.makeText(getApplicationContext(), "X를 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });

        /////////////////////식사/////////////////////////////

        breakfast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //아침
                img4 = "아침";
                //Toast.makeText(getApplicationContext(), "아침을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //점심
                img4 = "점심";
                //Toast.makeText(getApplicationContext(), "점심을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //저녁
                img4 = "저녁";
                //Toast.makeText(getApplicationContext(), "저녁을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        late_meal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //야식
                img4 = "야식";
                //Toast.makeText(getApplicationContext(), "야식을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });

        /////////////////////외출/////////////////////////////

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //집
                img5 = "집";
                //Toast.makeText(getApplicationContext(), "집을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        theater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //영화관
                img5 = "영화관";
                //Toast.makeText(getApplicationContext(), "영화관을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        amusement_park.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //놀이공원
                img5 = "놀이공원";
                //Toast.makeText(getApplicationContext(), "놀이공원을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //쇼핑
                img5 = "쇼핑";
                //Toast.makeText(getApplicationContext(), "쇼핑을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        picnic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //소풍
                img5 = "소풍";
                //Toast.makeText(getApplicationContext(), "소풍을 선택하셨습니다.",Toast.LENGTH_SHORT).show();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ModoriActivity.class); //메인화면으로 가기
                startActivity(intent);
            }
        });
    }
}