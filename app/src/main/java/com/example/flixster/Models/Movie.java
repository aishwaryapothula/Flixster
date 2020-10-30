
// Parsing is done here

package com.example.flixster.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie
{
    int movieId;
    String backdropPath;
    String postPath;
    String title;
    String overview;
    double rating;

     public Movie()
    {
        // Empty constructor needed by Parceler
    }

    // If any of the below fail in fetching the JSONException handler handles
    public Movie(JSONObject jsonObject) throws JSONException
    {
        backdropPath = jsonObject.getString("backdrop_path");
        // we need to generate a new getter  at the end
        postPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");
        movieId = jsonObject.getInt("id");
    }

    // Making the results into a list of movies
    // Taking each element from the json array and making a Movie class for it- creating object
    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException
    {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieJsonArray.length(); i++)
        {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
    return movies;
    }

    // Path in the results is only a relative path, we need a full path
    public String getPosterPath()
    {
        return String.format("https://image.tmdb.org/t/p/w342/%s", postPath);
    }

    public String getBackdropPath()
    {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public String getTitle()
    {

        return title;
    }

    public String getOverview()
    {

        return overview;
    }

    public double getRating()
    {
        return rating;
    }

    public int getMovieId()
    {
        return movieId;
    }
}
