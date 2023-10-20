
package com.assesment.cmedtask02;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.assesment.cmedtask02.databinding.FragmentCharacterBinding;
import com.assesment.cmedtask02.databinding.RowCharacterActivityMainBinding;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

public class CharacterFragment extends Fragment  implements CharacterAdapter.ItemClickListener{
    FragmentCharacterBinding binding;

    CharacterViewModel characterViewModel;

    CharacterAdapter characterAdapter;
    List<Character> characterList;

    private LinearLayoutManager layoutManager;
    private int savedScrollPosition = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCharacterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        characterViewModel =new CharacterViewModel(getContext());
        showCharacterList();

    }

    private void showCharacterList() {
        characterViewModel.getCharacterList().observe(getViewLifecycleOwner(), characters -> {
            if (characters != null) {
                Log.d("character", "showCharacters: " + characters);
                characterList = characters;
                characterAdapter = new CharacterAdapter(characterList, this);
                layoutManager = new LinearLayoutManager(getContext());
                binding.recyclerView.setLayoutManager(layoutManager);
                binding.recyclerView.setAdapter(characterAdapter);

                if (savedScrollPosition != RecyclerView.NO_POSITION) {
                    layoutManager.scrollToPosition(savedScrollPosition);
                }
            }
        });


    }

    @Override
    public void onItemClick(View view, int position) throws IOException {
        RowCharacterActivityMainBinding rowCharacterActivityMainBinding =RowCharacterActivityMainBinding.inflate(getLayoutInflater());

        Character character = characterList.get(position);
        Log.d("gender", "onItemClick: "+ character.getGender());
        Gson gson = new Gson();
        String characterJson = gson.toJson(character);

        Bundle args = new Bundle();
        args.putString("CHARACTER_JSON", characterJson);

        FragmentNavigator.Extras extras = new FragmentNavigator.Extras.Builder()
                .addSharedElement(rowCharacterActivityMainBinding.characterImage, "character_image").build();

        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).navigate(R.id.action_characterFragment_to_detailsFragment
        , args, null, extras);
    }


    @Override
    public void onPause() {
        super.onPause();
        if (layoutManager != null) {
            savedScrollPosition = layoutManager.findFirstVisibleItemPosition();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (layoutManager != null && savedScrollPosition != RecyclerView.NO_POSITION) {
            layoutManager.scrollToPosition(savedScrollPosition);
        }
    }
}