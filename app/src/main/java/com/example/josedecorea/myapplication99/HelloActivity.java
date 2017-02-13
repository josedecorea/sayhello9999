package com.example.josedecorea.myapplication99;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        String ncode;
        HelloItem item = new HelloItem();

        Intent intent = getIntent();

        ncode = intent.getStringExtra("nation_code");

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        item = databaseAccess.getHelloItem(ncode);
        databaseAccess.close();

        //setNcode(item.getNcode());

        TextView text1 = (TextView)findViewById(R.id.text1);
        text1.setText(item.getTitle1());

        TextView text1sub = (TextView)findViewById(R.id.text1sub);
        text1sub.setText(item.getSub1());


        TextView text2 = (TextView)findViewById(R.id.text2);
        text2.setText(item.getTitle2());

        TextView text2sub = (TextView)findViewById(R.id.text2sub);
        text2sub.setText(item.getSub2());


        TextView text3 = (TextView)findViewById(R.id.text3);
        text3.setText(item.getTitle3());

        TextView text3sub = (TextView)findViewById(R.id.text3sub);
        text3sub.setText(item.getSub3());

    }
}
