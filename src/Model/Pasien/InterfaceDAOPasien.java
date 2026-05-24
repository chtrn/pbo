/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Pasien;

import java.util.List;

/**
 *
 * @author Acer
 */
public interface InterfaceDAOPasien {
    public void insert(ModelPasien pasien);
    public void update(ModelPasien pasien);
    public void delete(int id);
    public List<ModelPasien> getAll();
}
