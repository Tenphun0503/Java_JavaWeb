package myjava.practices;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("").toAbsolutePath();
        System.out.println(path);
    }
}