/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Dokter;

/**
 *
 * @author Acer
 */
public class ModelDokter {

    public ModelDokter() {
    
    }
    public ModelDokter(
            Integer id,
            String nama,
            String spesialisasi,
            String telepon){

        this.id = id;
        this.nama = nama;
        this.spesialisasi = spesialisasi;
        this.telepon = telepon;
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

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }
    private Integer id;
    private String nama, telepon, spesialisasi;
}
