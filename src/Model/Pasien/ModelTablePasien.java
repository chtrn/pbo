/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Pasien;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Acer
 */

public class ModelTablePasien extends AbstractTableModel {
    private List<ModelPasien> listPasien;
    private final String[] columnNames = {"id", "Nama", "Tgl Lahir", "Gol Darah", "Riwayat", "Telepon"};

    public ModelTablePasien(List<ModelPasien> listPasien) {
        this.listPasien = listPasien;
    }

    @Override
    public int getRowCount() {
        return listPasien.size();
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
        ModelPasien pasien = listPasien.get(rowIndex);
        switch (columnIndex) {
            case 0: return pasien.getId();
            case 1: return pasien.getNama();
            case 2: return pasien.getTgl_Lahir();
            case 3: return pasien.getGol_Darah();
            case 4: return pasien.getRiwayat();
            case 5: return pasien.getTelepon();
            default: return null;
        }
    }
}
