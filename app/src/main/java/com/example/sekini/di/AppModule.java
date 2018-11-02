package com.example.sekini.di;


import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.sekini.app.C;
import com.example.sekini.data.IRepository;
import com.example.sekini.data.Repository;
import com.example.sekini.data.local.BookDataBase;
import com.example.sekini.data.local.db.IBookDao;
import com.example.sekini.data.remote.RetrofitApi;
import com.example.sekini.utils.common.CommonUtils;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public abstract class AppModule {

    @Singleton
    @Provides
    @Named("serverUrl")
    public static String getBaseUrl() {
        return C.UrlApi;
    }

    @Singleton
    @Provides
    public static CommonUtils providesCommonUtils(Context context) {
        return new CommonUtils(context);
    }

    @Binds
    @Singleton
    abstract Context getContext(Application application);

    @Singleton
    @Provides
    public static BookDataBase providesDatabase(Context context) {
        return Room.databaseBuilder(context, BookDataBase.class, "Sekini.db").allowMainThreadQueries().build();
    }
    @Singleton
    @Provides
    public static IBookDao providesBookDao(BookDataBase dataBase) {
        return dataBase.getBookDao();
    }

    @Singleton
    @Provides
    public static RetrofitApi provideRetrofitApi(Retrofit retrofit) {
        return new RetrofitApi(retrofit);
    }

    @Provides
    @Singleton
    public static IRepository provideRepository(RetrofitApi api, IBookDao IBookDao, Context context) {
        return new Repository(api, IBookDao, context);
    }
}
