/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Antrian;
import java.sql.Date;
/**
 *
 * @author Acer
 */

public class ModelAntrian {

    private Integer id;
    private Integer idPasien;
    private Integer idDokter;
    private Integer idObat;
    private Date    tanggal;
    private String  keluhan;
    private String  status;

    public ModelAntrian() {}

    // Constructor dari database (ada ID)
    public ModelAntrian(Integer id, Integer idPasien, Integer idDokter,
                        Integer idObat, Date tanggal, String keluhan, String status) {
        this.id       = id;
        this.idPasien = idPasien;
        this.idDokter = idDokter;
        this.idObat   = idObat;
        this.tanggal  = tanggal;
        this.keluhan  = keluhan;
        this.status   = status;
    }

    // Constructor untuk INSERT baru (tanpa ID)
    public ModelAntrian(Integer idPasien, Integer idDokter,
                        Integer idObat, Date tanggal, String keluhan, String status) {
        this.idPasien = idPasien;
        this.idDokter = idDokter;
        this.idObat   = idObat;
        this.tanggal  = tanggal;
        this.keluhan  = keluhan;
        this.status   = status;
    }

    public Integer getId()                  { return id; }
    public void    setId(Integer id)        { this.id = id; }
    public Integer getIdPasien()            { return idPasien; }
    public void    setIdPasien(Integer v)   { this.idPasien = v; }
    public Integer getIdDokter()            { return idDokter; }
    public void    setIdDokter(Integer v)   { this.idDokter = v; }
    public Integer getIdObat()              { return idObat; }
    public void    setIdObat(Integer v)     { this.idObat = v; }
    public Date    getTanggal()             { return tanggal; }
    public void    setTanggal(Date v)       { this.tanggal = v; }
    public String  getKeluhan()             { return keluhan; }
    public void    setKeluhan(String v)     { this.keluhan = v; }
    public String  getStatus()              { return status; }
    public void    setStatus(String v)      { this.status = v; }
}

