package adapter;

/**
 * Created by test on 2016/8/8.
 */
public class Item_Guanzhu_Detail {
    private String name;
    private String follower;
    private int picId;
    private int guanzhu_tag; //默认值0 是未关注  值1 为关注

    public Item_Guanzhu_Detail() {
    }

    public Item_Guanzhu_Detail(String name, String follower, int picId, int guanzhu) {
        this.name = name;
        this.follower = follower;
        this.picId = picId;
        this.guanzhu_tag = guanzhu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    public int getGuanzhu_tag() {
        return guanzhu_tag;
    }

    public void setGuanzhu_tag(int guanzhu_tag) {
        this.guanzhu_tag = guanzhu_tag;
    }
}
