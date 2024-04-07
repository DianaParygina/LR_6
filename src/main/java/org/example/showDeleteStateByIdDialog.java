package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static db.DBConnector.*;

public class showDeleteStateByIdDialog extends Dialog {

    public showDeleteStateByIdDialog(Frame owner) {
        super(owner, "Удаление государства по ID и типу", true);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(2, 2));
        FlowLayout layout = new FlowLayout();
        JPanel p2 = new JPanel();
        p2.setLayout(layout);
        JLabel idStateLabel, typeLabel;

        idStateLabel = new JLabel("ID государства:");
        TextField idStateField = new TextField(15);

        typeLabel = new JLabel("Тип государства:");
        JComboBox<String> typeComboBox = new JComboBox<>(new String[]{"republic", "monarchy", "federation"});
        typeComboBox.setSelectedIndex(-1);

        Button deleteId = new Button("Удалить");

        deleteId.addActionListener(e -> {
            try {
                int idState = Integer.parseInt(idStateField.getText().trim());
                String type = (String) typeComboBox.getSelectedItem();
                if (type == null) {
                    JOptionPane.showMessageDialog(null, "Пожалуйста, выберите тип государства");
                    return;
                }

                String result = "";
                switch (type) {
                    case "republic":
                        result = deleteRepublic(idState, type);
                        break;
                    case "monarchy":
                        result = deleteMonarchy(idState, type);
                        break;
                    case "federation":
                        result = deleteFederation(idState, type);
                        break;
                    default:
                        result = "Неизвестный тип государства";
                        break;
                }
                JOptionPane.showMessageDialog(null, result);
                idStateField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Пожалуйста, введите корректный числовой ID");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ошибка при удалении: " + ex.getMessage());
            }
        });

        p1.add(idStateLabel);
        p1.add(idStateField);
        p1.add(typeLabel);
        p1.add(typeComboBox);
        p2.add(deleteId);
        add(p1, "North");
        add(p2, "Center");

        setLayout(new FlowLayout());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setResizable(false);
        setVisible(true);
    }
}
