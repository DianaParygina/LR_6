package org.example;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MyTableModelFederation extends AbstractTableModel{

    private List<Federation> data;

    public MyTableModelFederation(List<Federation> federations){
        this.data = federations;
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
        Federation federation = data.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> federation.getName();
            case 1 -> federation.getId();
            case 2 -> federation.getCapital();
            case 3 -> federation.getNumberOfStates();
            default -> "Unknown";
        };
    }

    @Override
    public String getColumnName ( int column){
        return switch (column) {
            case 0 -> "Имя";
            case 1 -> "ID";
            case 2 -> "Столица";
            case 3 -> "Количество штатов";
            default -> "";
        };
    }
}

