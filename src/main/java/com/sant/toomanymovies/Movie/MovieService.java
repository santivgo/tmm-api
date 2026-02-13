package com.sant.toomanymovies.Movie;
import com.sant.toomanymovies.User.UserModel;
import com.sant.toomanymovies.dto.MovieApiResponseDTO;
import com.sant.toomanymovies.dto.MovieFromApiDTO;
import com.sant.toomanymovies.dto.SingleMovieDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.net.http.HttpClient;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Service
public class MovieService {

    private final MovieMapper movieMapper;
    private final WebClient webClient;

    MovieService(MovieMapper movieMapper){
        this.movieMapper = movieMapper;
        this.webClient = WebClient.builder()
                .baseUrl(
                        System.getenv("API_MOVIES_URL"))
                .defaultHeader(
                        "Authorization", "Bearer " + System.getenv("API_MOVIES_TOKEN"))
                .build();

    }



    public MovieDTO getMovieById(String id){
        MovieModel retrievedMovie;
        ResponseEntity<SingleMovieDTO> resp = webClient.get()
                .uri("3/movie/" + id + "?language=pt-br")
                .retrieve()
                .toEntity(SingleMovieDTO.class)
                .block();


        if (resp != null && resp.getBody() != null){
            retrievedMovie = movieMapper.map(resp.getBody());
        }else{
            return null;
        }


        return movieMapper.map(retrievedMovie);


    }

    public List<MovieDTO> searchMovie(String movieName){
        List<MovieModel> retrievedMoviesFromApi;

        ResponseEntity<MovieApiResponseDTO> resp = webClient.get()
                .uri("3/search/movie?query=" + movieName)
                .retrieve()
                .toEntity(MovieApiResponseDTO.class)
                .block();
        if (resp != null && resp.getBody() != null && resp.getBody().getResults() != null){
            retrievedMoviesFromApi = resp
                    .getBody()
                    .getResults()
                    .stream()
                    .map(movieMapper::map).toList();;
        }else{
            return null;
        }


        return retrievedMoviesFromApi.stream().map(movieMapper::map).toList();


    }

}
