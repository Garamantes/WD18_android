package com.example.choejunhyeog.test1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class BottomNavActivity extends BaseActivity {

    public static final String NAME_KEY = "NAME_KEY";
    private String name;

    private Fragment feedFragment;
    private Fragment notiFragment;
    private Fragment profileFragment;
    private Fragment activeFragment;
    private final FragmentManager fm = getSupportFragmentManager();

    Toolbar myToolbar;


    private BottomNavigationView bottomNavigationView;

    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

        //툴바 부분
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        setArguments();
        initFragments();

        findView();
        setBottomNavigationView();

        //Intent 받아서 출력하는 부분 -> 이부분을 Lyout과 함께 BlankFragment1으로 옮겨야함
        Intent intent=new Intent(this.getIntent());
        String s=intent.getStringExtra("text");
        TextView textView=(TextView)findViewById(R.id.sub_text2);
        textView.setText(s);

        bottomNavigationView.setSelectedItemId(R.id.nav_bottom_feed);

    }

    private void setArguments() {
        name = getIntent().getStringExtra(NAME_KEY);
    }

    private void initFragments() {
        feedFragment = new BlankFragment1();
        notiFragment = new BlankFragment2();
        profileFragment = BlankFragment3.newInstance(name);

        fm.beginTransaction().add(R.id.box_fragment, feedFragment).hide(feedFragment)
                .add(R.id.box_fragment, notiFragment).hide(notiFragment)
                .add(R.id.box_fragment, profileFragment).hide(profileFragment)
                .commit();
    }

    private void findView() {
        //bottomNavigationView = findViewById(R.id.nav_bottom);
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.nav_bottom);
    }

    private void setBottomNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_bottom_feed:
                        setFragment(feedFragment);
                        return true;
                    case R.id.nav_bottom_noti:
                        setFragment(notiFragment);
                        return true;
                    case R.id.nav_bottom_profile:
                        setFragment(profileFragment);
                        return true;
                }
                return false;
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction transaction = fm.beginTransaction();
        if (activeFragment != null) transaction.hide(activeFragment);
        transaction.show(fragment)
                .commit();
        activeFragment = fragment;
    }

}
