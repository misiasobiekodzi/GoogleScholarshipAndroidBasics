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

import java.util.ArrayList;


public class SongAdapter extends ArrayAdapter<Song> {

    private int mBackgroundColorResourceId;
    private ClickListener mClickListener;

    public SongAdapter(Activity context, ArrayList<Song> songs, int backgroundColorResourceId, ClickListener clickListener) {
        super(context, 0, songs);
        mBackgroundColorResourceId = backgroundColorResourceId;
        mClickListener = clickListener;
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
                mClickListener.onAddClick(currentSong);
            }
        });

        ImageView playButton = listItemView.findViewById(R.id.play_image);
        playButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mClickListener.onPlayClick(currentSong);
            }
        });


        // Return the whole list item layout (containing 2 TextViews + 2 ImageViews)
        // so that it can be shown in the ListView
        return listItemView;
    }

    public interface ClickListener {
        void onPlayClick(Song song);
        void onAddClick(Song song);
    }

}

