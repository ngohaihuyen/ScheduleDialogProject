package com.example.projectexample.librarymanage;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager {

    private List<Category> categories;

    public LibraryManager() {
        this.categories = new ArrayList<>();
    }

    // thêm cđề
    public boolean addCategory(Category category) {
        if (category != null) {
            return categories.add(category);
        }
        return false;
    }

    //xoá cđề
    public boolean removeCategory(int idCategory){
        for (int i = 0; i < categories.size(); i++) {
            if(categories.get(i).getId() == idCategory) {
                categories.remove(i);
                return true;
            }
        }
        return false;

    }

    //thêm truyện vafo cđề
    public boolean addStoryToTopic(int topicId, Story story) {
        Category topic = searchTopicById(topicId);
        if (topic != null) {
            return topic.addStory(story);
        }
        return false;
    }



    //  xóa truyện (id)
    public boolean removeStory(int storyId) {
        for (int i = 0; i < categories.size(); i++) {
            List<Story> stories = categories.get(i).getStories();
            for (int j = 0; j < stories.size(); j++) {
                if (stories.get(j).getIdStory() == storyId) {
                    stories.remove(j);
                    return true;
                }
            }
        }
        return false;
    }


    // tìm kiếm truyện (idd)
    public Story findStoryById(int storyId) {
        for (int i = 0; i < categories.size(); i++) {
            Category topic = categories.get(i);
            List<Story> stories = topic.getStories();
            for (int j = 0; j < stories.size(); j++) {
                Story storyItem = stories.get(j);
                if (storyItem.getIdStory() == storyId) {
                    return storyItem;
                }
            }
        }
        return null;

    }

    // tìm kiếm cđề (id)
    public Category searchTopicById(int topicId) {
        for (int i = 0; i < categories.size(); i++) {
            Category topicItem = categories.get(i);
            if (categories.get(i).getId() == topicId) {
                return topicItem;
            }
        }
        return null;
    }

    //tìm kiếm truyện theo tên
    public List<Story> searchStoriesByName(String name){
        List<Story> foundStory = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);
            List<Story> stories = category.getStories();
            for (int j = 0; j < stories.size(); j++) {
                Story story = stories.get(j);
                if(story.getName().equals(name)){
                    foundStory.add(story);
                }
            }
        }
        return foundStory;
    }

    //tiìm kiếm cđề theo tên
    public List<Category> searchCategoryByName(String name){
        List<Category> foundCategory = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);
            if(category.getName().equals(name)){
                foundCategory.add(category);
            }
        }
        return foundCategory;
    }

}
