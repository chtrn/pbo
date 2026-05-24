/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dokter;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Acer
 */


public class ModelTableDokter extends AbstractTableModel {
    private List<ModelDokter> listDokter;
    private final String[] columnNames = {"id", "Nama", "Spesialisasi", "Telepon"};

    public ModelTableDokter(List<ModelDokter> listDokter) {
        this.listDokter = listDokter;
    }

    @Override
    public int getRowCount() {
        return listDokter.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModelDokter dokter = listDokter.get(rowIndex);
        switch (columnIndex) {
            case 0: return dokter.getId();
            case 1: return dokter.getNama();
            case 2: return dokter.getSpesialisasi();
            case 3: return dokter.getTelepon();
            default: return null;
        }
    }
}
