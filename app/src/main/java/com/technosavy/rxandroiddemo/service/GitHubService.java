package com.technosavy.rxandroiddemo.service;


import com.technosavy.rxandroiddemo.model.comments.Comment;
import com.technosavy.rxandroiddemo.model.issues.Issue;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface GitHubService {

    String ENDPOINT = "https://api.github.com/";

    @GET("repos/crashlytics/secureudid/issues")
    Observable<List<Issue>> getIssuesList();

    @GET("repos/crashlytics/secureudid/issues/{number}/comments")
    Observable<List<Comment>> getComments(@Path("number") long number);

}
