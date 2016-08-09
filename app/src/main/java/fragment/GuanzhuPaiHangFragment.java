package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adapter.GuanzhuDetailAdapter;
import adapter.Item_Guanzhu_Detail;
import bron.yan.tecentnews.R;

/**
 * Created by test on 2016/8/8.
 */
public class GuanzhuPaiHangFragment extends Fragment {

    private List<Item_Guanzhu_Detail> datas = new ArrayList<>();
    private ListView listView;

    private String[] titles = {"我们爱讲冷笑话", "男人装",
            "南方周末", "Vista看天下",
            "今日话题", "VOGUE"};
    private String[] overviews = {"里约时间8月7日，里约奥运会举重男子56kg级，中国选手龙清泉破世界纪录夺冠" +
            "，中国代表团拿下第三金。",
            "里约时间8月7日，里约奥运女子十米气手枪颁奖仪式上，中国选手张梦雪摘得桂冠，这也是中国代表团在" +
                    "里约奥运会上获得的首枚金牌，颁奖仪式现场首次奏响了中华人民共和国国歌。", "北京时间8月8日" +
            "，里约热内卢，奥运会女子双人三米板决赛，吴敏霞/施廷懋夺冠，为中国军团夺取本届奥运会第二金。",
            "“镇上要封山禁牧，限我10天内必须把羊卖掉，否则就要罚款”", "昨天，潼南区毗卢村6社，109岁的郑世祥" +
            "端着大簸箕玉米扬尘，动作娴熟又轻松。", "当地时间2016年8月6日，印度拉贾斯坦邦阿杰梅尔，印度警察为印度独立日检阅彩排"};
    private int[] pcIds = {R.drawable.attention1, R.drawable.attention2, R.drawable.attention3,
            R.drawable.attention4, R.drawable.attention5, R.drawable.attention6};
    private boolean[] follows = {false, false, false, false, false, false};

    private String[] followers = {"123万人", "110万人", "102万人", "98万人", "36万人", "8万人"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        for (int i = 0; i < titles.length; i++) {
            Item_Guanzhu_Detail item = new Item_Guanzhu_Detail();
            item.setName(titles[i]);
            item.setPicId(pcIds[i]);
            item.setGuanzhu(follows[i]);
            item.setFollower(followers[i]);
            datas.add(item);
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.add_guanzhu_page_right, null);
        listView = (ListView) view.findViewById(R.id.guanzhu_listview_page_right);
        listView.setAdapter(new GuanzhuDetailAdapter(getActivity(), datas));
        return view;
    }
}
