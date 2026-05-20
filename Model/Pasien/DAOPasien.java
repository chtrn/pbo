/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Pasien;

import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

/**
 *
 * @author Acer
 */
public class DAOPasien implements InterfaceDAOPasien {
    private Connection conn;
    public DAOPasien() {
        this.conn = Connector.Connect();
    }
    @Override
    public void insert(ModelPasien pasien) {
        String sql = "INSERT INTO pasien (Nama, Tgl_Lahir, Gol_Darah, Riwayat, Telepon) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pasien.getNama());
            ps.setDate(2, pasien.getTgl_Lahir());
            ps.setString(3, pasien.getGol_Darah());
            ps.setString(4, pasien.getRiwayat());
            ps.setString(5, pasien.getTelepon());
            ps.setInt(6, pasien.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal tambah pasien: " + e.getMessage(), e);
        }
    }

    @Override
    public void update(ModelPasien pasien) {
        String sql = "UPDATE pasien SET Nama=?, Tgl_Lahir=?, Gol_Darah=?, Riwayat=?, Telepon=? WHERE ID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pasien.getNama());
            ps.setDate(2, pasien.getTgl_Lahir());
            ps.setString(3, pasien.getGol_Darah());
            ps.setString(4, pasien.getRiwayat());
            ps.setString(5, pasien.getTelepon());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal update pasien: " + e.getMessage(), e);
        }
    }
    @Override
    
    public void delete(int id) {
        String sql = "DELETE FROM pasien WHERE ID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal hapus pasien: " + e.getMessage(), e);
        }
    }

    @Override
    public List<ModelPasien> getAll() {
        List<ModelPasien> list = new ArrayList<>();
        String sql = "SELECT ID, Nama, Tgl_Lahir, Gol_Darah, Riwayat, Telepon FROM pasien ORDER BY ID";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                list.add(new ModelPasien(rs.getInt("ID"), rs.getString("Nama"), rs.getDate("Tgl_Lahir"), rs.getString("Gol_Darah"), rs.getString("Riwayat"), rs.getString("Telepon")));
        } catch (SQLException e) {
            throw new RuntimeException("Gagal ambil data pasien: " + e.getMessage(), e);
        }
        return list;
    }
    
}
