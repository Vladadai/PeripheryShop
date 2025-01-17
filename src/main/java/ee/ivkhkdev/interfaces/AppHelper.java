package ee.ivkhkdev.interfaces;

public interface AppHelper<T> {
    T create(String... params);
    void edit(String name, String... params);
    T findByName(String name);
}
