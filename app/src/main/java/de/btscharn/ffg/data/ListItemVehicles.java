package de.btscharn.ffg.data;

public class ListItemVehicles {

    private String title;
    private String radio;
    private String description;
    private String url;
    private String fulltext;


    public ListItemVehicles(String title, String radio, String description, String url, String fulltext){
        this.title = title;
        this.radio = radio;
        this.description = description;
        this.url = url;
        this.fulltext = fulltext;
    }

    public void ListItemDevices(String radio) {
        this.radio = radio;
    }

    public String getTitle() {
        return title;
    }

    public String getRadio() {
        return radio;
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