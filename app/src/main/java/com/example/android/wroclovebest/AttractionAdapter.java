package com.example.android.wroclovebest;

/**
 * Created by RonaldZboj on 2017-06-03.
 */

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link AttractionAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Attraction} objects.
 */

public class AttractionAdapter extends ArrayAdapter<Attraction> {
    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;

    /**
     * Create a new {@link AttractionAdapter object.
     *
     * @param context         is the current context (i.e. Activity) that the adapter is being created in.
     * @param attraction      is the list of {@link Attraction}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of words
     */

    public AttractionAdapter(Context context, ArrayList<Attraction> attractions, int colorResourceId) {
        super(context, 0, attractions);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Attraction} object located at this position in the list
        Attraction currentAttraction = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID name.
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name);
        // Get the name from the currentAttraction object and set this text on name TextView
        nameTextView.setText(currentAttraction.getName());

        // Find the TextView in the list_item.xml layout with the ID description.
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description);
        // Get the description from the currentAttraction object and set this text on name TextView
        descriptionTextView.setText(currentAttraction.getDescription());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        // Get the image from the currentAttraction object, display the provided image based on the resource ID
        imageView.setImageResource(currentAttraction.getImageResourceId());

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        //Link go_to image with map intent and open description of the attraction after click? TO DO

        return listItemView;
    }
}
