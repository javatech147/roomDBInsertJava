package taskcom.android.manish.androidjetpack;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Created by Manish Kumar on 11/6/2018
 */
public class NoteViewModel extends AndroidViewModel {

    private String TAG = this.getClass().getSimpleName();
    private NoteDAO noteDAO;
    private NoteRoomDatabase noteRoomDatabase;

    public NoteViewModel(@NonNull Application application) {
        super(application);

        noteRoomDatabase = NoteRoomDatabase.getDatabase(application);
        noteDAO = noteRoomDatabase.noteDAO();
    }

    public void inset(Note note){
        new InsertAsyncTask(noteDAO).execute(note);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "ViewModel Destroyed");
    }

    private class InsertAsyncTask extends AsyncTask<Note, Void, Void> {
        NoteDAO noteDAO;
        public InsertAsyncTask(NoteDAO noteDAO) {
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.insertNote(notes[0]);
            return null;
        }
    }
}
