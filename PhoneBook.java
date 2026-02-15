import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class PhoneBook {

    private List<Contact> contacts = new ArrayList<>();
    private final String FILE_NAME = "contacts.dat";

    public PhoneBook() {
        loadFromFile();
    }

    // 📱 Indian phone validation
    public boolean isValidIndianNumber(String number) {
        String regex = "^(\\+91|91)?[6-9]\\d{9}$";
        return Pattern.matches(regex, number);
    }

    // ➕ Add Contact
    public void addContact(Contact contact) {
        if (!isValidIndianNumber(contact.getPhoneNumber())) {
            System.out.println("❌ Invalid Indian phone number");
            return;
        }
        contacts.add(contact);
        saveToFile();
        System.out.println("✅ Contact added");
    }

    // 📋 View All Sorted
    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found");
            return;
        }
        Collections.sort(contacts);
        contacts.forEach(System.out::println);
    }

    // 🔠 Group by First Letter
    public void groupByFirstLetter() {
        Collections.sort(contacts);

        Map<Character, List<Contact>> map = new TreeMap<>();

        for (Contact c : contacts) {
            char ch = Character.toUpperCase(c.getName().charAt(0));
            map.putIfAbsent(ch, new ArrayList<>());
            map.get(ch).add(c);
        }

        for (char key : map.keySet()) {
            System.out.println("\n[" + key + "]");
            for (Contact c : map.get(key)) {
                System.out.println(c);
            }
        }
    }

    // 🔍 Search by Name
    public Contact searchByName(String name) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    // 🔍 Search by Phone
    public void searchByPhone(String phone) {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phone)) {
                System.out.println(c);
                return;
            }
        }
        System.out.println("❌ Contact not found");
    }

    // ⭐ Mark Favorite
    public void markFavorite(String name) {
        Contact c = searchByName(name);
        if (c != null) {
            c.setFavorite(true);
            saveToFile();
            System.out.println("⭐ Marked as favorite");
        } else {
            System.out.println("❌ Contact not found");
        }
    }

    // 🔁 Update Contact
    public void updateContact(String name, String newPhone, String newEmail) {
        Contact c = searchByName(name);

        if (c != null) {
            if (!isValidIndianNumber(newPhone)) {
                System.out.println("❌ Invalid phone number");
                return;
            }
            c.setPhoneNumber(newPhone);
            c.setEmail(newEmail);
            saveToFile();
            System.out.println("✅ Contact updated");
        } else {
            System.out.println("❌ Contact not found");
        }
    }

    // ❌ Delete Contact
    public void deleteContact(String name) {
        Contact c = searchByName(name);

        if (c != null) {
            contacts.remove(c);
            saveToFile();
            System.out.println("🗑 Contact deleted");
        } else {
            System.out.println("❌ Contact not found");
        }
    }

    // 💾 Save
    private void saveToFile() {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(contacts);
        } catch (IOException e) {
            System.out.println("Error saving file");
        }
    }

    // 📂 Load
    private void loadFromFile() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            contacts = (List<Contact>) ois.readObject();
        } catch (Exception e) {
            contacts = new ArrayList<>();
        }
    }
}
