package com.example.choejunhyeog.test1;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private boolean isFragmentB = true ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        /*
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();       //fragment를 뷸러오는 여러 메소드 가지고 있다

        fragmentTransaction.replace(R.id.frag_content1,new Fragment_main1());       //(들어가 레이아웃 id, frag불러옴
        fragmentTransaction.commit();       //항상 commit해줘야함
        */

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentBorC, new FragmentB());
        fragmentTransaction.commit();


        Intent intent=new Intent(this.getIntent());
        String s=intent.getStringExtra("text");
        TextView textView=(TextView)findViewById(R.id.sub_text2);
        textView.setText(s);

        Button button1 = (Button) findViewById(R.id.button1) ;
        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment() ;
            }
        });
    }

    public void switchFragment() {
        Fragment fr;
        if (isFragmentB) {
            fr = new FragmentB() ;
        } else {
            fr = new FragmentC() ;
        }

        isFragmentB = (isFragmentB) ? false : true ;

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentBorC, fr);
        fragmentTransaction.commit();
    }

}
