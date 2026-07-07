import java.util.*;

class Contact {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return String.format("%-20s %-15s %-25s", name, phone, email);
    }
}

public class AddressBookApp {
    private ArrayList<Contact> contacts;
    private HashMap<String, Contact> nameIndex;
    private HashSet<String> phoneSet;

    public AddressBookApp() {
        contacts = new ArrayList<>();
        nameIndex = new HashMap<>();
        phoneSet = new HashSet<>();
    }

    public boolean addContact(String name, String phone, String email) {
        if (phoneSet.contains(phone)) {
            System.out.println("Duplicate phone number: " + phone);
            return false;
        }
        if (nameIndex.containsKey(name)) {
            System.out.println("Duplicate name: " + name);
            return false;
        }
        Contact c = new Contact(name, phone, email);
        contacts.add(c);
        nameIndex.put(name, c);
        phoneSet.add(phone);
        return true;
    }

    public Contact searchByName(String name) {
        return nameIndex.get(name);
    }

    public boolean deleteContact(String name) {
        Contact c = nameIndex.remove(name);
        if (c == null) return false;
        contacts.remove(c);
        phoneSet.remove(c.getPhone());
        return true;
    }

    public void displaySorted() {
        Collections.sort(contacts, Comparator.comparing(Contact::getName));
        System.out.println(contacts.isEmpty() ? "No contacts." : "");
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        AddressBookApp book = new AddressBookApp();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Address Book ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Search by Name");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display All (Sorted)");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt(); sc.nextLine();

            switch (ch) {
                case 1 -> {
                    System.out.print("Name: "); String n = sc.nextLine();
                    System.out.print("Phone: "); String p = sc.nextLine();
                    System.out.print("Email: "); String e = sc.nextLine();
                    if (book.addContact(n, p, e))
                        System.out.println("Contact added.");
                }
                case 2 -> {
                    System.out.print("Name: "); String n = sc.nextLine();
                    Contact c = book.searchByName(n);
                    System.out.println(c != null ? c : "Not found.");
                }
                case 3 -> {
                    System.out.print("Name: "); String n = sc.nextLine();
                    System.out.println(book.deleteContact(n) ? "Deleted." : "Not found.");
                }
                case 4 -> book.displaySorted();
                case 5 -> { System.out.println("Bye."); return; }
                default -> System.out.println("Invalid.");
            }
        }
    }
}
