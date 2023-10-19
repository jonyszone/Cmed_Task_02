package com.assesment.cmedtask02;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

@SuppressLint("StaticFieldLeak")
public class CharacterViewModel extends ViewModel {
    CharacterRepository characterRepository;
    Context context;

    public CharacterViewModel(Context context) {
        this.context = context;
        characterRepository = new CharacterRepository(context);
    }

    public LiveData<List<Character>> getCharacterList() {
        return characterRepository.getCharacterList();
    }
}
