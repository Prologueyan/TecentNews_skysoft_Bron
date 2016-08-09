package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import bron.yan.tecentnews.R;

/**
 * Created by test on 2016/8/8.
 */
public class Guanzhufenzu_Listview_Adapter extends BaseAdapter {
    private Context mContext;
    private List<Item_Guanzhu_Fenzu> datas;

    public Guanzhufenzu_Listview_Adapter(Context mContext, List<Item_Guanzhu_Fenzu> datas) {
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.add_guanzhu_fenzu_item, null);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.fenzuguanzhu_textview);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText(datas.get(position).getFenZuName());
        return convertView;
    }

    class ViewHolder {
        TextView textView;
    }


}
