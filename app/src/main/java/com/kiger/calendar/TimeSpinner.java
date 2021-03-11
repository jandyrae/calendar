package com.kiger.calendar;

//import android.app.Dialog;
//import android.app.TimePickerDialog;
//import android.os.Build;
//import android.os.Bundle;
//
//import android.text.format.DateFormat;
//import android.widget.Button;
//import android.widget.TimePicker;
//import android.widget.Toast;
//
//import androidx.annotation.RequiresApi;
//import androidx.fragment.app.DialogFragment;
//
//import java.util.Calendar;
//
//class MyTimePickerFragment extends DialogFragment {
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//
//        final Calendar c = Calendar.getInstance();
//        int hour = c.get(Calendar.HOUR_OF_DAY);
//        int minute = c.get(Calendar.MINUTE);
//        Button getTime;
//
//        return new TimePickerDialog(getActivity(), timeSetListener, hour, minute,
//                DateFormat.is24HourFormat(getActivity()));
//    }
//
//    private TimePickerDialog.OnTimeSetListener timeSetListener =
//            new TimePickerDialog.OnTimeSetListener() {
//                @RequiresApi(api = Build.VERSION_CODES.M)
//                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                    Toast.makeText(getActivity(), "selected time is "
//                                    + view.getHour() +
//                                    " / " + view.getMinute()
//                            , Toast.LENGTH_SHORT).show();
//                }
//            };
//}



import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class TimeSpinner extends Fragment {
    Date date = new Date();
    Spinner spinner;
    TimePicker timePicker;

    final Calendar calendar = Calendar.getInstance();
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    int minutes = calendar.get(Calendar.MINUTE);
    TextView textView;
    Button getTime;

    private TimeSpinnerViewModel mViewModel;

    public static TimeSpinner newInstance() {
        return new TimeSpinner();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.time_spinner_fragment, container, false);
        setTimePickerContent(v);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TimeSpinnerViewModel.class);
        // TODO: Use the ViewModel

    }
    private void setTimePickerContent(View v){
        timePicker = (TimePicker) v.findViewById(R.id.timePick);
          getTime = (Button)v.findViewById(R.id.getTime);
          getTime.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                   chooseTime();
              }
          });


    }

    private void chooseTime() {

    }
}