package cz.cvut.fit.shiftify.helpdialogfragments;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by petr on 11/20/16.
 */

public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    public static final String DATE_TYPE_ARG = "date_type_fragment";
    public static final String DATE_MS_ARG = "date_seconds";
    public static final String DATE_MIN_MS_ARGS = "date_minimum_in_seconds";

    private DateDialogCallback mCallback;

    public static DateDialog newInstance() {
        Bundle args = new Bundle();
        DateDialog fragment = new DateDialog();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (DateDialogCallback) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement " + DateDialogCallback.class.getName());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle args = getArguments();
        Calendar calendar = Calendar.getInstance();
        long milliseconds = args.getLong(DATE_MS_ARG, calendar.getTimeInMillis());
        calendar.setTimeInMillis(milliseconds);

        DatePickerDialog dialog = new DatePickerDialog(getActivity(), this,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        dialog.getDatePicker().setTag(args.getString(DATE_TYPE_ARG));
        if (args.containsKey(DATE_MIN_MS_ARGS)) {
            dialog.getDatePicker().setMinDate(args.getLong(DATE_MIN_MS_ARGS));
        }
        return dialog;
    }


    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(i, i1, i2);
        mCallback.onDateSet(calendar, (String) datePicker.getTag());
    }

    public interface DateDialogCallback {
        public void onDateSet(Calendar calendar, String datepickerType);
    }
}
