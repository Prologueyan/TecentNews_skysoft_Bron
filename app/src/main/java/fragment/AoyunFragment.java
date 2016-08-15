package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bron.yan.tecentnews.R;

/**
 * Created by test on 2016/8/3.
 */
public class AoyunFragment extends Fragment {

    private static final String TAG = AoyunFragment.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "oncreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "oncreateView");
        View view = inflater.inflate(R.layout.page_aoyun, null);
        return view;
    }
}
