package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bron.yan.tecentnews.R;

/**
 * Created by test on 2016/8/8.
 */
public class MyGuanzhu_DetailAdapter extends BaseAdapter {
    private Context mContext;
    private List<Item_MyGuanzhu_Detail> datas;

    public MyGuanzhu_DetailAdapter(Context mContext, List<Item_MyGuanzhu_Detail> datas) {
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.myguanzhu_detail, null);
            viewHolder.picture = (ImageView) convertView.findViewById(R.id.item_myguanzhu_pic);
            viewHolder.name = (TextView) convertView.findViewById(R.id.item_myguanzhu_name);
            viewHolder.overview = (TextView) convertView.findViewById(R.id.item_myguanzhu_overview);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.picture.setImageResource(datas.get(position).getPicId());
        viewHolder.name.setText(datas.get(position).getName());
        viewHolder.overview.setText(datas.get(position).getOverView());

        return convertView;
    }

    class ViewHolder {
        ImageView picture;
        TextView name;
        TextView overview;
    }
}
