/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Obat;

import java.util.List;

/**
 *
 * @author Acer
 */
public interface InterfaceDAOObat {
    public void insert(ModelObat obat);
    public void update(ModelObat obat);
    public void delete(int id);
    public List<ModelObat> getAll();
}
