package com.hillel.polezhaiev.application.app.uin;

import com.hillel.polezhaiev.application.app.exception.UserAlreadyExistsException;
import com.hillel.polezhaiev.application.app.service.UserService;

import javax.swing.*;
import java.awt.*;

public class UserApp extends JFrame {

    private UserService userService;
    private JTextField usernameInput = new JTextField();
    private JLabel usernameLabel = new JLabel("username");

    private JTextField passwordInput = new JPasswordField();
    private JLabel passwordLabel = new JLabel("password");

    private JLabel buttonLabel = new JLabel();
    private JButton saveButton = new JButton("save");


    {
        setSize(600, 400);
        setVisible(true);
        setLayout(new GridLayout(3, 2));

        add(usernameLabel);
        add(usernameInput);

        add(passwordLabel);
        add(passwordInput);

        add(buttonLabel);
        add(saveButton);
    }

    public UserApp(UserService userService) throws HeadlessException {
        this.userService = userService;

        saveButton.addActionListener(e -> {
            String username = usernameInput.getText();
            String password = passwordInput.getText();

            try {
                userService.saveUser(username, password);
                buttonLabel.setForeground(Color.BLUE);
                buttonLabel.setText("Successfully saved");

            } catch (UserAlreadyExistsException ex) {
                System.out.printf("User %s already exists", ex.getMessage());
                buttonLabel.setForeground(Color.RED);
                buttonLabel.setText(String.format("User %s already exists", ex.getMessage()));
            }
        });
    }
}
