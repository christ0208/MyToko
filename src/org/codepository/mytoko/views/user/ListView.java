package org.codepository.mytoko.views.user;

import org.codepository.mytoko.models.entity.Staff;
import org.codepository.mytoko.models.entity.Student;
import org.codepository.mytoko.models.entity.User;
import org.codepository.mytoko.views.View;

public class ListView<T extends User> extends View {
    @Override
    public void render() {
        clearScreen();
    }

    public void render(T user) {
        System.out.println("Name: " + user.getName());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Campus: " + user.getCampus());

        if (user instanceof Student) {
            System.out.println("Major: " + ((Student) user).getMajor());
        } else if (user instanceof Staff) {
            System.out.println("Division: " + ((Staff) user).getDivision());
            System.out.println("Position: " + ((Staff) user).getPosition());
        }
        System.out.println("");
    }

    public void printEmptyMessage() {
        System.out.println("No data...");
    }
}
