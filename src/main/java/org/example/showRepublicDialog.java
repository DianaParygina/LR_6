package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class showRepublicDialog extends Dialog {

    public showRepublicDialog(Frame owner, L4_12 politic) {

        super(owner, "Добавление республики", true);
        setSize(400, 150);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3, 2));
        FlowLayout layout = new FlowLayout();
        JPanel p2 = new JPanel();
        p2.setLayout(layout);
        JLabel one, three, four;
        JTextField republicNameField, citizensSatisfactionField, parliamentField;

        one = new JLabel("Имя республики:");
        three = new JLabel("Удовлетворенность граждан:");
        four = new JLabel("Парламент:");

        republicNameField = new JTextField(16);
        citizensSatisfactionField = new JTextField(16);
        parliamentField = new JTextField(16);
        Button addButton = new Button("Добавить");

        addButton.addActionListener(e -> {

            String republicName = republicNameField.getText();
            String citizensatisfaction = citizensSatisfactionField.getText();
            String parlament = parliamentField.getText();

            setLocationRelativeTo(null);
            if (republicName.matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(null, "Имя республики не может содержать цифры");
                republicNameField.setText("");
                return;
            }

            if (citizensatisfaction.matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(null, "Удовлетворенность граждан не может содержать цифры");
                citizensSatisfactionField.setText("");
                return;
            }

            if (parlament.matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(null, "Парламент не может содержать цифры");
                parliamentField.setText("");
                return;
            }

            politic.addState(republicName, citizensatisfaction, parlament);

            republicNameField.setText("");
            citizensSatisfactionField.setText("");
            parliamentField.setText("");

            dispose();

        });

        p1.add(one);
        p1.add(republicNameField);
        p1.add(three);
        p1.add(citizensSatisfactionField);
        p1.add(four);
        p1.add(parliamentField);
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
