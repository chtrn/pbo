package Model.Pasien;

import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            
            // Perbaikan: Cek jika null, agar tidak NullPointerException
            if (pasien.getTgl_Lahir() != null) {
                ps.setDate(2, pasien.getTgl_Lahir());
            } else {
                ps.setNull(2, java.sql.Types.DATE);
            }
            
            ps.setString(3, pasien.getGol_Darah());
            ps.setString(4, pasien.getRiwayat());
            ps.setString(5, pasien.getTelepon());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal tambah pasien: " + e.getMessage(), e);
        }
    }

    @Override
    public void update(ModelPasien pasien) {
        String sql = "UPDATE pasien SET Nama=?, Tgl_Lahir=?, Gol_Darah=?, Riwayat=?, Telepon=? WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pasien.getNama());
            
            // Perbaikan Utama: Cek null secara langsung tanpa memanggil .getTime()
            if (pasien.getTgl_Lahir() != null) {
                ps.setDate(2, pasien.getTgl_Lahir());
            } else {
                ps.setNull(2, java.sql.Types.DATE);
            }
            
            ps.setString(3, pasien.getGol_Darah());
            ps.setString(4, pasien.getRiwayat());
            ps.setString(5, pasien.getTelepon());
            ps.setInt(6, pasien.getId()); 
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal update pasien: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM pasien WHERE id=?";
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
        String sql = "SELECT id, Nama, Tgl_Lahir, Gol_Darah, Riwayat, Telepon FROM pasien ORDER BY id";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ModelPasien(
                    rs.getInt("id"), 
                    rs.getString("Nama"), 
                    rs.getDate("Tgl_Lahir"), 
                    rs.getString("Gol_Darah"), 
                    rs.getString("Riwayat"), 
                    rs.getString("Telepon")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Gagal ambil data pasien: " + e.getMessage(), e);
        }
        return list;
    }
}