# 🧵 Java Multithreading Demonstration

This project demonstrates how to process large data using **single-threading (main thread)** versus **multi-threading** in Java. It simulates real-world workload examples (like user authentication, streaming, XML parsing) to showcase the performance difference between the two approaches.

---

## 🎯 Objective

To compare:

- There are **2 branches** for demonstarting
- 🔹 **Single-threaded processing** — simple but slow for large workloads
- 🔸 **Multi-threaded processing** — more complex but significantly faster


---

## 📂 Project Structure

### `repository/DatabaseRepository.java`

Contains methods that simulate data fetched from a database:

- `findDataFromDatabase()` — ~100 items
- `findExtendedDataFromDatabase()` — 500 items (longer sentences)
- `findExtendedDataFromDatabaseButShortSentences()` — 500 items (short strings)

---

### `Main.java` - Main Thread (Single Thread)

Processes each task sequentially on the **main thread**. Suitable for demonstrating how long it takes to handle heavy computation (e.g., calculating a Fibonacci number based on string length).

```java
       List<String> sentences = databaseRepository.findDataFromDatabase();
        for (String sentence : sentences) {
        BusinessLogic.fibSentence(sentence);
        }

```

---

### `Main.java` - Multi Threading

Processes tasks concurrently using a **fixed thread pool** via `ExecutorService`. Great for demonstrating CPU-bound task parallelization.

```java
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Future<Void>> futures = new ArrayList<>();

        List<String> sentences = databaseRepository.findDataFromDatabase();
        for (String sentence : sentences) {
        futures.add(executor.submit(() -> BusinessLogic.fibSentence(sentence)));
        }
        
        for (Future<Void> future : futures) {
        future.get();
        }

        executor.shutdown();
}
```

---

## 📊 Performance Comparison

| Feature                  | Single Thread         | Multi Thread           |
|--------------------------|------------------------|--------------------------|
| Execution Speed          | ❌ Slower              | ✅ Faster                |
| CPU Utilization          | ❌ Underutilized       | ✅ Utilized efficiently  |
| Code Simplicity          | ✅ Very simple         | ⚠️ Slightly more complex |
| Real-World Scalability   | ❌ Poor                | ✅ Excellent             |

---

## 🧪 Suggestions for Exploration

- Change the thread pool size in the multi-threaded version.
- Use short vs long sentence data to simulate different workloads.
- Measure execution time with `System.currentTimeMillis()` or `Instant.now()`.

---

## 🧠 Concepts Demonstrated

- Java Threads and `Runnable`
- `ExecutorService` and fixed thread pools
- Heavy CPU-bound task simulation (Fibonacci calculation)
- Comparative analysis of concurrency benefits

---

## 🤝 Contributions Welcome

You can extend the project to:
- Use `CompletableFuture` or `parallelStream()`
- Measure thread execution time with profiling tools
- Add benchmarking reports
