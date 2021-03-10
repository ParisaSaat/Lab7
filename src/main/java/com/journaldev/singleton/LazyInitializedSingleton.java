package main.java.com.journaldev.singleton;

public class LazyInitializedSingleton {
    private static LazyInitializedSingleton instance;
    public String value;

    //private constructor to avoid client applications to use constructor
    private LazyInitializedSingleton(String value){
        this.value = value;
    }

    public static LazyInitializedSingleton getInstance(String value){
        if (instance == null){
            instance = new LazyInitializedSingleton(value);
        }
        return instance;
    }
}


