package bron.yan.tecentnews;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import fragment.LiveFragment;
import fragment.MeFragment;
import fragment.NewsFragment;
import fragment.RecFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private LinearLayout ll_xinwen;
    private LinearLayout ll_tuijian;
    private LinearLayout ll_zhibo;
    private LinearLayout ll_wo;

    private TextView xinwen;
    private TextView tuijian;
    private TextView zhibo;
    private TextView wo;

//    //持有四个Fragment
//    private NewsFragment news_fragment;
//    private RecFragment rec_fragment;
//    private LiveFragment live_fragment;
//    private MeFragment me_fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_news);

        initView();

        setDefaultFragment();

    }

    private void initView() {
        xinwen = (TextView) findViewById(R.id.bottom_news_tv);
        tuijian = (TextView) findViewById(R.id.bottom_recommend_tv);
        zhibo = (TextView) findViewById(R.id.bottom_live_tv);
        wo = (TextView) findViewById(R.id.bottom_me_tv);

        ll_xinwen = (LinearLayout) findViewById(R.id.bottom_news);
        ll_tuijian = (LinearLayout) findViewById(R.id.bottom_recommend);
        ll_zhibo = (LinearLayout) findViewById(R.id.bottom_live);
        ll_wo = (LinearLayout) findViewById(R.id.bottom_me);
        ll_wo.setOnClickListener(this);
        ll_zhibo.setOnClickListener(this);
        ll_xinwen.setOnClickListener(this);
        ll_tuijian.setOnClickListener(this);
    }

    private void setDefaultFragment() {
        FragmentManager fg = getSupportFragmentManager();
        FragmentTransaction transaction = fg.beginTransaction();
        NewsFragment news_fragment = new NewsFragment();
        transaction.replace(R.id.main_frame, news_fragment);
        transaction.commit();

        xinwen.setTextColor(getResources().getColor(R.color.colorPrimary));

    }

    @Override
    public void onClick(View v) {
        FragmentManager fg = getSupportFragmentManager();
        FragmentTransaction transaction = fg.beginTransaction();
        Log.i(TAG, v.getId() + "");

        switch (v.getId()) {

            case R.id.bottom_news:
//                if (news_fragment == null) {
                NewsFragment news_fragment = new NewsFragment();
//                }
                colorReturn();
                transaction.replace(R.id.main_frame, news_fragment);
                transaction.commit();
                xinwen.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
            case R.id.bottom_recommend:
//                if (rec_fragment == null) {
                RecFragment rec_fragment = new RecFragment();
//                }
                colorReturn();
                transaction.replace(R.id.main_frame, rec_fragment);
                transaction.commit();
                tuijian.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
            case R.id.bottom_live:
//                if (live_fragment == null) {
                LiveFragment live_fragment = new LiveFragment();
//                }
                colorReturn();
                transaction.replace(R.id.main_frame, live_fragment);
                transaction.commit();
                zhibo.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;
            case R.id.bottom_me:
//                if (me_fragment == null) {
                MeFragment me_fragment = new MeFragment();
//                }
                colorReturn();
                transaction.replace(R.id.main_frame, me_fragment);
                transaction.commit();
                wo.setTextColor(getResources().getColor(R.color.colorPrimary));
                break;

        }
    }

    private void colorReturn() {
        xinwen.setTextColor(getResources().getColor(R.color.defaultColor));
        tuijian.setTextColor(getResources().getColor(R.color.defaultColor));
        zhibo.setTextColor(getResources().getColor(R.color.defaultColor));
        wo.setTextColor(getResources().getColor(R.color.defaultColor));
    }


}
