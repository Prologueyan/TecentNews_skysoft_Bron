package util;

import android.content.Context;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * 下拉刷新ListView
 * Created by test on 2016/8/5.
 */
public class LoadMoreListView extends ListView implements AbsListView.OnScrollListener {

    public LoadMoreListView(Context context) {
        super(context);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
