package demo.spring.controller;

import demo.spring.model.CinemaHall;
import demo.spring.model.Movie;
import demo.spring.model.MovieSession;
import demo.spring.service.AuthenticationService;
import demo.spring.service.CinemaHallService;
import demo.spring.service.MovieService;
import demo.spring.service.MovieSessionService;
import demo.spring.service.RoleService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inject")
public class InjectMokoData {
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;
    private final MovieSessionService movieSessionService;
    private final RoleService roleService;
    private final AuthenticationService authenticationService;

    public InjectMokoData(MovieService movieService,
                          CinemaHallService cinemaHallService,
                          MovieSessionService movieSessionService,
                          RoleService roleService,
                          AuthenticationService authenticationService) {
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
        this.movieSessionService = movieSessionService;
        this.roleService = roleService;
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public String inject() {
        Movie fastAndFurious = new Movie();
        fastAndFurious.setTitle("Fast and Furious");
        fastAndFurious.setDescription("An action film about street racing, heists, and spies.");
        Movie tomSawyer = new Movie();
        tomSawyer.setTitle("The Adventures of Tom Sawyer");
        tomSawyer.setDescription("Based on the novel The Adventures of Tom Sawyer by Mark Twain"
                + " (San Francisco, 1876).");
        movieService.add(fastAndFurious);
        movieService.add(tomSawyer);

        CinemaHall firstCinemaHall = new CinemaHall();
        firstCinemaHall.setCapacity(100);
        firstCinemaHall.setDescription("first hall with capacity 100");
        CinemaHall secondCinemaHall = new CinemaHall();
        secondCinemaHall.setCapacity(200);
        secondCinemaHall.setDescription("second hall with capacity 200");
        cinemaHallService.add(firstCinemaHall);
        cinemaHallService.add(secondCinemaHall);

        List<Movie> movieList = movieService.getAll();
        List<CinemaHall> cinemaHallList = cinemaHallService.getAll();

        MovieSession movieSession1 = new MovieSession();
        movieSession1.setMovie(movieList.get(0));
        movieSession1.setCinemaHall(cinemaHallList.get(0));
        movieSession1.setShowTime(LocalDateTime.of(2021, 11, 20, 12, 0));
        MovieSession movieSession2 = new MovieSession();
        movieSession2.setMovie(movieList.get(0));
        movieSession2.setCinemaHall(cinemaHallList.get(0));
        movieSession2.setShowTime(LocalDateTime.of(2021, 11, 20, 15, 0));
        movieSessionService.add(movieSession1);
        movieSessionService.add(movieSession2);

        return "Done!";
    }
}
