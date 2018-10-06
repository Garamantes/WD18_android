package com.example.choejunhyeog.test1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
//import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MainActivity1 extends AppCompatActivity {

    int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);    //여기서 가져다 씀!!!!

        //외부 클래스에서 선언한 변수를 onClick()에서 사용하기 위해 final을 부텨 줌, 이게 싫으면 해당 클래스 안에 선언할 것
        //final TextView textView1 = (TextView) findViewById(R.id.text1);
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView1 = (TextView) findViewById(R.id.text1);

                Date date = new Date();
                SimpleDateFormat tf = new SimpleDateFormat("hh:mm:ss a");
                String time = tf.format(date);

                textView1.setText("지금 시각은 " + time + "입니다.");

                Random rand = new Random();
                int color = Color.rgb(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
                textView1.setTextColor(color);

                view.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            }
        });


        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView = (ImageView) findViewById(R.id.img1);

                i = i * -1;
                if(i < 1){
                    imageView.setImageResource(R.drawable.android2);
                }else{
                    imageView.setImageResource(R.drawable.android3);
                }

            }
        });

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText=(EditText)findViewById(R.id.edittext);
                Intent intent=new Intent(MainActivity1.this,BottomNavActivity.class);
                intent.putExtra("text",String.valueOf(editText.getText()));     //입력된 문자열을 다른 액티비티로 전달할때 putExtra()이용
                startActivity(intent);      //엑티비티 전환시 이용

            }
        });
    }
}

