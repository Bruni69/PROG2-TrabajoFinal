/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author Maxi
 */
public interface GenericDao<T> {
    void insertar(T entidad)throws Exception;
    void actualizar(T entidad)throws Exception;
    void eliminar(int id)throws Exception;
    void recuperar(int id)throws Exception;
    T getById(int id)throws Exception;
    List<T> getAll()throws Exception;
}
