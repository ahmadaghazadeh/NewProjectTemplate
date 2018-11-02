package com.example.sekini.data.model;

import android.arch.persistence.room.Entity;


@Entity(tableName = "Book",primaryKeys = "BookId")
public class BookEntity extends BaseEntity{
    public int BookId;
    public String Name;
    public int ChapterCount;
    public String Description;
    public String UserName;
    public int UserId;
    public String ReleaseDate;
    public String Url;
}

