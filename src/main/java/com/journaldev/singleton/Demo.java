package main.java.com.journaldev.singleton;

public class Demo {
    public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");
        Thread threadFoo = new Thread(new Demo.ThreadFoo());
        Thread threadBar = new Thread(new Demo.ThreadBar());
        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            ThreadSafeSingleton singletonOne = ThreadSafeSingleton.getInstance();
            System.out.println("instanceOne hashCode="+singletonOne.hashCode());
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            ThreadSafeSingleton singletonTwo = ThreadSafeSingleton.getInstance();
            System.out.println("instanceTwo hashCode="+singletonTwo.hashCode());
        }
    }
}
