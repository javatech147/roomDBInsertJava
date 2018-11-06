package taskcom.android.manish.androidjetpack;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.UUID;

/**
 * Created by Manish Kumar on 11/5/2018
 */

public class MainActivity extends AppCompatActivity {
    private static final int NEW_NOTE_ACTIVITY_REQUEST_CODE = 1;
    private String TAG = this.getClass().getSimpleName();
    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, NewNoteActivity.class), NEW_NOTE_ACTIVITY_REQUEST_CODE);
            }
        });

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class); // Data is preserved when screen is rotated.
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == NEW_NOTE_ACTIVITY_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                String noteString = data.getStringExtra("KEY_NOTE_ADDED");
                String noteId = UUID.randomUUID().toString();
                Note note = new Note(noteId, noteString);
                noteViewModel.inset(note);
                Toast.makeText(this, "Note Inserted", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Note Not Inserted", Toast.LENGTH_SHORT).show();
            }
        }
    }
}