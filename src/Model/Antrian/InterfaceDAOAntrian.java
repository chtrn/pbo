/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Antrian;

/**
 *
 * @author Acer
 */
import java.util.List;

public interface InterfaceDAOAntrian {
    public void   insert(ModelAntrian antrian);
    public void   update(ModelAntrian antrian);
    public void   updateStatus(int id, String status); // update status saja
    public void   delete(int id);
    public List<ModelAntrian> getAll();
}

