package com.example.hp.httpurlconectiondemo;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private TextView textView;

    // private  String uri="http://139.199.171.179/androidtest/androidtest1.php";
    private String uri = "https://www.baidu.com";
    private ProgressDialog dialog;
    public static final String TAG = "MainActivity";
    private WebView webView;
    private Button butPost;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg != null && msg.what == 1) {
                dialog.dismiss();
                String s = (String) msg.obj;
                String data = new String(s.getBytes(), Charset.forName("utf-8"));
                Log.e(TAG, "handleMessage: "+data );
               // webView.getSettings().setDefaultTextEncodingName("utf-8");
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl(uri);
                Toast.makeText(getApplication(), "post请求成功!", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //button=findViewById(R.id.button);
        // textView=findViewById(R.id.tv);
        // button.setOnClickListener(this);
        webView = findViewById(R.id.webView);
        butPost = findViewById(R.id.post);
        butPost.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.post:
                Intent it=new Intent(MainActivity.this,HttpClientActivity.class);
                startActivity(it);
//                dialog = ProgressDialog.show(MainActivity.this, null, "正在加载中......");
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            URL url = new URL(uri);
//                            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//                            urlConnection.setRequestMethod("POST");
//                            urlConnection.setReadTimeout(5000);
//                            urlConnection.setConnectTimeout(5000);
//
//                            OutputStream outputStream = urlConnection.getOutputStream();
//                            String json = "page = 1 & num = 10";
//                            outputStream.write(json.getBytes("utf-8"));
//                            urlConnection.connect();
//                            int responseCode = urlConnection.getResponseCode();
//                            if (responseCode == 200) {
//                                int len = 0;
//                                byte[] buffer = new byte[1024];
//                                InputStream inputStream = urlConnection.getInputStream();
//                                ByteArrayOutputStream bos = new ByteArrayOutputStream();
//                                while ((len = inputStream.read(buffer)) != -1) {
//                                    bos.write(buffer, 0, len);
//                                }
//                                String result = bos.toString();
//                                outputStream.close();
//                                inputStream.close();
//                                bos.close();
//
//                                Message message = handler.obtainMessage(1, bos.toString());
//                                handler.sendMessage(message);
//                                runOnUiThread(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        WebSettings settings = webView.getSettings();
//                                        settings.setJavaScriptEnabled(true);
//                                        webView.setWebViewClient(new WebViewClient());
//                                        webView.loadUrl(uri);
//                                        dialog.dismiss();
//
//
//                                    }
//                                });
                            }

//                        } catch (Exception e) {
//                            dialog.dismiss();
//                            e.printStackTrace();
//                        }
//
//                    }
//                }).start();
//
//
//                break;
//        }
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId())
//        {
//            case R.id.button:
//                //应该在主线程中显示
//                 dialog = ProgressDialog.show(MainActivity.this,null,"正在处理中......");
//                 new Thread(new Runnable() {
//                     @Override
//                     public void run() {
//                         try {
//                             URL url=new URL(uri);
//                             HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                             connection.setRequestMethod("GET");
//                             connection.setReadTimeout(5000);
//                             connection.setConnectTimeout(5000);
//                             connection.connect();
//                             int responseCode = connection.getResponseCode();
//                             if(responseCode==200)
//                             {
//                                 InputStream is = connection.getInputStream();
//                                 final ByteArrayOutputStream bos=new ByteArrayOutputStream();
//                                 int len=0;
//                                 byte[] buffer=new byte[1024];
//                                 while((len=is.read(buffer))!=-1)
//                                 {
//                                     bos.write(buffer,0,len);
//                                 }
//
//                                 is.close();
//                                 bos.close();
//                                 connection.disconnect();
//                                 runOnUiThread(new Runnable() {
//                                     @Override
//                                     public void run() {
//                                         String result = bos.toString();
//                                         textView.setText(result);
//                                         dialog.dismiss();
//                                     }
//                                 });
//                             }
//
//
//                         } catch (Exception e) {
//                             e.printStackTrace();
//                             dialog.dismiss();
//                         }
//                     }
//                 }).start();
//
//                break;
//
//        }
//    }


}
