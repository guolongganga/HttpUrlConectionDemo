package com.example.hp.httpurlconectiondemo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.http.client.HttpClient;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by guolonggang on 2018/11/29.
 * Description:
 */

public class HttpClientActivity  extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private TextView tv;
    private  String path="http://139.199.171.179/androidtest/androidtest1.php";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_activity);
        button=findViewById(R.id.but_get);
        tv=findViewById(R.id.text_view);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.but_get:
                ProgressDialog dialog=ProgressDialog.show(HttpClientActivity.this,null,"正在加载中......");
                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    URL url=new URL(path);
                                    HttpClient client=new DefaultHttpClient();
                                    //设置超时
                                    HttpParams params = client.getParams();
                                  //  HttpClientParams.s

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                ).start();
                break;
        }
    }
}
