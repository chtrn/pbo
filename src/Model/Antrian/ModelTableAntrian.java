/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Antrian;
import javax.swing.table.DefaultTableModel;
import java.util.List;
/**
 *
 * @author Acer
 */

public class ModelTableAntrian extends DefaultTableModel {

    private static final String[] KOLOM = {
        "ID", "Pasien", "Dokter", "Obat", "Tanggal", "Keluhan", "Status"
    };

    public ModelTableAntrian() {
        super(KOLOM, 0);
    }

    // Isi tabel dari list ModelAntrian + nama pasien/dokter/obat
    public void setData(List<ModelAntrian> list,
                        java.util.Map<Integer, String> mapPasien,
                        java.util.Map<Integer, String> mapDokter,
                        java.util.Map<Integer, String> mapObat) {
        setRowCount(0);
        for (ModelAntrian a : list) {
            addRow(new Object[]{
                a.getId(),
                mapPasien.getOrDefault(a.getIdPasien(), "ID:" + a.getIdPasien()),
                mapDokter.getOrDefault(a.getIdDokter(), "ID:" + a.getIdDokter()),
                mapObat.getOrDefault(a.getIdObat(),     "ID:" + a.getIdObat()),
                a.getTanggal(),
                a.getKeluhan(),
                a.getStatus()
            });
        }
    }

    // Kolom Status (index 6) bisa diedit langsung, sisanya tidak
    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // edit status pakai combobox terpisah, bukan inline
    }
}

