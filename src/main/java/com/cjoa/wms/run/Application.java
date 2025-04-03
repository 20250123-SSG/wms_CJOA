package com.cjoa.wms.run;

import com.cjoa.wms.view.LoginView;
import com.cjoa.wms.view.UserMainView;

public class Application {
    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        //loginView.loginView();
        UserMainView userMainView = new UserMainView();
        userMainView.userMainView();
    }
}
