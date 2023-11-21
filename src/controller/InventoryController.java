package controller;

import repo.InventoryServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InventoryController {
    InventoryServiceImpl inventoryService = new InventoryServiceImpl();
    Scanner scanner = new Scanner(System.in);

    public InventoryController() {
    }

    public void run() {
        boolean isRunning = true;
        while(isRunning) {
            System.out.println("-------------------");
            System.out.println("Welcome to ENIGPUS!");
            System.out.println("-------------------");
            System.out.println("1. Show all books");
            System.out.println("2. Add new book");
            System.out.println("3. Delete book");
            System.out.println("4. Search book by Id");
            System.out.println("5. Search book by Title");
            System.out.println("6. Exit");
            System.out.print("Please choose menu: ");
            Integer menu = null;
            try {
                menu = scanner.nextInt();

                switch (menu) {
                    case 1:
                        inventoryService.getAllBook();
                        break;
                    case 2:
                        inventoryService.addBook();
                        break;
                    case 3:
                        inventoryService.deleteBook();
                        break;
                    case 4:
                        inventoryService.searchBookById();
                        break;
                    case 5:
                        inventoryService.searchBookByTitle();
                        break;
                    case 6:
                        isRunning = false;
                        System.out.println("Exiting program...");
                        break;
                    default:
                        throw new RuntimeException();
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.err.println("Menu input only accept number");
            } catch (NullPointerException e) {
                System.err.println("Books inventory is empty, please add new book first");
            }
        }
    }
}
