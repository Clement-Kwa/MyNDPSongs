package sg.edu.rp.c346.id20002694.myndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Song> versionList;

    public CustomAdapter(Context context, int resource, ArrayList<Song> objects){
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        versionList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        TextView tvRate = rowView.findViewById(R.id.textViewRating);
        TextView tvSing = rowView.findViewById(R.id.textViewSinger);

        // Obtain the Android Year information based on the position
        Song currentYear = versionList.get(position);

        // Set values to the TextView to display the corresponding information
        tvTitle.setText(currentYear.getTitle());
        tvYear.setText(currentYear.getYear()+"");

        tvSing.setText(currentYear.getSingers()+"");
        tvRate.setText(currentYear.toString());

        return rowView;
    }

}
