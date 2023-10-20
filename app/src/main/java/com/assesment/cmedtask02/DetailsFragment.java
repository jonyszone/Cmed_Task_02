package com.assesment.cmedtask02;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.assesment.cmedtask02.databinding.FragmentDetailsBinding;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class DetailsFragment extends Fragment {
    FragmentDetailsBinding fragmentDetailsBinding;
    CharacterViewModel characterViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        fragmentDetailsBinding = FragmentDetailsBinding.inflate(inflater, container, false);
        return fragmentDetailsBinding.getRoot();

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        setSharedElementEnterTransition(new ChangeBounds());

        //   characterViewModel =new CharacterViewModel(requireContext());

        assert getArguments() != null;
        String characterJson = getArguments().getString("CHARACTER_JSON");
        Character character = new Gson().fromJson(characterJson, Character.class);

        if (character.getImage() == null || character.getImage().isEmpty()) {
            fragmentDetailsBinding.characterImageDetails.setImageResource(R.drawable.male_placeholder_headshot);

        } else {
            Picasso.get().load(character.getImage()).placeholder(R.drawable.male_placeholder_headshot).into(fragmentDetailsBinding.characterImageDetails);
        }

        fragmentDetailsBinding.characterTitleDetails.setText(character.getName());
        fragmentDetailsBinding.characterMobNumberDetails.setText(character.getGender());

    }
}