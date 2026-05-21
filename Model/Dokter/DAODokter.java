/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dokter;
import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */

public class DAODokter implements InterfaceDAODokter {
    private Connection conn;
    public DAODokter() {
        this.conn = Connector.Connect();
    }
    @Override
    public List<ModelDokter> getAll() {
        List<ModelDokter> list = new ArrayList<>();
        String sql = "SELECT id, Nama, Spesialisasi, Telepon FROM dokter ORDER BY id";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                list.add(new ModelDokter(rs.getInt("id"), rs.getString("Nama"), rs.getString("Spesialisasi"), rs.getString("Telepon")));
        } catch (SQLException e) {
            throw new RuntimeException("Gagal ambil data dokter: " + e.getMessage(), e);
        }
        return list;
    }

    @Override
    public void insert(ModelDokter dokter) {
        String sql = "INSERT INTO dokter (Nama, Spesialisasi, Telepon) VALUES (?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dokter.getNama());
            ps.setString(2, dokter.getSpesialisasi());
            ps.setString(3, dokter.getTelepon());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal tambah dokter: " + e.getMessage(), e);
        }
    }

    @Override
    public void update(ModelDokter dokter) {
        String sql = "UPDATE dokter SET Nama=?, Spesialisasi=?, Telepon=? WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dokter.getNama());
            ps.setString(2, dokter.getSpesialisasi());
            ps.setString(3, dokter.getTelepon());
            ps.setInt(4, dokter.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal update dokter: " + e.getMessage(), e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM dokter WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal hapus dokter: " + e.getMessage(), e);
        }
    }
}
