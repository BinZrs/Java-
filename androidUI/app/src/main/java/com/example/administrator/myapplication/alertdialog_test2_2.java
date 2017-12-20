package com.example.administrator.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/*
 * Created by Administrator on 2017/12/15.
 */

public class alertdialog_test2_2 extends Activity {
    private Button bt;
    private AlertDialog.Builder builder;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2_2button);

        bt= (Button) findViewById(R.id.bt1);
        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                showalertDialog(v);
            }
        });

    }
    private void showalertDialog(View view) {
        builder=new AlertDialog.Builder(this);
        builder.setTitle("Android App");

        /**
         * 设置内容区域为自定义View
         */
        LinearLayout loginDialog= (LinearLayout) getLayoutInflater().inflate(R.layout.alertdialog,null);
        builder.setView(loginDialog);

        builder.setCancelable(true);
        AlertDialog dialog=builder.create();
        dialog.show();
    }
}
