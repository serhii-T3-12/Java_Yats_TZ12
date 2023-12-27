package lb7;

import java.util.ArrayList;
import java.util.List;

class Actor {
    private String name;
    private List<Film> films;

    public Actor(String name) {
        this.name = name;
        this.films = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void addFilm(Film film) {
        films.add(film);
    }

    @Override
    public String toString() {
        return name;
    }
}

class Film {
    private String title;
    private List<Actor> actors;

    public Film(String title) {
        this.title = title;
        this.actors = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    @Override
    public String toString() {
        return title;
    }
}

class MovieDatabase {
    private List<Film> films;
    private List<Actor> actors;

    public MovieDatabase() {
        this.films = new ArrayList<>();
        this.actors = new ArrayList<>();
    }

    public List<Film> getFilms() {
        return films;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void addFilm(Film film) {
        films.add(film);
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }
}

public class CinemaApplication {
    public static void main(String[] args) {
        MovieDatabase movieDatabase = new MovieDatabase();


        Actor robertDowneyJr = new Actor("Robert Downey Jr.");
        Actor chrisEvans = new Actor("Chris Evans");
        Actor scarlettJohansson = new Actor("Scarlett Johansson");
        Actor markRuffalo = new Actor("Mark Ruffalo");
        Actor TomCruise = new Actor("Tom Cruise");

        movieDatabase.addActor(robertDowneyJr);
        movieDatabase.addActor(chrisEvans);
        movieDatabase.addActor(scarlettJohansson);
        movieDatabase.addActor(markRuffalo);
        movieDatabase.addActor(TomCruise);


        Film ironMan = new Film("Iron Man");
        ironMan.addActor(robertDowneyJr);
        movieDatabase.addFilm(ironMan);

        Film avengers = new Film("The Avengers");
        avengers.addActor(robertDowneyJr);
        avengers.addActor(chrisEvans);
        avengers.addActor(scarlettJohansson);
        avengers.addActor(markRuffalo);
        movieDatabase.addFilm(avengers);

        Film civilWar = new Film("Captain America: Civil War");
        civilWar.addActor(robertDowneyJr);
        civilWar.addActor(chrisEvans);
        scarlettJohansson.addFilm(civilWar);
        movieDatabase.addFilm(civilWar);


        // Task 1:
        boolean hasActorWithNoFilms = Task1.hasActorWithNoFilms(movieDatabase.getActors());
        System.out.println("Чи є актор, який не зіграв в жодному фільмі: " + hasActorWithNoFilms);

        // Task 2:
        Actor targetActor = robertDowneyJr;
        List<Actor> coActors = Task2.findCoActors(targetActor, movieDatabase.getFilms());
        System.out.println("Список акторів, з якими коли-небудь грав " + targetActor.getName() + ": " + coActors);

        // Task 3:
        Film filmWithMostActors = Task3.findFilmWithMostActors(movieDatabase.getFilms());
        System.out.println("Фільм з найбільшою кількістю акторів: " + filmWithMostActors.getTitle());
    }
}

class Task1 {
    public static boolean hasActorWithNoFilms(List<Actor> actors) {
        for (Actor actor : actors) {
            if (actor.getFilms().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}

class Task2 {
    public static List<Actor> findCoActors(Actor targetActor, List<Film> films) {
        List<Actor> coActors = new ArrayList<>();
        for (Film film : films) {
            if (film.getActors().contains(targetActor)) {
                for (Actor actor : film.getActors()) {
                    if (!actor.equals(targetActor) && !coActors.contains(actor)) {
                        coActors.add(actor);
                    }
                }
            }
        }
        return coActors;
    }
}

class Task3 {
    public static Film findFilmWithMostActors(List<Film> films) {
        Film filmWithMostActors = null;
        int maxActors = 0;

        for (Film film : films) {
            int numActors = film.getActors().size();
            if (numActors > maxActors) {
                maxActors = numActors;
                filmWithMostActors = film;
            }
        }

        return filmWithMostActors;
    }
}
