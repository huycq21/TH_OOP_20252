package hust.soict.dsai.aims.screen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class CartScreenController {
    private Cart cart;
    private FilteredList<Media> filteredList;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Label lblTotalCost;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        filteredList = new FilteredList<>(this.cart.getItemsOrdered(), p -> true);
        tblMedia.setItems(filteredList);

        updateTotalCost();
        cart.getItemsOrdered().addListener((javafx.collections.ListChangeListener<Media>) c -> {
            updateTotalCost();
        });

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        }
                    }
                }
        );

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });
    }


    @FXML
    void menuViewStorePressed(ActionEvent event) {
        closeCurrentWindow();
        new StoreScreen(this.cart.getStoreReference(), this.cart);
    }

    @FXML
    void menuAddBookPressed(ActionEvent event) {
        closeCurrentWindow();
        new AddBookToStoreScreen(this.cart.getStoreReference(), this.cart);
    }

    @FXML
    void menuAddCDPressed(ActionEvent event) {
        closeCurrentWindow();
        new AddCompactDiscToStoreScreen(this.cart.getStoreReference(), this.cart);
    }

    @FXML
    void menuAddDVDPressed(ActionEvent event) {
        closeCurrentWindow();
        new AddDigitalVideoDiscToStoreScreen(this.cart.getStoreReference(), this.cart);
    }

    private void closeCurrentWindow() {
        java.awt.Window win = java.awt.FocusManager.getCurrentManager().getActiveWindow();
        if (win != null) {
            win.dispose();
        }
    }


    void updateTotalCost() {
        lblTotalCost.setText(String.format("%.2f $", cart.totalCost()));
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();

                javax.swing.JOptionPane.showMessageDialog(null,
                        "Playing: " + media.getTitle(),
                        "Media Player",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);

            } catch (hust.soict.dsai.aims.exception.PlayerException e) {
                javax.swing.JOptionPane.showMessageDialog(null,
                        e.getMessage(),
                        "Player Error",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            tblMedia.getSelectionModel().clearSelection();
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "Your cart is empty!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Order placed successfully! Total: " + String.format("%.2f $", cart.totalCost()));
            cart.getItemsOrdered().clear();
        }
    }

    void showFilteredMedia(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            filteredList.setPredicate(media -> true);
            return;
        }
        String lowerCaseFilter = keyword.toLowerCase().trim();
        filteredList.setPredicate(media -> {
            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(lowerCaseFilter);
            } else if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            }
            return false;
        });
    }
}
