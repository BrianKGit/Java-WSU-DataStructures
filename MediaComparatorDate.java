package assignment3;


import java.util.Comparator;

public class MediaComparatorDate implements Comparator<Media> {
    public int compare(Media m1, Media m2) {
        return m1.getReleaseDate().compareTo(m2.getReleaseDate());
    }
}