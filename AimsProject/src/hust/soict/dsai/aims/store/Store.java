package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_CAPACITY = 100;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_CAPACITY];
    private int qtyInStore = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < MAX_CAPACITY) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("The DVD \"" + dvd.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("The store is full, cannot add more DVDs.");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        int index = -1;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("The DVD \"" + dvd.getTitle() + "\" is not found in the store.");
        } else {
            for (int i = index; i < qtyInStore - 1; i++) {
                itemsInStore[i] = itemsInStore[i + 1];
            }
            itemsInStore[qtyInStore - 1] = null;
            qtyInStore--;
            System.out.println("The DVD \"" + dvd.getTitle() + "\" has been removed from the store.");
        }
    }
    
    public void printStore() {
        System.out.println("**********STORE INVENTORY**********");
        for (int i = 0; i < qtyInStore; i++) {
            System.out.println((i+1) + ". " + itemsInStore[i].toString());
        }
        System.out.println("***********************************");
    }
}