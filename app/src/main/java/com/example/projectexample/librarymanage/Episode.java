package com.example.projectexample.librarymanage;

public class Episode {

    private int idEp, idStory;
    String content;

    public Episode(int idEp, int idCategory){
        this.idEp = idEp;
        this.idStory = idCategory;
    }

    public int getIdEp() {
        return idEp;
    }

    public int getIdStory() {
        return idStory;
    }

    public void setIdEp(int idEp) {
        this.idEp = idEp;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "idEp=" + idEp +
                ", idStory=" + idStory +
                ", content='" + content + '\'' +
                '}';
    }
}
