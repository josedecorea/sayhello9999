package com.example.josedecorea.myapplication99;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String lang_code, lang_tab_name;

        ListView listview ;
        ListViewAdapter adapter;
        ArrayList<ListViewItem >listViewItemList = new ArrayList<ListViewItem>() ;

        /* 1. 언어설정 가져와서 언어 테이블 컬럼명 가지고 오기  */

        Locale systemLocale = getApplicationContext().getResources().getConfiguration().locale;
        lang_code = systemLocale.getLanguage(); // ko

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        lang_tab_name = databaseAccess.getLangTableName(lang_code);
        databaseAccess.close();


        /* 2. 언어에 따른 국가명 가져오기  */

        //DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        listViewItemList = databaseAccess.getNationName(lang_tab_name);
        databaseAccess.close();

        // Adapter 생성
        adapter = new ListViewAdapter(this, R.layout.listview_item, listViewItemList);

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

    }
}