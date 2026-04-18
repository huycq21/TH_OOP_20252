package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store myStore = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        //Test Add DVD
        System.out.println("--- Testing Add DVD ---");
        myStore.addDVD(dvd1);
        myStore.addDVD(dvd2);
        myStore.addDVD(dvd3);
        myStore.printStore();

        //Test Remove DVD
        System.out.println("\n--- Testing Remove DVD ---");
        myStore.removeDVD(dvd2);
        myStore.printStore();

        //Test Remove Non-existent DVD
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avengers");
        myStore.removeDVD(dvd4);
    }
}