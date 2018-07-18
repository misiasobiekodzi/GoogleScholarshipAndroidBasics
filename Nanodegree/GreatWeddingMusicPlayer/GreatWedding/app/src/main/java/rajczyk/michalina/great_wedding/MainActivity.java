package rajczyk.michalina.great_wedding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView dinnerSongsTextView = (TextView) findViewById(R.id.dinner_songs_text_view);
        dinnerSongsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dinnerMusicIntent = new Intent(MainActivity.this, DinnerMusicActivity.class);
                startActivity(dinnerMusicIntent);
            }
        });

        TextView romanticSongsTextView = (TextView) findViewById(R.id.romantic_songs_text_view);
        romanticSongsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent romanticMusicIntent = new Intent(MainActivity.this, RomanticMusicActivity.class);
                startActivity(romanticMusicIntent);
            }
        });

        TextView hitsSongsTextView = (TextView) findViewById(R.id.hits_text_view);
        hitsSongsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hitsMusicIntent = new Intent(MainActivity.this, HitsActivity.class);
                startActivity(hitsMusicIntent);
            }
        });

        TextView wildPartySongsTextView = (TextView) findViewById(R.id.wild_party_text_view);
        wildPartySongsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent wildPartyMusicIntent = new Intent(MainActivity.this, WildPartyActivity.class);
                startActivity(wildPartyMusicIntent);
            }
        });

        TextView yourPlaylistTextView = (TextView) findViewById(R.id.your_playlist_text_view);
        yourPlaylistTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent yourPlaylistIntent = new Intent(MainActivity.this, YourPlaylistActivity.class);
                startActivity(yourPlaylistIntent);
            }
        });

    }
}
