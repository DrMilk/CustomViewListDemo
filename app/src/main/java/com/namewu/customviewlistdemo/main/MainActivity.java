package com.namewu.customviewlistdemo.main;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.namewu.customviewlistdemo.R;
import com.namewu.customviewlistdemo.wuview.CircleFragment;

/**
 * Created by Administrator on 2017/4/3.
 */

public class MainActivity extends Activity implements View.OnClickListener{
    private LinearLayout show_linear;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        fragmentManager=getFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
    }

    private void initView() {
        show_linear= (LinearLayout) findViewById(R.id.linear_show);
        Button circle= (Button) findViewById(R.id.button_circle);
        circle.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_circle:
                CircleFragment circle=new CircleFragment();
                fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.linear_show,circle);
                fragmentTransaction.commit();break;
        }
    }
}
