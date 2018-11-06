package taskcom.android.manish.androidjetpack;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Manish Kumar on 11/6/2018
 */

// @Entity() - In this case class name will be the table name.
@Entity(tableName = "notes")
public class Note {
    @PrimaryKey
    @NonNull
    private String id;

    @NonNull
    @ColumnInfo(name = "note")  // Optional
    private String note;

    public Note(String id, String note) {
        this.id = id;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public String getNote() {
        return note;
    }
}
