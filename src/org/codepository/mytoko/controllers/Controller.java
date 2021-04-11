package org.codepository.mytoko.controllers;

import org.codepository.mytoko.utils.CustomScanner;

public abstract class Controller {
    protected CustomScanner scan;

    public Controller() {
        this.scan = CustomScanner.getInstance();
    }

    protected void clearScreen() {
        for (int i = 0; i < 50; i++) System.out.println("");
    }
}
