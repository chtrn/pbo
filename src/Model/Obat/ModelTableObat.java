/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Obat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Acer
 */

public class ModelTableObat extends AbstractTableModel {
    private List<ModelObat> listObat;
    private final String[] columnNames = {"id", "Nama", "Kategori", "Stok", "Harga"};

    public ModelTableObat(List<ModelObat> listObat) {
        this.listObat = listObat;
    }

    @Override
    public int getRowCount() {
        return listObat.size();
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
        ModelObat obat = listObat.get(rowIndex);
        switch (columnIndex) {
            case 0: return obat.getId();
            case 1: return obat.getNama();
            case 2: return obat.getKategori();
            case 3: return obat.getStok();
            case 4: return obat.getHarga();
            default: return null;
        }
    }
}