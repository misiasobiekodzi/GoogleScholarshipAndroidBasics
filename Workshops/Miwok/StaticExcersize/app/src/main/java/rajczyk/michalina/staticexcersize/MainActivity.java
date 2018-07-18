package rajczyk.michalina.staticexcersize;

import android.util.Log;

public class MainActivity {

    public static void main(String[] args){
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        // Print the values of both counters to the Log console
        Log.i("person4.localCount + "," + Person.instanceCount + ");
    }
}


