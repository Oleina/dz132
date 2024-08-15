import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private Map<String, List<String>> directory;

    public Main() {
        directory = new HashMap<>();
    }

    // Метод для добавления записи
    public void add(String surname, String phoneNumber) {
        directory.computeIfAbsent(surname, k -> new ArrayList<>()).add(phoneNumber);
    }

    // Метод для поиска номеров телефонов по фамилии
    public List<String> get(String surname) {
        return directory.getOrDefault(surname, new ArrayList<>());
    }

    public static void main(String[] args) {
        Main phoneDirectory = new Main();

        phoneDirectory.add("Иванов", "123-45-67");
        phoneDirectory.add("Петров", "234-56-78");
        phoneDirectory.add("Иванов", "345-67-89");

        System.out.println("Телефоны Иванов: " + phoneDirectory.get("Иванов"));
        System.out.println("Телефоны Петров: " + phoneDirectory.get("Петров"));
        System.out.println("Телефоны Сидоров: " + phoneDirectory.get("Сидоров"));
    }
}