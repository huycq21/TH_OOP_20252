package hust.soict.dsai.test.media;

import java.util.ArrayList;
import java.util.List;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class PolymorphismTest {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        Media dvd = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 24.95f);

        Book book = new Book();
        book.setTitle("Java Core");
        book.setCategory("Technology");
        book.setCost(15.0f);
        book.addAuthor("Cay Horstmann");

        CompactDisc cd = new CompactDisc();
        cd.setTitle("Abbey Road");
        cd.setCategory("Music");
        cd.setCost(20.0f);

        mediae.add(dvd);
        mediae.add(book);
        mediae.add(cd);

        System.out.println("--- PRINTING MEDIA INFORMATION ---");
        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}