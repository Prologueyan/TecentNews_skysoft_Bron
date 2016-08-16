package fragment;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import adapter.FragAdapter;
import bron.yan.tecentnews.R;
import util.ObServerScrollView;
import util.ScrollViewListener;

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


    private FragAdapter fragAdapter;

    private RadioButton mCurrentRadioButton;
    private HorizontalScrollView mHorizontalScrollView;
    private ViewPager viewPager;
    private int mCurrentpage;


    private Animation animation = null;

    private int oldX = 0;
    private int scrollX = 0;
    private int oldScrollX = 0;
    private int currentX = 0;
    private int oldPosition = 0;
    private int position = 0;
    private int nowScroll = 0;
    private ObServerScrollView scrollView;

    private int[] radioIds = {R.id.radio_yaowen, R.id.radio_aoyun, R.id.radio_shipin, R.id.radio_sichuan,
            R.id.radio_yule, R.id.radio_tiyu, R.id.radio_nba, R.id.radio_caijing, R.id.radio_qiche};
    private int cursorWidth;
    private int offset;
    private ImageView cursor;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        initFragments();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.news_fragment, null);
//        mHorizontalScrollView = (HorizontalScrollView) view.findViewById(R.id.horizontal_scroll_view);
        scrollView = (ObServerScrollView) view.findViewById(R.id.observerScrollView);
        initView(view);
        initCursor(6, view);
        initViewPager();
        scrollView.setScrollViewListener(new ScrollViewListener() {
            @Override
            public void onScrollChanged(ObServerScrollView scrollView, int x, int y, int oldx, int oldy) {
                scrollX = x;
                nowScroll = scrollX - oldScrollX;
                oldX = currentX - nowScroll;
            }
        });
        return view;
    }

    private void initCursor(int tagNum, View view) {
        cursorWidth = BitmapFactory.decodeResource(getResources(),
                R.mipmap.cursor).getWidth();
        Log.d("Debug", cursorWidth + "....");
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        offset = ((dm.widthPixels / tagNum) - cursorWidth) / 3+12;
        Log.d("Debug", offset + "......offset........" + (dm.widthPixels / tagNum));
        cursor = (ImageView) view.findViewById(R.id.tecent_iv_cursor);
        animation = new TranslateAnimation(0, offset, 0, 0);
        animation.setFillAfter(true);
        animation.setDuration(100);
        cursor.startAnimation(animation);
        oldX = offset;

    }


    /**
     * 初始化布局
     *
     * @param view
     */
    private void initView(View view) {

        Log.i(TAG, "initView");

        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
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

        Log.i(TAG, "initViewPager");

        viewPager.setAdapter(fragAdapter);
        viewPager.setCurrentItem(0);
        Log.i(TAG, "currentItem :" + viewPager.getCurrentItem());
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int arg0) {

                position = arg0;
                int x = arg0 - oldPosition;
                currentX = oldX + x * 180;
                Log.d("Debug", currentX + ".......currentX");
                if (oldPosition < position) {
                    if (currentX + 135 <= 1080) {
                        Log.d("Debug", "2222222222");
                        animation = new TranslateAnimation(oldX + scrollX, currentX + scrollX, 0, 0);
                        animation.setFillAfter(true);
                        animation.setDuration(100);
                        cursor.startAnimation(animation);
                        oldX = currentX;
                    } else {
                        Log.d("Debug", "333333333333333");
                        animation = new TranslateAnimation(oldX + scrollX, currentX + scrollX, 0, 0);
                        animation.setFillAfter(true);
                        animation.setDuration(100);
                        cursor.startAnimation(animation);
                        oldX = currentX;
                        animation.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                scrollView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        scrollView.smoothScrollBy(180, 0);
                                    }
                                });
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });

                    }
                } else if (position < oldPosition) {
                    if (currentX - 100 > 0) {
                        Log.d("Debug", "111111111");
                        Log.d("Debug", currentX + ".......currentX........." + oldX);
                        animation = new TranslateAnimation(oldX + scrollX, currentX + scrollX, 0, 0);
                        animation.setFillAfter(true);
                        animation.setDuration(100);
                        cursor.startAnimation(animation);
                        oldX = currentX;
                    } else {
                        animation = new TranslateAnimation(oldX + scrollX, currentX + scrollX, 0, 0);
                        animation.setFillAfter(true);
                        animation.setDuration(100);
                        cursor.startAnimation(animation);
                        oldX = currentX;
                        animation.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                scrollView.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        scrollView.smoothScrollBy(-180, 0);
                                    }
                                });
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                    }
                }
                oldX = currentX;
                oldScrollX = scrollX;
                oldPosition = position;

