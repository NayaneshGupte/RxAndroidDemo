package com.technosavy.rxandroiddemo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.technosavy.rxandroiddemo.Utils.OnItemClickListener;
import com.technosavy.rxandroiddemo.adapter.IssuesListAdapter;
import com.technosavy.rxandroiddemo.base.BaseActivity;
import com.technosavy.rxandroiddemo.service.GitHubWrapper;

import butterknife.Bind;
import butterknife.ButterKnife;

public class IssueListActivity extends BaseActivity implements OnItemClickListener {


    @Bind(R.id.recyListComments)
    RecyclerView recyclerView;

    @Bind(R.id.toolbar)
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_list);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        setData();
    }


    private void setData() {

        IssuesListAdapter adapter = new IssuesListAdapter(this);
        adapter.setOnItemClickListener(this);

        GitHubWrapper.getIssuesForRepo(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onItemClick(Bundle bundle, int position) {

    }
}
