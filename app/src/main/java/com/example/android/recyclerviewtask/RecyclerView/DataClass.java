package com.example.android.recyclerviewtask.RecyclerView;

public class DataClass {
    String Title,Content;
    int img;

    public DataClass(String title, String content, int img) {
        Title = title;
        Content = content;
        this.img = img;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
