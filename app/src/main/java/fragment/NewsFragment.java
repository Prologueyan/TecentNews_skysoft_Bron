package fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import java.util.ArrayList;
import java.util.List;

import adapter.FragAdapter;
import adapter.MyPagerAdapter;
import bron.yan.tecentnews.MainActivity;
import bron.yan.tecentnews.R;

/**
 * 主新闻界面
 * Created by test on 2016/8/2.
 */
public class NewsFragment extends Fragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private static final String TAG = NewsFragment.class.getSimpleName();


    private RadioGroup mRadioGroup;
    private RadioButton radio_yaowen;
    private RadioButton radio_aoyun;
    private RadioButton radio_sichuan;
    private RadioButton radio_shipin;
    private RadioButton radio_yule;
    private RadioButton radio_tiyu;
    private RadioButton radio_nba;
    private RadioButton radio_caijing;
    private RadioButton radio_qiche;

    private View view_yaowen;
    private View view_aoyun;
    private View view_shipin;
    private View view_sichuan;
    private View view_yule;
    private View view_nba;
    private View view_tiyu;
    private View view_caijing;
    private View view_qiche;

    private android.support.v4.app.Fragment mYaowenFragment;
    private android.support.v4.app.Fragment mAoyunFragment;
    private android.support.v4.app.Fragment mShipinFragment;
    private android.support.v4.app.Fragment mSichuanFragment;
    private android.support.v4.app.Fragment mTiyuFragment;
    private android.support.v4.app.Fragment mNbaFragment;
    private android.support.v4.app.Fragment mYuleFragment;
    private android.support.v4.app.Fragment mCaijingFragment;
    private android.support.v4.app.Fragment mQicheFragment;

    private FragAdapter fragAdapter;
    private List<android.support.v4.app.Fragment> fragmentlist;

    private RadioButton mCurrentRadioButton;
    private HorizontalScrollView mHorizontalScrollView;
    private ViewPager viewPager;
    private MyPagerAdapter pagerAdapter;
    private int mCurrentpage;

    private int[] radioIds = {R.id.radio_yaowen, R.id.radio_aoyun, R.id.radio_shipin, R.id.radio_sichuan,
            R.id.radio_yule, R.id.radio_tiyu, R.id.radio_nba, R.id.radio_caijing, R.id.radio_qiche};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragments();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_fragment, null);
        mHorizontalScrollView = (HorizontalScrollView) view.findViewById(R.id.horizontal_scroll_view);
        initView(view);
        initViewPager();
        initYaoWen();
        return view;
    }


    /**
     * 初始化布局
     *
     * @param view
     */
    private void initView(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
//        mImageView = (ImageView) view.findViewById(R.id.tab_news_line);
        mRadioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);
        radio_yaowen = (RadioButton) view.findViewById(R.id.radio_yaowen);
        radio_aoyun = (RadioButton) view.findViewById(R.id.radio_aoyun);
        radio_sichuan = (RadioButton) view.findViewById(R.id.radio_sichuan);
        radio_shipin = (RadioButton) view.findViewById(R.id.radio_shipin);
        radio_yule = (RadioButton) view.findViewById(R.id.radio_yule);
        radio_tiyu = (RadioButton) view.findViewById(R.id.radio_tiyu);
        radio_nba = (RadioButton) view.findViewById(R.id.radio_nba);
        radio_caijing = (RadioButton) view.findViewById(R.id.radio_caijing);
        radio_qiche = (RadioButton) view.findViewById(R.id.radio_qiche);


        mRadioGroup.setOnCheckedChangeListener(this);
        mCurrentRadioButton = radio_yaowen;
        radio_yaowen.setChecked(true);
    }

    /**
     * 初始化Viewpager
     */
    private void initViewPager() {
        int[] viewIds = {R.layout.page_yaowen, R.layout.page_aoyun, R.layout.page_shipin,
                R.layout.page_sichuan, R.layout.page_yule, R.layout.page_tiyu, R.layout.page_nba,
                R.layout.page_caijing, R.layout.page_qiche};
        View[] views = {view_yaowen, view_aoyun, view_shipin, view_sichuan, view_yule,
                view_tiyu, view_nba, view_caijing, view_qiche};
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();

        viewPager.setAdapter(fragAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                int change_width = radio_aoyun.getWidth();

                if (mCurrentpage == 5 && position == 6) {
                    mHorizontalScrollView.smoothScrollBy(change_width, 0);
                } else if (mCurrentpage == 6 && position == 7) {
                    mHorizontalScrollView.smoothScrollBy(change_width, 0);
                } else if (mCurrentpage == 7 && position == 8) {
                    mHorizontalScrollView.smoothScrollBy(change_width, 0);
                } else if (mCurrentpage == 8 && position == 7) {
                    mHorizontalScrollView.smoothScrollBy(-change_width, 0);
                } else if (mCurrentpage == 7 && position == 6) {
                    mHorizontalScrollView.smoothScrollBy(-change_width, 0);
                } else if (mCurrentpage == 6 && position == 5) {
                    mHorizontalScrollView.smoothScrollBy(-change_width, 0);
                }

                ((RadioButton) mRadioGroup.findViewById(radioIds[position])).setChecked(true);
                Log.i(TAG, "page" + position + "");


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    /**
     * 初始化 要闻 界面
     */
    private void initYaoWen() {
        mYaowenFragment = new YaowenFragment();
        view_yaowen = mYaowenFragment.getView();

    }

    @Override
    public void onClick(View v) {
        Log.i(TAG, v.getId() + "");
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Log.i(TAG, "CheckedChanged" + checkedId + "");
        if (checkedId == R.id.radio_yaowen) {
            returnRadioStyle();
            changeRadioStyle(radio_yaowen);
            viewPager.setCurrentItem(0);
            mCurrentpage = 0;
        } else if (checkedId == R.id.radio_aoyun) {
            returnRadioStyle();
            changeRadioStyle(radio_aoyun);
            viewPager.setCurrentItem(1);
            mCurrentpage = 1;
        } else if (checkedId == R.id.radio_shipin) {
            returnRadioStyle();
            changeRadioStyle(radio_shipin);
            viewPager.setCurrentItem(2);
            mCurrentpage = 2;
        } else if (checkedId == R.id.radio_sichuan) {
            returnRadioStyle();
            changeRadioStyle(radio_sichuan);
            viewPager.setCurrentItem(3);
            mCurrentpage = 3;
        } else if (checkedId == R.id.radio_yule) {
            returnRadioStyle();
            changeRadioStyle(radio_yule);
            viewPager.setCurrentItem(4);
            mCurrentpage = 4;
        } else if (checkedId == R.id.radio_tiyu) {
            returnRadioStyle();
            changeRadioStyle(radio_tiyu);
            viewPager.setCurrentItem(5);
            mCurrentpage = 5;
        } else if (checkedId == R.id.radio_nba) {
            returnRadioStyle();
            changeRadioStyle(radio_nba);
            viewPager.setCurrentItem(6);
            mCurrentpage = 6;
        } else if (checkedId == R.id.radio_caijing) {
            returnRadioStyle();
            changeRadioStyle(radio_caijing);
            viewPager.setCurrentItem(7);
            mCurrentpage = 7;
        } else if (checkedId == R.id.radio_qiche) {
            returnRadioStyle();
            changeRadioStyle(radio_qiche);
            viewPager.setCurrentItem(8);
            mCurrentpage = 8;
        }


    }

    private void changeRadioStyle(RadioButton radio) {
        radio.setBackgroundColor(getResources().getColor(R.color.backGroundRadio));
        radio.setTextColor(getResources().getColor(R.color.textRadio));
    }

    private void returnRadioStyle() {
        radio_yaowen.setTextColor(getResources().getColor(R.color.defaultColor));
        radio_yaowen.setBackground(null);
        radio_aoyun.setTextColor(getResources().getColor(R.color.defaultColor));
        radio_aoyun.setBackground(null);
        radio_shipin.setTextColor(getResources().getColor(R.color.defaultColor));
        radio_shipin.setBackground(null);
        radio_sichuan.setTextColor(getResources().getColor(R.color.defaultColor));
        radio_sichuan.setBackground(null);
        radio_yule.setTextColor(getResources().getColor(R.color.defaultColor));
        radio_yule.setBackground(null);
        radio_nba.setTextColor(getResources().getColor(R.color.defaultColor));
        radio_nba.setBackground(null);
        radio_tiyu.setTextColor(getResources().getColor(R.color.defaultColor));
        radio_tiyu.setBackground(null);
        radio_caijing.setTextColor(getResources().getColor(R.color.defaultColor));
        radio_caijing.setBackground(null);
        radio_qiche.setTextColor(getResources().getColor(R.color.defaultColor));
        radio_qiche.setBackground(null);
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
        fragmentlist = new ArrayList<>();
        fragmentlist.add(mYaowenFragment);
        fragmentlist.add(mAoyunFragment);
        fragmentlist.add(mSichuanFragment);
        fragmentlist.add(mShipinFragment);
        fragmentlist.add(mTiyuFragment);
        fragmentlist.add(mNbaFragment);
        fragmentlist.add(mYuleFragment);
        fragmentlist.add(mCaijingFragment);
        fragmentlist.add(mQicheFragment);

        FragmentManager fragmentManager = MainActivity.getMainActivityFragmentManager();
        fragAdapter = new FragAdapter(fragmentManager, fragmentlist);
    }


}
