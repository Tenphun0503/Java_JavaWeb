package myjava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\file.JPG");
        FileOutputStream fos = new FileOutputStream("D:\\copy.JPG");

        int b;
        while ((b=fis.read())!= -1){
            fos.write(b);
        }
        fis.close();
        fos.close();
    }
}
