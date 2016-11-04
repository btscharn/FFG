package de.btscharn.ffg.data;

public class ListItem {

    private String title;
    private String description;
    private String url;
    private String fulltext;
    //Vehicle-specific
    private String radio;
    //Device-specific
    private int on1_11;
    private int on1_44;
    private int on1_30;
    private int on1_22;
    private int on1_45;
    private int on1_64;
    private int on1_78;


    public ListItem(String title, String description, String url, String fulltext){
        this.title = title;
        this.description = description;
        this.url = url;
        this.fulltext = fulltext;
    }

    public void ListItemVehicles(String radio) {
        this.radio = radio;
    }

    public void ListItemDevices(String radio) {
        this.radio = radio;
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
