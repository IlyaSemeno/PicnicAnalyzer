import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PicnicAnalyzer {

    public static void main(String[] args) {
        // Чтение файла и выполнение заданий
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);

            // Задание 1: Подсчет слов
            int wordCount = countWords(scanner);
            System.out.println("Количество слов в файле: " + wordCount);

            // Задание 2: Нахождение самого длинного слова
            scanner = new Scanner(file); // переоткрытие файла
            String longestWord = findLongestWord(scanner);
            System.out.println("Самое длинное слово в файле: " + longestWord);

            // Задание 3: Вычисление частоты слов
            scanner = new Scanner(file); // переоткрытие файла
            Map<String, Integer> wordFrequency = calculateWordFrequency(scanner);
            System.out.println("Частота слов в файле:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден.");
            e.printStackTrace();
        }
    }

    private static int countWords(Scanner scanner) {
        int count = 0;
        while (scanner.hasNext()) {
            scanner.next(); // переход к следующему слову
            count++;
        }
        return count;
    }

    private static String findLongestWord(Scanner scanner) {
        String longestWord = "";
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    private static Map<String, Integer> calculateWordFrequency(Scanner scanner) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        while (scanner.hasNext()) {
            String word = scanner.next();
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        return wordFrequency;
    }
}
