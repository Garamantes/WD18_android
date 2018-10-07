package com.example.choejunhyeog.test1;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by choejunhyeog on 2018. 10. 8..
 */

public class BaseActivity  extends AppCompatActivity{

    protected final String TAG = getClass().getSimpleName();
    protected Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }
}
