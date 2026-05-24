/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Obat;

/**
 *
 * @author Acer
 */
public class ModelObat {
    private Integer id;
    private String nama, kategori;
    private int stok;
    private double harga;
    
    public ModelObat(){

    }

    public ModelObat(
            Integer id,
            String nama,
            String kategori,
            int stok,
            double harga){

        this.id = id;
        this.nama = nama;
        this.kategori = kategori;
        this.stok = stok;
        this.harga = harga;

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
   
}
