package Model.Obat;

import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOObat implements InterfaceDAOObat {
    private Connection conn;

    public DAOObat() {
        this.conn = Connector.Connect();
    }

    @Override
    public List<ModelObat> getAll() {
        List<ModelObat> list = new ArrayList<>();
        String sql = "SELECT id, Nama, Kategori, Stok, Harga FROM obat ORDER BY id";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(); 
            while (rs.next()) {
                list.add(new ModelObat(
                    rs.getInt("id"), 
                    rs.getString("Nama"),
                    rs.getString("Kategori"), 
                    rs.getInt("Stok"), 
                    rs.getDouble("Harga") // Mengambil int dari DB ke double Model aman
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Gagal ambil data obat: " + e.getMessage(), e);
        }
        return list;
    }

    @Override
    public void insert(ModelObat obat) {
        String sql = "INSERT INTO obat (Nama, Kategori, Stok, Harga) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, obat.getNama());
            ps.setString(2, obat.getKategori());
            ps.setInt(3, obat.getStok());
            ps.setInt(4, (int) obat.getHarga()); // Casting double ke int sesuai DB int(11)
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal tambah obat: " + e.getMessage(), e);
        }
    }

    @Override
    public void update(ModelObat obat) {
        String sql = "UPDATE obat SET Nama=?, Kategori=?, Stok=?, Harga=? WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, obat.getNama());
            ps.setString(2, obat.getKategori());
            ps.setInt(3, obat.getStok());
            ps.setInt(4, (int) obat.getHarga()); // Casting double ke int sesuai DB int(11)
            ps.setInt(5, obat.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal update obat: " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM obat WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Gagal hapus obat: " + e.getMessage(), e);
        }
    }
}