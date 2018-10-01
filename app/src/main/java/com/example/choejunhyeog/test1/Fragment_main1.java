package com.example.choejunhyeog.test1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by choejunhyeog on 2018. 10. 1..
 */

public class Fragment_main1 extends Fragment {
    TextView textview;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //추가함
        View view = inflater.inflate(R.layout.fragment_main1,null);
        textview= (TextView)view.findViewById(R.id.frag_text1);

        return view;
    }
}
