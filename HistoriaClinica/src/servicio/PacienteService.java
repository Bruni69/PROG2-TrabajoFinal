/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servicio;

import modelo.Paciente;

/**
 *
 * @author Maxi
 */
public interface PacienteService extends GenericService<Paciente>{
    Paciente buscarPorDni(String dni);
    void insertarConHistoria(Paciente paciente);
}
