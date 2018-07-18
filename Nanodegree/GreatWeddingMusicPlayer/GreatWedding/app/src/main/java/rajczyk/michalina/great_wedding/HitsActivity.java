package rajczyk.michalina.great_wedding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class HitsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);

        //Create a String array with songs
        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Love Really Hurts Without You", "Billy Ocean"));
        songs.add(new Song("Grease (You are the one that I want", "Arthur Bentley & Anita Benson"));
        songs.add(new Song("Mambo No. 5", "Lou Bega"));
        songs.add(new Song("YMCA", "Village People"));
        songs.add(new Song("I Can't Help Myself", "Four Tops"));
        songs.add(new Song("Pretty Woman", "Roy Orbison"));
        songs.add(new Song("You're The First, The Last, My Everything", "Barry White"));
        songs.add(new Song("You can't hurry love", "The Supremes"));
        songs.add(new Song("Prawy Do Lewego", "Kayah, Goran Bregovic"));
        songs.add(new Song("Mój Przyjacielu", "Krzysztof Krawczyk"));
        songs.add(new Song("Dragostea Din Tei", "O-Zone"));
        songs.add(new Song("Moves like Jagger", "Maroon 5"));
        songs.add(new Song("Ona Tańczy Dla Mnie", "Weekend"));
        songs.add(new Song("Twist And Shout", "The Beatles"));
        songs.add(new Song("Hands Up", "Ottawan"));
        songs.add(new Song("Super Trouper", "ABBA"));

        SongAdapter songAdapter = new SongAdapter(this, songs, R.color.indigo);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(songAdapter);


    }
}
