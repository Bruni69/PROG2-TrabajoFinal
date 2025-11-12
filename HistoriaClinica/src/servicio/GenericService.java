/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import java.util.List;

/**
 *
 * @author Maxi
 */
public interface GenericService<T> {
    void insertar(T t);
    void actualizar(T t);
    void eliminar(Long id);
    void recuperar(Long id);
    T getById(Long id);
    List<T> getAll();

}
