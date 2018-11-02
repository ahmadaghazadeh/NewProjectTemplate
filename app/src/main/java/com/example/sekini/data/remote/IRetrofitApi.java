package com.example.sekini.data.remote;


import com.example.sekini.data.model.BookEntity;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IRetrofitApi {

    @POST("getBook")
    Call<BookEntity> getBook(@Body PostModel postModel);

}
