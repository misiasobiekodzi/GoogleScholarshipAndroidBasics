package rajczyk.michalina.great_wedding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class RomanticMusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);

        //Create a String array with songs
        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("You Got It", "Roy Orbison"));
        songs.add(new Song("L-O-V-E", "Nat King Cole"));
        songs.add(new Song("Can't take my eyes from you", "Frankie Valli"));
        songs.add(new Song("With or without you", "U2"));
        songs.add(new Song("A 1000 Times", "Hamilton Leithauser"));

        SongAdapter songAdapter = new SongAdapter(this, songs, R.color.light_pink);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(songAdapter);

        TextView goBackButton = (TextView) findViewById(R.id.go_back_button);
        goBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent goBackIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(goBackIntent);
            }
        });
    }
}
