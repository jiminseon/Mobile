package ddwu.mobile.finalproject.ma01_20201020;

import java.io.Serializable;

public class Post implements Serializable {
    long _id;
    String title;
    String date;
    String content;
    String place;

    public Post(long _id, String title, String date, String place, String content) {
        this._id = _id;
        this.title = title;
        this.date = date;
        this.place = place;
        this.content = content;
    }

    public Post(String title, String date, String place, String content) {
        this.title = title;
        this.date = date;
        this.place = place;
        this.content = content;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPlace() {
        return place;
    }


    @Override
    public String toString() {
        return "Post{" +
                "_id=" + _id +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}
