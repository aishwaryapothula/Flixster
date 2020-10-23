package com.example.flixster.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie
{
    String postPath;
    String title;
    String overview;

    // If any of the below fail in fetching the JSONException handler handles
    public Movie(JSONObject jsonObject) throws JSONException
    {
        postPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
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
    public String getPostPath()
    {
        return String.format("https://image.tmdb.org/t/p/w342/%s", postPath);
    }

    public String getTitle()
    {
        return title;
    }

    public String getOverview()
    {
        return overview;
    }
}
