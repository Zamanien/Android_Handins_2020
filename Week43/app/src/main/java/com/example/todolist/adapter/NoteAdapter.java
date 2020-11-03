package com.example.todolist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.Note;
import com.example.todolist.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

//FirestoreRecyclerAdapter reduces boilerplate code. Sets many things up for us so that we only have to do queries
public class NoteAdapter extends FirestoreRecyclerAdapter<Note, NoteAdapter.Noteholder> {

    //constructor
    public NoteAdapter(@NonNull FirestoreRecyclerOptions<Note> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull Noteholder noteholder, int position, @NonNull Note model) {

        //tell the adapter what we want to in each view in cardlayout

        //tells the adapter to put the title of out note ('...getTitle()' into the textViewTitle position)
        noteholder.textViewTitle.setText(model.getTitle());
        // -||-
        noteholder.textViewDescription.setText(model.getDescription());
                                            //Casts int into string
        noteholder.textViewPriority.setText(String.valueOf(model.getPriority()));
    }

    @NonNull
    @Override
    //which laoyout to inflate
    public Noteholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_detail, parent, false);

        return new Noteholder(view);
    }

    class Noteholder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        TextView textViewDescription;
        TextView textViewPriority;

        public Noteholder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
            textViewPriority = itemView.findViewById(R.id.text_view_priority);


        }
    }

}
