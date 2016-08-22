package bron.yan.tecentnews;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import util.DataBaseHelper;
import util.PingLunPopupWindow;
import util.SelectPopupWindow;

/**
 * Created by test on 2016/8/10.
 */
public class NewsDetailActivity extends Activity {

    private static final String TAG = NewsDetailActivity.class.getSimpleName();

    private ImageView back;
    private RelativeLayout top;
    private TextView tv_top;
    private TextView tv_01;
    private TextView tv_02;
    private ImageView xiePingLun;
    private TextView tv_pinglun;
    private RelativeLayout rl_pinglun;
    private ScrollView scrollView;
    private ImageView detail_dot3;
    private SelectPopupWindow popupWindow;
    private PingLunPopupWindow pingLunPopupWindow;
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase database;


    private View.OnClickListener itemsOnclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popupWindow.dismiss();
            switch (v.getId()) {
                case R.id.popup_shoucang:
                    dataBaseHelper = new DataBaseHelper(NewsDetailActivity.this, "shoucang", null, 1);
                    database = dataBaseHelper.getWritableDatabase();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("title", getResources().getString(R.string.detail_title));
                    contentValues.put("mag", "参考消息");
                    contentValues.put("picId", R.drawable.pujing);
                    database.insert("shoucang", null, contentValues);
                    Log.i(TAG, "insert into database");
                    break;
                case R.id.popup_ziti:
                    tv_01.setTextSize(5);
                    break;
                default:
                    break;
            }
        }
    };

    private View.OnClickListener popupOnclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail_page);
        initView();

    }

    private void initView() {

        back = (ImageView) findViewById(R.id.news_detail_page_back);
        top = (RelativeLayout) findViewById(R.id.rl_news_detail_dingbu);
        tv_top = (TextView) findViewById(R.id.tv_huidaodingbu);
        scrollView = (ScrollView) findViewById(R.id.scrollView_news_detail);
        detail_dot3 = (ImageView) findViewById(R.id.news_detail_page_dot3);
        tv_02 = (TextView) findViewById(R.id.tv_detail_2);
        tv_01 = (TextView) findViewById(R.id.tv_detail_1);
        xiePingLun = (ImageView) findViewById(R.id.iv_xiepinglun);
        tv_pinglun = (TextView) findViewById(R.id.tv_pingLun);
        rl_pinglun = (RelativeLayout) findViewById(R.id.rl_pinglun);

        rl_pinglun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View dialogView = LayoutInflater.from(NewsDetailActivity.this).inflate(R.layout.pinglunpopup, null);

                final AlertDialog dialog = new AlertDialog.Builder(NewsDetailActivity.this).create();
                dialog.setView(dialogView, 0, 0, 0, 0);
                dialog.show();
                Window window = dialog.getWindow();
                WindowManager.LayoutParams params = window.getAttributes();
                params.width = WindowManager.LayoutParams.WRAP_CONTENT;
                params.height = WindowManager.LayoutParams.WRAP_CONTENT;
                window.setAttributes(params);
                window.setGravity(Gravity.BOTTOM);
                Button fabiao = (Button) dialogView.findViewById(R.id.bt_pinglun_fabiao);
                fabiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

            }
        });

        detail_dot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow = new SelectPopupWindow(NewsDetailActivity.this, itemsOnclick);
                popupWindow.showAtLocation(NewsDetailActivity.this.findViewById(R.id.rl_pinglun),
                        Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.scrollTo(10, 10);
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
    }


}
