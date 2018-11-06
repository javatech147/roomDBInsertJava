package taskcom.android.manish.androidjetpack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewNoteActivity extends AppCompatActivity {

    private EditText etNewNote;
    private Button btnAddNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);


        etNewNote = findViewById(R.id.etNewNote);
        btnAddNote = findViewById(R.id.btnAddNote);

        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent resultIntent = new Intent();
                if(TextUtils.isEmpty(etNewNote.getText().toString().trim())){
                    setResult(RESULT_CANCELED, resultIntent);
                }else{
                    String note = etNewNote.getText().toString().trim();
                    resultIntent.putExtra("KEY_NOTE_ADDED", note);
                    setResult(RESULT_OK, resultIntent);
                }
                finish();
            }
        });
    }
}
