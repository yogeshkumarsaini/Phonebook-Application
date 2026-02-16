# 📱 Phonebook Application

A feature-rich console-based Phonebook application built using **Java, OOP, Collections, and File Handling**.  
It allows users to manage contacts efficiently with sorting, searching, grouping, favorites, and persistent storage.

---

## ✨ Features

✅ Add new contact  
✅ View all contacts (sorted A–Z)  
✅ 🔠 Group contacts by first letter  
✅ 🔍 Search by name  
✅ 📱 Search by phone number  
✅ ⭐ Mark contacts as favorite  
✅ 🔁 Update contact  
✅ ❌ Delete contact  
✅ 📌 Indian phone number validation  
✅ 💾 Data stored using file handling  
✅ 🧱 Object-Oriented design  
✅ 📋 Menu-driven interface  

---

## 🏗️ Project Structure
```
PhoneBook/
│── Contact.java
│── PhoneBook.java
│── Main.java
│── contacts.dat (auto-generated)
```

---

## 🛠️ Technologies Used

- Java
- OOP (Encapsulation, Abstraction, Comparable)
- Collections Framework (ArrayList, TreeMap)
- File Handling (Serialization)
- Regex (for phone validation)

---

## 📱 Indian Phone Number Validation

Valid formats:

- `9876543210`
- `919876543210`
- `+919876543210`

Invalid numbers are rejected.

---

## ▶️ How to Run

### 1️⃣ Compile
```bash
javac *.java
```

### 2️⃣ Run
```bash
java Main
```
---

## 📸 Sample Menu
```
📱 PHONEBOOK MENU
1. Add Contact
2. View All Contacts
3. Group by First Letter
4. Search by Name
5. Search by Phone
6. Mark Favorite
7. Update Contact
8. Delete Contact
9. Exit
```

---

## 💾 Data Storage

All contacts are saved in:
```
contacts.dat
```
So data remains available after restarting the program.
