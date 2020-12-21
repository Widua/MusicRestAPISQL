package com.widua.restapi.model;

import javax.persistence.*;

@Entity
public class MusicModel {

    private String author;
    private String title;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MusicModel() {
    }

    public MusicModel(String author, String title, long id) {
        this.author = author;
        this.title = title;
        this.id = id;
    }
}
