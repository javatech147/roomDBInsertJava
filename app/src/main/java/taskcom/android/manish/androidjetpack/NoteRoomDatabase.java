package taskcom.android.manish.androidjetpack;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Manish Kumar on 11/6/2018
 */

@Database(entities = Note.class, version = 1)
public abstract class NoteRoomDatabase extends RoomDatabase {
    public abstract NoteDAO noteDAO();

    private static volatile NoteRoomDatabase noteRoomDatabase;
    static NoteRoomDatabase getDatabase(final Context context) {
        if (noteRoomDatabase == null) {
            synchronized (NoteRoomDatabase.class) {
                if (noteRoomDatabase == null) {
                    noteRoomDatabase = Room.databaseBuilder(
                            context.getApplicationContext(),
                            NoteRoomDatabase.class,
                            "note_database")    //Name of the database
                            .build();
                }
            }
        }
        return noteRoomDatabase;
    }
}
