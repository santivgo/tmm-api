package com.sant.toomanymovies.Movie;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movies")

public class MovieController {

    private final MovieService movieService;

    @GetMapping("/{id}")
    public MovieDTO getMovieById(@PathVariable String id){
        return movieService.getMovieById(id);
    }

    @GetMapping("/search/{nome}")
    public List<MovieDTO> searchMovie(@PathVariable String nome){
        return movieService.searchMovie(nome);
    }

}
