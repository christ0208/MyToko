package org.codepository.mytoko.views;

public abstract class View {
    public void clearScreen() {
        for (int i = 0; i < 50; i++) System.out.println("");
    }

    public void printNoData() {
        System.out.println("No data...");
    }

    public void printPausePrompt() {
        System.out.println("Press ENTER to continue...");
    }

    public abstract void render();
}
