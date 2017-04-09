package com.namewu.customviewlistdemo.main;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.namewu.customviewlistdemo.R;
import com.namewu.customviewlistdemo.wuview.CircleFragment;
import com.namewu.customviewlistdemo.wuview.WuTagCloudLayout;

/**
 * Created by Administrator on 2017/4/3.
 */

public class MainActivity extends Activity implements View.OnClickListener{
    private WuTagCloudLayout show_layout;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Context mcontext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mcontext=this;
        initView();
        initData();
    }

    private void initData() {
        fragmentManager=getFragmentManager();
        TextView text_circle= new TextView(mcontext);
        text_circle.setText("环形统计图");
     //   show_layout.addView(linear,marginLayoutParams);
        show_layout.invalidate();
    }

    private void initView() {
        show_layout= (WuTagCloudLayout) findViewById(R.id.main_show);
        initTagCloud();
    }

    private void initTagCloud() {
        View linear= LayoutInflater.from(mcontext).inflate(R.layout.reward_one,null);
        ViewGroup.LayoutParams lp=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ViewGroup.MarginLayoutParams marginLayoutParams= new ViewGroup.MarginLayoutParams(lp.width,lp.height);
        marginLayoutParams.setMargins(10,10,10,10);
        LinearLayout linear_bg= (LinearLayout) linear.findViewById(R.id.reward_one_linear);
        linear_bg.setBackgroundResource(R.drawable.bgcircle_on);
        TextView text_keyword= (TextView) linear.findViewById(R.id.reward_one_keyword);
        text_keyword.setText("清除");
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
