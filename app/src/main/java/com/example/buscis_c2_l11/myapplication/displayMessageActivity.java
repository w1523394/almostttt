package com.example.buscis_c2_l11.myapplication;

import android.content.ActivityNotFoundException;
import android.content.res.Configuration; // import resource config
import android.content.res.Resources; // import resources
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.DisplayMetrics; // import display metrics
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;
import android.widget.Toast;
import android.view.View.OnClickListener;

import java.util.Locale;


public class displayMessageActivity extends AppCompatActivity{

    private static final String TAG = "CalendarActivity";
    private CalendarView calendarView;
    private Toast toast;
    private RadioButton radio1_id;
    private RadioButton radio2_id;
    private Locale myLocale;
    private EditText EmailId;


    //final static int CAMERA_RESULT_REQUEST_CODE = 1;

    // private void takePhoto() {
    //    Intent intent = new Intent();
    //    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
    //    startActivityForResult(intent, CAMERA_RESULT_REQUEST_CODE);
    // }

    // @Override
    //protected void onActivityResult(int requestCode, int resultCode, )

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        radio1_id = (RadioButton) findViewById(R.id.radio1_Id);
        radio2_id = (RadioButton) findViewById(R.id.radio2_Id);
        EmailId = (EditText) findViewById(R.id.EmailId);

        EmailId.setText("w1523394@apps.losrios.edu");
        radio1_id.setOnClickListener(first_radio_listener);
        radio2_id.setOnClickListener(second_radio_listener);
        calendarView.setOnDateChangeListener(new OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                Toast.makeText(getApplicationContext(), "" + dayOfMonth, Toast.LENGTH_SHORT).show();// TODO Auto-generated method stub}
            }});

        //String mailto = "mailto:abmukarram@gmail.com" + "&subject=" + Uri.encode("Hello") + "&body =" + Uri.encode("Are you there");

        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        String [] to = {EmailId.getText().toString()};
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT," Sent from my app!");
        emailIntent.putExtra(Intent.EXTRA_TEXT," Thank You For Visiting!");
        emailIntent.setType("message/rfc822");

        try {
            startActivity(emailIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No Mail App", Toast.LENGTH_LONG).show();
            System.out.println("Mail Not there");
        }
        Intent intent2 = new Intent();
       intent2.setAction(Intent.ACTION_VIEW);
        intent2.setData(Uri.parse("https://google.com"));

        try
        { startActivity(intent2);}
        catch (ActivityNotFoundException e)
        {Toast.makeText(this, "Cannot Open Browser", Toast.LENGTH_LONG).show();}


    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    OnClickListener first_radio_listener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            // enter convert to english string
            setLocale("en");
        }
    };
    OnClickListener second_radio_listener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            // enter convert to spanish string
            setLocale("es");
        }
    };

    public void setLocale(String lang) {

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, displayMessageActivity.class);
        startActivity(refresh);
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        //respond to menu item selection
        switch (item.getItemId()) {
            case R.id.aboutId:
                startActivity(new Intent(this, AboutActivity.class));
                return true;
            case R.id.appId:
                startActivity(new Intent(this, appActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
