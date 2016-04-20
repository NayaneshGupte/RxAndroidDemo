
package com.technosavy.rxandroiddemo.model.comments;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.technosavy.rxandroiddemo.model.BaseModel;
import com.technosavy.rxandroiddemo.model.User;

public class Comment extends BaseModel implements Parcelable{

    @SerializedName("url")
    private String url;

    @SerializedName("html_url")
    private String htmlUrl;

    @SerializedName("issue_url")
    private String issueUrl;

    @SerializedName("id")
    private long id;

    @SerializedName("body")
    private String body;

    protected Comment(Parcel in) {
        url = in.readString();
        htmlUrl = in.readString();
        issueUrl = in.readString();
        id = in.readLong();
        user = in.readParcelable(User.class.getClassLoader());
        createdAt = in.readString();
        updatedAt = in.readString();
        body = in.readString();
    }

    public static final Creator<Comment> CREATOR = new Creator<Comment>() {
        @Override
        public Comment createFromParcel(Parcel in) {
            return new Comment(in);
        }

        @Override
        public Comment[] newArray(int size) {
            return new Comment[size];
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
     * @return The issueUrl
     */
    public String getIssueUrl() {
        return issueUrl;
    }

    /**
     * @param issueUrl The issue_url
     */
    public void setIssueUrl(String issueUrl) {
        this.issueUrl = issueUrl;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(htmlUrl);
        dest.writeString(issueUrl);
        dest.writeLong(id);
        dest.writeParcelable(user, flags);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeString(body);
    }
}
