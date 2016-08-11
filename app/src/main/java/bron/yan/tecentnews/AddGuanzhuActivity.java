package bron.yan.tecentnews;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adapter.Guanzhufenzu_Listview_Adapter;
import adapter.Item_Guanzhu_Fenzu;
import fragment.GuanzhuPaiHangFragment;

/**
 * 我的关注Activity
 * Created by test on 2016/8/8.
 */
public class AddGuanzhuActivity extends FragmentActivity {

    private ListView listViewFenzu; //分组关注listview
    private FrameLayout frameLayoutDetail;//关注详细listview
    private List<Item_Guanzhu_Fenzu> fenzuList = new ArrayList<>(); //分组数据
    private android.support.v4.app.FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    private Fragment fragment;
    private Guanzhufenzu_Listview_Adapter adapter;
    public static int cur_position = 0;

    private ImageView back;

    private String[] fenzunames = {"排行", "最新", "新闻", "财经", "人文", "时尚", "搞笑", "设计", "生活", "旅游",
            "美食", "家居", "视频", "科技", "思想", "娱乐", "汽车", "体育", "游戏", "军事", "历史", "教育"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("AddGuanzhu", "onCreate");
        setContentView(R.layout.add_guanzhu_page);
        fragment = new GuanzhuPaiHangFragment();
        initView();
    }

    private void initView() {

        back = (ImageView) findViewById(R.id.iv_back_addguanzhu);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listViewFenzu = (ListView) findViewById(R.id.listview_guanzhufenzu);
        frameLayoutDetail = (FrameLayout) findViewById(R.id.framelayout_guanzhu_detail);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout_guanzhu_detail, fragment);
        fragmentTransaction.commit();

        for (int i = 0; i < fenzunames.length; i++) {
            Item_Guanzhu_Fenzu item = new Item_Guanzhu_Fenzu();
            item.setFenZuName(fenzunames[i]);
            fenzuList.add(item);
        }

        adapter = new Guanzhufenzu_Listview_Adapter(AddGuanzhuActivity.this, fenzuList);
        listViewFenzu.setAdapter(adapter);

        listViewFenzu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("click", position + "");
                adapter.changeSelect(position);
            }
        });


    }


}
