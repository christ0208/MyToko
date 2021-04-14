package org.codepository.mytoko.views.home;

import org.codepository.mytoko.views.View;

public final class HomeView extends View {
    @Override
    public void render() {
        clearScreen();
        System.out.println("Binusmaya 5 LDAP Admin Console");
        System.out.println("==============================");
        System.out.println("1. Add New User");
        System.out.println("2. List Users");
        System.out.println("3. Delete Existing User");
        System.out.println("4. Exit");
        System.out.print("Choose >> ");
    }
}
