package ee.ivkhkdev.repositories;

import ee.ivkhkdev.interfaces.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Storage<T> implements Repository<T> {
    private final String fileName;

    public Storage(String fileName) {
        this.fileName = fileName;
    }
    public void save(T entity){
        List<T> entities = this.load();
        if(entities == null) entities = new ArrayList<>();
        entities.add(entity);
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(entities);
            objectOutputStream.flush();
        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл");
        } catch (IOException e) {
            System.out.println("Ошибка ввода");
        }
    }

    public void saveAll(List<T> entities) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(entities);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<T> load() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<T>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
