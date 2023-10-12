package crudmvc;

import Controlador.CtrlCliente;
import Modelo.ConsultasCliente;
import Modelo.Cliente;
import Vista.frmCliente;



/**
 *
 * @author GUSTAVO
 */
public class CRUDMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Cliente mod = new Cliente();
        ConsultasCliente modC = new ConsultasCliente();
        frmCliente frm = new frmCliente();
        
        CtrlCliente ctrl = new CtrlCliente(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
        
        
    }
}
