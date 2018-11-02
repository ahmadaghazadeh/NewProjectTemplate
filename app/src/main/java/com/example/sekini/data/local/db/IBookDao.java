package com.example.sekini.data.local.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.example.sekini.data.model.BookEntity;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface IBookDao {

    @Insert(onConflict = REPLACE)
    void insert(BookEntity... entities);

    @Insert(onConflict = REPLACE)
    void insert(List<BookEntity> entities);


    @Query("SELECT *FROM book WHERE BookId = :bookId LIMIT 1")
    LiveData<BookEntity> getBookLiveData(int bookId);

    @Query("SELECT *FROM book WHERE BookId = :bookId LIMIT 1")
    BookEntity getBook(int bookId);

}
