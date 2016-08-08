package adapter;

import android.graphics.drawable.Drawable;

/**
 * 推荐的新闻内容 来自各个关注
 * Created by test on 2016/8/5.
 */
public class Item_RecommendNews {

    private String title;
    private String comeFrom;
    private int commentCount;
    private int pictureId;


    public Item_RecommendNews() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComeFrom() {
        return comeFrom;
    }

    public void setComeFrom(String comeFrom) {
        this.comeFrom = comeFrom;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }
}
