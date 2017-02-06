package com.example.josedecorea.myapplication99;

/**
 * Created by jose de corea on 2017-02-02.
 */
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import java.util.ArrayList;
        import java.util.List;


public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     *  언어코드에 따른 ioc_code 언어별 컬럼명 가져오기  select
     */

    public String getLangTableName(String lang_code) {

        String LangTableName;
        final String DefaultLangName = "en_name";

        Cursor cursor = database.rawQuery("SELECT lang_tab_name FROM LangTable where lang_code =" + lang_code , null);

        if(cursor.getCount() == 0) {

            LangTableName = DefaultLangName;

        }else
            LangTableName = cursor.getString(0);

        cursor.close();

        return LangTableName;
    }

    /**
     *  국기 이미지 주소, 언어별 국가명 select
     */

    public ArrayList<ListViewItem> getNationName(String lang_code) {

        ArrayList<ListViewItem>listViewItemList = new ArrayList<ListViewItem>() ;

        Cursor cursor = database.rawQuery("SELECT " + lang_code + " FROM ioc_code", null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {

            ListViewItem item = new ListViewItem();

            item.setIcon(R.drawable.flag_of_south_korea);
            item.setTitle(cursor.getString(0));
            listViewItemList.add(item);
            cursor.moveToNext();
        }
        cursor.close();

        return listViewItemList;
    }

    /**
     *  hello, thanks, love u 가지고 오기
     */

}