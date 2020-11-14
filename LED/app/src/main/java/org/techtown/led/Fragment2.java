package org.techtown.led;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class Fragment2 extends Fragment {
    MainActivity mActivity;
    TextView good;
    @Override
    public void onAttach(Activity activity) {
        this.mActivity = (MainActivity) activity;
        super.onAttach(activity);
    }

    @androidx.annotation.Nullable
    @Override
    public View onCreateView(@androidx.annotation.NonNull LayoutInflater inflater, @androidx.annotation.Nullable ViewGroup container, @androidx.annotation.Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment2, container, false);
        good = (TextView) rootView.findViewById(R.id.good);
        /*final TextView fd_state = (TextView) rootView.findViewById(R.id.fd_state);
        final TextView fd_value = (TextView) rootView.findViewById(R.id.fd_value);
        final ImageView fd_img = (ImageView) rootView.findViewById(R.id.fd_img);
        final TextView ufd_state = (TextView) rootView.findViewById(R.id.ufd_state);
        final TextView ufd_value = (TextView) rootView.findViewById(R.id.ufd_value);
        final ImageView ufd_img = (ImageView) rootView.findViewById(R.id.ufd_img);*/

        return rootView;
    }
}
