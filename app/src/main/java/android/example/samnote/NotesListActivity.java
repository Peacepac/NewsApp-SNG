package android.example.samnote;

import android.os.Bundle;
import android.app.Activity;

public class NotesListActivity extends Activity {

    private NotesDbAdapter mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mDbHelper = new NotesDbAdapter(this);
        mDbHelper.open();
    }
}