package com.example.projectexample.librarymanage;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private int id;
    private String name;
    private List<Story> stories;

    public Category(int id, String name, String content) {
        this.id = id;
        this.name = name;
        this.stories = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Story> getStories() {
        return stories;
    }

    public boolean addStory(Story story) {
        if (story == null) {
            return false;
        }
        if (!stories.contains(story)) {
            stories.add(story);
            return true;
        }
        return false;
    }

    public boolean deleteStory(int idStory) {
        for (int i = 0; i < stories.size(); i++) {
            if (stories.get(i).getIdStory() == idStory) {
                stories.remove(i);
                return true;
            }
        }
        return false;
    }

    public void updateNewContent(List<Story> newStories) {
        if (newStories == null) {
            return;
        }
        stories.clear();
        stories.addAll(newStories);
    }

    public Story searchStoryByName(String name) {
        List<Story> stories = getStories();
        for (int j = 0; j < stories.size(); j++) {
            Story story = stories.get(j);
            if (story.getName().equals(name)) {
                return story;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stories=" + stories +
                '}';
    }
}

