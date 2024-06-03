import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("input.txt");
        try {
            Scanner scanner = new Scanner(file);

            int wordCount = 0;
            String longestWord = "";
            Map<String, Integer> wordFrequency = new HashMap<>();

            while (scanner.hasNext()) {
                String word = scanner.next();
                wordCount++;

                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }

                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }

            System.out.println("Количество слов в файле: " + wordCount);
            System.out.println("Самое длинное слово в файле: " + longestWord);

            System.out.println("Частота встречаемости каждого слова:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }
    }
}