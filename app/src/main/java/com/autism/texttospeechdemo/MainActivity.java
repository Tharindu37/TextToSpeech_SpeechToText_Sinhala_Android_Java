package com.autism.texttospeechdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText=findViewById(R.id.editTextTextMultiLine);
        Button button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status==TextToSpeech.SUCCESS){
//                            textToSpeech.setLanguage(Locale.ENGLISH);
                            textToSpeech.setLanguage(new Locale("si_LK"));
                            textToSpeech.setSpeechRate(1.0f);
                            textToSpeech.speak(editText.getText().toString(),TextToSpeech.QUEUE_ADD,null);
                        }
                    }
                });
            }
        });
    }
}