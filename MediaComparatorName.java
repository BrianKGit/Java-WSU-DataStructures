package assignment3;

import java.util.Comparator;

public class MediaComparatorName implements Comparator<Media> {
	public int compare(Media m1, Media m2) {
        return m1.getName().compareTo(m2.getName());
    }
}
