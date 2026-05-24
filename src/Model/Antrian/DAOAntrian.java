/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Antrian;
import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Acer
 */


public class DAOAntrian implements InterfaceDAOAntrian {

    private Connection conn;

    public DAOAntrian() {
        this.conn = Connector.Connect();
    }

    @Override
    public List<ModelAntrian> getAll() {
        List<ModelAntrian> list = new ArrayList<>();
        String sql = "SELECT ID, ID_Pasien, ID_Dokter, ID_Obat, Tanggal, Keluhan, Status " +
                     "FROM antrian ORDER BY ID";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                list.add(new ModelAntrian(
                    rs.getInt   ("ID"),
                    rs.getInt   ("ID_Pasien"),
                    rs.getInt   ("ID_Dokter"),
                    rs.getInt   ("ID_Obat"),
                    rs.getDate  ("Tanggal"),
                    rs.getString("Keluhan"),
                    rs.getString("Status")
                ));
        } catch (SQLException e) {
            throw new RuntimeException("Gagal ambil data antrian: " + e.getMessage(), e);
        }
        return list;
    }

    @Override
    public void insert(ModelAntrian a) {
        String sql = "INSERT INTO antrian (ID_Pasien, ID_Dokter, ID_Obat, Tanggal, Keluhan, Status) " +
                     "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt   (1, a.getIdPasien());
            ps.setInt   (2, a.getIdDokter());
            ps.setInt   (3, a.getIdObat());
            ps.setDate  (4, a.getTanggal());
            ps.setString(5, a.getKeluhan());
            ps.setString(6, a.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal tambah antrian: " + e.getMessage(), e);
        }
    }

    @Override
    public void update(ModelAntrian a) {
        String sql = "UPDATE antrian SET ID_Pasien=?, ID_Dokter=?, ID_Obat=?, " +
                     "Tanggal=?, Keluhan=?, Status=? WHERE ID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt   (1, a.getIdPasien());
            ps.setInt   (2, a.getIdDokter());
            ps.setInt   (3, a.getIdObat());
            ps.setDate  (4, a.getTanggal());
            ps.setString(5, a.getKeluhan());
            ps.setString(6, a.getStatus());
            ps.setInt   (7, a.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal update antrian: " + e.getMessage(), e);
        }
    }

    @Override
    public void updateStatus(int id, String status) {
        // update status saja tanpa ubah data lain
        String sql = "UPDATE antrian SET Status=? WHERE ID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt   (2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal update status antrian: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM antrian WHERE ID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal hapus antrian: " + e.getMessage(), e);
        }
    }
}
