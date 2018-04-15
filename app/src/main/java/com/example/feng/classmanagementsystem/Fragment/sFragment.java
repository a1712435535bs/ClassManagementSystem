package com.example.feng.classmanagementsystem.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.feng.classmanagementsystem.R;
import com.example.feng.classmanagementsystem.View.CircleImageView;
import com.squareup.picasso.Picasso;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by dell on 2018/3/8.
 */

public class sFragment extends android.support.v4.app.Fragment {

    private CircleImageView setCivHead;
    private TextView setTvName;
    private LinearLayout setLlUser;
    private LinearLayout setLlInfo;
    private LinearLayout setLlFeedback;

    public static sFragment newInstance() {
        sFragment fragment = new sFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    @Override
    public void onResume() {
        super.onResume();
        User user = BmobUser.getCurrentUser(User.class);
        if (user != null) {
            setTvName.setText(user.getUsername());
            loadHead(user);
        } else {
            setTvName.setText("未登录");
        }
    }

    private void loadHead(User user) {
        if (user.getHeadFile() != null) {
            BmobFile headFile = user.getHeadFile();
            Picasso.with(getContext()).load(headFile.getFileUrl()).into(setCivHead);
        } else {
            Picasso.with(getContext()).load(R.mipmap.ic_head).into(setCivHead);
        }
    }


}
