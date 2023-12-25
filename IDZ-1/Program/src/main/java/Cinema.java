import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.util.*;


public class Cinema {
    List<Movie> movies;
    TreeSet<Session> sessions;
    int placesNumbers;
    List<Ticket> tickets;

    Cinema(){
    }
    Cinema(int placesNumbers) {
        movies = new ArrayList<>();
        sessions = new TreeSet<>();
        if (placesNumbers < 1) {
            throw new NumberFormatException("Количество мест не может быть меньше 1");
        }
        this.placesNumbers = placesNumbers;
        tickets = new ArrayList<>();
    }

    public void addMovie() {
        System.out.println("\u001B[44m" + "Добавление фильма" + "\u001B[0m");
        Scanner scanner = new Scanner(System.in);
        String name;
        long minutesDuration = 0;
        boolean flag;
        do {
            System.out.print("\u001B[34m" + "Введите название фильма (без пробелов, иначе запишется только часть до 1 пробела): " + "\u001B[0m");
            name = scanner.next();
            String finalName = name;
            flag = movies.stream().anyMatch(movie -> Objects.equals(movie.name, finalName));
            if (flag) {
                outputMovies();
                System.out.println("\u001B[31m" + "Уже существует фильм таким именем, пожалуйста повторите ввод" + "\u001B[0m");
            }
            if (name.isEmpty()) {
                flag = true;
                System.out.println("\u001B[31m" + "Название фильма не может иметь длинну в 0 симвлов" + "\u001B[0m");
            }
        } while (flag);
        flag = true;
        do {
            try {
                System.out.print("\u001B[34m" + "Введите длительность фильма в минутах: " + "\u001B[0m");
                minutesDuration = Long.parseLong(scanner.next());
                flag = false;
                if (minutesDuration == 0) {
                    flag = true;
                    System.out.println("\u001B[31m" + "Длительность фильма не может быть менее 1 минуты" + "\u001B[0m");
                }
            } catch (java.lang.NumberFormatException exception) {
                System.out.println("\u001B[31m" + "Некорректный ввод числа, повторите попытку" + "\u001B[0m");
            }
        } while (flag);
        movies.add(new Movie(name, minutesDuration));
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void addSession() {
        if (movies.isEmpty()) {
            System.out.println("\u001B[31m" + "Нельзя добавить сеанс так как список фильмов пуст" + "\u001B[0m");
            return;
        }
        System.out.println("\u001B[44m" + "Добавление сеанса" + "\u001B[0m");
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        Movie movie;
        LocalTime start = LocalTime.parse("00:00");
        boolean flag;
        outputMovies();
        do {
            System.out.print("\u001B[34m" + "Введите название фильма: " + "\u001B[0m");
            String movieName = scanner.next();
            movie = movies.stream().filter(currMovie -> currMovie.name.equals(movieName)).findFirst().orElse(null);
            if (movie == null) {
                System.out.println("\u001B[31m" + "Не найден фильм с таким название, повторите попытку" + "\u001B[0m");
            }
        } while (movie == null);
        do {
            flag = false;
            try {
                System.out.print("\u001B[34m" + "Введите время в формате HH:mm: " + "\u001B[0m");
                start = LocalTime.parse(scanner.next(), formatter);
                LocalTime end = start.plusMinutes(movie.minutesDuration);
                if (start.isBefore(LocalTime.now())) {
                    flag = true;
                    System.out.println("\u001B[31m" + "Нельзя создать сеанс раньше нынешнего времени, повторите попытку" + "\u001B[0m");
                }
                for (Session session : sessions) {
                    if (flag || session.start.isAfter(end)) {
                        break;
                    }
                    if (session.end.isAfter(start)) {
                        flag = true;
                        System.out.println("\u001B[31m" + "Время сеанса пересекается с другими сеансами, повторите попытку" + "\u001B[0m");
                        break;
                    }
                }
            } catch (java.time.format.DateTimeParseException exception) {
                flag = true;
                System.out.println("\u001B[31m" + "Некорректный ввод времени, повторите попытку" + "\u001B[0m");
            }
        } while (flag);
        sessions.add(new Session(movie, start, placesNumbers));
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void outputMovies() {
        System.out.println("\u001B[34m" + "Список фильмов:" + "\u001B[0m");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public void outputSessions() {
        System.out.println("\u001B[34m" + "Список сеансов:" + "\u001B[0m");
        for (Session session : sessions) {
            System.out.println(session);
        }
    }

    public void deleteMovie() {
        if (movies.isEmpty()) {
            System.out.println("\u001B[31m" + "Нельзя удалить фильм так как список фильмов пуст" + "\u001B[0m");
            return;
        }
        System.out.println("\u001B[44m" + "Удаление фильма" + "\u001B[0m");
        Scanner scanner = new Scanner(System.in);
        Movie movie;
        outputMovies();
        do {
            if (continueOrNot()) {
                return;
            }
            System.out.print("\u001B[34m" + "Введите название фильма: " + "\u001B[0m");
            String movieName = scanner.nextLine();
            movie = movies.stream().filter(currMovie -> currMovie.name.equals(movieName)).findFirst().orElse(null);
            if (movie == null) {
                System.out.println("\u001B[31m" + "Не найден фильм с таким название, повторите попытку");
            }
        } while (movie == null);
        deleteMovie(movie);
    }

    private void deleteMovie(Movie movie) {
        for (Session session : sessions) {
            if (session.movie.name.equals(movie.name)) {
                deleteSession(session);
            }
        }
        movies.remove(movie);
    }

    public void deleteSession() {
        if (sessions.isEmpty()) {
            System.out.println("\u001B[31m" + "Нельзя удалить сеанс так как список сеансов пуст" + "\u001B[0m");
            return;
        }
        System.out.println("\u001B[44m" + "Удаление сеанса" + "\u001B[0m");
        Session session = selectSession();
        if (session != null) {
            deleteSession(session);
        }
    }

    public void viewPlaces() {
        if (sessions.isEmpty()) {
            System.out.println("\u001B[31m" + "Нельзя просмотреть места так как список сеансов пуст" + "\u001B[0m");
            return;
        }
        Session session = selectSession();
        if (session != null) {
            session.outputPlaces();
        }
    }

    public Session selectSession() {
        Scanner scanner = new Scanner(System.in);
        outputSessions();
        Session session;
        do {
            if(continueOrNot()) {
                return null;
            }
            System.out.print("\u001B[34m" + "Введите название фильма: " + "\u001B[0m");
            String movieString = scanner.nextLine();
            LocalTime start = LocalTime.parse("00:00");
            boolean flag = true;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            do {
                try {
                    System.out.print("\u001B[34m" + "Введите время начала сеанса в формате [HH:mm]: " + "\u001B[0m");
                    start = LocalTime.parse(scanner.next(), formatter);
                    flag = false;
                } catch (java.time.format.DateTimeParseException exception) {
                    System.out.println("\u001B[31m" + "Некорректный ввод времени, повторите попытку" + "\u001B[0m");
                }
            } while (flag);
            LocalTime tmp = start;
            session = sessions.stream().filter(curSession -> curSession.movie.name.equals(movieString) && curSession.start.equals(tmp)).findAny().orElse(null);
            if (session == null) {
                System.out.println("\u001B[31m" + "Не найден такой сеанс, повторите ввод" + "\u001B[0m");
            }
        } while (session == null);
        return session;
    }

    private void deleteSession(Session session) {
        for (int i = 0; i < tickets.size(); ++i) {
            if (tickets.get(i).sessionStart.equals(session.start) && tickets.get(i).movieName.equals(session.movie.name)) {
                tickets.remove(tickets.get(i));
                --i;
            }
        }
        sessions.remove(session);
    }
    private boolean continueOrNot() {
        Scanner scanner = new Scanner(System.in);
        String command;
        do {
            System.out.print("\u001B[34m" + "Для выхода в главное меню введите \"exit\", чтобы продолжить введите \"continue\": " + "\u001B[0m");
            command = scanner.next();
            if(command.equals("exit")) {
                return true;
            } else if(!command.equals("continue")) {
                System.out.println("\u001B[31m" + "Данная команда не существует, повторите ввод" + "\u001B[0m");
            }
        } while (!command.equals("continue"));
        return false;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public TreeSet<Session> getSessions() {
        return sessions;
    }

    public void setSessions(TreeSet<Session> sessions) {
        this.sessions = sessions;
    }

    public int getPlacesNumbers() {
        return placesNumbers;
    }

    public void setPlacesNumbers(int placesNumbers) {
        this.placesNumbers = placesNumbers;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}