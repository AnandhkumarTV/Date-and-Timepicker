package tv.anandhkumar.datetimepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class DateActivity extends AppCompatActivity {

    TextView textView;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        textView = findViewById(R.id.textView);
        datePicker = findViewById(R.id.datePicker);


        // Set minSdk = 27 so that this method will work.
//        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
//            @Override
//            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                textView.setText("Date is : "+dayOfMonth+"/"+monthOfYear+"/"+year);
//
//            }
//        });

        //this mwthode will work below the API level 27
        Calendar calendar =Calendar.getInstance();
        datePicker.init(calendar.
                        get(Calendar.YEAR), calendar.
                        get(Calendar.MONTH), calendar.
                        get(Calendar.DAY_OF_MONTH),
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        textView.setText("Date is : "+dayOfMonth+"/"+monthOfYear+"/"+year);
                    }
                });
    }
}
