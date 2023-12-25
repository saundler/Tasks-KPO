public class Movie {
    String name;
    long minutesDuration;

    public Movie() {
    }

    Movie(String name, long minutesDuration) {
        this.name = name;
        this.minutesDuration = minutesDuration;
    }

    @Override
    public String toString() {
        return "Название фильма = " + name + ", Длительность в минутах = " + minutesDuration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMinutesDuration() {
        return minutesDuration;
    }

    public void setMinutesDuration(long minutesDuration) {
        this.minutesDuration = minutesDuration;
    }
}