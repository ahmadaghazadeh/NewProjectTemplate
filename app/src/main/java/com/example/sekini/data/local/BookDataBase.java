package com.example.sekini.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.sekini.data.local.db.IBookDao;
import com.example.sekini.data.model.BookEntity;


@Database(entities = {BookEntity.class}, version = BookDataBase.VERSION)
public abstract class BookDataBase extends RoomDatabase {
    static final int VERSION = 1;
    public abstract IBookDao getBookDao();

}
