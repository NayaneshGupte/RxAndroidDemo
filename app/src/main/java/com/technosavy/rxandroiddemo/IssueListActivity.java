package com.technosavy.rxandroiddemo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.technosavy.rxandroiddemo.Utils.IAppConstants;
import com.technosavy.rxandroiddemo.Utils.OnItemClickListener;
import com.technosavy.rxandroiddemo.adapter.IssuesListAdapter;
import com.technosavy.rxandroiddemo.base.BaseActivity;
import com.technosavy.rxandroiddemo.service.GitHubWrapper;

import butterknife.Bind;
import butterknife.ButterKnife;

public class IssueListActivity extends BaseActivity implements OnItemClickListener, IAppConstants {


    @Bind(R.id.recyListComments)
    RecyclerView recyclerView;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_list);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getDataFromIntent();

        setData();
    }


    private void getDataFromIntent() {

        type = getIntent().getIntExtra(KEY_REQUEST_TYPE, 0);
    }


    private void setData() {

        IssuesListAdapter adapter = new IssuesListAdapter(this);
        adapter.setOnItemClickListener(this);

        setupRecyclerView(adapter);

        switch (type) {

            case RETRIEVE_DATA_IN_ONE_GO:

                GitHubWrapper.getIssuesForRepo(adapter);

                break;

            case RETRIEVE_DATA_IN_CHUNCKS:

                GitHubWrapper.getIssuesSerially(adapter);

                break;
        }


    }

    private void setupRecyclerView(IssuesListAdapter adapter) {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onItemClick(Bundle bundle, int position) {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_issue_list, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {

            case android.R.id.home: {

                onBackPressed();

                return true;
            }

        }

        return super.onOptionsItemSelected(item);
    }
}
