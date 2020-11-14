package org.techtown.led;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    MainActivity mActivity;
    private Switch btnPublish1;
    private Switch btnPublish2;
    private Switch btnPublish3;
    int chk = 0;

    @Override
    public void onAttach(Activity activity) {
        this.mActivity = (MainActivity) activity;
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(@androidx.annotation.NonNull LayoutInflater inflater, @androidx.annotation.Nullable ViewGroup container, @androidx.annotation.Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);
        btnPublish1 = (Switch)rootView.findViewById(R.id.switch1);
        btnPublish2 = (Switch)rootView.findViewById(R.id.switch2);
        btnPublish3 = (Switch)rootView.findViewById(R.id.switch3);

        btnPublish1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if(chk==0){
                        btnPublish2.setChecked(true);
                        btnPublish3.setChecked(true);
                        mActivity.sendMsg("LED","ALLON");
                    }
                } else {
                    if(chk==0){
                        btnPublish2.setChecked(false);
                        btnPublish3.setChecked(false);
                        mActivity.sendMsg("LED","ALLOFF");
                    }
                }
                chk = 0;
            }
        });

        btnPublish2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if(btnPublish3.isChecked()){
                        chk=1;
                        btnPublish1.setChecked(true);
                    }
                    mActivity.sendMsg("LED","ONEON");
                } else {
                    if(btnPublish1.isChecked()){
                        chk=1;
                        btnPublish1.setChecked(false);
                    }
                    mActivity.sendMsg("LED","ONEOFF");
                }
            }
        });

        btnPublish3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if(btnPublish2.isChecked()){
                        chk=1;
                        btnPublish1.setChecked(true);
                    }
                    mActivity.sendMsg("LED","TWOON");
                } else {
                    if(btnPublish1.isChecked()){
                        chk=1;
                        btnPublish1.setChecked(false);
                    }
                    mActivity.sendMsg("LED","TWOON");
                }
            }
        });

        return rootView;
    }
}