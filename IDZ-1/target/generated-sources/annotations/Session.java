import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Session implements Comparable<Session> {
    Movie movie;
    LocalTime start;
    LocalTime end;
    boolean[] places;

    Session() {
    }

    Session(Movie movie, LocalTime start, int placesNumbers) {
        this.movie = movie;
        this.start = start;
        end = start.plusMinutes(movie.minutesDuration);
        this.places = new boolean[placesNumbers];
    }

    @Override
    public int compareTo(Session o) {
        return this.start.compareTo(o.start);
    }

    public void outputPlaces() {
        System.out.println("\u001B[34m" + "Список мест:" + "\u001B[0m");
        for (int i = 0; i < places.length; ++i) {
            if (places[i]) {
                System.out.printf("Место под номером %d, \u001B[31mЗАНЯТО\u001B[0m\n", i + 1);
            } else {
                System.out.printf("Место под номером %d, \u001B[32mСВОБОДНО\u001B[0m\n", i + 1);
            }
        }
    }

    @Override
    public String toString() {
        return "Название фильма = " + movie.name + ", Начало сеанса = " + start + ", Конец сеанса = " + end;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public boolean[] getPlaces() {
        return places;
    }

    public void setPlaces(boolean[] places) {
        this.places = places;
    }
}