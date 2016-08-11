package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import adapter.Item_News;
import adapter.RecycAdapter;
import bron.yan.tecentnews.R;

/**
 * 新闻要闻界面
 * Created by test on 2016/8/3.
 */
public class YaowenFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Item_News> list_yaowen = new ArrayList<>();
    private RecycAdapter recycAdapter;

    private int[] drawableIds = {R.drawable.yaowen1, R.drawable.yaowen2, R.drawable.yaowen3};
    private String[] titles = {"印度曲棍球队发图批奥运村住宿：连椅子都没有", "中年男子用零食零花钱做诱饵 9岁小女孩被拐走", "女子遭“鬼面人”骚扰7个月 监控拍下惊悚画面"};
    private int[] commentCount = {3730, 694, 3257};
    private String[] tags = {"奥运", "四川", "视频"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_yaowen, null);
        initRecyc(view);
        return view;
    }

    /**
     * 初始化RecycView
     *
     * @param view
     */
    private void initRecyc(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        for (int i = 0; i < 3; i++) {
            Item_News yaowen = new Item_News();
            yaowen.setTitle(titles[i]);
            yaowen.setTag(tags[i]);
            yaowen.setCount(commentCount[i]);
            yaowen.setPicture(getResources().getDrawable(drawableIds[i]));
            list_yaowen.add(yaowen);
        }
        recycAdapter = new RecycAdapter(getActivity(), list_yaowen);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerView.addItemDecoration(new ItemDivider(getActivity(), ItemDivider.VERTICAL_LIST));
        recyclerView.setAdapter(recycAdapter);

    }
}
