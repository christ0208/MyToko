package org.codepository.mytoko.views.user;

import org.codepository.mytoko.views.View;

public class CreateView extends View {
    @Override
    public void render() {
        clearScreen();
    }

    public void printUserTypePrompt() {
        System.out.print("Role [Student | Staff]: ");
    }

    public void printNamePrompt() {
        System.out.print("Name [1-30 characters]: ");
    }

    public void printCampusPrompt() {
        System.out.print("Campus [Anggrek | Syahdan | Kijang] (case sensitive): ");
    }

    public void printMajorPrompt() {
        System.out.print("Major [Computer Science | Information Systems] (case insensitive): ");
    }

    public void printDivisionPrompt() {
        System.out.print("Division [SLC | SoCS | IT]: ");
    }

    public void printPositionPrompt() {
        System.out.print("Position [1 - 25 characters]: ");
    }

    public void printSuccessCreatePrompt(String role) {
        System.out.println("Successfully create user with role " + role + ".");
    }
}
