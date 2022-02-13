import java.util.*;

public class DataBase {
    private static Scanner sc = new Scanner(System.in);

    public static void fillup(){
        Actors.fillActorsMap();
        Directors.fillDirectorsMap();
        Genres.fillGenresMap();
        Writers.fillWritersMap();
        Movies.fillMoviesMap();
    }

    public static void showAllMovies(){
        for(Map.Entry<Integer,Movie> entry : Movies.getMoviesMap().entrySet()){
            Movie movie = entry.getValue();
            System.out.println("Название фильма - " + movie.getTitle());
            System.out.printf("imdb рейтинг - %.1f \n", movie.getRaiting());
            System.out.println("Режиссер - " + movie.getDirector());
            System.out.println("Жанры - " + movie.getGenresNames());
            System.out.println("Сценаристы - " + movie.getWritersNames());
            System.out.println("Актеры - " + movie.getActorsNames());
            System.out.println("Описание - " + movie.getDescription());
        }
    }

    public static void getGenreInfo(){
        System.out.println("Выберите жанр : ");
        Genres.printGenresMap();
        int id = sc.nextInt();
        Genre selectedGenre = Genres.getGenreById(id);

        int countMoviesOfGenre = 0;
        double avgRaiting = 0;

        for(Map.Entry<Integer,Movie> entry : Movies.getMoviesMap().entrySet()){
            Movie movie = entry.getValue();
            for(Genre genre : movie.getGenres()){
                if(genre.equals(selectedGenre)){
                    countMoviesOfGenre++;
                    avgRaiting += movie.getRaiting();
                }
            }
        }
        avgRaiting /= countMoviesOfGenre;
        System.out.println("Название жанра - " + selectedGenre.getName());
        System.out.println("Кол-во фильмов этого жанра - " + countMoviesOfGenre);
        System.out.printf("Средняя оценка фильмов данного жанра - %.1f \n" , avgRaiting);
    }

    public static void getActorInfo(){
        System.out.println("Выберите актера : ");
        Actors.printActorsMap();
        int id = sc.nextInt();
        Actor selectedActor = Actors.getActorById(id);
        double bestRaiting = 0;
        int countActorsMovie = 0;
        Set<Genre> bestGenre = new HashSet<>();

        for(Map.Entry<Integer,Movie> entry : Movies.getMoviesMap().entrySet()){
            Movie movie = entry.getValue();
            for(Actor actor : movie.getActors()){
                if(actor.equals(selectedActor)){
                    countActorsMovie++;
                    if(bestRaiting < movie.getRaiting()){
                        bestRaiting = movie.getRaiting();
                        if(bestRaiting == movie.getRaiting()){
                            bestGenre = Set.copyOf(movie.getGenres());
                        }else{
                            bestGenre.clear();
                        }
                    }
                }
            }
        }

        System.out.println("Имя актера - " + selectedActor.getName());
        System.out.println("Кол-во фильмов в которых снимался этот\n" +
                "актер - " + countActorsMovie);
        System.out.print("Жанры с лучшим средним\n" +
                "рейтингом фильмов, в которых снимался\n" +
                "актер - ");
        for (Genre genre : bestGenre) {
            System.out.print(genre.getName() + " ");
        }
        System.out.println();
    }
    // переделать разбив это месиво на методы
    public static void getDirectorInfo(){
        System.out.println("Выберите режиссера : ");
        Directors.printDirectorsMap();
        int id = sc.nextInt();
        Director selectedDirector = Directors.getDirectorById(id);
        int moviesCount = 0;
        List<Actor> actorList = new ArrayList<>();
        Map<Integer,Actor> countMoviesWithActors = new TreeMap<>(Collections.reverseOrder());
        Map<Double, Movie> topMoviesByRaiting = new TreeMap<>(Collections.reverseOrder());
        for(Map.Entry<Integer,Movie> entry : Movies.getMoviesMap().entrySet()){
            Movie movie = entry.getValue();
            if(movie.getDirector().equals(selectedDirector)){
                moviesCount++;
                actorList.addAll(movie.getActors());
                topMoviesByRaiting.put(movie.getRaiting(),movie);
            }
        }
        for (Actor actor : actorList) {
            int occurences = Collections.frequency(actorList,actor);
            countMoviesWithActors.put(occurences,actor);
        }
        List<Integer> keys  = new ArrayList<>();
        List<Actor> values = new ArrayList<>();
        for(Map.Entry<Integer,Actor> entry : countMoviesWithActors.entrySet()){
            int key = entry.getKey();
            keys.add(key);
            Actor value = entry.getValue();
            values.add(value);
        }

        System.out.println("Имя режиссера - " + selectedDirector.getName());
        System.out.println("Колличество фильмов режиссера - " + moviesCount);
        System.out.println("Имена актеров, которые чаще всего\n" +
                "снимались с этим режиссером в порядке\n" +
                "убывания количества фильмов и само\n" +
                "количество фильмов.");
        for (int i = 0; i < 3; i++) {
            System.out.println(values.get(i).getName() + " - " + keys.get(i));
        }//если рандом не упадет как надо то буде индексэрэйаутофбанес (((
        System.out.println("Лучшие три фильма по рейтингу : ");
        int stop = 0;
        for(Map.Entry<Double,Movie> entry : topMoviesByRaiting.entrySet()){
            Movie movie = entry.getValue();
            double rating = entry.getKey();
            System.out.printf("%s - рейтинг: %.1f \n", movie.getTitle(), rating);

            stop++;
            if (stop == 3) break;
        }
    }
}
