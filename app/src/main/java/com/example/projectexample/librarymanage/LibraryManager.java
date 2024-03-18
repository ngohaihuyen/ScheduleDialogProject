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
    public boolean removeCategory(int idCategory) {
        for (int i = 0; i < categories.size(); i++) {

            Category item = categories.get(i);
            int itemId = item.getId();

            if (itemId == idCategory) {
                categories.remove(i);
                return true;
            }
        }
        return false;

    }

    //thêm truyện vafo cđề
    public boolean addStoryToCategory(Story story) {
        Category category = searchCategoryById(story.getIdStory());
        if (category != null) {
            return category.addStory(story);
        }

        if (!categories.contains(category)) {
            categories.add(category);
            return true;
        }
        return false;
    }


    //  xóa truyện (id)
    public boolean removeStory(int storyId) {
        for (int i = 0; i < categories.size(); i++) {
            List<Story> stories = categories.get(i).getStories();

            for (int j = 0; j < stories.size(); j++) {

                Story storyItem = stories.get(i);
                int itemId = storyItem.getIdStory();

                if (itemId == storyId) {
                    stories.remove(j);
                    return true;
                }
            }
        }
        return false;
    }


    // tìm kiếm truyện (idd)
    public Story searchStoryById(int storyId) {
        for (int i = 0; i < categories.size(); i++) {

            Category category = categories.get(i);
            List<Story> stories = category.getStories();

            for (int j = 0; j < stories.size(); j++) {

                Story storyItem = stories.get(j);
                int itemId = storyItem.getIdStory();
                if (itemId == storyId) {
                    return storyItem;
                }
            }
        }
        return null;

    }

    // tìm kiếm cđề (id)
    public Category searchCategoryById(int topicId) {
        for (int i = 0; i < categories.size(); i++) {
            Category categoryItem = categories.get(i);
            int itemId = categoryItem.getId();
            if (itemId == topicId) {
                return categoryItem;
            }
        }
        return null;
    }

    //tìm kiếm truyện theo tên
    public List<Story> searchStoriesByName(String name) {
        List<Story> foundStory = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);
            List<Story> stories = category.getStories();

            for (int j = 0; j < stories.size(); j++) {
                Story story = stories.get(j);

                if (story.getName().equals(name)) {
                    foundStory.add(story);
                }
            }
        }
        return foundStory;
    }

    public Story searchStoryByName(String name) {
        for (int i = 0; i < categories.size(); i++) {

            Category category = categories.get(i);
            Story result = category.searchStoryByName(name);

            return result;
        }
        return null;
    }

    //tiìm kiếm cđề theo tên
    public List<Category> searchCategoryByName(String name) {
        List<Category> foundCategory = new ArrayList<>();
        for (int i = 0; i < categories.size(); i++) {

            Category category = categories.get(i);
            String categoryName = category.getName();

            if (categoryName.equals(name)) {
                foundCategory.add(category);
            }
        }
        return foundCategory;
    }

}
