package cz.cvut.fit.shiftify.exceptions;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Calendar;

import cz.cvut.fit.shiftify.R;
import cz.cvut.fit.shiftify.data.ExceptionNew;
import cz.cvut.fit.shiftify.data.ExceptionShift;
import cz.cvut.fit.shiftify.data.Schedule;
import cz.cvut.fit.shiftify.utils.CalendarUtils;

/**
 * Created by petr on 11/14/16.
 */

public class ExceptionAdapter extends ArrayAdapter<ExceptionNew> {


    private Context mContext;

    public ExceptionAdapter(Context context, int resource, ExceptionNew[] objects) {
        super(context, resource, objects);
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ExceptionNew exception = getItem(position);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.list_item_exception, parent, false);

        ((TextView) view.findViewById(R.id.exception_title)).setText(getExceptionTitle(exception));
        return view;
    }

//    TODO After upgraded DB - set view of exception item in list
    private String getExceptionTitle(ExceptionNew exception) {
        return "Vyjimka - ID: " + String.valueOf(exception.getId());
    }
}