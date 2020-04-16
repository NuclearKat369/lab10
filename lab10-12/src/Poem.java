import java.io.*;

public class Poem {
    public static void main(String[] args) throws IOException {

        BufferedReader br = null;
        PrintWriter pr = null;
        try {
            br = new BufferedReader
                    (new InputStreamReader(new FileInputStream
                            ("D:\\Документы\\lab10-12\\Стих.txt")));
            pr = new PrintWriter("D:\\Документы\\lab10-12\\СтихNew.txt");

            int lineCount = 0;
            int wordCount;
            String s;

            String[] letters = {"б", "в", "г", "д", "ж", "з",
                    "й", "к", "л", "м", "н", "п", "р", "с", "т",
                    "ф", "х", "ц", "ч", "ш", "щ"};
            while ((s = br.readLine()) != null) {
                String[] str = s.split(" ");
                lineCount++;
                wordCount = 0;
                String line = "";
                for (int i = 0; i < str.length; i++) {
                    for (int j = 0; j < letters.length; j++) {
                        if (str[i].toUpperCase().
                                startsWith(letters[j].
                                        toUpperCase())) {
                            wordCount++;
                            line = line + (str[i] + " ");
                            break;
                        }
                    }
                }
                if (wordCount > 0) {
                    System.out.print(line);
                    String info = ("Номер строки: " +
                            lineCount + " Слов в строке: " + wordCount + "\n");
                    pr.printf("%-35s%35s", line, info);
                    System.out.println();
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            br.close();
            pr.flush();
            pr.close();
        }
    }
}