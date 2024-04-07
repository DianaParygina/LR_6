package org.example;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MyTableModelRepublic extends AbstractTableModel {
    private List<Republic> data;

    public MyTableModelRepublic(List<Republic> republics){
        this.data = republics;
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
        Republic republic = data.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> republic.getName();
            case 1 -> republic.getId();
            case 2 -> republic.getSatisfaction_of_citizens();
            case 3 -> republic.getParliament();
            default -> "";
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "Имя";
            case 1 -> "ID";
            case 2 -> "Удовлетворенность граждан";
            case 3 -> "Парламент";
            default -> "";
        };
    }
}