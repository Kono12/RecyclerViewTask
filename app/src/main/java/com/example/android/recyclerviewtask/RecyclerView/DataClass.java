package com.example.android.recyclerviewtask.RecyclerView;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DataClass {
    String Title,Content;
    int img;
    @PrimaryKey(autoGenerate = true)
    int id;
    public DataClass(String Title, String Content, int img) {
       this.Title = Title;
        this.Content = Content;
        this.img = img;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){return id;}
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
