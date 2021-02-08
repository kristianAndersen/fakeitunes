package com.kristian.fi.models;

public class CustomerSearchResult {

    private String Search;
    private String ArtistName;
    private String AlbumName;
    private String TrackName;
    private String composer;
    private String GenreName;

    public String getSearch() {
        return Search;
    }

    public void setSearch(String search) {
        Search = search;
    }

    public String getArtistName() {
        return ArtistName;
    }

    public void setArtistName(String artistName) {
        ArtistName = artistName;
    }

    public String getAlbumName() {
        return AlbumName;
    }

    public void setAlbumName(String albumName) {
        AlbumName = albumName;
    }

    public String getTrackName() {
        return TrackName;
    }

    public void setTrackName(String trackName) {
        TrackName = trackName;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getGenreName() {
        return GenreName;
    }

    public void setGenreName(String genreName) {
        GenreName = genreName;
    }



    public CustomerSearchResult(String Search,String ArtistName,String AlbumName,String TrackName,String composer,String GenreName){
        this.Search=Search;
        this.ArtistName=ArtistName;
        this.AlbumName=AlbumName;
        this.TrackName=TrackName;
        this.composer=composer;
        this.GenreName=GenreName;
    }

}
