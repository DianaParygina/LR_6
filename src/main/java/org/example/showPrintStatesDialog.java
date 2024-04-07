package org.example;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;
import db.DBConnector;

public class showPrintStatesDialog extends JDialog {

    public showPrintStatesDialog(Frame owner) {

        super(owner, "Список государств", true);
        setSize(1000, 500);
        setLocationRelativeTo(owner);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        DBConnector.connection();

        List<Republic> republic = null;
        try {
            republic = DBConnector.getAllRepublics();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ошибка при получении данных из БД",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        }

        List<Monarchy> monarchy = null;
        try {
            monarchy = DBConnector.getAllMonarchy();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ошибка при получении данных из БД",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        }

        List<Federation> federation = null;
        try {
            federation = DBConnector.getAllFederation();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ошибка при получении данных из БД",
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        }

        MyTableModelRepublic tableModelRepublic = new MyTableModelRepublic(republic);
        MyTableModelMonarchy tableModelMonarchy = new MyTableModelMonarchy(monarchy);
        MyTableModelFederation tableModelFederation = new MyTableModelFederation(federation);

        JTable tableRepublic = new JTable(tableModelRepublic);
        JTable tableMonarchy = new JTable(tableModelMonarchy);
        JTable tableFederation = new JTable(tableModelFederation);

        addSectionWithLabelAndTable("Республики", tableRepublic);
        addSectionWithLabelAndTable("Монархии", tableMonarchy);
        addSectionWithLabelAndTable("Федерации", tableFederation);

        setResizable(false);
    }

    private void addSectionWithLabelAndTable(String labelTitle, JTable table) {
        JLabel label = new JLabel(labelTitle);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        getContentPane().add(label);

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
        getContentPane().add(Box.createVerticalStrut(10));
    }
}

