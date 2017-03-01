package pierre.mathieu.mytodolist;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Piou on 01/03/2017.
 */

public class TodoActivity extends Activity {
    private TextView myTextView ;
    private EditText myEditText;
    private Button btnViderList ;
    private Button btnAdd;
    private ListView lvMyListView;
    private static final int MON_ACTIVITE_REQUEST_CODE = 1;
    public static final String PREFS_NAME = "MyPrefsFile";
    public static final String PREFS_EDIT = "PREFS_EDIT";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_layout);
        btnViderList = (Button) findViewById(R.id.myButtonViderList);
        btnAdd = (Button) findViewById(R.id.myButtonAdd);

        lvMyListView = (ListView)findViewById(R.id.myListView);

        onRefresh();

        btnViderList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //lvMyListView.setAdapter(new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1, Singleton.getInstance().removeArray()));
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                Set<String> nameArraySet = settings.getStringSet(PREFS_EDIT,new HashSet<String>());
                nameArraySet.clear();
                editor.putStringSet(PREFS_EDIT,nameArraySet);
                editor.commit();
                onRefresh();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Appel la nouvelle activity
                Intent myIntent = new Intent(getApplicationContext(),addElement.class);
                startActivityForResult(myIntent,MON_ACTIVITE_REQUEST_CODE);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MON_ACTIVITE_REQUEST_CODE) {
            if (resultCode==RESULT_OK)
            {
               onRefresh();
            }
        }
    }
    private void onRefresh(){

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        Set<String> nameArraySet = settings.getStringSet(PREFS_EDIT,new HashSet<String>());
        lvMyListView.setAdapter(new CustomListView(getApplicationContext(), nameArraySet.toArray(new String[nameArraySet.size()])));

    }
}
