package com.kristian.fi.models;

public class CustomerGenre {

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        Name = Name;
    }

    public String getGenreCount() {
        return GenreCount;
    }

    public void setGenreCount(String GenreCount) {
        GenreCount = GenreCount;
    }

    private String Name;
    private String GenreCount;


    public CustomerGenre(String Name,String GenreCount) {
        this.Name = Name;
        this.GenreCount=GenreCount;

    }


}
