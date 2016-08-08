package adapter;

import android.graphics.drawable.Drawable;

/**
 * 要闻条目
 * Created by test on 2016/8/4.
 */
public class Item_News {
    private String title;
    private String tag;
    private int count;
    private Drawable picture;

    public Item_News() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Drawable getPicture() {
        return picture;
    }

    public void setPicture(Drawable picture) {
        this.picture = picture;
    }
}
