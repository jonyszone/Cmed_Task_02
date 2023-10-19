package com.assesment.cmedtask02;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.assesment.cmedtask02.databinding.RowCharacterActivityMainBinding;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {

    List<Character> characterList;
    ItemClickListener itemClickListener;

    public CharacterAdapter(List<Character> characterList, ItemClickListener itemClickListener) {
        this.characterList = characterList;
        this.itemClickListener = itemClickListener;

    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CharacterViewHolder(RowCharacterActivityMainBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        holder.binding.setCharacter(characterList.get(position));
        holder.binding.executePendingBindings();

    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        RowCharacterActivityMainBinding binding;

        public CharacterViewHolder(@NonNull RowCharacterActivityMainBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null)
                itemClickListener.onItemClick(v, getAdapterPosition());
        }
    }
}
