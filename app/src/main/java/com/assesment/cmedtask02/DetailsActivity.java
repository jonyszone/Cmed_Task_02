package com.assesment.cmedtask02;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Transition;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.assesment.cmedtask02.databinding.ActivityDetailsBinding;
import com.assesment.cmedtask02.databinding.ActivityMainBinding;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    ActivityDetailsBinding activityDetailsBinding;
    CharacterViewModel characterViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_details);
        setContentView(activityDetailsBinding.getRoot());
/*
        android.transition.Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        Transition transition = (Transition) fade;

        transition.excludeTarget(decor.findViewById(androidx.transition.R.id.action_container), true);
        transition.excludeTarget(android.R.id.statusBarBackground, true);
        transition.excludeTarget(android.R.id.navigationBarBackground, true);


        getWindow().setEnterTransition(transition);
        getWindow().setExitTransition(transition);*/

        characterViewModel =new CharacterViewModel(this);

        String characterJson = getIntent().getStringExtra("CHARACTER");

        Gson gson = new Gson();
        Character character = gson.fromJson(characterJson, Character.class);

        if (character.getImage() == null || character.getImage().isEmpty()) {
                activityDetailsBinding.characterImageDetails.setImageResource(R.drawable.male_placeholder_headshot);

        } else {
            Picasso.get().load(character.getImage()).placeholder(R.drawable.male_placeholder_headshot).into(activityDetailsBinding.characterImageDetails);
        }

        activityDetailsBinding.characterTitleDetails.setText(character.getName());


    }

}