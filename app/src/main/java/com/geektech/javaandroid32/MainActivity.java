package com.geektech.javaandroid32;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText gmail, subject, message;
    Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gmail = findViewById(R.id.gmail);
        subject = findViewById(R.id.subject);
        message = findViewById(R.id.messageEt);
        sendBtn = findViewById(R.id.sendBtn);


        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userGmail = gmail.getText().toString().trim();
                String userSubject = subject.getText().toString().trim();
                String userMessage = message.getText().toString().trim();

                sendEmail(userGmail, userSubject, userMessage);

            }
        });
    }

    private void sendEmail(String userGmail, String userSubject, String userMessage) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{userGmail});
        intent.putExtra(Intent.EXTRA_SUBJECT, userSubject);
        intent.putExtra(Intent.EXTRA_TEXT, userMessage);


        try {
            startActivity(Intent.createChooser(intent, "Выберите пользователя"));
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}