package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class showMonarchyDialog extends Dialog {

    public showMonarchyDialog(Frame owner, L4_12 politic) {

        super(owner, "Добавление монархии", true);
        setSize(400, 150);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3, 2));
        FlowLayout layout = new FlowLayout();
        JPanel p2 = new JPanel();
        p2.setLayout(layout);
        JLabel one, three, four;
        JTextField monarchyNameField, nameMonarhField, hundredField;

        one = new JLabel("Имя монархии:");
        three = new JLabel("Имя правителя:");
        four = new JLabel("Век правления:");

        monarchyNameField = new JTextField(16);
        nameMonarhField = new JTextField(16);
        hundredField = new JTextField(16);
        Button addButton = new Button("Добавить");

        addButton.addActionListener(e -> {

            String monarchyName = monarchyNameField.getText();
            String ruler = nameMonarhField.getText();
            String reignPeriod = hundredField.getText();

            setTitle("Окно добавления монархии");
            setLocationRelativeTo(null);
            if (monarchyName.matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(null, "Имя монархии не может содержать цифры");
                monarchyNameField.setText("");
                return;
            }

            if (ruler.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Имя правителя не может содержать цифры");
                nameMonarhField.setText("");
                return;
            }

            if (!reignPeriod.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Введите корректный век правления");
                hundredField.setText("");
                return;
            }

            if (Integer.parseInt(reignPeriod) < 0 || Integer.parseInt(reignPeriod) > 21) {
                JOptionPane.showMessageDialog(null, "Введите век правления от 0 до 21");
                hundredField.setText("");
                return;
            }

            politic.addMonarchy(monarchyName, ruler, reignPeriod);

            monarchyNameField.setText("");
            nameMonarhField.setText("");
            hundredField.setText("");

            dispose();

        });

        p1.add(one);
        p1.add(monarchyNameField);
        p1.add(three);
        p1.add(nameMonarhField);
        p1.add(four);
        p1.add(hundredField);
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
