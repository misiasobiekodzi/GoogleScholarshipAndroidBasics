package rajczyk.michalina.great_wedding;

public class Song {

    private String mSongTitle;
    private String mArtistName;
    //private String mSongURL;

    public Song (String songTitle, String artistName){
        mSongTitle = songTitle;
        mArtistName = artistName;
        //mSongURL = songURL;
    }

    public String getSongTitle() {
        return mSongTitle;
    }
    public String getmArtistName(){
        return mArtistName;
    };
    /*public String getSongURL(){
        return mSongURL;
    } */

}
