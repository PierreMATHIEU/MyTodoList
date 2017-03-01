package pierre.mathieu.mytodolist;

import java.util.ArrayList;

/**
 * Created by Piou on 01/03/2017.
 */

public class Singleton {

    private static Singleton mInstance;
    private ArrayList<String> list = null;

    public static Singleton getInstance() {
        if(mInstance == null)
            mInstance = new Singleton();

        return mInstance;
    }

    private Singleton() {
        list = new ArrayList<String>();
    }
    // retrieve array from anywhere
    public ArrayList<String> getArray() {
        return this.list;
    }
    //Add element to array
    public void addToArray(String value) {
        list.add(value);
    }
    public ArrayList<String> removeArray() {
        list.clear();
        return list;
    }
}
