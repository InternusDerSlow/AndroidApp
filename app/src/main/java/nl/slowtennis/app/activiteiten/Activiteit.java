package nl.slowtennis.app.activiteiten;

import java.io.Serializable;

public class Activiteit implements Serializable {
    private String title,  date, aanvang;
    private int banner;



    public String getAanvang() {
        return aanvang;
    }

    public void setAanvang(String aanvang) {
        this.aanvang = aanvang;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public int getBanner() {
        return banner;
    }

    public void getBanner(int thumbnail) {
        this.banner = thumbnail;
    }
}


