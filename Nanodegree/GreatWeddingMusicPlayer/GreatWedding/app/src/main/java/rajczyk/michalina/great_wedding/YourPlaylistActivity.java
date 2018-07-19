package rajczyk.michalina.great_wedding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

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
