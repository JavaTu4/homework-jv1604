package homework5.record.tracks;

import java.util.Comparator;

/**
 * Created by root.
 */
public class Track {
    private String name;
    private String singer;
    private String album;
    private String genre;
    private int duration;

    static String[] genres = {"Rock","Techno","Minimal","Electro","Drum&Bass","Dubstep","Trip-Hop","Rap","Hip-Hop"};

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }
    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Track() {
        this.name = "Дорожка "+random(1,50);
        this.singer = "Исполнитель "+random(1,60);
        this.album = "Альбом "+random(10,70);
        this.genre = genres[random(0,(genres.length - 1))];
        this.duration = random(120,420);
    }

    @Override
    public String toString() {
        return "Композиция{ Название: "+name+", Исполнитель: "+singer+", Альбом: "
                +album+", Жанр: "+genre+", Длительность = "+duration+" секунд}";
    }

    public class TrackGenreComparator implements Comparator<Track>{
        @Override
        public int compare(Track o1, Track o2) {
            return o1.genre.compareTo(o2.genre);
        }
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

}
