package adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by test on 2016/8/4.
 */
public class ADAdapter extends PagerAdapter {

    List<ImageView> pictures;

    public ADAdapter(List<ImageView> pictures) {
        this.pictures = pictures;
        Log.i("pagerAdapter", "create");
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        if (pictures.get(position % pictures.size()).getParent() != null) {
            ((ViewPager) pictures.get(position % pictures.size())
                    .getParent()).removeView(pictures.get(position
                    % pictures.size()));
        }
        container.addView(pictures.get(position % pictures.size()), 0);
        pictures.get(position % pictures.size()).setScaleType(ImageView.ScaleType.CENTER_CROP);
        return pictures.get(position % pictures.size());
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(pictures.get(position % pictures.size()));
    }
}
