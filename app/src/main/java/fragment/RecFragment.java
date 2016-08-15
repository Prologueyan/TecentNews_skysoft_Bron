package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import util.RecommendNews;

/**
 * Created by test on 2016/8/2.
 */
public class RecFragment extends Fragment {

    private static final String TAG = RecFragment.class.getSimpleName();

    private List<Item_RecommendNews> lists = new ArrayList<>();
    private ListView listView;
    private List<View> icons = new ArrayList<>();
    private RecomAdapter recomAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tuijian_fragment, null);
        listView = (ListView) view.findViewById(R.id.listview_tuijian);

        lists = RecommendNews.getRecommendNews();
        recomAdapter = new RecomAdapter(getActivity(), lists);
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
        return view;
    }

    @Override
    public void onDestroyView() {
        listView = null;
        super.onDestroyView();
    }
}
