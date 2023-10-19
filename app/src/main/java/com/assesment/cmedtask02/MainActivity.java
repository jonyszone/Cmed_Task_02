package com.assesment.cmedtask02;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.transition.Fade;
import android.transition.Transition;

import com.assesment.cmedtask02.databinding.ActivityMainBinding;
import com.assesment.cmedtask02.databinding.RowCharacterActivityMainBinding;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements CharacterAdapter.ItemClickListener{
    ActivityMainBinding activityMainBinding;
    CharacterViewModel characterViewModel;

    CharacterAdapter characterAdapter;
    List<Character> characterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setContentView(activityMainBinding.getRoot());

        Fade fade = new Fade();
        View decor = getWindow().getDecorView();

        fade.excludeTarget(decor.findViewById(androidx.transition.R.id.action_container), true);
        fade.excludeTarget(android.R.id.statusBarBackground, true);
        fade.excludeTarget(android.R.id.navigationBarBackground, true);


        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);

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
    public void onItemClick(View view, int position) throws IOException {
        Character character = characterList.get(position);
        Log.d("gender", "onItemClick: "+ character.getGender());

        Gson gson = new Gson();
        String characterJson = gson.toJson(character);

        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("CHARACTER", characterJson);

        startActivity(intent);


       /* ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, binding.characterImage, Objects.requireNonNull(ViewCompat.getTransitionName(binding.characterImage)));
        startActivity(intent, optionsCompat.toBundle());*/
    }
}