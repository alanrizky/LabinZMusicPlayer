package lmp.labinzmusicplayer;

import android.widget.AdapterView;

import java.util.List;


public class SongInfo {

    String songNumber;
    String songName;
    String bandName;
    String songUrl;

    public String getSongNumber() {
        return songNumber;
    }

    public void setSongNumber(String songNumber) {
        this.songNumber = songNumber;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public SongInfo(String songNumber, String songName, String bandName, String songUrl) {
        this.songNumber = songNumber;
        this.songName = songName;
        this.bandName = bandName;
        this.songUrl = songUrl;
    }
}
