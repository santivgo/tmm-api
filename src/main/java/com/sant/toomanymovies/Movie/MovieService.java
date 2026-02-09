package com.sant.toomanymovies.Movie;
import com.sant.toomanymovies.User.UserModel;
import com.sant.toomanymovies.dto.MovieApiResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.net.http.HttpClient;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service

public class MovieService {

    MovieRepository movieRepository;
    MovieMapper movieMapper;


    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }


    public List<MovieDTO> searchMovie(String movieName){
        List<MovieModel> retrievedMoviesFromApi;
        WebClient webClient = WebClient.builder()
                              .baseUrl(
                              System.getenv("API_MOVIES_URL"))
                              .defaultHeader(
                       "Authorization", "Bearer " + System.getenv("API_MOVIES_TOKEN"))
                              .build();

        ResponseEntity<MovieApiResponseDTO> resp = webClient.get()
                .uri("3/search/movie?query=" + movieName)
                .retrieve()
                .toEntity(MovieApiResponseDTO.class)
                .block();
        if (resp != null && resp.getBody() != null && resp.getBody().getResults() != null){
            retrievedMoviesFromApi = resp.getBody().getResults().stream().map((item)-> movieMapper.map(item)).toList();;
        }else{
            retrievedMoviesFromApi = null;
        }

        List<MovieDTO> retrievedMoviesFromApiDTO = retrievedMoviesFromApi.stream().map(movieMapper::map).toList();



        return retrievedMoviesFromApiDTO;

//        MovieModel createdMovie = this.movieMapper.map(movieDTO);
//        createdMovie = this.movieRepository.save(createdMovie);
//        return this.movieMapper.map(createdMovie);

    }

}
