package pierre.mathieu.mytodolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by Piou on 01/03/2017.
 */

public class CustomListView extends ArrayAdapter<String> {

    private final Context context;
    private final String[] values;
    public CustomListView(Context context, String[] values) {
        super(context, R.layout.custom_list_view, values);
        this.context = context;
        this.values = values;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.custom_list_view, parent, false);

        TextView textView = (TextView) rowView.findViewById(R.id.myTextView2);
        CheckBox checkBox = (CheckBox) rowView.findViewById(R.id.myCheckBox2);

        textView.setText(values[position]);

        return rowView;
    }

}
