package hr.tvz.android.bedtimecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.time.LocalTime;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker = (TimePicker) this.findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);

        Button wakeupButton = findViewById(R.id.wakeup_button);
        Button bedtimeButton = findViewById(R.id.bedtime_button);
    }

//    private void initListeners() {
//        wakeupButton = findViewById(R.id.wakeup_button);
//        bedtimeButton = findViewById(R.id.bedtime_button);
//
//        //calculate wakeup
//        bedtimeButton.setOnClickListener(v -> {
//            int hourValue = timePicker.getHour();
//            int minuteValue = timePicker.getMinute();
//            Intent intent = new Intent(MainActivity.this, Bedtime.class);
//            intent.putExtra("hours", hourValue);
//            intent.putExtra("minutes", minuteValue);
//            MainActivity.this.startActivity(intent);
//        });
//
//        //calculate bedtime
//        wakeupButton.setOnClickListener(v -> {
//            LocalTime localTime = LocalTime.now();
//        });
//    }

    public void calculateBedtime(View view) {
        int hourValue = timePicker.getHour();
        int minuteValue = timePicker.getMinute();
        Intent intent = new Intent(this, Bedtime.class);
        intent.putExtra("hours", hourValue);
        intent.putExtra("minutes", minuteValue);
        startActivity(intent);
    }

    public void calculateWakeup(View view) {
        Intent intent = new Intent(this, WakeUp.class);
        startActivity(intent);
    }




}