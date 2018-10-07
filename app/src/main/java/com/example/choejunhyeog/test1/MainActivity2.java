package com.example.choejunhyeog.test1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by choejunhyeog on 2018. 10. 8..
 */

public class MainActivity2 extends BaseActivity{
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("RecyclerViewActivity", "error, 에러로그, 빨강");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //툴바 부분
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        //Toolbar의 왼쪽에 버튼을 추가하고 버튼의 아이콘을 바꾼다.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_dehaze_black_24dp);
        getSupportActionBar().setTitle("Menu Page");  //해당 액티비티의 툴바에 있는 타이틀을 공백으로 처리


        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<FoodInfo> foodInfoArrayList = new ArrayList<>();
        foodInfoArrayList.add(new FoodInfo(R.drawable.strawberry, "5,000원"));
        foodInfoArrayList.add(new FoodInfo(R.drawable.bread, "4,600원"));
        foodInfoArrayList.add(new FoodInfo(R.drawable.noodle, "4,000원"));

        MyAdapter myAdapter = new MyAdapter(foodInfoArrayList);

        mRecyclerView.setAdapter(myAdapter);

    }
}

