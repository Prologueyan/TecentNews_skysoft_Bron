package bron.yan.tecentnews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import adapter.Item_MyGuanzhu_Detail;
import adapter.MyGuanzhu_DetailAdapter;

/**
 * Created by test on 2016/8/8.
 */
public class MyGuanzhuActivity extends Activity {

    private ImageView back;
    private RelativeLayout add_guanzhu;
    private ListView mygunazhulist;
    private List<Item_MyGuanzhu_Detail> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        mygunazhulist = (ListView) findViewById(R.id.myguanzhu_listView);
        mygunazhulist.setAdapter(new MyGuanzhu_DetailAdapter(MyGuanzhuActivity.this,datas));

    }
}
