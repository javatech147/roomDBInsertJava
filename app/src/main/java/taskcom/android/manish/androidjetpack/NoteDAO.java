package taskcom.android.manish.androidjetpack;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

/**
 * Created by Manish Kumar on 11/6/2018
 */
@Dao
public interface NoteDAO {
    @Insert
    void insertNote(Note note);
}
