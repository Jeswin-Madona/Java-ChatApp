# 💬 Java Chat Application (Alice & Bob)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge\&logo=java\&logoColor=white)
![Networking](https://img.shields.io/badge/Socket%20Programming-007396?style=for-the-badge)
![UI](https://img.shields.io/badge/AWT-UI-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Project-Completed-success?style=for-the-badge)

---

## 📌 Overview

A simple **real-time chat application** built using **Java Socket Programming** and **AWT GUI**.

This project demonstrates communication between two users:

* 🟢 **Alice (Server)**
* 🔵 **Bob (Client)**

Both users can send and receive messages instantly, similar to basic messaging apps.

---

## 🚀 Features

* 💬 Real-time messaging
* 🔌 Client-Server architecture
* 🧵 Multithreading (continuous message listening)
* 🖥️ Clean WhatsApp-style UI layout
* ⚡ Fast and lightweight

---

## 🛠️ Tech Stack

* **Java**
* **AWT (GUI)**
* **Socket Programming**
* **Multithreading**

---

## 🧠 What I Learned

* How client-server communication works
* Using `ServerSocket` and `Socket`
* Handling input/output streams
* Designing GUI using layouts
* Writing multi-threaded programs

---

## 📂 Project Structure

```bash
.
├── Alice.java   # Server code
├── Bob.java     # Client code
└── README.md
```

---

## ▶️ How to Run

### 1️⃣ Compile the files

```bash
javac Alice.java
javac Bob.java
```

### 2️⃣ Run Server (Alice)

```bash
java Alice
```

### 3️⃣ Run Client (Bob)

```bash
java Bob
```

---

## ⚠️ Important Notes

* Start **Alice (Server)** first
* Then run **Bob (Client)**
* Runs on `localhost`
* Port used: **12000**

---



## 🔄 How It Works

1. Server (Alice) starts and waits for connection
2. Client (Bob) connects to server
3. Messages are sent using `DataOutputStream`
4. Messages are received using `DataInputStream`
5. A separate thread continuously listens for messages

---

## 🚀 Future Improvements

* 🔄 Switch AWT → Swing (better UI)
* ⌨️ Press Enter to send messages
* 😊 Add emojis
* ⏰ Add timestamps
* 👥 Support multiple clients
* 🎨 Improve UI design

---



## 🙌 Author

**Jeswin Madona**

---

## ⭐ Support

If you like this project:

* ⭐ Star this repo
* 🍴 Fork it
* 📢 Share with others

---

💡 *This project is a beginner-friendly step into Java Networking and real-time applications.*
