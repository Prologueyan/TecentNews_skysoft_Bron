package bron.yan.tecentnews;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import adapter.Item_MyGuanzhu_Detail;
import adapter.MyGuanzhu_DetailAdapter;
import util.DataBaseHelper;

/**
 * Created by test on 2016/8/8.
 */
public class MyGuanzhuActivity extends Activity {

    private ImageView back;
    private RelativeLayout add_guanzhu;
    private ListView mygunazhulist;
    private List<Item_MyGuanzhu_Detail> datas = new ArrayList<>();

    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase database;
    private MyGuanzhu_DetailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MyGuanzhu", "onCreate");
        setContentView(R.layout.myattention_list);

        back = (ImageView) findViewById(R.id.myguanzhu_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        add_guanzhu = (RelativeLayout) findViewById(R.id.rl_addguanzhu);

        add_guanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyGuanzhuActivity.this, AddGuanzhuActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        dataBaseHelper = new DataBaseHelper(this, "guanzhu_db", null, 1);
        database = dataBaseHelper.getReadableDatabase();
        Cursor cursor = database.query("guanzhu", new String[]{"name,picId"}, null, null, null, null, null);
        datas.clear();
        while (cursor.moveToNext()) {
            Item_MyGuanzhu_Detail item = new Item_MyGuanzhu_Detail();
            item.setName(cursor.getString(0));
            item.setPicId(cursor.getInt(1));
            datas.add(item);
        }
        cursor.close();
        adapter = new MyGuanzhu_DetailAdapter(MyGuanzhuActivity.this, datas);
        adapter.notifyDataSetChanged();
        mygunazhulist = (ListView) findViewById(R.id.myguanzhu_listView);
        mygunazhulist.setAdapter(adapter);
    }
}
