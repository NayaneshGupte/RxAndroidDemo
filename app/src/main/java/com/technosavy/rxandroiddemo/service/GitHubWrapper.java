package com.technosavy.rxandroiddemo.service;

import com.technosavy.rxandroiddemo.Utils.DateComparator;
import com.technosavy.rxandroiddemo.adapter.IssuesListAdapter;
import com.technosavy.rxandroiddemo.model.issues.Issue;

import java.util.Collections;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 *
 */
public class GitHubWrapper {


    public static void getIssuesForRepo(final IssuesListAdapter adapter) {

        GitHubService gitHubService = ServiceFactory.createServiceFrom(GitHubService.class, GitHubService.ENDPOINT);

        gitHubService.getIssuesList()// get all issues
                .subscribeOn(Schedulers.newThread())// process request on Worker thread
                .observeOn(AndroidSchedulers.mainThread()) // get results on main thread
                .flatMap(issues -> Observable.from(issues))// get each Observable<Issue>
                .filter(issue -> issue.getCommentsUrl() != null)// don't request for comments if url is null
                .flatMap(new Func1<Issue, Observable<Issue>>() { // GET all comments for each issue
                    @Override
                    public Observable<Issue> call(Issue issue) {


                        return gitHubService.getComments(issue.getNumber())
                                .subscribeOn(Schedulers.newThread())
                                .observeOn(AndroidSchedulers.mainThread())
                                .map(comments -> {

                                    Collections.sort(comments, new DateComparator());
                                    issue.setCommentList(comments);

                                    return issue;
                                });
                    }


                })
                .toList()// convert back to list
                .map(issues -> { // sort on basis of date

                    Collections.sort(issues, new DateComparator());
                    return issues;
                })
                .subscribe(adapter::add);//update adapter

    }


}