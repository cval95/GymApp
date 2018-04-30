package com.example.cormac.gym12m;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Cormac on 18/04/2018.
 */

public class WorkoutAdapter  extends BaseAdapter {

    private Context context;
    private ArrayList<Workout> workoutArrayList;

    public WorkoutAdapter(Context context, ArrayList<Workout> workoutArrayList){
        this.context = context;
        this.workoutArrayList = workoutArrayList;

    }



    @Override
    public int getCount() {
        return workoutArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return workoutArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       ViewHolder holder;

       if (convertView == null){
           holder = new ViewHolder();
           LayoutInflater inflater = (LayoutInflater) context
                   .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView = inflater.inflate(R.layout.workout_item, null, true);

           holder.tvname = (TextView) convertView.findViewById(R.id.name);

           convertView.setTag(holder);

       }else{
           holder = (ViewHolder) convertView.getTag();
       }

       holder.tvname.setText("Name: " + workoutArrayList.get(position).getName());

       return convertView;





    }

    private class ViewHolder{
        protected TextView tvname;
    }
}
