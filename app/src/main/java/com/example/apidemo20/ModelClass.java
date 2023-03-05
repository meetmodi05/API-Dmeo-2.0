package com.example.apidemo20;

public class ModelClass {
    public int albumId, id, thumbnailUrl;
    public String title, url;

    public ModelClass(int albumId, int id, int thumbnailUrl, String title, String url) {
        this.albumId = albumId;
        this.id = id;
        this.thumbnailUrl = thumbnailUrl;
        this.title = title;
        this.url = url;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(int thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
