package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends Frame {

    L4_12 politic = new L4_12();

    public MainWindow() {

        setTitle("Главное окно");
        setSize(300, 300);
        setLocationRelativeTo(null);
        Button button1 = new Button("Добавить республику");
        Button button2 = new Button("Добавить монархию");
        Button button3 = new Button("Добавить федерацию");
        Button button4 = new Button("Вывести список государств");
        Button button5 = new Button("Удалить государство по ID");
        Button button6 = new Button("Поиск государства по ID");
        Button button7 = new Button("Выход");

        button1.addActionListener(e -> showRepublicDialog());
        add(button1);
        button2.addActionListener(e ->  showMonarchyDialog());
        add(button2);
        button3.addActionListener(e -> showFederationDialog());
        add(button3);
        button4.addActionListener(e -> showPrintStatesDialog());
        add(button4);
        button5.addActionListener(e ->  showDeleteStateByIdDialog());
        add(button5);
        button6.addActionListener(e -> showSearchStateByIdDialog());
        add(button6);
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(button7);

        Panel panel = new Panel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Добавление кнопок на панель
        panel.add(button1);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(button2);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(button3);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(button4);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(button5);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(button6);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(button7);

        Panel centerPanel = new Panel(new GridBagLayout());
        centerPanel.add(panel);

        add( centerPanel);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setResizable(false);
        setVisible(true);
    }


    // Добавление слушателя на нажатие кнопки 1
    private void showRepublicDialog() {
        new showRepublicDialog(this, politic);
    }

    // Добавление слушателя на нажатие кнопки 2
    private void showMonarchyDialog() {
        new showMonarchyDialog(this, politic);
    }

    //окно для 3 кнопки
    private void showFederationDialog() {
        new showFederationDialog(this, politic);
    }

    //окно выведения всего что есть
    private void showPrintStatesDialog() {
        new showPrintStatesDialog(this).setVisible(true);
    }

    //окно удаления
    private void showDeleteStateByIdDialog() {
        new showDeleteStateByIdDialog(this);
    }

    //окно поиска
    private void showSearchStateByIdDialog() {
        new showSearchStateByIdDialog(this);
    }

}