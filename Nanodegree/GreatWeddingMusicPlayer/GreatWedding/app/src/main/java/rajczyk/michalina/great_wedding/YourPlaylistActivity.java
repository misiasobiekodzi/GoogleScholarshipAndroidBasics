package rajczyk.michalina.great_wedding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class YourPlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);

        //Create a String array with songs
        ArrayList<Song> songs = new ArrayList<Song>();
        //TO DO LATER: figure out how to create such a list  with picked songs

        SongAdapter songAdapter = new SongAdapter(this, songs, R.color.grey);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(songAdapter);
    }
}
