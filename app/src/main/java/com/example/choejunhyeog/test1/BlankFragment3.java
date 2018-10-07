package com.example.choejunhyeog.test1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BlankFragment3 extends BaseFragment {

    private TextView txtName;

    public static BlankFragment3 newInstance(String name) {
        Bundle args = new Bundle();
        args.putString(BottomNavActivity.NAME_KEY, name);

        BlankFragment3 fragment = new BlankFragment3();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_blank_fragment3, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //setArguments();
    }

    private void findView(View view) {
        txtName = view.findViewById(R.id.txt_name);
    }

    private void setArguments() {
        String name = getArguments().getString(BottomNavActivity.NAME_KEY);
        txtName.setText(getString(R.string.profile_welcome) + ": " + name);
    }
}