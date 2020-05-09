package android.example.samnote;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        fab = findViewById(R.id.addFabButton);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //create a new activity
                Intent intent= new Intent(MainActivity.this,SecondActivity.class);

                startActivity(intent);
            }
        });

    }
}