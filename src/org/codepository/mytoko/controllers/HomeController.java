package org.codepository.mytoko.controllers;

import org.codepository.mytoko.views.home.HomeView;

public class HomeController extends Controller {
    private final UserController userController;
    private final HomeView homeView;

    public HomeController() {
        super();
        this.userController = new UserController();
        this.homeView = new HomeView();
    }

    public void index() {
        int input = 0;
        do {
            this.homeView.render();
            input = scan.nextInt();

            redirectIndexMenu(input);
        } while (input != 4);
    }

    private void redirectIndexMenu(int menu) {
        switch (menu) {
            case 1:
                this.userController.create();
                break;
            case 2:
                this.userController.index();
                break;
            case 3:
                this.userController.remove();
                break;
            default:
                break;
        }
    }
}
