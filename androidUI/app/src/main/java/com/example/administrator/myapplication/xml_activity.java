package com.example.administrator.myapplication;

/**
 * Created by Administrator on 2017/12/20.
 */
import android.app.ActionBar;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class xml_activity extends AppCompatActivity {
    private Button button1;
    private Button singleChoiceDiaog;
    private Button colorChoiceDialog;
    //声明一个AlertDialog构造器
    private AlertDialog.Builder builder;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_menu);
//        button1 = (Button)findViewById(R.id.button2);
//        button1.setOnClickListener(this);
        ActionBar actionBar = getActionBar();
        //实例化控件
        singleChoiceDiaog = (Button) findViewById(R.id.FontSize);
        colorChoiceDialog = (Button) findViewById(R.id.FontColor);
        //
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.popup_view, menu);

        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.FontSize:
                showSingleChoiceDialog(view);
                break;
            case R.id.Menu:
                Toast.makeText(this, "普通菜单选项", Toast.LENGTH_SHORT).show();
                break;
            case R.id.FontColor:
                //Toast.makeText(this, "退出", Toast.LENGTH_SHORT).show();
                showcolorChoiceDialog(view);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //点击按钮后，加载弹出式菜单
    //@Override
    //创建弹出式菜单对象（最低版本11）
    // public boolean onMenuItemClick(MenuItem item){
    //      switch (item.getItemId()){
    //          case R.id.FontSize:
//                Toast.makeText(this, "退出", Toast.LENGTH_SHORT).show();
    //View view;
    //           showSingleChoiceDialog(view);
//                break;
//            case R.id.Menu:
//                Toast.makeText(this, "退出", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.FontColor:
    //Toast.makeText(this, "退出", Toast.LENGTH_SHORT).show();
//                showcolorChoiceDialog(view);
//                break;
//
//        }
//        return false;
//    }
    private void showSingleChoiceDialog(View view) {
        builder=new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("字体大小");

        /**
         * 设置内容区域为单选列表项
         */
        final String[] items={"小","中","大"};
        builder.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(getApplicationContext(), "You clicked "+items[i], Toast.LENGTH_SHORT).show();
                if(items[i]=="小"){
                    Button bt =(Button) findViewById(R.id.button2);
                    bt.setTextSize(10);
                }
                else if(items[i]=="中"){
                    Button bt =(Button) findViewById(R.id.button2);
                    bt.setTextSize(16);
                }
                else if(items[i]=="大"){
                    Button bt =(Button) findViewById(R.id.button2);
                    bt.setTextSize(20);
                }
                else{

                }
            }
        });

        builder.setCancelable(true);
        AlertDialog dialog=builder.create();
        dialog.show();
    }
    private void showcolorChoiceDialog(View view) {
        builder=new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("字体颜色");

        /**
         * 设置内容区域为单选列表项
         */
        final String[] items={"红色","黑色"};
        builder.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(getApplicationContext(), "You clicked "+items[i], Toast.LENGTH_SHORT).show();
                if(items[i]=="红色"){
                    Button bt =(Button) findViewById(R.id.button2);
                    bt.setTextColor(Color.parseColor("#ff0000"));
                }
                else if(items[i]=="黑色"){
                    Button bt =(Button) findViewById(R.id.button2);
                    bt.setTextColor(Color.parseColor("#000000"));
                }
                else{

                }
            }
        });

        builder.setCancelable(true);
        AlertDialog dialog=builder.create();
        dialog.show();
    }
}


