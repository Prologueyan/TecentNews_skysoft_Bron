package adapter;

/**
 * Created by test on 2016/8/8.
 */
public class Item_Guanzhu_Detail {
    private String name;
    private String follower;
    private int picId;
    private boolean guanzhu;

    public Item_Guanzhu_Detail() {
    }

    public Item_Guanzhu_Detail(String name, String follower, int picId, boolean guanzhu) {
        this.name = name;
        this.follower = follower;
        this.picId = picId;
        this.guanzhu = guanzhu;
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

    public boolean isGuanzhu() {
        return guanzhu;
    }

    public void setGuanzhu(boolean guanzhu) {
        this.guanzhu = guanzhu;
    }
}
