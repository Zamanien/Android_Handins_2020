package com.example.todolist;

/**
 * Note class
 * Handles the notes written.
 */
public class Note {
    private String title;
    private String description;
    private int priority;

    //empty constructor
    public Note(){
        //Empty constructor
    }

    //constructor with attributes as parameters
    public Note(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    //Getters for the 3 attributes

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
