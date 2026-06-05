package hust.soict.dsai.aims.screen;

import javax.swing.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector, tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add DVD to Store");
    }

    @Override
    protected void addCustomFields(JPanel panel) {
        panel.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        panel.add(tfDirector);

        panel.add(new JLabel("Length:"));
        tfLength = new JTextField();
        panel.add(tfLength);
    }

    @Override
    protected void addTheItem() throws Exception {
        float cost = Float.parseFloat(tfCost.getText());
        int length = Integer.parseInt(tfLength.getText());
        if (cost < 0 || length < 0) throw new IllegalArgumentException("Cost/Length cannot be negative!");

        DigitalVideoDisc dvd = new DigitalVideoDisc(tfTitle.getText(), tfCategory.getText(), tfDirector.getText(), length, cost);
        store.addMedia(dvd);
    }
}