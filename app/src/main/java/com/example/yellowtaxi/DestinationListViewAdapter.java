package com.example.yellowtaxi;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class DestinationListViewAdapter extends ArrayAdapter<Destination> {
Context context;
    public DestinationListViewAdapter(@NonNull Context context, int resource, @NonNull List<Destination> objects) {
        super(context, resource, objects);
        this.context = context;
    }
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Destination destination = getItem(position);      // getItem = built in function from ArrayAdapter parent class

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view_template, parent, false);
        }

        TextView dName = convertView.findViewById(R.id.id_destination_name);
        TextView dAddress = convertView.findViewById(R.id.id_destination_address);
        ImageView dImage = convertView.findViewById(R.id.id_destination_image);

        // associate the labels with the properties of the animal
        dName.setText(destination.getName());
        dAddress.setText(destination.getAddress());

        String imageLoc = String.valueOf(destination.getPic_main());

        DrawableManager drawableManager = new DrawableManager(context);
        Drawable d= drawableManager.getDrawable(imageLoc);

        dImage.setImageDrawable(d);

        return convertView;
    }


}
