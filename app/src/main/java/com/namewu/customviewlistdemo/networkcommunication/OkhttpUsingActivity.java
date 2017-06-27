package com.namewu.customviewlistdemo.networkcommunication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.namewu.customviewlistdemo.R;
import com.namewu.customviewlistdemo.utils.L;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/6/22.
 */

public class OkhttpUsingActivity extends Activity implements View.OnClickListener{
    private Handler mhandle=new Handler();
    private static final String TAG = "OkhttpUsingActivity";
    private Button button_get;
    private TextView text_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        initView();
    }

    private void initView() {
        button_get= (Button) findViewById(R.id.activity_okhttp_get);
        text_show= (TextView) findViewById(R.id.activity_okhttp_show);
        button_get.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.activity_okhttp_get:
                try {
                    doGet();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void doGet() throws IOException {
        //1.拿到okHttpClient对象
        OkHttpClient okHttpClient=new OkHttpClient();
        //2.构造Request
        Request.Builder builder=new Request.Builder();
        final Request request=builder.get().url("http://weibo.com/5242909969").build();
        //3.将Request封装成Call
        Call call=okHttpClient.newCall(request);
        //4.执行call
        //直接执行
//        Response response=call.execute();
        //异步执行
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                text_show.setText(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result=response.body().string();
                L.i(TAG,result);
                try {
                    mhandle.post(new Runnable() {
                        @Override
                        public void run() {
                            text_show.setText(result);
                        }
                    });
                }catch (Exception e){
                    L.i(TAG,e.toString()+"发生错误");
                }
            }
        });
    }
    private void doPost(){

    }
}
