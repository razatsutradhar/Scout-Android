package com.example.pctureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class mediaOptions extends AppCompatActivity {
    Button pictureBtn;
    Button recordVideoBtn;
    Button takeNotesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_options);

        pictureBtn = findViewById(R.id.TakePictureBtn);
        pictureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takeAPicture();
            }
        });

        recordVideoBtn = findViewById(R.id.takeVideoBtn);
        recordVideoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recordAVideo();
            }
        });

        takeNotesBtn = findViewById(R.id.goToTakeNotesBtn);
        takeNotesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takeNotes();
            }
        });
    }
    void takeAPicture(){
        Intent intent = new Intent(this, pictureActivity.class);
        startActivity(intent);
    }
    void recordAVideo(){
        Intent intent = new Intent(this, videoActivity.class);
        startActivity(intent);
    }
    void takeNotes(){
        Intent intent = new Intent(this, notesActivity.class);
        startActivity(intent);
    }
}
