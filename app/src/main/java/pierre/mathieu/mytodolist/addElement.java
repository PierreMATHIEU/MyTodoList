package pierre.mathieu.mytodolist;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Piou on 01/03/2017.
 */

public class addElement extends Activity {

    private Button btnValider ;
    private EditText myEditText;
    public static final String PREFS_EDIT = "PREFS_EDIT";
    public static final String PREFS_NAME = "MyPrefsFile";


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Détermine le Layout
        setContentView(R.layout.addtask_layout);

        btnValider = (Button) findViewById(R.id.myButtonValider);
        myEditText = (EditText) findViewById(R.id.myEditText);

        btnValider.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Premier tableau avec la clé PREFS_NAME
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                //tableau dans le premier tableau, avec la clé PREFS_EDIT
                Set<String> nameArraySet = new HashSet<String>( settings.getStringSet(PREFS_EDIT,new HashSet<String>()));
                nameArraySet.add(String.valueOf(myEditText.getText()));

                editor.putStringSet(PREFS_EDIT,nameArraySet);
                editor.commit();

                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
