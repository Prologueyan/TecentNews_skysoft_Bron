package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import fragment.AoyunFragment;
import fragment.CaijingFragment;
import fragment.NbaFragment;
import fragment.QicheFragment;
import fragment.ShipinFragment;
import fragment.SichuanFragment;
import fragment.TiyuFragment;
import fragment.YaowenFragment;
import fragment.YuleFragment;

/**
 * Fragment 适配器
 * Created by test on 2016/8/3.
 */
public class FragAdapter extends FragmentPagerAdapter {

    List<Fragment> mFragments;
    private android.support.v4.app.Fragment mYaowenFragment;
    private android.support.v4.app.Fragment mAoyunFragment;
    private android.support.v4.app.Fragment mShipinFragment;
    private android.support.v4.app.Fragment mSichuanFragment;
    private android.support.v4.app.Fragment mTiyuFragment;
    private android.support.v4.app.Fragment mNbaFragment;
    private android.support.v4.app.Fragment mYuleFragment;
    private android.support.v4.app.Fragment mCaijingFragment;
    private android.support.v4.app.Fragment mQicheFragment;

    private String[] titles = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public FragAdapter(FragmentManager fm) {
        super(fm);
        initFragments();

    }


    @Override
    public Fragment getItem(int position) {
//        switch (position) {
//            case 0:
//                YaowenFragment item1 = new YaowenFragment();
//                return item1;
//            case 1:
//                AoyunFragment item2 = new AoyunFragment();
//                return item2;
//            case 2:
//                ShipinFragment item3 = new ShipinFragment();
//                return item3;
//            case 3:
//                SichuanFragment item4 = new SichuanFragment();
//                return item4;
//            case 4:
//                YuleFragment item5 = new YuleFragment();
//                return item5;
//            case 5:
//                TiyuFragment item6 = new TiyuFragment();
//                return item6;
//            case 6:
//                NbaFragment item7 = new NbaFragment();
//                return item7;
//            case 7:
//                CaijingFragment item8 = new CaijingFragment();
//                return item8;
//            case 8:
//                QicheFragment item9 = new QicheFragment();
//                return item9;
//            default:
//                return null;
//        }
        return mFragments.get(position);

    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    private void initFragments() {

        mAoyunFragment = new AoyunFragment();
        mYaowenFragment = new YaowenFragment();
        mSichuanFragment = new SichuanFragment();
        mShipinFragment = new ShipinFragment();
        mTiyuFragment = new TiyuFragment();
        mNbaFragment = new NbaFragment();
        mYuleFragment = new YuleFragment();
        mCaijingFragment = new CaijingFragment();
        mQicheFragment = new QicheFragment();
        mFragments = new ArrayList<>();
        mFragments.add(mYaowenFragment);
        mFragments.add(mAoyunFragment);
        mFragments.add(mShipinFragment);
        mFragments.add(mSichuanFragment);
        mFragments.add(mYuleFragment);
        mFragments.add(mTiyuFragment);
        mFragments.add(mNbaFragment);
        mFragments.add(mCaijingFragment);
        mFragments.add(mQicheFragment);
    }

}
