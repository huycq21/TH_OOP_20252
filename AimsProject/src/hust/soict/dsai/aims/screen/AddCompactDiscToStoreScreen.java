package hust.soict.dsai.aims.screen;

import javax.swing.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfArtist;

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add CD to Store");
    }

    @Override
    protected void addCustomFields(JPanel panel) {
        panel.add(new JLabel("Artist:"));
        tfArtist = new JTextField();
        panel.add(tfArtist);
    }

    @Override
    protected void addTheItem() throws Exception {
        float cost = Float.parseFloat(tfCost.getText());
        if (cost < 0) throw new IllegalArgumentException("Cost cannot be negative!");

        CompactDisc cd = new CompactDisc();
        cd.setTitle(tfTitle.getText());
        cd.setCategory(tfCategory.getText());
        cd.setCost(cost);
        store.addMedia(cd);
    }
}