package util;

import java.util.ArrayList;
import java.util.List;

import adapter.Item_RecommendNews;
import bron.yan.tecentnews.R;

/**
 * 可关注的新闻信息集合
 * Created by test on 2016/8/5.
 */
public class RecommendNews {

    public static int number;
    private static List<Item_RecommendNews> datas;

    private static int[] drawableIds = {0,R.drawable.tuijian1, R.drawable.tuijian2, R.drawable.tuijian3, R.drawable.tuijian4, R.drawable.tuijian5, R.drawable.tuijian6};

    private static String[] titles = {"","美军宣布F-35A可参与作战 首个海外中队部署日本", "金正恩出席“敢死队”积极分子大会",
            "开幕式导演：预算不够人来凑 舞蹈前所未见", "三星获奥运独家虚拟现实播放权 将借势推广VR设备",
            "三星获奥运独家虚拟现实播放权 将借势推广VR设备", "首款Android 7.0新机下月发布 竟然不是谷歌系"};

    private static int[] commentCount = {0,331, 633, 10, 563, 66, 29};

    private static String[] tags = {"","Vista看天下", "Vista看天下", "今日话题", "今日话题", "VOGUE", "VOGUE"};


    public static List<Item_RecommendNews> getRecommendNews() {
        datas = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Item_RecommendNews news = new Item_RecommendNews();
            news.setTitle(titles[i]);
            news.setComeFrom(tags[i]);
            news.setCommentCount(commentCount[i]);
            news.setPictureId(drawableIds[i]);
            datas.add(news);
        }

        return datas;
    }

}
