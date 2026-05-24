/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Dokter;

import java.util.List;

/**
 *
 * @author Acer
 */
public interface InterfaceDAODokter {
    public void insert(ModelDokter dokter);
    public void update(ModelDokter dokter);
    public void delete(int id);
    public List<ModelDokter> getAll();
}
