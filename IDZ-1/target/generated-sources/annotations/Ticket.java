import java.time.LocalTime;

public class Ticket {
    String movieName;
    LocalTime sessionStart;
    int placeNumber;
    public Ticket() {
    }
    Ticket(String movieName, LocalTime sessionStart,int placeNumber) {
        this.movieName = movieName;
        this.sessionStart = sessionStart;
        this.placeNumber = placeNumber;
    }

    public LocalTime getSessionStart() {
        return sessionStart;
    }

    public void setSessionStart(LocalTime sessionStart) {
        this.sessionStart = sessionStart;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public String toString() {
        return "Название фильма = " + movieName + " Начало сеанса = " + sessionStart + " Место = " + placeNumber;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }
}