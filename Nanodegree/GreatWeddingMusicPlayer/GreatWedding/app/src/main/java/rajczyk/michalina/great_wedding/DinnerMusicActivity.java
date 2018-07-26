package rajczyk.michalina.great_wedding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DinnerMusicActivity extends AppCompatActivity {

    private SongAdapter.ClickListener clickListener = new SongAdapter.ClickListener() {
        @Override
        public void onPlayClick(Song song) {
            Toast.makeText(DinnerMusicActivity.this, "play song1", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAddClick(Song song) {

        }} ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_list);

        //Create a String array with songs
        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("(What A) Wonderful World", "Sam Cooke"));
        songs.add(new Song("I Say A Little Prayer", "Aretha Franklin"));
        songs.add(new Song("Stand By Me", "aBen E.King"));
        songs.add(new Song("Isn't She Lovely", "David Sanborn"));

        SongAdapter songAdapter = new SongAdapter(this, songs, R.color.amber, clickListener);

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
