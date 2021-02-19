package com.injorny.justqrreader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtQr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtQr = findViewById(R.id.txtQr);
        txtQr.setText(getIntent().getStringExtra("qrtext"));
        txtQr.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Uri url = Uri.parse(txtQr.getText().toString());
        Intent intent = new Intent(Intent.ACTION_VIEW, url);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "App not found!", Toast.LENGTH_SHORT).show();
        }
    }
}
