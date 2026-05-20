package hust.soict.dsai.aims;

import java.util.Scanner;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.*;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initSampleData();

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewStoreMenu();
                    break;
                case 2:
                    updateStoreMenu();
                    break;
                case 3:
                    viewCartMenu();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void initSampleData() {
        store.addMedia(new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 24.95f));
        store.addMedia(new DigitalVideoDisc("Avatar", "Sci-Fi", "James Cameron", 162, 19.95f));

        Book book = new Book();
        book.setTitle("Java Core");
        book.setCategory("Technology");
        book.setCost(15.0f);
        book.addAuthor("Cay Horstmann");
        store.addMedia(book);

        CompactDisc cd = new CompactDisc();
        cd.setTitle("Abbey Road");
        cd.setCategory("Music");
        cd.setCost(20.0f);
        store.addMedia(cd);
    }

    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    private static void viewStoreMenu() {
        int choice;
        do {
            store.printStore();
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // See details
                    System.out.print("Enter media title: ");
                    String title = scanner.nextLine();
                    Media media = findMediaInStore(title);
                    if (media != null) {
                        System.out.println(media.toString());
                        handleMediaDetails(media);
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 2: // Add to cart
                    System.out.print("Enter media title: ");
                    String addTitle = scanner.nextLine();
                    Media addMedia = findMediaInStore(addTitle);
                    if (addMedia != null) {
                        cart.addMedia(addMedia);
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 3: // Play media
                    System.out.print("Enter media title: ");
                    String playTitle = scanner.nextLine();
                    Media playMedia = findMediaInStore(playTitle);
                    if (playMedia != null) {
                        playMediaAction(playMedia);
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 4: // See cart
                    viewCartMenu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void handleMediaDetails(Media media) {
        int choice;
        do {
            mediaDetailsMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    playMediaAction(media);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0 && choice != 1 && choice != 2);
    }

    private static void updateStoreMenu() {
        System.out.println("1. Add a media to Store");
        System.out.println("2. Remove a media from Store");
        System.out.print("Choose option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("Choose media type: 1. DVD  2. CD  3. Book");
            int type = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Title: ");
            String title = scanner.nextLine();
            System.out.print("Enter Category: ");
            String category = scanner.nextLine();
            System.out.print("Enter Cost: ");
            float cost = scanner.nextFloat();
            scanner.nextLine();

            if (type == 1) {
                store.addMedia(new DigitalVideoDisc(title, category, cost));
            } else if (type == 2) {
                CompactDisc cd = new CompactDisc();
                cd.setTitle(title); cd.setCategory(category); cd.setCost(cost);
                store.addMedia(cd);
            } else if (type == 3) {
                Book book = new Book();
                book.setTitle(title); book.setCategory(category); book.setCost(cost);
                store.addMedia(book);
            }
        } else if (choice == 2) {
            System.out.print("Enter title to remove: ");
            String title = scanner.nextLine();
            Media media = findMediaInStore(title);
            if (media != null) {
                store.removeMedia(media);
            } else {
                System.out.println("Media not found.");
            }
        }
    }

    private static void viewCartMenu() {
        int choice;
        do {
            cart.print();
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Filter
                    System.out.println("Filter by: 1. ID  2. Title");
                    int filterChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (filterChoice == 1) {
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        cart.searchById(id);
                    } else {
                        System.out.print("Enter Keyword: ");
                        String keyword = scanner.nextLine();
                        cart.searchByTitle(keyword);
                    }
                    break;
                case 2: // Sort
                    System.out.println("Sort by: 1. Title  2. Cost");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (sortChoice == 1) {
                        cart.sortByTitle();
                    } else {
                        cart.sortByCost();
                    }
                    break;
                case 3: // Remove
                    System.out.print("Enter title to remove: ");
                    String remTitle = scanner.nextLine();
                    Media remMedia = findMediaInCart(remTitle);
                    if (remMedia != null) {
                        cart.removeMedia(remMedia);
                    } else {
                        System.out.println("Not found in cart.");
                    }
                    break;
                case 4: // Play
                    System.out.print("Enter title to play: ");
                    String pTitle = scanner.nextLine();
                    Media pMedia = findMediaInCart(pTitle);
                    if (pMedia != null) {
                        playMediaAction(pMedia);
                    } else {
                        System.out.println("Not found in cart.");
                    }
                    break;
                case 5: // Place order
                    System.out.println("An order has been created successfully!");
                    cart = new Cart();
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static Media findMediaInStore(String title) {
        return null;
    }

    private static Media findMediaInCart(String title) {
        return null;
    }

    private static void playMediaAction(Media media) {
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This type of media (" + media.getClass().getSimpleName() + ") cannot be played.");
        }
    }
}