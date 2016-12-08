package com.tcl.librory.models;

/**
 * Created by franc on 12/8/2016.
 */
public enum Genre {
    SCI_FI("Science Fiction"),
    SATIRE("Satire"),
    DRAMA("Drama"),
    ACTION_ADVENTURE("Action and Adventure"),
    ROMANCE("Romance"),
    MYSTERY("Mystery"),
    HORROR("Horror"),
    SELF_HELP("Self Help"),
    HEALTH("Health"),
    GUIDE("Guide"),
    TRAVEL("Travel"),
    CHILDREN("Children"),
    RELIGION("Religion"),
    SCIENCE("Science"),
    HISTORY("History"),
    MATH("Math"),
    ANTHOLOGY("Anthology"),
    POETRY("Poetry"),
    ENCYCLOPEDIAS("Encyclopedias"),
    DICTIONARIES("Dictionaries"),
    COOKBOOKS("Cookbooks"),
    FANTASY("Fantasy");

    private String name;

    Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }    

}
