package com.example.CineMilleProject.resources;

import com.example.CineMilleProject.models.Movie;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;

@RestController
@RequestMapping(path = "/catalog")
public class MovieCatalog {
    private List<Movie> allMovie;
    private LocalDate dataInizio;
    private LocalDate dataFine;

    public MovieCatalog() {
        this.allMovie = new ArrayList<>();

        // Aggiungi esempi di oggetti Movie alla lista allMovie
        Movie movie1 = new Movie("The Dark Knight", "Christopher Nolan", "Action, Crime, Drama",false,LocalDate.of(2008, 7, 18),LocalDate.of(2008, 8, 18));
        Movie movie2 = new Movie("Inception", "Christopher Nolan", "Action, Adventure, Sci-Fi",false,LocalDate.of(2009, 4, 12),LocalDate.of(2009, 4, 21));
        Movie movie3 = new Movie("Parasite", "Bong Joon Ho", "Comedy, Drama, Thriller",false,LocalDate.of(2010, 7, 18),LocalDate.of(2010, 8, 9));
        Movie movie4 = new Movie("Interstellar", "Christopher Nolan", "Adventure, Drama, Sci-Fi",false,LocalDate.of(2018, 7, 18),LocalDate.of(2018, 8, 6));
        Movie movie5 = new Movie("The Shawshank Redemption", "Frank Darabont", "Drama",true,LocalDate.of(2023, 5, 10),LocalDate.of(2023, 5, 30));
        Movie movie6 = new Movie("film6", "Frank Darabont", "Drama",true,LocalDate.of(2023, 5, 9),LocalDate.of(2023, 5, 28));
        Movie movie7 = new Movie("film7", "Frank", "Drama",false,LocalDate.of(2023, 8, 7),LocalDate.of(2023, 8, 21));


        allMovie.add(movie1);
        allMovie.add(movie2);
        allMovie.add(movie3);
        allMovie.add(movie4);
        allMovie.add(movie5);
        allMovie.add(movie6);
        allMovie.add(movie7);
        Scanner scanner = new Scanner(System.in);
        boolean inputValido = false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.dataInizio=null;
        this.dataFine=null;



        while (!inputValido) {
            System.out.print("Inserisci la data di inizio (formato: yyyy-MM-dd, premi Invio per saltare): ");
            String inputInizio = scanner.nextLine();

            if (inputInizio.isEmpty()) {
                break;
            }

            try {
                setDataInizio(convertToLocalDate(dateFormat.parse(inputInizio)));
                inputValido = true;
            } catch (ParseException e) {
                System.out.println("Input non valido. Inserisci una data nel formato corretto.");
            }
        }

        inputValido = false;

        while (!inputValido) {
            System.out.print("Inserisci la data di fine (formato: yyyy-MM-dd, premi Invio per saltare): ");
            String inputFine = scanner.nextLine();

            if (inputFine.isEmpty()) {
                break;
            }

            try {
                setDataFine(convertToLocalDate(dateFormat.parse(inputFine)));
                inputValido = true;
            } catch (ParseException e) {
                System.out.println("Input non valido. Inserisci una data nel formato corretto.");
            }
        }
        scanner.close();

}

    @RequestMapping(path = "/allMovie")
    public List<Movie> getCatalog(){

        return this.allMovie;

    }
    private static LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    @RequestMapping(path = "/filmInSala")
    public List<Movie> getFilmInSala() {
        List<Movie> filmInSala = new ArrayList<>();
        LocalDate dataAttuale = LocalDate.now();
        for (Movie movie : getAllMovie()) {
            if(getDataInizio()!=null && getDataFine()!=null){

                if (movie.getFinishDay().isAfter(getDataInizio())&&movie.getStartDay().isBefore(getDataFine())){
                    filmInSala.add(movie);
                    System.out.println(filmInSala);}
            } else if (getDataInizio()!=null && getDataFine()==null) {

                    setDataFine(getDataInizio().plusDays(7));
                if (movie.getFinishDay().isAfter(getDataInizio())&&movie.getStartDay().isBefore(getDataFine())){
                    filmInSala.add(movie);
                }
            } else if (getDataInizio()==null && getDataFine()!=null) {
                    setDataInizio(getDataFine().minusDays(7));
                    if (movie.getFinishDay().isAfter(getDataInizio())&&movie.getStartDay().isBefore(getDataFine())){
                        filmInSala.add(movie);}
                }
             else{
                long giorniRimasti = ChronoUnit.DAYS.between(dataAttuale,movie.getFinishDay());
                long giorniTotali = ChronoUnit.DAYS.between(dataAttuale,movie.getStartDay());
                if (giorniRimasti > 0 && movie.isActive()) {
                    filmInSala.add(movie);
                } else if (giorniTotali >21  && movie.isActive()==true) {
                    movie.setActive(false);
                } else if (giorniTotali<=7 && giorniRimasti>0) {
                    movie.setActive(true);
                    filmInSala.add(movie);
                }
            }
        }
        return filmInSala;
    }

    public List<Movie> getAllMovie() {
        return allMovie;
    }

    public void setAllMovie(List<Movie> allMovie) {
        this.allMovie = allMovie;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }
}
