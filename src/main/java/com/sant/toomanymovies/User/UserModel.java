package com.sant.toomanymovies.User;
import com.sant.toomanymovies.UserMovieList.UserMovieListModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tb_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(unique = true, nullable = false, updatable = false)
    private String username;
    @Column(unique = true, nullable = false, updatable = false)
    private String email;
    @Column(length = 20, nullable = false)
    private String senha;
    @Min(18)
    @Max(120)
    private int idade;


    @NotNull
    @OneToMany(mappedBy = "owner")
    List<UserMovieListModel> userLists;



}
