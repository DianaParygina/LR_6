package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static java.lang.Integer.parseInt;

public class showFederationDialog extends Dialog{

    public showFederationDialog(Frame owner, L4_12 politic) {

        super(owner, "Добавление федерации", true);
        setSize(400, 150);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3, 2));
        FlowLayout layout = new FlowLayout();
        JPanel p2 = new JPanel();
        p2.setLayout(layout);
        JLabel one, three, four;
        JTextField federationNameField, capitalField, numberOfStatesField;

        one = new JLabel("Имя федерации:");
        three = new JLabel("Название столицы:");
        four = new JLabel("Количество штатов:");

        federationNameField = new JTextField(16);
        capitalField = new JTextField(16);
        numberOfStatesField = new JTextField(16);
        Button addButton = new Button("Добавить");

        addButton.addActionListener(e -> {

            String federationName = federationNameField.getText();
            String capital = capitalField.getText();
            String numberOfStates = numberOfStatesField.getText();

            setTitle("Окно добавления федерации");
            setLocationRelativeTo(null);
            if (federationName.matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(null, "Имя федерации не может содержать цифры");
                federationNameField.setText("");
                return;
            }

            if (capital.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Столица не может содержать цифры");
                capitalField.setText("");
                return;
            }

            if (!numberOfStates.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Количество штатов должно быть числом");
                numberOfStatesField.setText("");
                return;
            }

            politic.addFederation(federationName, capital, numberOfStates);

            federationNameField.setText("");
            capitalField.setText("");
            numberOfStatesField.setText("");

            dispose();
        });

        p1.add(one);
        p1.add(federationNameField);
        p1.add(three);
        p1.add(capitalField);
        p1.add(four);
        p1.add(numberOfStatesField);
        p2.add(addButton);
        add(p1, "North");
        add(p2, "Center");

        // Обработчик закрытия окна
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setResizable(false);
        setVisible(true);
    }
}
