package com.technosavy.rxandroiddemo.service;

import android.content.Context;

import com.technosavy.rxandroiddemo.Utils.AppUtil;
import com.technosavy.rxandroiddemo.Utils.DateComparator;
import com.technosavy.rxandroiddemo.adapter.IssuesListAdapter;
import com.technosavy.rxandroiddemo.model.issues.Issue;

import java.util.Collections;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 *
 */
public class GitHubWrapper {

    public static final String TAG = GitHubWrapper.class.getSimpleName();


    public static void getIssuesForRepo(Context context ,final IssuesListAdapter adapter) {

        GitHubService gitHubService = ServiceFactory.createServiceFrom(GitHubService.class, GitHubService.ENDPOINT);

        gitHubService.getIssuesList()// get all issues
                .filter(issues -> AppUtil.isNetworkAvailable(context))
                .subscribeOn(Schedulers.io())// process request on Worker thread
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
                // lambda expression with no exception handling can result into crash
                .subscribe(new Subscriber<List<Issue>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<Issue> issues) {

                        adapter.add(issues);
                    }
                });//update adapter

    }


    public static void getIssuesSerially(Context context ,final IssuesListAdapter adapter) {

        GitHubService gitHubService = ServiceFactory.createServiceFrom(GitHubService.class, GitHubService.ENDPOINT);

        gitHubService.getIssuesList()// get all issues
                .filter(issues1 -> AppUtil.isNetworkAvailable(context))
                .subscribeOn(Schedulers.io())// process request on Worker thread
                .observeOn(AndroidSchedulers.mainThread()) // get results on main thread
                .flatMap(issues -> Observable.from(issues))// get each Observable<Issue>
                .filter(issue -> issue.getCommentsUrl() != null)// don't request for comments if url is null

                .flatMap(new Func1<Issue, Observable<Issue>>() { // GET all comments for each issue
                    @Override
                    public Observable<Issue> call(Issue issue) {


                        return gitHubService.getComments(issue.getNumber())
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .map(comments -> {

                                    issue.setCommentList(comments);

                                    return issue;
                                })
                                .subscribeOn(Schedulers.computation())// reduce the work on main thread
                                .map(issue1 -> {

                                    Collections.sort(issue1.getCommentList(), new DateComparator());

                                    return issue1;
                                });

                    }


                })

                // above observable result was on Schedulers.computation()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Issue>() {// subscriber with exception handling
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Issue issue) {

                        adapter.add(issue);
                    }
                });


    }
}
