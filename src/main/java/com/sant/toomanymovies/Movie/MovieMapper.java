    package com.sant.toomanymovies.Movie;

    import com.sant.toomanymovies.Category.CategoryMapper;
    import com.sant.toomanymovies.Category.CategoryService;
    import com.sant.toomanymovies.dto.MovieFromApiDTO;
    import com.sant.toomanymovies.dto.SingleMovieDTO;
    import org.mapstruct.Mapper;
    import org.springframework.beans.factory.annotation.Autowired;

    @Mapper(componentModel = "spring")
    public abstract class MovieMapper {

        @Autowired
        private CategoryService categoryService;
        @Autowired
        private CategoryMapper categoryMapper;

        public abstract MovieDTO map(MovieModel movieModel);

        public abstract MovieModel map(MovieDTO movieDTO);

        public MovieModel map(SingleMovieDTO singleMovieDTO){
            MovieModel movieModel = new MovieModel();

            movieModel.setId((long) singleMovieDTO.getId());
            movieModel.setName(singleMovieDTO.getTitle());
            movieModel.setCategories(singleMovieDTO
                    .getGenres()
                    .stream()
                    .map(
                            (genre) ->
                                    categoryMapper.map(categoryService.getCategory((long) genre.getId()))
                    ).toList());
            movieModel.setPhotoUrl(singleMovieDTO.getPoster_path());
            return movieModel;
        }

        public MovieModel map(MovieFromApiDTO movieFromApiDTO){
            MovieModel movieModel = new MovieModel();

            movieModel.setId((long) movieFromApiDTO.getId());
            movieModel.setName(movieFromApiDTO.getTitle());
            movieModel.setCategories(movieFromApiDTO
                                     .getGenre_ids()
                                     .stream()
                                     .map(
                                     (genre) ->
                                         categoryMapper.map(categoryService.getCategory(Long.valueOf(genre)))
                                     ).toList());
            movieModel.setPhotoUrl(movieFromApiDTO.getPoster_path());
            return movieModel;
        }

    }
