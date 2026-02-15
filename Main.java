import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PhoneBook pb = new PhoneBook();

        while (true) {

            System.out.println("\n📱 PHONEBOOK MENU");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Group by First Letter");
            System.out.println("4. Search by Name");
            System.out.println("5. Search by Phone");
            System.out.println("6. Mark Favorite");
            System.out.println("7. Update Contact");
            System.out.println("8. Delete Contact");
            System.out.println("9. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Favorite (true/false): ");
                    boolean fav = sc.nextBoolean();

                    pb.addContact(new Contact(name, phone, email, fav));
                    break;

                case 2:
                    pb.viewContacts();
                    break;

                case 3:
                    pb.groupByFirstLetter();
                    break;

                case 4:
                    System.out.print("Enter name: ");
                    Contact c = pb.searchByName(sc.nextLine());
                    System.out.println(c != null ? c : "❌ Not found");
                    break;

                case 5:
                    System.out.print("Enter phone: ");
                    pb.searchByPhone(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Enter name: ");
                    pb.markFavorite(sc.nextLine());
                    break;

                case 7:
                    System.out.print("Enter name to update: ");
                    String uname = sc.nextLine();

                    System.out.print("New phone: ");
                    String uphone = sc.nextLine();

                    System.out.print("New email: ");
                    String uemail = sc.nextLine();

                    pb.updateContact(uname, uphone, uemail);
                    break;

                case 8:
                    System.out.print("Enter name to delete: ");
                    pb.deleteContact(sc.nextLine());
                    break;

                case 9:
                    System.out.println("👋 Goodbye");
                    return;

                default:
                    System.out.println("❌ Invalid choice");
            }
        }
    }
}
