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
public class DrinkingFragment extends Fragment {

    private double latitude;
    private double longitude;
    private String data;

    public DrinkingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        //Create a list of attractions
        final ArrayList<Attraction> attractions = new ArrayList<Attraction>();
        attractions.add(new Attraction(R.drawable.ambasada,
                R.string.ambasada_wodki_i_piwa, R.string.ambasada_wodki_i_piwa_description, 51.111415, 17.029109));
        attractions.add(new Attraction(R.drawable.przekret,
                R.string.przekret, R.string.przekret_description, 51.112237, 17.056355));
        attractions.add(new Attraction(R.drawable.igly,
                R.string.igly, R.string.igly_description, 51.111544, 17.031766));
        attractions.add(new Attraction(R.drawable.szajba,
                R.string.szajba, R.string.szajba_description, 51.108484, 17.026397));
        attractions.add(new Attraction(R.drawable.taras,
                R.string.taras_bar, R.string.taras_bar_description, 51.1060668, 17.030864299999962));
        attractions.add(new Attraction(R.drawable.siwydym,
                R.string.siwy_dym, R.string.siwy_dym_description, 51.1002911, 17.028740900000003));
        attractions.add(new Attraction(R.drawable.burgerking,
                R.string.burger_king, R.string.burger_king_description, 51.1095603, 17.033228399999985));


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
