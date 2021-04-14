package org.codepository.mytoko.views.user;

import org.codepository.mytoko.views.View;

public class RemoveView extends View {
    @Override
    public void render() {
        clearScreen();
    }

    public void printRolePrompt() {
        System.out.print("Role [Student | Staff]: ");
    }

    public void printUsernamePrompt() {
        System.out.print("Enter username you want to delete [must not empty]: ");
    }

    public void printSuccessRemovePrompt() {
        System.out.println("Successfully remove user.");
    }

    public void printFailedRemovePrompt() {
        System.out.println("Failed to remove user, make sure the username exists in database.");
    }
}
