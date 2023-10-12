package Controlador;

import Modelo.ConsultasCliente;
import Modelo.Cliente;
import Vista.frmCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author GUSTAVO
 */
public class CtrlCliente implements ActionListener {

    private final Cliente modelo;
    private final ConsultasCliente consultas;
    private final frmCliente vista;

    public CtrlCliente(Cliente modelo, ConsultasCliente consultas, frmCliente vista) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
    }

    public void iniciar() {
        vista.setTitle("Clientes");
        vista.setLocationRelativeTo(null);
        vista.txtId.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnGuardar) {
            modelo.setDocumento(vista.txtDocumento.getText());
            modelo.setNombres(vista.txtNombres.getText());
            modelo.setApellidos(vista.txtApellidos.getText());
            modelo.setTelefono(Integer.parseInt(vista.txtTelefono.getText()));
            modelo.setCorreo(vista.txtCorreo.getText());
           
            if (consultas.registrar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }

        if (e.getSource() == vista.btnModificar) {
           // modelo.setId(Integer.parseInt(vista.txtId.getText()));
            modelo.setDocumento(vista.txtDocumento.getText());
            modelo.setNombres(vista.txtNombres.getText());
            modelo.setApellidos(vista.txtApellidos.getText());
            modelo.setTelefono(Integer.parseInt(vista.txtTelefono.getText()));
            modelo.setCorreo(vista.txtCorreo.getText());

            if (consultas.modificar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }

        if (e.getSource() == vista.btnEliminar) {
           // modelo.setId(Integer.parseInt(vista.txtId.getText()));

            if (consultas.eliminar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }

        if (e.getSource() == vista.btnBuscar) {
            modelo.setDocumento(vista.txtDocumento.getText());

            if (consultas.buscar(modelo)) {
                vista.txtId.setText(String.valueOf(modelo.getId()));
                vista.txtDocumento.setText(modelo.getDocumento());
                vista.txtNombres.setText(modelo.getNombres());
                vista.txtApellidos.setText(modelo.getApellidos());
                vista.txtTelefono.setText(String.valueOf(modelo.getTelefono()));
                vista.txtCorreo.setText(modelo.getApellidos());

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }

        if (e.getSource() == vista.btnLimpiar) {
            limpiar();
        }
    }

    public void limpiar() {
        //vista.txtId.setText(null);
        vista.txtDocumento.setText(null);
        vista.txtNombres.setText(null);
        vista.txtApellidos.setText(null);
        vista.txtTelefono.setText(null);
        vista.txtCorreo.setText(null);
    }
}
