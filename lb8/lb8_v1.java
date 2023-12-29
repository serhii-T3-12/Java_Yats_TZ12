package lb8;

import java.util.*;

class Actor {
    private String name;
    private Set<Film> films;
    private Map<Actor, Integer> filmsCount;

    public Actor(String name) {
        this.name = name;
        this.films = new HashSet<>();
        this.filmsCount = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public int getFilmsCount(Actor actor) {
        return filmsCount.getOrDefault(actor, 0);
    }

    public void addFilm(Film film) {
        films.add(film);

        for (Actor actor : film.getActors()) {
            if (!actor.equals(this)) {
                filmsCount.put(actor, filmsCount.getOrDefault(actor, 0) + 1);
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}

class Film {
    private String title;
    private Set<Actor> actors;

    public Film(String title) {
        this.title = title;
        this.actors = new HashSet<>();
    }

    public String getTitle() {
        return title;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void addActor(Actor actor) {
        actors.add(actor);
        actor.addFilm(this);
    }

    @Override
    public String toString() {
        return title;
    }
}

class MovieDatabase {
    private Set<Film> films;
    private Set<Actor> actors;

    public MovieDatabase() {
        this.films = new HashSet<>();
        this.actors = new HashSet<>();
    }

    public Set<Film> getFilms() {
        return films;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void addFilm(Film film) {
        films.add(film);

        for (Actor actor : film.getActors()) {
            actors.add(actor);
            actor.addFilm(film);
        }
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }
}

public class lb8_v1 {
    public static void main(String[] args) {
        MovieDatabase movieDatabase = new MovieDatabase();

        Actor robertDowneyJr = new Actor("Robert Downey Jr.");
        Actor chrisEvans = new Actor("Chris Evans");
        Actor scarlettJohansson = new Actor("Scarlett Johansson");
        Actor markRuffalo = new Actor("Mark Ruffalo");
        Actor tomCruise = new Actor("Tom Cruise");

        movieDatabase.addActor(robertDowneyJr);
        movieDatabase.addActor(chrisEvans);
        movieDatabase.addActor(scarlettJohansson);
        movieDatabase.addActor(markRuffalo);
        movieDatabase.addActor(tomCruise);

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

        // Завдання 1:
        boolean hasActorWithNoFilms = Task1.hasActorWithNoFilms(movieDatabase.getActors());
        System.out.println("Чи є актор, який не зіграв в жодному фільмі: " + hasActorWithNoFilms);

        // Завдання 2:
        Actor targetActor = robertDowneyJr;
        List<Actor> coActors = Task2.findCoActors(targetActor, movieDatabase.getFilms());
        System.out.println("Список акторів, з якими коли-небудь грав " + targetActor.getName() + ": " + coActors);

        // Завдання 3:
        Film filmWithMostActors = Task3.findFilmWithMostActors(movieDatabase.getFilms());
        System.out.println("Фільм з найбільшою кількістю акторів: " + filmWithMostActors.getTitle());


        System.out.println("Кількість фільмів, в яких грав Robert Downey Jr.: " +
                robertDowneyJr.getFilmsCount(robertDowneyJr));
        System.out.println("Кількість фільмів, в яких грав Chris Evans: " +
                chrisEvans.getFilmsCount(chrisEvans));
    }
}

class Task1 {
    public static boolean hasActorWithNoFilms(Set<Actor> actors) {
        for (Actor actor : actors) {
            if (actor.getFilms().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}

class Task2 {
    public static List<Actor> findCoActors(Actor targetActor, Set<Film> films) {
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
    public static Film findFilmWithMostActors(Set<Film> films) {
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
