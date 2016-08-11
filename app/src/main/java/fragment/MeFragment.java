package fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import bron.yan.tecentnews.MyGuanzhuActivity;
import bron.yan.tecentnews.R;
import bron.yan.tecentnews.SettingActivity;

/**
 * Created by test on 2016/8/2.
 */
public class MeFragment extends Fragment {


    private RelativeLayout rl_MyAttention;
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
}
