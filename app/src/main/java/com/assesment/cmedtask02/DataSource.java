package com.assesment.cmedtask02;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataSource {

    private static retrofit2.Retrofit retrofit = null;
    private static final ApiService characterAPI = getRetrofit().create(ApiService.class);

    public static retrofit2.Retrofit getRetrofit() {

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request newRequest = chain.request().newBuilder()
                            .addHeader("Accept", "application/json")
                            .build();
                    return chain.proceed(newRequest);
                })
                .readTimeout(1, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .retryOnConnectionFailure(true)
                .build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl("https://hp-api.onrender.com/api/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public static retrofit2.Retrofit retrofit() {
        return retrofit;
    }

    public static ApiService getCharacterAPI() {
        return characterAPI;
    }
}

