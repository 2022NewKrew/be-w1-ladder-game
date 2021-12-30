package view.input;

import java.util.Scanner;

public class ResourceManager {
    public static Scanner sc = new Scanner(System.in);

    public static void close(){
        sc.close();
    }
}
