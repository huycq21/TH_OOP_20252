package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddToCart = new JButton("Add to cart");
        container.add(btnAddToCart);
        btnAddToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MediaStore.this.cart != null) {
                    MediaStore.this.cart.addMedia(MediaStore.this.media);
                    JOptionPane.showMessageDialog(null,
                            "Added \"" + MediaStore.this.media.getTitle() + "\" to cart successfully!");
                }
            }
        });

        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            container.add(btnPlay);
            btnPlay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JDialog dialog = new JDialog((Frame) null, "Playing Media", true);
                    dialog.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

                    JLabel label = new JLabel("Playing: " + MediaStore.this.media.getTitle());
                    label.setFont(new Font(label.getFont().getName(), Font.BOLD, 14));
                    dialog.add(label);
                    JButton btnClose = new JButton("Close");
                    btnClose.addActionListener(ev -> dialog.dispose());
                    dialog.add(btnClose);

                    dialog.setSize(300, 150);
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                }
            });
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}