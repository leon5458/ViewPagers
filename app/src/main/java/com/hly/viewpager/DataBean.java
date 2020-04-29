package com.hly.viewpager;

public class DataBean {

    private String title;
    private String content;
    private String label;
    private String time;
    private int img;

    public DataBean(String title, String content, String label, String time, int img) {
        this.title = title;
        this.content = content;
        this.label = label;
        this.time = time;
        this.img = img;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
