package com.technosavy.rxandroiddemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technosavy.rxandroiddemo.R;
import com.technosavy.rxandroiddemo.Utils.OnItemClickListener;
import com.technosavy.rxandroiddemo.adapter.viewholder.IssuesViewHolder;
import com.technosavy.rxandroiddemo.model.issues.Issue;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class IssuesListAdapter extends RecyclerView.Adapter<IssuesViewHolder> {

    private List<Issue> data = new ArrayList<>();
    private LayoutInflater inflater;

    private OnItemClickListener onItemClickListener;


    public IssuesListAdapter(Context context) {

        inflater = LayoutInflater.from(context);
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    public void add(List<Issue> data) {

        this.data.addAll(data);
        notifyItemRangeInserted(0 , data.size()-1);
    }

    public void add (Issue issue){

        this.data.add(issue);
        notifyItemInserted(this.data.size());
    }


    @Override
    public IssuesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_issues, parent, false);
        return new IssuesViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(final IssuesViewHolder holder, final int position) {

        final Issue issue = data.get(position);

        holder.bindTo(issue, position);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}