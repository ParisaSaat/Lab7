package main.java.com.journaldev.singleton;

public class DemoMultiThread {
    public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            LazyInitializedSingleton singletonOne = LazyInitializedSingleton.getInstance("FOO");
            System.out.println(singletonOne.value);
            System.out.println("instanceOne hashCode="+singletonOne.hashCode());
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            LazyInitializedSingleton singletonTwo = LazyInitializedSingleton.getInstance("BAR");
            System.out.println(singletonTwo.value);
            System.out.println("instanceTwo hashCode="+singletonTwo.hashCode());
        }
    }
}
