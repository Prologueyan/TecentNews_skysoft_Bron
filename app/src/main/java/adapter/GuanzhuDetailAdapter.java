package adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bron.yan.tecentnews.R;
import util.DataBaseHelper;

/**
 * Created by test on 2016/8/8.
 */
public class GuanzhuDetailAdapter extends BaseAdapter {

    private Context mContext;
    private List<Item_Guanzhu_Detail> datas;
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase database;

    public GuanzhuDetailAdapter(Context mContext, List<Item_Guanzhu_Detail> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }


    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.add_guanzhu_detail_item, null);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.guanzhu_tubiao);
            viewHolder.name = (TextView) convertView.findViewById(R.id.guanzhu_detail_name);
            viewHolder.follower = (TextView) convertView.findViewById(R.id.guanzhu_detail_number);
            viewHolder.follow = (Button) convertView.findViewById(R.id.guanzhu_button);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.imageView.setImageResource(datas.get(position).getPicId());
        viewHolder.name.setText(datas.get(position).getName());
        viewHolder.follower.setText(datas.get(position).getFollower());

        Log.i("guanzhu_tag", datas.get(position).getGuanzhu_tag() + "");
        //设置button样式
        if (datas.get(position).getGuanzhu_tag() == 1) {
            viewHolder.follow.setText("已关注");
            viewHolder.follow.setTextColor(Color.parseColor("#535353"));
            viewHolder.follow.setBackground(null);
//            viewHolder.follow.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    dataBaseHelper = new DataBaseHelper(mContext, "guanzhu_db", null, 1);
//                    database = dataBaseHelper.getWritableDatabase();
//                    database.delete("guanzhu", "name=?", new String[]{viewHolder.name.getText().toString()});
//
//                    viewHolder.follow.setText("关注");
//                    datas.get(position).setGuanzhu_tag(0);
//                }
//            });
        } else {
            viewHolder.follow.setText("关注");
//            viewHolder.follow.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    dataBaseHelper = new DataBaseHelper(mContext, "guanzhu_db", null, 1);
//                    database = dataBaseHelper.getWritableDatabase();
//                    ContentValues values = new ContentValues();
//                    values.put("name", datas.get(position).getName());
//                    values.put("picId", datas.get(position).getPicId());
//                    values.put("follow", 1);
//                    database.insert("guanzhu", null, values);
//                    viewHolder.follow.setText("已关注");
//                    viewHolder.follow.setTextColor(Color.parseColor("#535353"));
//                    viewHolder.follow.setBackground(null);
//                    datas.get(position).setGuanzhu_tag(1);
//
//                }
//            });

        }

        //设置点击事件监听
        viewHolder.follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataBaseHelper = new DataBaseHelper(mContext, "guanzhu_db", null, 1);
                database = dataBaseHelper.getWritableDatabase();
                if (datas.get(position).getGuanzhu_tag() == 1) {
                    database.delete("guanzhu", "name=?", new String[]{viewHolder.name.getText().toString()});
                    viewHolder.follow.setText("关注");
                    viewHolder.follow.setBackgroundResource(R.drawable.button_style);
                    datas.get(position).setGuanzhu_tag(0);
                } else {
                    ContentValues values = new ContentValues();
                    values.put("name", datas.get(position).getName());
                    values.put("picId", datas.get(position).getPicId());
                    values.put("follow", 1);
                    database.insert("guanzhu", null, values);
                    viewHolder.follow.setText("已关注");
                    viewHolder.follow.setTextColor(Color.parseColor("#535353"));
                    viewHolder.follow.setBackground(null);
                    datas.get(position).setGuanzhu_tag(1);
                }
            }
        });


        return convertView;
    }

    class ViewHolder {
        ImageView imageView;
        TextView name;
        TextView follower;
        Button follow;
    }
}
