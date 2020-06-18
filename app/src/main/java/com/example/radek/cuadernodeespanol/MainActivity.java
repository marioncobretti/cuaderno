package com.example.radek.cuadernodeespanol;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Button nextButton, checkButton;
    private TextView polish, spanish, counterText;
    private ArrayList<Phrase> phrases;
    private int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);
        readDictionary();
        Collections.shuffle(phrases);
        polish = findViewById(R.id.polish);
        spanish = findViewById(R.id.spanish);
        counterText = findViewById(R.id.counterText);

        nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkButton.setEnabled(true);
                polish.setText(phrases.get(counter).getPolish());
                spanish.setText(phrases.get(counter).getSpanish());
                spanish.setVisibility(View.INVISIBLE);
                if(counter < phrases.size() - 1) {
                    counter++;
                }
                else {
                    nextButton.setEnabled(false);
                }
                counterText.setText(String.valueOf(counter));
            }
        });

        checkButton = findViewById(R.id.checkButton);
        checkButton.setEnabled(false);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkButton.setEnabled(false);
                spanish.setVisibility(View.VISIBLE);
            }
        });
    }

    private void readDictionary() {

        try {
            phrases = new ArrayList<>();
            InputStream inputStream = getApplicationContext().getAssets().open("dictionary.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while(reader.ready()) {
                String line = reader.readLine();
                String[] splitted = line.split("=");
                Phrase phrase = new Phrase(splitted[0], splitted[1]);
                phrases.add(phrase);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}