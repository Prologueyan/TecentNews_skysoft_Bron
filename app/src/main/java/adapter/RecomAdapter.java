package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bron.yan.tecentnews.R;

/**
 * 推荐界面的ListViewAdapter
 * Created by test on 2016/8/5.
 */
public class RecomAdapter extends BaseAdapter {

    Context mContext;
    List<Item_RecommendNews> lists;


    public RecomAdapter(Context mContext, List<Item_RecommendNews> lists) {
        this.mContext = mContext;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        } else {
            return 2;
        }
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        ViewHolder viewHolder = null;
        ViewHolder viewHolder1 = null;
        if (type == 1) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.recommend_news_item1, parent, false);
            Log.i("ViewHolder1", convertView + "");
//            viewHolder1=new ViewHolder();
//            convertView.setTag(viewHolder1);
//            return view
        } else {

            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.recommend_news_item2, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.title = (TextView) convertView.findViewById(R.id.title_tuijian_item);
                viewHolder.tag = (TextView) convertView.findViewById(R.id.tag_tuijian_item);
                viewHolder.count = (TextView) convertView.findViewById(R.id.comment_count_tuijian_item);
                viewHolder.picture = (ImageView) convertView.findViewById(R.id.imageView_tuijian_item);
                convertView.setTag(viewHolder);
                Log.i("ViewHolder2", convertView + "");
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
                Log.i("ViewHolder3", convertView + "");
            }
            Log.d("Debug", lists.get(position).getTitle());
            viewHolder.title.setText(lists.get(position).getTitle());
            viewHolder.tag.setText(lists.get(position).getComeFrom());
            viewHolder.count.setText(lists.get(position).getCommentCount() + "条评论");
            viewHolder.picture.setImageResource(lists.get(position).getPictureId());

        }
        return convertView;

    }

    class ViewHolder {

        TextView title;
        TextView tag;
        TextView count;
        ImageView picture;

    }
}
