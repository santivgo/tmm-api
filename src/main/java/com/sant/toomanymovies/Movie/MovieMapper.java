    package com.sant.toomanymovies.Movie;

    import com.sant.toomanymovies.Category.CategoryHashMap;
    import com.sant.toomanymovies.Category.CategoryModel;
    import com.sant.toomanymovies.dto.MovieFromApiDTO;
    import org.mapstruct.Mapper;

    @Mapper(componentModel = "spring")
    public abstract class MovieMapper {
        public abstract MovieDTO map(MovieModel movieModel);
        public abstract MovieModel map(MovieDTO movieDTO);
        public MovieModel map(MovieFromApiDTO movieFromApiDTO){
            MovieModel movieModel = new MovieModel();
            CategoryHashMap categoryHashMap = new CategoryHashMap();

            movieModel.setId((long) movieFromApiDTO.getId());
            movieModel.setName(movieFromApiDTO.getTitle());
            movieModel.setCategories(movieFromApiDTO
                                     .getGenre_ids()
                                     .stream()
                                     .map(
                                     (genre) ->
                                         new CategoryModel((long)genre, categoryHashMap.getCategoryHashMap().get(genre))
                                     ).toList());
            movieModel.setPhotoUrl(movieModel.getPhotoUrl());
            return movieModel;
        }

    }
