package com.example.fragmentpingban;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by longbao on 2019/5/8.
 */
public class NewsTitleFragment extends Fragment {
    private boolean isTwoPane;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_title,container,false);
        RecyclerView newsTitleRecyclerView = (RecyclerView) view.findViewById(R.id.news_title_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        newsTitleRecyclerView.setLayoutManager(layoutManager);
        NewsAdapter adapter = new NewsAdapter(getNews());
        newsTitleRecyclerView.setAdapter(adapter);
        return view;
    }


    public List<News> getNews() {
        List<News> poetryList = new ArrayList<>();
        News poetry1 = new News("登鹳雀楼","白日依山尽，黄河入海流。\n 欲穷千里目，更上一层楼。");
        poetryList.add(poetry1);
        News poetry2 = new News("静夜思","床前明月光，疑是地上霜。\n举头望明月，低头思故乡。");
        poetryList.add(poetry2);
        News poetry3 = new News("春晓","春眠不觉晓，处处闻啼鸟。\n夜来风雨声，花落知多少。");
        poetryList.add(poetry3);
        News poetry4 = new News("九月九日忆山东兄弟","独在异乡为异客，每逢佳节倍思亲。\n遥知兄弟登高处，遍插茱萸少一人。");
        poetryList.add(poetry4);
        News poetry5 = new News("黄鹤楼送孟浩然之广陵","故人西辞黄鹤楼，烟花三月下扬州。\n孤帆远影碧空尽，唯见长江天际流。");
        poetryList.add(poetry5);
        News poetry6 = new News("江雪","千山鸟飞绝，万径人踪灭。\n孤舟蓑笠翁，独钓寒江雪。");
        poetryList.add(poetry6);
        return poetryList;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.news_content_layout) != null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }
    }

    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

        private List<News> newsList;

        class ViewHolder extends RecyclerView.ViewHolder {

            TextView newsTitleText;

            public ViewHolder (View view) {
                super(view);
                newsTitleText = (TextView) view.findViewById(R.id.news_title);
            }
        }

        public NewsAdapter(List<News> newsList) {
            this.newsList = newsList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
            final ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    News news = newsList.get(holder.getAdapterPosition());
                    if(isTwoPane) {
                        NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
                        newsContentFragment.refresh(news.getTitle(), news.getContent());
                    } else {
                        Toast.makeText(getContext() ,""+news.getTitle(),Toast.LENGTH_LONG).show();
                        NewsContentActivity.actionStart(getContext(), news.getTitle(), news.getContent());
                    }
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            News news = newsList.get(position);
            holder.newsTitleText.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return newsList.size();
        }
    }
}
