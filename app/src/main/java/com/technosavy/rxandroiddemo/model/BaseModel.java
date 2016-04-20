package com.technosavy.rxandroiddemo.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nayaneshg on 20/04/16.
 */
public abstract class BaseModel {


    @SerializedName("user")
    protected User user;

    @SerializedName("created_at")
    protected String createdAt;

    @SerializedName("updated_at")
    protected String updatedAt;


    /**
     * @return The user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}


