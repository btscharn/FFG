package de.btscharn.ffg.data;

public class ListItem {

    public String title;
    public String description;
    public String url;
    public String fulltext;

    public ListItem(String title, String description, String url, String fulltext){
        this.title = title;
        this.description = description;
        this.url = url;
        this.fulltext = fulltext;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getURL() {
        return url;
    }

    public String getFulltext() {
        return fulltext;
    }

}
