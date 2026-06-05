package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Book;

public class MainScreenTest {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        store.addMedia(new DigitalVideoDisc("Inception", "Sci-Fi", 24.95f));
        store.addMedia(new DigitalVideoDisc("Avatar", "Sci-Fi", 19.95f));

        Book book = new Book();
        book.setTitle("Java Core");
        book.setCategory("Technology");
        book.setCost(15.0f);
        store.addMedia(book);

        CompactDisc cd = new CompactDisc();
        cd.setTitle("Abbey Road");
        cd.setCategory("Music");
        cd.setCost(20.0f);
        store.addMedia(cd);

        new StoreScreen(store, cart);
    }
}