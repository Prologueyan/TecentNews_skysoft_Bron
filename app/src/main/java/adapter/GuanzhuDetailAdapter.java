package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bron.yan.tecentnews.R;

/**
 * Created by test on 2016/8/8.
 */
public class GuanzhuDetailAdapter extends BaseAdapter {

    private Context mContext;
    private List<Item_Guanzhu_Detail> datas;

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
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
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
        if (datas.get(position).isGuanzhu()) {
            viewHolder.follow.setText("已关注");
            viewHolder.follow.setBackground(null);
        }else{
            viewHolder.follow.setText("关注");
        }


        viewHolder.follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
