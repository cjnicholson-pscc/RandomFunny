package com.example.randomfunny.networking;

import com.google.gson.annotations.SerializedName;

public class MemeResult {
    @SerializedName("postLink")
    String postLink;

    @SerializedName("subreddit")
    String subreddit;

    @SerializedName("title")
    String title;

    @SerializedName("url")
    String url;

    @SerializedName("nsfw")
    boolean nsfw;

    @SerializedName("spoiler")
    boolean spoiler;

    @SerializedName("author")
    String author;

    @SerializedName("ups")
    int ups;


    public String getPostLink() {
        return postLink;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public boolean isNsfw() {
        return nsfw;
    }

    public boolean isSpoiler() {
        return spoiler;
    }

    public String getAuthor() {
        return author;
    }

    public int getUps() {
        return ups;
    }

    @Override
    public String toString() {
        return "MemeResult{" +
                "postLink='" + postLink + '\n' +
                ", subreddit='" + subreddit + '\n' +
                ", title='" + title + '\n' +
                ", url='" + url + '\n' +
                ", nsfw=" + nsfw + "\n" +
                ", spoiler=" + spoiler + '\n' +
                ", author='" + author + '\n' +
                ", ups=" + ups +
                '}';
    }
}
