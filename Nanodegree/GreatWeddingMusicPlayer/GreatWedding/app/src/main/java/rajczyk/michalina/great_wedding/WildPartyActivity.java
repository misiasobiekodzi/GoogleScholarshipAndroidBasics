package rajczyk.michalina.great_wedding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class WildPartyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);

        //Create a String array with songs
        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("I Gotta Feeling", "The Black Eyed Peas"));
        songs.add(new Song("Hung Up", "Madonna"));
        songs.add(new Song("Can't Hold Us", "Macklemore & Ryan Lewis"));
        songs.add(new Song("Crazy In Love", "Beyonce"));
        songs.add(new Song("Give Me Everything", "Pitbull"));
        songs.add(new Song("Dancing in the Moonlight", "Welshy"));
        songs.add(new Song("A Little Party Never Killed Nobody", "Fergie, Q-Tip, GoonRock"));
        
        SongAdapter songAdapter = new SongAdapter(this, songs, R.color.orange);

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
