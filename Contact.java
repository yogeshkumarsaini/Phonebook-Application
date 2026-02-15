import java.io.Serializable;

public class Contact implements Serializable, Comparable<Contact> {

    private String name;
    private String phoneNumber;
    private String email;
    private boolean favorite;

    public Contact(String name, String phoneNumber, String email, boolean favorite) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.favorite = favorite;
    }

    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail() { return email; }
    public boolean isFavorite() { return favorite; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmail(String email) { this.email = email; }
    public void setFavorite(boolean favorite) { this.favorite = favorite; }

    @Override
    public int compareTo(Contact o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    @Override
    public String toString() {
        return (favorite ? "⭐ " : "") + name + " | " + phoneNumber + " | " + email;
    }
}
