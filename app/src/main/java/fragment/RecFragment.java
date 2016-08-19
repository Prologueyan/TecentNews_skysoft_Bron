package fragment;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adapter.Item_RecommendNews;
import adapter.RecomAdapter;
import bron.yan.tecentnews.MyGuanzhuActivity;
import bron.yan.tecentnews.NewsDetailActivity;
import bron.yan.tecentnews.R;
import util.DataBaseHelper;
import util.RecommendNews;
import util.RefreshableView;

/**
 * Created by test on 2016/8/2.
 */
public class RecFragment extends Fragment {

    private static final String TAG = RecFragment.class.getSimpleName();

    private List<Item_RecommendNews> lists = new ArrayList<>();
    private List<Item_RecommendNews> guanzhu_datas = new ArrayList<>();
    private List<String> mags = new ArrayList<>();
    private ListView listView;
    private RefreshableView mRefreshableView;
    private List<View> icons = new ArrayList<>();
    private RecomAdapter recomAdapter;
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase db;
    private Cursor cursor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBaseHelper = new DataBaseHelper(getActivity(), "haa", null, 1);
        db = dataBaseHelper.getReadableDatabase();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.i(TAG,"onCreateView");
        View view = inflater.inflate(R.layout.tuijian_fragment, null);
        listView = (ListView) view.findViewById(R.id.listview_tuijian);
        mRefreshableView = (RefreshableView) view.findViewById(R.id.rec_refreshable);

        mRefreshableView.setOnRefreshListener(new RefreshableView.PullToRefreshListener() {
            @Override
            public void onRefresh() {
                try {
//                    recomAdapter.notifyDataSetChanged();
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mRefreshableView.finishRefreshing();
            }
        }, 0);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "recFragment onStart");
        lists = RecommendNews.getRecommendNews();
        cursor = db.query("guanzhu", new String[]{"name"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            mags.add(cursor.getString(0));
            Log.i(TAG, cursor.getString(0));
        }
        cursor.close();
        guanzhu_datas.clear();
        guanzhu_datas.add(new Item_RecommendNews());
        for (int i = 1; i < lists.size() && !mags.isEmpty(); i++) {
            if (mags.contains(lists.get(i).getComeFrom())) {
                guanzhu_datas.add(lists.get(i));
            }
        }


        recomAdapter = new RecomAdapter(getActivity(), guanzhu_datas);
        listView.setAdapter(recomAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(getActivity(), MyGuanzhuActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onStop() {
        Log.i(TAG, "onStop");
        super.onStop();
        mags.clear();
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, "onDestroyView");
        super.onDestroyView();
        listView = null;
    }
}
