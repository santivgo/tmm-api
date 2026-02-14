package com.sant.toomanymovies.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MovieApiResponseDTO {
    private int page;
    private List<MovieFromApiDTO> results;

}
