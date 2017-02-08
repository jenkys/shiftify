package cz.cvut.fit.shiftify;

import android.app.Activity;
import android.content.Context;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fit.shiftify.data.WorkDay;
import cz.cvut.fit.shiftify.data.models.Shift;
import cz.cvut.fit.shiftify.data.models.User;
import cz.cvut.fit.shiftify.helpers.UserWorkdayWrapper;
import cz.cvut.fit.shiftify.views.TimeLineView;


/**
 * Created by Vojta on 17.11.2016.
 */

public class CustomShiftListAdapter extends ArrayAdapter<UserWorkdayWrapper> {

    private final Activity context;
    private final Integer[] imageId;
    private final List<UserWorkdayWrapper> userWorkdayList;


    public CustomShiftListAdapter(Activity context, List<UserWorkdayWrapper> userWorkdayList, Integer[] imageId) {
        super(context, R.layout.shift_list_single, userWorkdayList);
        this.context = context;
        this.imageId = imageId;
        this.userWorkdayList = userWorkdayList;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.shift_list_single, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.person_name);
        txtTitle.setText( userWorkdayList.get(position).getUser().getFullNameWithNick() );
        //txtTitle.setPadding(50,0,0,0);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.person_image);
        imageView.setImageResource(imageId[position]);

        TimeLineView timeline = (TimeLineView) rowView.findViewById(R.id.timeline);
        timeline.addInterval(8 * 3600,16 * 3600);


        TextView shiftDescr = (TextView) rowView.findViewById(R.id.shift_description);

        for (Shift s: userWorkdayList.get(position).getWorkday().getShifts()
             ) {

            shiftDescr.setText(s.getName() + " " + s.getFromToString());
        }

        return rowView;
    }
}
