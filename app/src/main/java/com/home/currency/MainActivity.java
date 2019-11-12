package com.home.currency;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ntd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViews();
    }

    private void getViews() {
        ntd = findViewById(R.id.ntd_is);
    }

    public void onGoButtonClick(View view) {
        exchange();
    }

    private void exchange() {
        try {
            float currentExchangeRate = 30.9f;
            float exchangeCalculateResult = (Float.parseFloat(ntd.getText().toString()) / currentExchangeRate);
            Toast.makeText(this, (getString(R.string.usd_is) + exchangeCalculateResult), Toast.LENGTH_LONG).show();
            showExchangeCalculateResult(getString(R.string.result), (getString(R.string.usd_is) + exchangeCalculateResult));
        } catch (NullPointerException | NumberFormatException e) {
            showExchangeCalculateResult(getString(R.string.problem), getString(R.string.please_your_ntd));
        }
    }


    private void showExchangeCalculateResult(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(getString(R.string.oK), (dialog, which) -> ntd.setText("")).show();
    }
}
