package de.btscharn.ffg.data;

public class ListItemDevices {

    private String title;
    private String description;
    private String url;
    private String fulltext;
    private int on1_11;
    private int on1_44;
    private int on1_30;
    private int on1_22;
    private int on1_45;
    private int on1_64;
    private int on1_78;


    public ListItemDevices(String title, String description, String url, String fulltext){
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