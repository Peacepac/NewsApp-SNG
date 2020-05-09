package android.example.samnote;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SecondActivity extends AppCompatActivity {
    FloatingActionButton fab;
    EditText entertitle, enternote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        enternote= findViewById(R.id.enternote);
        entertitle= findViewById(R.id.entertitle);


        fab = findViewById(R.id.saveFabButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //create a new activity
                Intent intent = new Intent(SecondActivity.this, ViewActivity.class);

                startActivity(intent);

            }
        });
    }
}



