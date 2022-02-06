package com.example.pizzarecipes;

public class PizzaRecipeRecyclerViewItem {

    private int imageResource;

    private String title;

    private String summary;

    public PizzaRecipeRecyclerViewItem(int imageResource, String title, String summary) {
        this.imageResource = imageResource;
        this.title = title;
        this.summary = summary;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
