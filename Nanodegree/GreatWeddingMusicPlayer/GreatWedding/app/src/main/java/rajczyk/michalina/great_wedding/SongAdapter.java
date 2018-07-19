package rajczyk.michalina.great_wedding;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class SongAdapter extends ArrayAdapter<Song> {

    private int mBackgroundColorResourceId;

    public SongAdapter(Activity context, ArrayList<Song> songs, int backgroundColorResourceId) {
        super(context, 0, songs);
        mBackgroundColorResourceId = backgroundColorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        final Song currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView songTitleTextView = (TextView) listItemView.findViewById(R.id.song_title_text_view);
        songTitleTextView.setText(currentSong.getSongTitle());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView artistNameTextView = (TextView) listItemView.findViewById(R.id.artist_text_view);
        artistNameTextView.setText(currentSong.getmArtistName());


        View textContainer = listItemView.findViewById(R.id.item_container);
        int color = ContextCompat.getColor(getContext(), mBackgroundColorResourceId);
        textContainer.setBackgroundColor(color);

        ImageView addButton = listItemView.findViewById(R.id.add_image);
        addButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getContext(), R.string.add_button_warning, Toast.LENGTH_SHORT).show();
            }
        });

        ImageView playButton = listItemView.findViewById(R.id.play_image);
        playButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getContext(), "Let's try...", Toast.LENGTH_SHORT).show();
                //playAudio(currentSong.getSongURL());
            }
        });

        // Return the whole list item layout (containing 2 TextViews + 2 ImageViews)
        // so that it can be shown in the ListView
        return listItemView;
    }

}

