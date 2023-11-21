package repo;

import model.Magazine;
import model.Novel;
import model.Book;
import service.InventoryService;
import utils.Period;
import utils.Util;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InventoryServiceImpl implements InventoryService {

    ArrayList<Book> books = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void addBook() {
        System.out.println("-- Book Types --");
        System.out.println("1. Novel");
        System.out.println("2. Magazine");
        System.out.print("Choose book's type: ");
        Integer bookChoice = null;
        try {
            bookChoice = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.err.println("Book's type input only accept number");
            addBook();
        }
        if (bookChoice != null) {
            switch (bookChoice) {
                case 1:
                    while(true) {
                        try {
                            System.out.println("Please input novel's detail");
                            System.out.print("Title: ");
                            String title = scanner.nextLine();
                            System.out.print("Publisher: ");
                            String publisher = scanner.nextLine();
                            System.out.print("Published Year: ");
                            Integer publishedYear = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Author: ");
                            String author = scanner.nextLine();

                            if (title.isEmpty()
                                || publisher.isEmpty()
                                || author.isEmpty()) {
                                System.err.println("Title, Publisher, and Author cannot be empty");
                                continue;
                            }

                            int novelCount = (int) books.stream()
                                    .filter(book -> book instanceof Novel)
                                    .count();
                            books.add(new Novel(
                                    Util.generateId(publishedYear, Novel.class.getName(),novelCount),
                                    title,
                                    publisher,
                                    publishedYear,
                                    author
                            ));
                            System.out.println("Novel [" + title + "] saved in Inventory");
                            break;
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.err.println("Published year only accept number");
                        }
                    }
                    break;
                case 2:
                    while(true) {
                        try {
                            System.out.println("Please input magazine's detail");
                            System.out.print("Title: ");
                            String title = scanner.nextLine();
                            if (title.isEmpty()) {
                                System.err.println("Title cannot be empty");
                                continue;
                            }

                            System.out.println("Please select published period: ");
                            System.out.println("1. Weekly");
                            System.out.println("2. Monthly");
                            System.out.print("Published Period: ");
                            Integer selectedPeriod = scanner.nextInt();
                            scanner.nextLine();
                            Period publishedPeriod = null;
                            if (selectedPeriod == 1) {
                                publishedPeriod = Period.WEEKLY;
                            }else if (selectedPeriod == 2) {
                                publishedPeriod = Period.MONTHLY;
                            } else {
                                System.err.println("Invalid published period input: " + selectedPeriod);
                            }

                            System.out.print("Published Year: ");
                            Integer publishedYear = scanner.nextInt();
                            scanner.nextLine();

                            int magazineCount = (int) books.stream()
                                    .filter(book -> book instanceof Magazine)
                                    .count();
                            books.add(new Magazine(
                                    Util.generateId(publishedYear, Magazine.class.getName(), magazineCount),
                                    title,
                                    publishedPeriod,
                                    publishedYear
                            ));
                            System.out.println("Magazine [" + title + "] saved in Inventory");
                            break;
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.err.println("Published year only accept number");
                        }
                    }
                    break;
                default:
                    System.err.println("Invalid book's type input: " + bookChoice);
                    addBook();
            }
        }
    }

    @Override
    public void searchBookByTitle() {
        System.out.print("Please input query for title: ");
        String query = scanner.nextLine().toLowerCase();

        ArrayList<Book> result = (ArrayList<Book>) books
                .stream()
                .filter(book -> book.getTitle().toLowerCase().contains(query))
                .collect(Collectors.toList());

        if(result.isEmpty()) {
            System.out.println("There is no book with [" + query + "] title");
            return;
        }

        System.out.println("Books which title contains [" + query + "] are:");
        for (int i = 0; i < result.size(); i++) {
            System.out.println(i + 1 + ". " + result.get(i));
        }
    }

    @Override
    public void searchBookById() {
        System.out.print("Please input query for book's Id: ");
        String query = scanner.nextLine().toLowerCase();

        ArrayList<Book> result = (ArrayList<Book>) books
                .stream()
                .filter(book -> {
                    if (book instanceof Novel){
                        Novel novel = (Novel) book;
                        return novel.getId().toLowerCase().contains(query);
                    } else {
                        Magazine magazine = (Magazine) book;
                        return magazine.getId().toLowerCase().contains(query);
                    }
                })
                .collect(Collectors.toList());

        if(result.isEmpty()) {
            System.out.println("There is no book with [" + query + "] Id");
            return;
        }

        System.out.println("Books which Id contains [" + query + "] are:");
        for (int i = 0; i < result.size(); i++) {
            System.out.println(i + 1 + ". " + result.get(i));
        }
    }

    @Override
    public void deleteBook() {
        if (books.isEmpty())
            throw new NullPointerException();

        System.out.println("-- Book List --");
        for (int i = 0; i < books.size(); i++) {
            System.out.println(i + 1 + ". " + books.get(i));
        }
        while(true) {
            Integer deleteIndex = null;
            try {
                System.out.print("Choose books to delete: ");
                deleteIndex = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Book [" + books.remove(deleteIndex-1).getTitle() + "] deleted successfully");
                break;
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Invalid novel index input: " + deleteIndex);
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.err.println("Input books to delete only accept number");
            }
        }
    }

    @Override
    public void getAllBook() {
        if (books.isEmpty())
            throw new NullPointerException();

        System.out.println("-- Book List --");
        for (int i = 0; i < books.size(); i++) {
            System.out.println(i + 1 + ". " + books.get(i));
        }
    }
}
