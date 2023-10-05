# threads
Существует 2 способа создание потоков:
1. При помощи класса Thread
```java
class MyThread extends Thread {
    public void run() {
        // Код
    }
}

// Создание и запуск потока
MyThread thread1 = new MyThread();
thread1.start();
```
2. При помощи интерфейса Runnable
```java
class MyRunnable implements Runnable {
    public void run() {
        // Код
    }
}

// Создание и запуск потока
MyRunnable runnable = new MyRunnable();
Thread thread2 = new Thread(runnable);
thread2.start();
```
