package assignment3;

import java.util.Comparator;

public class MediaComparatorScore implements Comparator<Media> {
	public int compare(Media m1, Media m2) {
        //return m1.getCriticScore().compareTo(m2.getCriticScore());
		return Double.compare(m2.getCriticScore(), m1.getCriticScore());
    }
}
