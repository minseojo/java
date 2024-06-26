package problem;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileIo f = new FileProperties();
        try {
            f.readFromFile("adapter/src/problem/file/file.txt");
            f.setValue("width", "1024");
            f.setValue("height", "512");
            f.setValue("depth", "32");
            f.writeToFile("adapter/src/problem/file/newfile.txt");
            System.out.println("newfile.txt is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
