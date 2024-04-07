package org.example;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MyTableModelMonarchy extends AbstractTableModel{

    private List<Monarchy> data;

    public MyTableModelMonarchy(List<Monarchy> monarchies){
        this.data = monarchies;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Monarchy monarchy = data.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> monarchy.getName();
            case 1 -> monarchy.getId();
            case 2 -> monarchy.getRuler();
            case 3 -> monarchy.getReignPeriod();
            default -> "";
        };
    }

    @Override
    public String getColumnName ( int column){
        return switch (column) {
            case 0 -> "Имя";
            case 1 -> "ID";
            case 2 -> "Правитель";
            case 3 -> "Период правления";
            default -> "";
        };
    }
}