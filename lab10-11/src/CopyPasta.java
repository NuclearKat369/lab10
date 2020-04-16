import java.io.*;
import java.util.Scanner;

public class CopyPasta {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in, "cp1251");
        BufferedReader br = null;
        PrintWriter pr = null;

        try {
            File f1 = new File("D:\\Документы\\lab10-11\\Исходный.txt");
            f1.createNewFile();
            System.out.println("Полный путь файла: " + f1.getAbsolutePath());

            pr = new PrintWriter((f1), "cp1251");

            for (int i = 0; i < 2; i++) {
                System.out.print("Введите " + (i + 1) + "-ю строку для записи в файл => ");
                String s = sc.nextLine();
                System.out.println(s);
                pr.write(s + "\n");
            }

            System.out.println("Введите вещественные числа:");
            for (int i = 0; i < 5; i++) {
                double num = sc.nextDouble();
                System.out.println(num);
                pr.write(num + " ");
            }

            File f2 = new File("D:\\Документы\\lab10-11\\Результат.txt");
            f2.createNewFile();
            System.out.println("Полный путь файла: " + f2.getAbsolutePath());

            pr.flush();

            br = new BufferedReader
                    (new InputStreamReader
                            (new FileInputStream(f1)));
            pr = new PrintWriter((f2), "cp1251");

            int lineCount = 0;
            String s;
            while ((s = br.readLine()) != null) {
                lineCount++;
                if (lineCount == 2) {
                    System.out.println(lineCount + " " + s);
                    pr.println(s);
                } else if (lineCount > 2) {
                    String[] str = s.split(" ");
                    double[] d = new double[5];
                    for (int i = 0; i < d.length; i++) {
                        d[i] = Double.parseDouble(str[i]);
                        if (d[i] > 0) {
                            pr.print(d[i] + " ");
                            System.out.print(d[i] + "\n");
                        }
                    }
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