//                int change_width = radio_aoyun.getWidth();
//
//                if (mCurrentpage == 5 && position == 6) {
//                    mHorizontalScrollView.smoothScrollBy(change_width, 0);
//                } else if (mCurrentpage == 6 && position == 7) {
//                    mHorizontalScrollView.smoothScrollBy(change_width, 0);
//                } else if (mCurrentpage == 7 && position == 8) {
//                    mHorizontalScrollView.smoothScrollBy(change_width, 0);
//                } else if (mCurrentpage == 8 && position == 7) {
//                    mHorizontalScrollView.smoothScrollBy(-change_width, 0);
//                } else if (mCurrentpage == 7 && position == 6) {
//                    mHorizontalScrollView.smoothScrollBy(-change_width, 0);
//                } else if (mCurrentpage == 6 && position == 5) {
//                    mHorizontalScrollView.smoothScrollBy(-change_width, 0);
//                }
//
//                ((RadioButton) mRadioGroup.findViewById(radioIds[position])).setChecked(true);
//                Log.i(TAG, "page" + position + "");


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    @Override
    public void onClick(View v) {
        int[] location = new int[2];
        v.getLocationOnScreen(location);
        int[] location1 = new int[2];
        cursor.getLocationOnScreen(location1);
        currentX = location[0] + offset;
        Toast.makeText(getActivity(), currentX + "", Toast.LENGTH_SHORT).show();
        Log.i(TAG, v.getId() + "");
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.radio_yaowen) {
//            returnRadioStyle();
//            changeRadioStyle(radio_yaowen);
            viewPager.setCurrentItem(0);
            mCurrentpage = 0;
        } else if (checkedId == R.id.radio_aoyun) {
//            returnRadioStyle();
//            changeRadioStyle(radio_aoyun);
            viewPager.setCurrentItem(1);
            mCurrentpage = 1;
        } else if (checkedId == R.id.radio_shipin) {
//            returnRadioStyle();
//            changeRadioStyle(radio_shipin);
            viewPager.setCurrentItem(2);
            mCurrentpage = 2;
        } else if (checkedId == R.id.radio_sichuan) {
//            returnRadioStyle();
//            changeRadioStyle(radio_sichuan);
            viewPager.setCurrentItem(3);
            mCurrentpage = 3;
        } else if (checkedId == R.id.radio_yule) {
//            returnRadioStyle();
//            changeRadioStyle(radio_yule);
            viewPager.setCurrentItem(4);
            mCurrentpage = 4;
        } else if (checkedId == R.id.radio_tiyu) {
//            returnRadioStyle();
//            changeRadioStyle(radio_tiyu);
            viewPager.setCurrentItem(5);
            mCurrentpage = 5;
        } else if (checkedId == R.id.radio_nba) {
//            returnRadioStyle();
//            changeRadioStyle(radio_nba);
            viewPager.setCurrentItem(6);
            mCurrentpage = 6;
        } else if (checkedId == R.id.radio_caijing) {
//            returnRadioStyle();
//            changeRadioStyle(radio_caijing);
            viewPager.setCurrentItem(7);
            mCurrentpage = 7;
        } else if (checkedId == R.id.radio_qiche) {
//            returnRadioStyle();
//            changeRadioStyle(radio_qiche);
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

        Log.i(TAG, "initFragments");

        fragAdapter = new FragAdapter(getChildFragmentManager());
    }


}
