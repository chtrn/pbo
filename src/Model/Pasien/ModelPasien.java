/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Pasien;

import java.sql.Date;

/**
 *
 * @author Acer
 */
public class ModelPasien {

    public ModelPasien(){
    
    }
    public ModelPasien(
        Integer id,
        String nama,
        Date tgl_lahir,
        String gol_darah,
        String riwayat,
        String telepon){

    this.id=id;
    this.nama=nama;
    this.tgl_lahir=tgl_lahir;
    this.gol_darah=gol_darah;
    this.riwayat=riwayat;
    this.telepon=telepon;
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

    public Date getTgl_Lahir() {
        return tgl_lahir;
    }

    public void setTgl_Lahir(Date tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getGol_Darah() {
        return gol_darah;
    }

    public void setGol_Darah(String gol_Darah) {
        this.gol_darah = gol_Darah;
    }

    public String getRiwayat() {
        return riwayat;
    }

    public void setRiwayat(String riwayat) {
        this.riwayat = riwayat;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
    private Integer id;
    private String nama, gol_darah, riwayat, telepon;
    private Date tgl_lahir;
}
