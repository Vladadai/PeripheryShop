package ee.ivkhkdev.interfaces;

import java.util.List;

public interface Service<T> {
    void create(String... params);
    void edit(String name, String... params);
    void printList();
    T findByName(String name);
}
