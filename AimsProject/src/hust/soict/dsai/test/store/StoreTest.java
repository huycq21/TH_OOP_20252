package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store myStore = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        System.out.println("--- Testing Add DVD ---");
        myStore.addMedia(dvd1);
        myStore.addMedia(dvd2);
        myStore.addMedia(dvd3);
        myStore.printStore();

        System.out.println("\n--- Testing Remove DVD ---");
        myStore.removeMedia(dvd2);
        myStore.printStore();

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avengers");
        myStore.removeMedia(dvd4);
    }
}