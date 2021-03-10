package main.java.com.journaldev.singleton;

public enum EnumSingleton {
    INSTANCE;

    private EnumSingleton(){
        System.out.println("Enum Singleton");
    }
}
