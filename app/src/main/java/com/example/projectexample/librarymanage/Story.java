package com.example.projectexample.librarymanage;

import java.util.ArrayList;
import java.util.List;

public class Story {
    private int idStory, idCategory;
    private String name;
    private List<Episode> episodeList;

    public Story(int idStory, String name) {
        this.idStory = idStory;
        this.name = name;
        this.episodeList = new ArrayList<>();
    }

    public int getIdStory() {
        return idStory;
    }

    public String getName() {
        return name;
    }

    public List<Episode> getEpisodeList() {
        return episodeList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdStory(int idStory) {
        this.idStory = idStory;
    }

    public boolean addEpisode(Episode episode) {
        if (episode == null) {
            return false;
        }
        if (!episodeList.contains(episode)) {
            return episodeList.add(episode);
        }
        return false;
    }

    public boolean deleteEpisode(int idEp) {
        for (int i = 0; i < episodeList.size(); i++) {

            Episode episodeItem = episodeList.get(i);
            int itemId = episodeItem.getIdEp();
            if (itemId == idEp) {

                Episode removedItem= episodeList.remove(i);

                return removedItem!=null;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Story{" +
                "idStory=" + idStory +
                ", idCategory=" + idCategory +
                ", name='" + name + '\'' +
                ", episodeList=" + episodeList +
                '}';
    }
}