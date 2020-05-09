package android.example.samnote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseSam extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAME ="note.db";
    public static final String TABLE_NAME ="notes";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_TITLE = "title";

    public DatabaseSam(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public DatabaseSam(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PERSON_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_TITLE + " TEXT" + ")";
        db.execSQL(CREATE_PERSON_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }



    public boolean insertSave(Notes notes) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_TITLE, notes.getTitle());
        contentValues.put(KEY_NAME, notes.getName());
        ;
        db.insert(TABLE_NAME, null, contentValues);
        return true;

     }
    public Notes getNote(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME, new String[]{KEY_ID,KEY_NAME,KEY_TITLE},
                KEY_ID+"=?", new String[]{String.valueOf(id)}, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        return new Notes(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
    }

    public List<Notes> findAll(){
        java.util.List<Notes> listnote=new ArrayList<Notes>();
        String query="SELECT * FROM "+TABLE_NAME;

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(query, null);

// looping through all rows and adding to list
        if(cursor.moveToFirst()){
            do{

            Notes notes = null;
            notes.setId(cursor.getInt(0));
                notes.setName(cursor.getString(1));
                notes.setTitle(cursor.getString(2));
                listnote.add(notes);
            }while(cursor.moveToNext());
        }

        return listnote;
    }
    public void update(Notes notes){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(KEY_NAME , notes.getName());
        values.put(KEY_TITLE, notes.getTitle());

        db.update(TABLE_NAME, values, KEY_ID+"=?", new String[]{String.valueOf(notes.getId())});
        db.close();
    }

    public void delete(Notes notes){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID+"=?", new String[]{String.valueOf(notes.getId())});
        db.close();
    }

    public void insertSave(EditText entertitle, EditText enternote) {
    }
}
