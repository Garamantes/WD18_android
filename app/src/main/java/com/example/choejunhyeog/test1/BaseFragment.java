package com.example.choejunhyeog.test1;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Created by choejunhyeog on 2018. 10. 8..
 */

public class BaseFragment extends Fragment{
    protected final String TAG = getClass().getSimpleName();
    protected Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        context = getContext();
    }
}
