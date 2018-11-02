package com.example.sekini.data;

import android.content.Context;

import com.example.sekini.data.local.db.IBookDao;
import com.example.sekini.data.remote.RetrofitApi;


public class Repository implements IRepository {

    private RetrofitApi api;

    private IBookDao bookDao;

    private Context context;

    public Repository(RetrofitApi api, IBookDao bookDao, Context context) {
        this.api = api;
        this.bookDao = bookDao;
        this.context = context;

    }


}
