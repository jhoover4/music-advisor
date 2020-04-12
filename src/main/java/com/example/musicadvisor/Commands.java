package com.example.musicadvisor;

import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellComponent;

@ShellComponent
public class Commands {

    /**
     * List of new albums with artists and links on Spotify.
     *
     * @return String
     */
    @ShellMethod(value = "List of new albums with artists and links.", key = "new")
    public String newAlbums() {
        StringBuilder newAlbums = new StringBuilder("---NEW RELEASES---\n");

        // Example hardcoded data for now
        newAlbums.append("Mountains [Sia, Diplo, Labrinth]\n");
        newAlbums.append("Runaway [Lil Peep]\n");
        newAlbums.append("The Greatest Show [Panic! At The Disco]\n");
        newAlbums.append("All Out Life [Slipknot]\n");

        return newAlbums.toString();
    }

    /**
     * List of Spotify featured playlists with their links fetched from API.
     *
     * @return String
     */
    @ShellMethod("List of spotify featured playlists.")
    public String featured() {
        StringBuilder featured = new StringBuilder("---FEATURED---\n");

        // Example hardcoded data for now
        featured.append("Mellow Morning\n");
        featured.append("Wake Up and Smell the Coffee\n");
        featured.append("Monday Motivation\n");
        featured.append("Songs to Sing in the Shower\n");

        return featured.toString();
    }

    /**
     * List of all available categories on Spotify.
     *
     * @return String
     */
    @ShellMethod("List of all available categories on Spotify.")
    public String categories() {
        StringBuilder categories = new StringBuilder("---CATEGORIES---\n");

        // Example hardcoded data for now
        categories.append("Top Lists\n");
        categories.append("Pop\n");
        categories.append("Mood\n");
        categories.append("Latin\n");

        return categories.toString();
    }

    /**
     * List contains playlists of this category and their links on Spotify.
     *
     * @return String
     */
    @ShellMethod("List contains playlists of this category and their links on Spotify.")
    public String playlists(String category) {
        StringBuilder playlists = new StringBuilder("---" + category.toUpperCase() + " PLAYLISTS---\n");

        // Example hardcoded data for now
        playlists.append("Walk Like A Badass\n");
        playlists.append("Rage Beats\n");
        playlists.append("Arab Mood Booster\n");
        playlists.append("Sunday Stroll\n");

        return playlists.toString();
    }
}
