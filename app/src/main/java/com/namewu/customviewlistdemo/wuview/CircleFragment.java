package com.namewu.customviewlistdemo.wuview;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.namewu.customviewlistdemo.R;

/**
 * Created by Administrator on 2017/4/6.
 */

public class CircleFragment extends Fragment {
    private TextView text_circle_balance;//余额
    private TextView text_circle_balancetreasure;//余额宝
    private TextView text_circle_terminal;//定期
    private TextView text_circle_fund;//基金
    private TextView text_all;//总资产
    private WuCircularStatistics wuCircularStatistics;
    private int[] data=new int[]{457,2430,10000,1500};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_circle,null);
        wuCircularStatistics= (WuCircularStatistics) view.findViewById(R.id.tab_data_circle);
        text_all= (TextView) view.findViewById(R.id.tab_data_all);
        text_circle_balance= (TextView) view.findViewById(R.id.circle_balance);
        text_circle_balancetreasure= (TextView) view.findViewById(R.id.circle_balancetreasure);
        text_circle_terminal= (TextView) view.findViewById(R.id.circle_terminal);
        text_circle_fund= (TextView) view.findViewById(R.id.circle_fund);
        int all=0;
        for(int i=0;i<data.length;i++){
            all+=data[i];
        }
        text_all.setText(all+"");
        text_circle_balance.setText(data[0]+"");
        text_circle_balancetreasure.setText(data[1]+"");
        text_circle_terminal.setText(data[2]+"");
        text_circle_fund.setText(data[3]+"");
        wuCircularStatistics.setListData(data);
        return view;
    }
}
