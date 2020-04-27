package com.example.musicadvisor;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethodAvailability;

@ShellComponent
public class Commands {

    private boolean isAuthenticated;
    static final String REDIRECT_URI = "http://localhost:8080&response_type=code";
    String spotifyAccessUrl = "https://accounts.spotify.com/authorize?client_id=a4f9b3eabff748268a31f77116a996d9&redirect_uri=" +
            REDIRECT_URI;

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

    /**
     * Checks if user is authenticated before using the application.
     *
     * @return boolean
     */
    @ShellMethodAvailability({"new", "featured", "categories", "playlists"})
    public Availability availabilityCheck() {
        return isAuthenticated
                ? Availability.available()
                : Availability.unavailable("Please, provide access for application.");
    }

    /**
     * Authenticates new user to be able to use the application.
     *
     * @return String
     */
    @ShellMethod("Authenticates new user.")
    public String auth() {
        // Hardcoded for now
        isAuthenticated = true;
        return this.spotifyAccessUrl + "\n---SUCCESS---\n";
    }
}
