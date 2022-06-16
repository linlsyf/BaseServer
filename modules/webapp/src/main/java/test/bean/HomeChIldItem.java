package test.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class HomeChIldItem {

//     private  String class;
     private  String name;
     private  String url;
     private  String area;
     private  String year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
