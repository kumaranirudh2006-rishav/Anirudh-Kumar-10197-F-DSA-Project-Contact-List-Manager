import java.util.Scanner;

class ContactListManager {

    
    static class Node {
        String name;
        String phone;
        Node next;

        Node(String name, String phone) {
            this.name = name;
            this.phone = phone;
            this.next = null;
        }
    }

    static Node head = null;
    static Scanner sc = new Scanner(System.in);

    
    static void addContact() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        Node newNode = new Node(name, phone);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        System.out.println("Contact Added Successfully!");
    }

    
    static void displayContacts() {
        if (head == null) {
            System.out.println("Contact List is Empty!");
            return;
        }

        Node temp = head;

        System.out.println("\n--- Contact List ---");

        while (temp != null) {
            System.out.println("Name: " + temp.name);
            System.out.println("Phone: " + temp.phone);
            System.out.println("-------------------");

            temp = temp.next;
        }
    }

    
    static void searchContact() {
        System.out.print("Enter Name to Search: ");
        String searchName = sc.nextLine();

        Node temp = head;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(searchName)) {
                System.out.println("Contact Found!");
                System.out.println("Name: " + temp.name);
                System.out.println("Phone: " + temp.phone);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Contact Not Found!");
    }

    
    static void deleteContact() {
        if (head == null) {
            System.out.println("Contact List is Empty!");
            return;
        }

        System.out.print("Enter Name to Delete: ");
        String deleteName = sc.nextLine();

        
        if (head.name.equalsIgnoreCase(deleteName)) {
            head = head.next;
            System.out.println("Contact Deleted Successfully!");
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            if (temp.next.name.equalsIgnoreCase(deleteName)) {
                temp.next = temp.next.next;
                System.out.println("Contact Deleted Successfully!");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Contact Not Found!");
    }

   
    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== CONTACT LIST MANAGER =====");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addContact();
                    break;

                case 2:
                    displayContacts();
                    break;

                case 3:
                    searchContact();
                    break;

                case 4:
                    deleteContact();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);
    }
}