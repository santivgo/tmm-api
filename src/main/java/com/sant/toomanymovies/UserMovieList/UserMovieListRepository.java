package com.sant.toomanymovies.UserMovieList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMovieListRepository extends JpaRepository<UserMovieListModel, Long> {
}
