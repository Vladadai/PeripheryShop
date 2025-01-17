package ee.ivkhkdev.input;

import ee.ivkhkdev.interfaces.Input;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private final Scanner scanner;

    public ConsoleInput(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public double nextDouble() {
        return scanner.nextDouble();
    }

    @Override
    public int nextInt() {
        return scanner.nextInt(); // добавлен метод для считывания целых чисел
    }
}
