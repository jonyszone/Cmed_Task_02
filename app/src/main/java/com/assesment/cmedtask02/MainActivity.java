package com.assesment.cmedtask02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.assesment.cmedtask02.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    CharacterViewModel characterViewModel;
    List<Character> characterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        characterViewModel =new CharacterViewModel(this);
        showCharacterList();

    }

    private void showCharacterList() {
            characterViewModel.getCharacterList().observe(this, characters -> {
                if (characters != null) {
                    Log.d("character", "showCharacters: " + characters);
                    characterList = characters;
                   /* diaryAdapter = new DiaryAdapter(diaryList, this);
                    binding.diaryRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
                    binding.diaryRecycler.setAdapter(diaryAdapter);*/
                }
            });


    }
}