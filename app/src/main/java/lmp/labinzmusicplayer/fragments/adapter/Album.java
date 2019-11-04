package lmp.labinzmusicplayer.fragments.adapter;

public class Album {
    String id_album;
    String id_artist;
    String name;

    public Album() {

    }

    public String getId_album() {
        return id_album;
    }

    public void setId_album(String id_album) {
        this.id_album = id_album;
    }

    public String getId_artist() {
        return id_artist;
    }

    public void setId_artist(String id_artist) {
        this.id_artist = id_artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbum_url() {
        return album_url;
    }

    public void setAlbum_url(String album_url) {
        this.album_url = album_url;
    }

    String album_url;

    public Album(String id_album, String id_artist, String name, String album_url) {
        this.id_album = id_album;
        this.id_artist = id_artist;
        this.name = name;
        this.album_url = album_url;
    }
}
