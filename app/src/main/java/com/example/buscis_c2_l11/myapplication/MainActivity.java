package com.example.buscis_c2_l11.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    public EditText nameId;
    public EditText passwordId;
    public Button sendId;
    public TextView wrongId;

    //  public static final String EXTRA_MESSAGE = "com.example.buscis_c2_l11.myapplication";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameId = (EditText) findViewById(R.id.nameId);
        passwordId = (EditText) findViewById(R.id.passwordId);
        sendId = (Button) findViewById(R.id.sendId);
        wrongId = (TextView) findViewById(R.id.wrongId);
        sendId.setOnClickListener(this);

//        String message = nameId.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE,message);
//        startActivity(intent);
    }
    //   public void sendMessage (View view) {
    //  Intent intent = new Intent(this, displayMessageActivity.class);

    //       nameId = (EditText) findViewById(R.id.nameId);
    //       passwordId = (EditText) findViewById(R.id.passwordId);
    //       sendId = (Button) findViewById(R.id.sendId);
    //       sendId.setOnClickListener(this);

    //       String message = nameId.getText().toString();
    //      intent.putExtra(EXTRA_MESSAGE,message);
    //     startActivity(intent);
    // }

    public void onClick(View view) {
        if (view.getId() == R.id.sendId)
            if (nameId.getText().toString().equals("admin") && passwordId.getText().toString().equals("admin")) {
                Intent intent = new Intent(this, displayMessageActivity.class);
                startActivity(intent);
            }
            else wrongId.setText("Wrong Password/Name");
    }
}
