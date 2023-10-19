package com.assesment.cmedtask02;

import android.database.Observable;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("characters")
    Call<List<Character>> getCharacters();

    @GET("character/{id}")
    Call<Character> getCharacterById(@Path("id") String id);
}
