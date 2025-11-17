package servicio;

import config.DatabaseConnection;
import dao.PacienteDao;
import dao.HistoriaClinicaDao;
import modelo.Paciente;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PacienteService {
    private final PacienteDao pacienteDao = new PacienteDao();
    private final HistoriaClinicaDao historiaDao = new HistoriaClinicaDao();

    /**
     * Inserta un paciente junto con su historia clínica en una única transacción.
     */
    public void insertarConHistoria(Paciente paciente) {
        Connection conn = null;
        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false);

            // Primero insertar historia clínica
            historiaDao.insertar(paciente.getHistoriaClinica(), conn);

            // Luego insertar paciente asociado
            pacienteDao.insertar(paciente, conn);

            conn.commit();
            System.out.println("Paciente y su historia clínica insertados correctamente.");
        } catch (Exception e) {
            System.out.println("Error en la transacción: " + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Rollback ejecutado.");
                } catch (SQLException ex) {
                    System.out.println("Error al hacer rollback: " + ex.getMessage());
                }
            }
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar conexión: " + e.getMessage());
                }
            }
        }
    }

    // Métodos delegados al DAO para responder al AppMenu

    public List<Paciente> getAll() throws Exception {
        return pacienteDao.getAll();
    }

    public Paciente getByDni(String dni) throws Exception {
        return pacienteDao.getByDni(dni);
    }

    public void actualizar(Paciente paciente) throws Exception {
        pacienteDao.actualizar(paciente);
    }

    public void eliminar(int id) throws Exception {
        pacienteDao.eliminar(id);
    }

    public void recuperar(int id) throws Exception {
        pacienteDao.recuperar(id);
    }

    public Paciente getById(int id) throws Exception {
        return pacienteDao.getById(id);
    }
    
    public Paciente getByIdEliminado(int id) throws Exception{
        return pacienteDao.getByIdEliminado(id);
    }
}