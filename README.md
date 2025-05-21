# 🏘️ **Housings Admin App**

_A no-framework, all-Java, command-line housing management experience!_

---

## 🎯 The Challenge

> _Your challenge, should you choose to accept it, is to manage multiple types of housing (Tent, Cottage, and Hotel) in a neat Java application. You must allow users to add, search, display, and calculate costs for various accommodations — all through console-based wizardry._

**Requirements (a.k.a. mission parameters):**

- No frameworks. No databases. Just pure Java.
- Design an OOP model for different types of accommodations.
- Collect input interactively via the console.
- Implement operations like:

  - Adding accommodations
  - Searching for housing or clients by ID (RUT)
  - Calculating bonuses, discounts, and totals
  - Displaying info about clients and housings

- Organize your code in a maintainable, readable way.
- BONUS: Make the compiler happy on first try.

---

## 💡 The Final Result

> What do you get when you combine solid object-oriented principles, a splash of console-based UI, and a pinch of Java-flavored determination?
> **This repository.**

### ✨ Features

- **Multiple Housing Types**: Tent, Cottage, and Hotel – each with its own set of delightful quirks.
- **Polymorphism in Action**: Smart use of inheritance to handle behavior across housing types.
- **User-Friendly Console Input**: Okay, “friendly” might be a stretch, but it gets the job done.
- **Business Logic Goodness**:

  - Calculate total cost (with discounts and increments!)
  - Count housing types
  - Apply specific rules for each accommodation type

- **Client Management**: Track client details like name and RUT, and retrieve their housing info.

---

## 🔍 Under the Hood

### 🔧 Notable Design Highlights:

- **Encapsulation**: Each class does one thing and does it well.
- **Separation of Concerns**: Business logic lives in the `Housing` controller; model classes are cleanly separated.
- **Reusability**: Shared behavior abstracted via an `Accommodation` superclass.
- **Simplicity**: No external dependencies – just pure Java and raw power.

---

## 📁 How to Run It

1. Clone the repo:

   ```bash
   git clone https://github.com/visconttig/Housings-Admin-App.git
   cd Housings-Admin-App
   ```

2. Compile everything:

   ```bash
   javac com/company/*.java controladora/*.java
   ```

3. Run the main class (depending on your setup; assuming a `Main` class exists):

   ```bash
   java com.company.App
   ```

> Note: Make sure your terminal is ready to answer all kinds of quirky accommodation questions.

---

## 😎 Fun Extras

### 🤹 “What’s your accommodation type?”

- **Tent**: You’re adventurous, minimalist, and okay with bugs (code and real ones).
- **Cottage**: You appreciate the simple things — like a fireplace and peace.
- **Hotel**: You like it classy. Room service, breakfast, and bonus charges included.

---

## 📈 Why This Repo Stands Out

- ✔️ OOP design fundamentals on full display
- ✔️ Real-world modeling: clients, housing types, pricing logic
- ✔️ Clean, readable code with clear intention
- ✔️ Console-based interaction without needing GUI distractions
- ✔️ Humor-friendly variable naming? Check.

---

## 🧪 Tests & Validation

While this version doesn’t include unit tests (because, let's be real — this was built in the wild Java west), it’s structured to easily support them. Feel free to refactor for JUnit goodness... or don’t — we promised no refactoring here, after all 😉

---

## 🙋 Who’s Behind This?

Made with Java, brain cells, and at least one cup of coffee by
[@visconttig](https://github.com/visconttig)

---

## 📜 License

This code is so lightweight it doesn’t even need a license to feel free — but you can pretend it’s MIT. Fork it, run it, show it to your dog 🐶
