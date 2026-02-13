package com.sant.toomanymovies.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SingleMovieDTO {
    @Getter
    public static class Genre{
        private int id;
        private String name;
    }


    @Getter
    public static class ProductionCompany{
        private int id;
        private String logo_path;
        private String name;
        private String origin_country;
    }


    @Getter
    public static class ProductionCountry{
        private String iso_3166_1;
        private String name;
    }


    @Getter
    public static class SpokenLanguage{
        private String english_name;
        private String iso_639_1;
        private String name;
    }

    private boolean adult;
    private String backdrop_path;
    private Object belongs_to_collection;
    private int budget;
    private ArrayList<Genre> genres;
    private String homepage;
    private int id;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private String overview;
    private double popularity;
    private String poster_path;
    private ArrayList<ProductionCompany> production_companies;
    private ArrayList<ProductionCountry> production_countries;
    private String release_date;
    private int revenue;
    private int runtime;
    private ArrayList<SpokenLanguage> spoken_languages;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private double vote_average;
    private int vote_count;
}
