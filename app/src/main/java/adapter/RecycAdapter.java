package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bron.yan.tecentnews.NewsDetailActivity;
import bron.yan.tecentnews.R;

/**
 * RecyclerView 适配器
 * Created by test on 2016/8/4.
 */
public class RecycAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<Item_News> lists;
    private List<ImageView> ads = new ArrayList<>();
    private ADAdapter adAdapter;

    //自动轮播的时间间隔
    private final static int TIME_INTERVAL = 5;

    private int[] adIds = {R.drawable.guanggao1, R.drawable.guanggao2, R.drawable.guanggao3};


    public RecycAdapter(Context context, List<Item_News> datas) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        lists = datas;

        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(mContext);
            imageView.setBackground(mContext.getDrawable(adIds[i]));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ads.add(imageView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new MyViewHolder1(mLayoutInflater.inflate(R.layout.recyc_item_yaowen_1, parent, false));
        } else {
            return new MyViewHolder2(mLayoutInflater.inflate(R.layout.recyc_item_yaowen_2, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        int yaowen_item_count = position - 1;

        if (holder instanceof MyViewHolder1) {

            adAdapter = new ADAdapter(ads);
            ((MyViewHolder1) holder).viewPager_holder1.setAdapter(adAdapter);
            ((MyViewHolder1) holder).viewPager_holder1.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

                Boolean isAutoPlay = false;

                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });


        } else if (holder instanceof MyViewHolder2) {
            ((MyViewHolder2) holder).title.setText(lists.get(yaowen_item_count).getTitle());
            ((MyViewHolder2) holder).tag.setText(lists.get(yaowen_item_count).getTag());
            ((MyViewHolder2) holder).count.setText(lists.get(yaowen_item_count).getCount() + "条评论");
            ((MyViewHolder2) holder).picture.setImageDrawable(lists.get(yaowen_item_count).getPicture());
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return lists.size() + 1;
    }

    class MyViewHolder1 extends RecyclerView.ViewHolder {

        ViewPager viewPager_holder1;

        public MyViewHolder1(android.view.View itemView) {
            super(itemView);
            viewPager_holder1 = (ViewPager) itemView.findViewById(R.id.view_pager_yaowen_guanggao);
        }
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        TextView tag;
        TextView count;
        ImageView picture;


        public MyViewHolder2(android.view.View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title_yaowen_item);
            tag = (TextView) itemView.findViewById(R.id.tag_yaowen_item);
            count = (TextView) itemView.findViewById(R.id.comment_count_yaowen_item);
            picture = (ImageView) itemView.findViewById(R.id.imageView_yaowen_item);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, NewsDetailActivity.class);
            mContext.startActivity(intent);
        }
    }
}
