package com.example.NewsApplication.Models;


public class ListViewModel {
    String SiteName;
    int image;
    String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public ListViewModel(String siteName, int image,String link) {
        SiteName = siteName;
        this.image = image;
        this.link = link;
    }

    public String getSiteName() {
        return SiteName;
    }

    public void setSiteName(String siteName) {
        SiteName = siteName;
    }

    @Override
    public String toString() {
        return SiteName;
    }
}
