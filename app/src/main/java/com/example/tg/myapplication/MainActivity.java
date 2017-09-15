package com.example.tg.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static java.lang.System.loadLibrary;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btn_protocol).setOnClickListener(this);
        findViewById(R.id.btn_codec).setOnClickListener(this);
        findViewById(R.id.btn_filter).setOnClickListener(this);
        findViewById(R.id.btn_format).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_protocol:
                ((TextView) findViewById(R.id.tv_info)).setText(urlprotocolinfo());
                break;
            case R.id.btn_format:
                ((TextView) findViewById(R.id.tv_info)).setText(avformatinfo());
                break;
            case R.id.btn_codec:
                ((TextView) findViewById(R.id.tv_info)).setText(avcodecinfo());
                break;
            case R.id.btn_filter:
                ((TextView) findViewById(R.id.tv_info)).setText(avfilterinfo());
                break;
            default:
                break;
        }
    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native String urlprotocolinfo();
    public native String avformatinfo();
    public native String avcodecinfo();
    public native String avfilterinfo();

    // Used to load the 'native-lib' library on application startup.
    static {
        loadLibrary("native-lib");
    }
}
