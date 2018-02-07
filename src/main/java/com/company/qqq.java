package com.company;

import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

import java.util.List;

/**
 * Created by admin on 25.01.2018.
 */
public interface qqq {

        @GET("/")
        Call<ResponseBody> loadRepo();
}
