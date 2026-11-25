import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Lab7Lambda {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8.name());

        System.out.println("Введіть рядок зі словами:");
        String input = scanner.nextLine();

        String[] result = findWordWithMinUniqueChars(input);

        System.out.println("Результат (масив String): " + Arrays.toString(result));
    }

    public static String[] findWordWithMinUniqueChars(String text) {
        if (text == null || text.trim().isEmpty()) {
            return new String[0];
        }

        return Arrays.stream(text.trim().split("\\s+"))
                .filter(word -> !word.isEmpty())
                .min(Comparator.comparingLong(word -> word.chars().distinct().count()))
                .map(word -> new String[]{word})
                .orElse(new String[0]);
    }
}