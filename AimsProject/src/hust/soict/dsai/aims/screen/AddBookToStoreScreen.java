package hust.soict.dsai.aims.screen;

import javax.swing.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add Book to Store");
    }

    @Override
    protected void addCustomFields(JPanel panel) {
    }

    @Override
    protected void addTheItem() throws Exception {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        if (cost < 0) throw new IllegalArgumentException("Cost cannot be negative!");

        Book book = new Book();
        book.setTitle(title);
        book.setCategory(category);
        book.setCost(cost);
        store.addMedia(book);
    }
}