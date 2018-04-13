package com.asosia.baby;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class IntroActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    public EditText babyName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        babyName = findViewById(R.id.babyName);
        babyName.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        babyName.setText("");
    }

    public void datePicker(View v)
    {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(), "date");
    }

    private void setDate(final Calendar c) {
        final DateFormat dateformat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        ((TextView) findViewById(R.id.textView)).setText(dateformat.format(c.getTime()));
    }

    @Override
    public void onDateSet(DatePicker datePicker, int y, int m, int d) {
        Calendar c = new GregorianCalendar(y, m ,d);
        setDate(c);
    }


    public static class DatePickerFragment extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int y = c.get(Calendar.YEAR);
            int m = c.get(Calendar.MONTH);
            int d = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(),
                    (DatePickerDialog.OnDateSetListener)
                            getActivity(), y, m ,d);
        }

    }
}
