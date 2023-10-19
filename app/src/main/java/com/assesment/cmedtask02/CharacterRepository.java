package com.assesment.cmedtask02;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterRepository {

    public ObservableInt characterVisibility;
    public ObservableInt characterProgress;
    public ObservableInt characterEmptyVisibility;

    Context context;

    public CharacterRepository(Context context) {
        this.context = context;
    }

    public LiveData<List<Character>> getCharacterList() {
        MutableLiveData<List<Character>> data = new MutableLiveData<>();
        DataSource.getCharacterAPI().getCharacters().enqueue(new Callback<List<Character>>() {
            @Override
            public void onResponse(@NonNull Call<List<Character>> call, Response<List<Character>> response) {


                if (response.isSuccessful()) {
                    if (response.body().size() != 0) {


                        data.postValue(response.body());
                       /* for (Character character : response.body()) {
                            Log.d("Character", "Image URL: " + character.getImage());
                        }*/


                    } else {
                       //

                    }


                } else {

                    try {
                        String errorBody = response.errorBody().string();
                        JSONObject json = new JSONObject(errorBody);
                        Log.d("eee:", json.getString("message"));

                    } catch (IOException | JSONException ex) {
                        ex.printStackTrace();
                    }


                }

               //


            }

            @Override
            public void onFailure(@NonNull Call<List<Character>> call, @NonNull Throwable t) {
                data.postValue(null);
            }

        });
        return data;
    }
}
