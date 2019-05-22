package com.example.fragmentpingban;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by longbao on 2019/5/8.
 */
public class NewsContentFragment extends Fragment {


    private View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_content,container,false);
        // Inflate the layout for this fragment
        return view;
    }

    public void refresh(String newsTitle, String newsContent) {
        View visibilityLayout = view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView newsTitleText = (TextView) view.findViewById(R.id.news_title);
        TextView newsContentText = (TextView) view.findViewById(R.id.news_content);
        switch (newsTitle){
            case "登鹳雀楼":
                view.setBackgroundResource(R.drawable.poetry1);
                break;
            case "静夜思":
                view.setBackgroundResource(R.drawable.poetry2);
                break;
            case "春晓":
                view.setBackgroundResource(R.drawable.poetry3);
                break;
            case "九月九日忆山东兄弟":
                view.setBackgroundResource(R.drawable.poetry4);
                break;
            case "黄鹤楼送孟浩然之广陵":
                view.setBackgroundResource(R.drawable.poetry5);
                break;
            case "江雪":
                view.setBackgroundResource(R.drawable.poetry6);
                break;
            default:
                break;
        }
        newsTitleText.setText(newsTitle);
        newsContentText.setText(newsContent);
    }
}
