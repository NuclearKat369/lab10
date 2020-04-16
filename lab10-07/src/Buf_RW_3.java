import java.io.*;

public class Buf_RW_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        BufferedWriter out = null;

        try {
            //создание файловых символьных потоков для чтения и записи
            br = new BufferedReader(new FileReader("D:\\Документы\\lab10-07\\MyFile1.txt"));
            out = new BufferedWriter(new FileWriter("D:\\Документы\\lab10-07\\MyFile2.txt"));

            int lineCount = 0;      //счётчик строк
            String s;
            //переписывание информации из одного файла в другой
            while ((s = br.readLine()) != null) {
                lineCount++;
                System.out.println(lineCount + " : " + s);
                out.write(s);
                out.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error!!!");
        } finally {
            br.close();
            out.flush();
            out.close();
        }
    }
}
