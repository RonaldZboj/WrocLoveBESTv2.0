package com.example.android.wroclovebest;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EatingFragment extends Fragment {

    private double latitude;
    private double longitude;
    private String data;

    public EatingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        //Create a list of attractions
        final ArrayList<Attraction> attractions = new ArrayList<Attraction>();
        attractions.add(new Attraction(R.drawable.mcdonald,
                R.string.macdonald, R.string.macdonald_description, 51.1093085, 17.03320210000004));


        // Create an {@link AttractionAdapter}, whose data source is a list of {@link Attraction}s. The
        // adapter knows how to create list items for each item in the list.
        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions, R.color.fragment_color);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // attraction_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link AttractionAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Attraction} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to open new Activity when clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Attraction} object at the given position the user clicked on
                Attraction attraction = attractions.get(position);
                // Get the coordinates from current Attraction
                latitude = attraction.getLatitude();
                longitude = attraction.getLongitude();
                // Start the maps intent with corresponding coordinates
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                data = String.format("geo:%s,%s", latitude, longitude);
                intent.setData(Uri.parse(data));
                startActivity(intent);

            }
        });

        return rootView;
    }

}
