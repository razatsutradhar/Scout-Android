package com.example.pctureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class notesActivity extends AppCompatActivity {
    EditText strengthEditText;
    EditText weaknessEditText;
    EditText otherNotesEditText;
    EditText teamNumberEditText;
    String strengthStr;
    String weaknessStr;
    String  otherNotesStr;
    String teamNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        strengthEditText = findViewById(R.id.strengthTextEdit);
        weaknessEditText = findViewById(R.id.weaknessTextEdit);
        otherNotesEditText = findViewById(R.id.otherInfoTextEdit);
        teamNumberEditText = findViewById(R.id.multiAutoCompleteTextView);
    }
    public void save(View v) {
        strengthStr = strengthEditText.getText().toString();
        weaknessStr = weaknessEditText.getText().toString();
        otherNotesStr = otherNotesEditText.getText().toString();
        teamNumber = teamNumberEditText.getText().toString();

        FileOutputStream outStream = null;

        try {
            outStream = openFileOutput(teamNumber, MODE_PRIVATE);
            outStream.write(("Strengths: " + strengthStr + "\n" +
                             "Weakness: " + weaknessStr + "\n" +
                             "Other: " + otherNotesStr).getBytes());
            Intent intent = new Intent(this, mediaOptions.class);
            Toast.makeText(this, "Saved to " + getFilesDir()+"/"+teamNumber, Toast.LENGTH_LONG).show();
            startActivity(intent);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outStream != null){
                try {
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
