package fragment;

import android.content.Intent;
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

import adapter.Item_Live;
import adapter.Live_ListView_Adapter;
import bron.yan.tecentnews.NewsDetailActivity;
import bron.yan.tecentnews.R;
import util.RefreshableView;

/**
 * Created by test on 2016/8/2.
 */
public class LiveFragment extends Fragment {

    private RefreshableView mRefreshableView;
    private ListView mListView;
    private List<Item_Live> datas = new ArrayList<>();
    private Live_ListView_Adapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zhibo_fragment, null);
        mRefreshableView = (RefreshableView) view.findViewById(R.id.live_refreshable);
        mListView = (ListView) view.findViewById(R.id.live_listview);

        for (int i = 0; i < 10; i++) {
            Item_Live item = new Item_Live();
            item.setPicId(R.drawable.live_image);
            item.setTitle(getResources().getString(R.string.live_title));
            datas.add(item);
        }

        adapter = new Live_ListView_Adapter(getActivity(), datas);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                startActivity(intent);
            }
        });

        mRefreshableView.setOnRefreshListener(new RefreshableView.PullToRefreshListener() {
            @Override
            public void onRefresh() {
                try {
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
    public void onDestroyView() {
        Log.i("LiveFrag", "onDestroyView");
        mListView = null;
        super.onDestroyView();

    }

    @Override
    public void onDestroy() {
        Log.i("LiveFrag", "onDestroy");
        super.onDestroy();
    }
}
