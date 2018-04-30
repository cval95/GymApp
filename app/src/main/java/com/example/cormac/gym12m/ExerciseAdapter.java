package com.example.cormac.gym12m;;

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

public class ExerciseAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Exercise> exerciseArrayList;

    public ExerciseAdapter(Context context, ArrayList<Exercise> exerciseArrayList){

        this.context = context;
        this.exerciseArrayList = exerciseArrayList;
    }




    @Override
    public int getCount() {
        return exerciseArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return exerciseArrayList.get(position);
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
            convertView = inflater.inflate(R.layout.exercise_item, null, true);

            holder.tvname = (TextView) convertView.findViewById(R.id.name);
            holder.tvset = (TextView) convertView.findViewById(R.id.set);
            holder.tvweight = (TextView) convertView.findViewById(R.id.weight);
            holder.tvreps = (TextView) convertView.findViewById(R.id.reps);

            convertView.setTag(holder);

        } else
        {
            holder = ( ViewHolder) convertView.getTag();
        }

        holder.tvname.setText("Name: "+ exerciseArrayList.get(position).getName());
        holder.tvset.setText("Set: "+ exerciseArrayList.get(position).getSet());
        holder.tvweight.setText("Weight: "+ exerciseArrayList.get(position).getWeight());
        holder.tvreps.setText("Reps: "+ exerciseArrayList.get(position).getReps());




        return convertView;
    }






    private class ViewHolder{
        protected TextView tvname, tvset, tvweight, tvreps;
    }
}
