package com.technosavy.rxandroiddemo.adapter.viewholder;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.technosavy.rxandroiddemo.R;
import com.technosavy.rxandroiddemo.Utils.DateTimeUtil;
import com.technosavy.rxandroiddemo.Utils.IAppConstants;
import com.technosavy.rxandroiddemo.Utils.OnItemClickListener;
import com.technosavy.rxandroiddemo.customviews.ExpandableTextView;
import com.technosavy.rxandroiddemo.model.comments.Comment;
import com.technosavy.rxandroiddemo.model.issues.Issue;

import butterknife.Bind;
import butterknife.ButterKnife;

public class IssuesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @Bind(R.id.tvTitle)
    TextView tvTitle;

    @Bind(R.id.tvIssue)
    ExpandableTextView tvIssue;

    @Bind(R.id.tvComment)
    TextView tvComment;

    @Bind(R.id.tvUserName)
    TextView tvUserName;

    @Bind(R.id.tvCommentUserName)
    TextView tvCommentUserName;

    @Bind(R.id.tvTimestamp)
    TextView tvTimestamp;

    @Bind(R.id.imgUser)
    ImageView imgUser;

    @Bind(R.id.imgCommentUser)
    ImageView imgCommentUser;

    View view;

    private Issue issue;

    private OnItemClickListener onItemClickListener;

    private int position;

    public IssuesViewHolder(View itemView, OnItemClickListener onItemClickListener) {
        super(itemView);

        this.onItemClickListener = onItemClickListener;
        view = itemView;

        ButterKnife.bind(this, view);
    }

    public void bindTo(Issue issue, int position) {

        this.issue = issue;

        this.position = position;

        Comment comment = issue.getCommentList().get(0);

        //--- set title
        tvTitle.setText(issue.getTitle());

        //--- set timestamp
        tvTimestamp.setText(DateTimeUtil.getFormatedDate(issue.getUpdatedAt()));

        //--- set Issue body
        tvIssue.setText(issue.getBody());

        //--- set comment
        tvComment.setText(comment.getBody());

        //--- set username for comment
        tvUserName.setText(issue.getUser().getLogin());

        //--- set username for comment
        tvCommentUserName.setText(comment.getUser().getLogin());


        //--- set user image
        Picasso.with(imgUser.getContext())
                .load(issue.getUser().getAvatarUrl())
                .placeholder(R.drawable.ic_placeholder)
                .into(imgUser);

        //--- set comment user image
        Picasso.with(imgCommentUser.getContext())
                .load(comment.getUser().getAvatarUrl())
                .placeholder(R.drawable.ic_placeholder)
                .into(imgCommentUser);
    }

    @Override
    public void onClick(View v) {

        Bundle bundle = new Bundle();
        bundle.putParcelable(IAppConstants.KEY_ISSUE, issue);

        onItemClickListener.onItemClick(bundle, position);
    }
}