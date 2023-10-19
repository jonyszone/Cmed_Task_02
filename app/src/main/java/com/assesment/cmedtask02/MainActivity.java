package com.assesment.cmedtask02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.assesment.cmedtask02.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity implements CharacterAdapter.ItemClickListener{
    ActivityMainBinding activityMainBinding;
    CharacterViewModel characterViewModel;

    CharacterAdapter characterAdapter;
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
                    characterAdapter = new CharacterAdapter(characterList, this);
                    activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    activityMainBinding.recyclerView.setAdapter(characterAdapter);
                }
            });


    }

    @Override
    public void onItemClick(View view, int position) {

    }
}