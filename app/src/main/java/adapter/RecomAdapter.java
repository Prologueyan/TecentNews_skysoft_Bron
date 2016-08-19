package adapter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bron.yan.tecentnews.R;
import util.DataBaseHelper;

/**
 * 推荐界面的ListViewAdapter
 * Created by test on 2016/8/5.
 */
public class RecomAdapter extends BaseAdapter {

    Context mContext;
    List<Item_RecommendNews> lists;
    private ImageView iv_icon1, iv_icon2, iv_icon3;
    private List<View> ivs = new ArrayList<>();
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase database;
    private List<Integer> picIds = new ArrayList<>();


    public RecomAdapter(Context mContext, List<Item_RecommendNews> lists) {
        this.mContext = mContext;
        this.lists = lists;
        Log.i("adapter", "chuangjian");
        dataBaseHelper = new DataBaseHelper(mContext, "hah", null, 1);
        database = dataBaseHelper.getReadableDatabase();
        Cursor cursor = database.query("guanzhu", new String[]{"name", "overview", "picId"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            picIds.add(cursor.getInt(2));
        }
        cursor.close();
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
        Log.i("adapter", "getView");
        int type = getItemViewType(position);
        ViewHolder1 viewHolder1 = null;
        ViewHolder2 viewHolder2 = null;

        if (convertView == null) {
            switch (type) {
                case 1:
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.recommend_news_item1, parent, false);
                    viewHolder1 = new ViewHolder1();
                    viewHolder1.imageView1 = (ImageView) convertView.findViewById(R.id.rec_guanzhu_1);
                    viewHolder1.imageView2 = (ImageView) convertView.findViewById(R.id.rec_guanzhu_2);
                    viewHolder1.imageView3 = (ImageView) convertView.findViewById(R.id.rec_guanzhu_3);

                    convertView.setTag(viewHolder1);
                    Log.i("viewHolder1", convertView + "");
                    break;
                case 2:
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.recommend_news_item2, parent, false);
                    viewHolder2 = new ViewHolder2();
                    viewHolder2.title = (TextView) convertView.findViewById(R.id.title_tuijian_item);
                    viewHolder2.tag = (TextView) convertView.findViewById(R.id.tag_tuijian_item);
                    viewHolder2.count = (TextView) convertView.findViewById(R.id.comment_count_tuijian_item);
                    viewHolder2.picture = (ImageView) convertView.findViewById(R.id.imageView_tuijian_item);
                    convertView.setTag(viewHolder2);
                    Log.i("viewHolder2", convertView + "");
                    break;
                default:
                    break;
            }
        } else {
            switch (type) {
                case 1:
                    viewHolder1 = (ViewHolder1) convertView.getTag();
                    break;
                case 2:
                    viewHolder2 = (ViewHolder2) convertView.getTag();
                    break;
            }
        }

//        if (type == 1) {
//            Log.i("getView", "type = 1");
//
//            convertView = LayoutInflater.from(mContext).inflate(R.layout.recommend_news_item1, parent, false);
////            convertView.findViewById(R.id.rec_guanzhu_1).setBackgroundResource(picIds.get(0));
//            iv_icon1 = (ImageView) convertView.findViewById(R.id.rec_guanzhu_1);
//            iv_icon2 = (ImageView) convertView.findViewById(R.id.rec_guanzhu_2);
//            iv_icon3 = (ImageView) convertView.findViewById(R.id.rec_guanzhu_3);
//            ivs.add(iv_icon3);
//            ivs.add(iv_icon2);
//            ivs.add(iv_icon1);
//            for (int i = 0; i < picIds.size() && i < 3; i++) {
//                Log.i("recAdapter", picIds.get(i) + "");
//                ivs.get(i).setBackgroundResource(picIds.get(i));
//            }
//            Log.i("viewHolder21", convertView + "");
//        } else {
//            if (convertView == null) {
//                convertView = LayoutInflater.from(mContext).inflate(R.layout.recommend_news_item2, parent, false);
//                viewHolder2 = new ViewHolder2();
//                viewHolder2.title = (TextView) convertView.findViewById(R.id.title_tuijian_item);
//                viewHolder2.tag = (TextView) convertView.findViewById(R.id.tag_tuijian_item);
//                viewHolder2.count = (TextView) convertView.findViewById(R.id.comment_count_tuijian_item);
//                viewHolder2.picture = (ImageView) convertView.findViewById(R.id.imageView_tuijian_item);
//                convertView.setTag(viewHolder2);
//                Log.i("viewHolder22", convertView + "");
//            } else {
//                viewHolder2 = (ViewHolder2) convertView.getTag();
//                Log.i("viewHolder23", convertView + "");
//            }

//        Log.d("Debug", lists.get(position).getTitle());
        switch (type) {
            case 1:
                ivs.add(viewHolder1.imageView3);
                ivs.add(viewHolder1.imageView2);
                ivs.add(viewHolder1.imageView1);
                for (int i = 0; i < picIds.size() && i < 3; i++) {
                    Log.i("recAdapter", picIds.get(i) + "");
                    ivs.get(i).setBackgroundResource(picIds.get(i));
                }
                break;
            case 2:
                viewHolder2.title.setText(lists.get(position).getTitle());
                viewHolder2.tag.setText(lists.get(position).getComeFrom());
                viewHolder2.count.setText(lists.get(position).getCommentCount() + "条评论");
                viewHolder2.picture.setImageResource(lists.get(position).getPictureId());

                break;
        }

        return convertView;

    }

    class ViewHolder1 {

        ImageView imageView1;
        ImageView imageView2;
        ImageView imageView3;

    }

    class ViewHolder2 {

        TextView title;
        TextView tag;
        TextView count;
        ImageView picture;

    }
}
