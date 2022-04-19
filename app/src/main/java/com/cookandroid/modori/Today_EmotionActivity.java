package com.cookandroid.modori;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Today_EmotionActivity extends AppCompatActivity {
    ImageView Img_good, Img_love, Img_taste, Img_tired, Img_sad, Img_angry, Img_awkward, Img_um, Img_umm;
    ImageButton emotionbtn;
    int select_emotion = 0; //선택 화인

    String profile;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.today_emotion);

        Img_good = findViewById(R.id.Img_good);
        Img_love = findViewById(R.id.Img_love);
        Img_taste = findViewById(R.id.Img_taste);
        Img_tired = findViewById(R.id.Img_tired);
        Img_sad = findViewById(R.id.Img_sad);
        Img_angry = findViewById(R.id.Img_angry);
        Img_awkward = findViewById(R.id.Img_awkward);
        Img_um = findViewById(R.id.Img_um);
        Img_umm = findViewById(R.id.Img_umm);

        emotionbtn = findViewById(R.id.emotionbtn);

        Img_good.setOnClickListener(new View.OnClickListener() { //기쁨
            @Override
            public void onClick(View view) {
                //if(select_emotion == 0) { //아무것도 선택되어 있지 않을 때
                    select_emotion = 1; //이미지 선택했을 때 select_emotion 1로 바꿈
                    profile = "기쁨";
                    Toast.makeText(getApplicationContext(), "기쁨을 선택하셨습니다!", Toast.LENGTH_SHORT).show();
                //} else if(select_emotion == 1) { //선택되어 있을 때

               // }
            }
        });

        Img_love.setOnClickListener(new View.OnClickListener() { //사랑
            @Override
            public void onClick(View view) {
                select_emotion = 1;
                profile = "사랑";
                Toast.makeText(getApplicationContext(), "사랑을 선택하셨습니다!", Toast.LENGTH_SHORT).show();
                //디비 연결
            }
        });

        Img_taste.setOnClickListener(new View.OnClickListener() { //맛있음
            @Override
            public void onClick(View view) {
                select_emotion = 1;
                profile = "맛있음";
                Toast.makeText(getApplicationContext(), "맛있음을 선택하셨습니다!", Toast.LENGTH_SHORT).show();
                //디비 연결
            }
        });

        Img_tired.setOnClickListener(new View.OnClickListener() { //피곤
            @Override
            public void onClick(View view) {
                select_emotion = 1;
                profile = "피곤";
                Toast.makeText(getApplicationContext(), "피곤을 선택하셨습니다!", Toast.LENGTH_SHORT).show();
                //디비 연결
            }
        });

        Img_sad.setOnClickListener(new View.OnClickListener() { //슬픔
            @Override
            public void onClick(View view) {
                select_emotion = 1;
                profile = "슬픔";
                Toast.makeText(getApplicationContext(), "슬픔을 선택하셨습니다!", Toast.LENGTH_SHORT).show();
                //디비 연결
            }
        });

        Img_angry.setOnClickListener(new View.OnClickListener() { //화남
            @Override
            public void onClick(View view) {
                select_emotion = 1;
                profile = "화남";
                Toast.makeText(getApplicationContext(), "화남을 선택하셨습니다!", Toast.LENGTH_SHORT).show();
                //디비 연결
            }
        });

        Img_awkward.setOnClickListener(new View.OnClickListener() { //당황
            @Override
            public void onClick(View view) {
                select_emotion = 1;
                profile = "당황";
                Toast.makeText(getApplicationContext(), "당황을 선택하셨습니다!", Toast.LENGTH_SHORT).show();
                //디비 연결
            }
        });

        Img_um.setOnClickListener(new View.OnClickListener() { //언짢음
            @Override
            public void onClick(View view) {
                select_emotion = 1;
                profile = "언짢음";
                Toast.makeText(getApplicationContext(), "언짢음을 선택하셨습니다!", Toast.LENGTH_SHORT).show();
                //디비 연결
            }
        });

        Img_umm.setOnClickListener(new View.OnClickListener() { //무표정
            @Override
            public void onClick(View view) {
                select_emotion = 1;
                profile = "무표정";
                Toast.makeText(getApplicationContext(), "무표정을 선택하셨습니다!", Toast.LENGTH_SHORT).show();
                //디비 연결
            }
        });

        emotionbtn.setOnClickListener(new View.OnClickListener() { //다음 누를 때
            @Override
            public void onClick(View view) {
                if(select_emotion == 0) { //아무 이미지도 선택하지 않았을 때
                    Toast.makeText(getApplicationContext(), "'오늘 나의 감정'을 골라주세요!", Toast.LENGTH_SHORT).show();
                }else {
                    //Toast.makeText(getApplicationContext(), "오늘 하루 기록 화면으로 넘어갑니다!", Toast.LENGTH_SHORT).show();
                    //디비 연결

                    Intent intent = new Intent(getApplicationContext(), Today_RecordActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
