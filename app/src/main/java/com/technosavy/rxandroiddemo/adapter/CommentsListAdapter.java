package com.technosavy.rxandroiddemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.technosavy.rxandroiddemo.R;
import com.technosavy.rxandroiddemo.model.comments.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class CommentsListAdapter extends RecyclerView.Adapter<CommentsListAdapter.CommentsViewHolder> {

    private List<Comment> data = new ArrayList<>();
    private LayoutInflater inflater;

    public CommentsListAdapter(Context context) {
        inflater = LayoutInflater.from(context);

    }

    public void add(List<Comment> data) {

        this.data.addAll(data);
        notifyDataSetChanged();
    }


    @Override
    public CommentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row_comments, parent, false);
        return new CommentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentsViewHolder holder, int position) {

        Comment comment = data.get(position);

        //--- set title
        holder.txtvTitle.setText(comment.getUser().getLogin());


        //--- set Issue body
        holder.txtvIssue.setText(comment.getBody());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class CommentsViewHolder extends RecyclerView.ViewHolder {

        final TextView txtvTitle;

        final TextView txtvIssue;

        public CommentsViewHolder(View itemView) {
            super(itemView);

            txtvTitle = (TextView) itemView.findViewById(R.id.txtvTitle);

            txtvIssue = (TextView) itemView.findViewById(R.id.txtvIssue);

        }
    }
}