package org.codepository.mytoko.controllers;

import org.codepository.mytoko.models.dto.StaffCreateDto;
import org.codepository.mytoko.models.dto.StudentCreateDto;
import org.codepository.mytoko.models.dto.UserRemoveDto;
import org.codepository.mytoko.models.entity.Student;
import org.codepository.mytoko.models.entity.User;
import org.codepository.mytoko.repositories.UserRepository;
import org.codepository.mytoko.services.UserService;
import org.codepository.mytoko.validators.StringInListInsensitiveValidator;
import org.codepository.mytoko.validators.StringInListValidator;
import org.codepository.mytoko.validators.StringLengthBetweenValidator;
import org.codepository.mytoko.views.user.CreateView;
import org.codepository.mytoko.views.user.ListView;
import org.codepository.mytoko.views.user.RemoveView;

import java.util.Vector;

public class UserController extends Controller {
    private final CreateView createView;
    private final ListView<User> listView;
    private final RemoveView removeView;
    private final UserService userService;
    private final StringLengthBetweenValidator stringLengthBetweenValidator;
    private final StringInListValidator stringInListValidator;
    private final StringInListInsensitiveValidator stringInListInsensitiveValidator;

    public UserController() {
        this.createView = new CreateView();
        this.listView = new ListView<>();
        this.removeView = new RemoveView();
        this.userService = new UserService();
        this.stringLengthBetweenValidator = new StringLengthBetweenValidator();
        this.stringInListValidator = new StringInListValidator();
        this.stringInListInsensitiveValidator = new StringInListInsensitiveValidator();
    }

    public void index() {
        Vector<User> users = UserRepository.getInstance().get();

        this.listView.render();

        if (users.isEmpty()) {
            this.listView.printEmptyMessage();
        } else {
            for (User user:
                    users) {
                listView.render(user);
            }
        }

        this.listView.printPausePrompt();
        scan.nextLine();
    }

    public void create() {
        this.createView.render();
        String role = this.rolePrompt();

        if (role.equals("Student")) {
            this.createStudent();
        } else if (role.equals("Staff")) {
            this.createStaff();
        }

        this.createView.printSuccessCreatePrompt(role);
        this.createView.printPausePrompt();
        scan.nextLine();
    }

    private User createStudent() {
        String name = "";
        String campus = "";
        String major = "";

        String[] majorCompareList = new String[]{"Computer Science", "Information Systems"};

        name = this.namePrompt();
        campus = this.campusPrompt();

        do {
            this.createView.printMajorPrompt();
            major = scan.nextLine();
        } while (! this.stringInListInsensitiveValidator.validate(major, majorCompareList));

        User newStudent = this.userService.handleCreateStudent(
                new StudentCreateDto(
                        name,
                        campus,
                        major
                )
        );

        return newStudent;
    }

    private User createStaff() {
        String name = "";
        String campus = "";
        String division = "";
        String position = "";

        String[] divisionCompareList = new String[]{"SLC", "SoCS", "IT"};

        name = this.namePrompt();
        campus = this.campusPrompt();

        do {
            this.createView.printDivisionPrompt();
            division = scan.nextLine();
        } while (! this.stringInListValidator.validate(division, divisionCompareList));

        do {
            this.createView.printPositionPrompt();
            position = scan.nextLine();
        } while (! this.stringLengthBetweenValidator.validate(position, 1, 25));

        User newStaff = this.userService.handleCreateStaff(
                new StaffCreateDto(
                        name,
                        campus,
                        division,
                        position
                )
        );

        return newStaff;
    }

    public void remove() {
        String role = "";
        String username = "";

        this.removeView.render();

        role = this.rolePrompt();

        this.removeView.printUsernamePrompt();
        username = scan.nextLine();

        boolean status = this.userService.handleRemoveUser(
                new UserRemoveDto(
                        role, username
                )
        );

        if (status) {
            this.removeView.printSuccessRemovePrompt();
        } else {
            this.removeView.printFailedRemovePrompt();
        }

        scan.nextLine();
    }

    private String rolePrompt() {
        String role = "";
        String[] roleCompareList = new String[]{"Student", "Staff"};

        do {
            this.createView.printUserTypePrompt();
            role = scan.nextLine();
        } while (! this.stringInListValidator.validate(role, roleCompareList));

        return role;
    }

    private String namePrompt() {
        String name = "";

        do {
            this.createView.printNamePrompt();
            name = scan.nextLine();
        } while (! this.stringLengthBetweenValidator.validate(name, 1, 30));

        return name;
    }

    private String campusPrompt() {
        String campus = "";
        String[] campusCompareList = new String[]{"Anggrek", "Syahdan", "Kijang"};

        do {
            this.createView.printCampusPrompt();
            campus = scan.nextLine();
        } while (! this.stringInListValidator.validate(campus, campusCompareList));

        return campus;
    }
}
