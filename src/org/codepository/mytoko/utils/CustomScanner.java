package org.codepository.mytoko.utils;

import java.util.Scanner;

public class CustomScanner {
    private static CustomScanner instance;
    private Scanner scan;

    public static CustomScanner getInstance() {
        if (instance == null) {
            instance = new CustomScanner();
        }

        return instance;
    }

    public String nextLine() {
        return scan.nextLine();
    }

    public Integer nextInt() {
        int input = 0;
        try {
            input = scan.nextInt();
        } catch (Exception e) {
            input = -1;
        }
        scan.nextLine();

        return input;
    }
}
