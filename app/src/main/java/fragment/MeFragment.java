package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import bron.yan.tecentnews.MyGuanzhuActivity;
import bron.yan.tecentnews.MyShoucangActivity;
import bron.yan.tecentnews.R;
import bron.yan.tecentnews.SettingActivity;

/**
 * Created by test on 2016/8/2.
 */
public class MeFragment extends Fragment {


    private RelativeLayout rl_MyAttention;
    private RelativeLayout rl_MyShoucang;
    private ImageView iv_setting;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.me_fragment, null);
        rl_MyAttention = (RelativeLayout) view.findViewById(R.id.rl_wodeguanzhu);
        rl_MyAttention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyGuanzhuActivity.class);
                startActivity(intent);
            }
        });

        rl_MyShoucang = (RelativeLayout) view.findViewById(R.id.rl_wodeshoucang);
        rl_MyShoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyShoucangActivity.class);
                startActivity(intent);
            }
        });

        iv_setting = (ImageView) view.findViewById(R.id.image_setting);
        iv_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }


    @Override
    public void onDestroyView() {
        iv_setting = null;

        super.onDestroyView();
    }
}
