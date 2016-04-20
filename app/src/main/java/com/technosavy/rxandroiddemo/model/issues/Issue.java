
package com.technosavy.rxandroiddemo.model.issues;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.technosavy.rxandroiddemo.model.BaseModel;
import com.technosavy.rxandroiddemo.model.User;
import com.technosavy.rxandroiddemo.model.comments.Comment;

import java.util.ArrayList;
import java.util.List;


public class Issue extends BaseModel implements Parcelable {

    @SerializedName("url")
    private String url;

    @SerializedName("repository_url")
    private String repositoryUrl;

    @SerializedName("labels_url")
    private String labelsUrl;

    @SerializedName("comments_url")
    private String commentsUrl;

    @SerializedName("events_url")
    private String eventsUrl;

    @SerializedName("html_url")
    private String htmlUrl;

    @SerializedName("id")
    private long id;

    @SerializedName("number")
    private long number;

    @SerializedName("title")
    private String title;

    @SerializedName("labels")
    private List<String> labels = new ArrayList<>();

    @SerializedName("state")
    private String state;

    @SerializedName("locked")
    private boolean locked;

    @SerializedName("assignee")
    private Object assignee;

    @SerializedName("milestone")
    private Object milestone;

    @SerializedName("comments")
    private long comments;

    @SerializedName("closed_at")
    private Object closedAt;

    @SerializedName("body")
    private String body;

    private List<Comment> commentList;

    protected Issue(Parcel in) {
        url = in.readString();
        repositoryUrl = in.readString();
        labelsUrl = in.readString();
        commentsUrl = in.readString();
        eventsUrl = in.readString();
        htmlUrl = in.readString();
        id = in.readLong();
        number = in.readLong();
        title = in.readString();
        user = in.readParcelable(User.class.getClassLoader());
        labels = in.createStringArrayList();
        state = in.readString();
        locked = in.readByte() != 0;
        comments = in.readLong();
        createdAt = in.readString();
        updatedAt = in.readString();
        body = in.readString();
        commentList = in.createTypedArrayList(Comment.CREATOR);
    }

    public static final Creator<Issue> CREATOR = new Creator<Issue>() {
        @Override
        public Issue createFromParcel(Parcel in) {
            return new Issue(in);
        }

        @Override
        public Issue[] newArray(int size) {
            return new Issue[size];
        }
    };

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return The repositoryUrl
     */
    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    /**
     * @param repositoryUrl The repository_url
     */
    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    /**
     * @return The labelsUrl
     */
    public String getLabelsUrl() {
        return labelsUrl;
    }

    /**
     * @param labelsUrl The labels_url
     */
    public void setLabelsUrl(String labelsUrl) {
        this.labelsUrl = labelsUrl;
    }

    /**
     * @return The commentsUrl
     */
    public String getCommentsUrl() {
        return commentsUrl;
    }

    /**
     * @param commentsUrl The comments_url
     */
    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    /**
     * @return The eventsUrl
     */
    public String getEventsUrl() {
        return eventsUrl;
    }

    /**
     * @param eventsUrl The events_url
     */
    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    /**
     * @return The htmlUrl
     */
    public String getHtmlUrl() {
        return htmlUrl;
    }

    /**
     * @param htmlUrl The html_url
     */
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    /**
     * @return The id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return The number
     */
    public long getNumber() {
        return number;
    }

    /**
     * @param number The number
     */
    public void setNumber(long number) {
        this.number = number;
    }

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * @return The labels
     */
    public List<String> getLabels() {
        return labels;
    }

    /**
     * @param labels The labels
     */
    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    /**
     * @return The state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state The state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return The locked
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     * @param locked The locked
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    /**
     * @return The assignee
     */
    public Object getAssignee() {
        return assignee;
    }

    /**
     * @param assignee The assignee
     */
    public void setAssignee(Object assignee) {
        this.assignee = assignee;
    }

    /**
     * @return The milestone
     */
    public Object getMilestone() {
        return milestone;
    }

    /**
     * @param milestone The milestone
     */
    public void setMilestone(Object milestone) {
        this.milestone = milestone;
    }

    /**
     * @return The comments
     */
    public long getComments() {
        return comments;
    }

    /**
     * @param comments The comments
     */
    public void setComments(long comments) {
        this.comments = comments;
    }


    /**
     * @return The closedAt
     */
    public Object getClosedAt() {
        return closedAt;
    }

    /**
     * @param closedAt The closed_at
     */
    public void setClosedAt(Object closedAt) {
        this.closedAt = closedAt;
    }

    /**
     * @return The body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body The body
     */
    public void setBody(String body) {
        this.body = body;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(repositoryUrl);
        dest.writeString(labelsUrl);
        dest.writeString(commentsUrl);
        dest.writeString(eventsUrl);
        dest.writeString(htmlUrl);
        dest.writeLong(id);
        dest.writeLong(number);
        dest.writeString(title);
        dest.writeParcelable(user, flags);
        dest.writeStringList(labels);
        dest.writeString(state);
        dest.writeByte((byte) (locked ? 1 : 0));
        dest.writeLong(comments);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeString(body);
        dest.writeTypedList(commentList);
    }
}
