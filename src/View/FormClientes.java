package View;

import Controller.Clientes;
import Model.ClientesDAO;
import java.util.List;

public class FormClientes {

    public static void main(String[] args) {
        Clientes cli = new Clientes();

        cli.setNome("Emerson Luis");

        ClientesDAO cliDao = new ClientesDAO();
       //  cliDao.Salvar(cli);    //salvar
        // cliDao.Deletar(cli);   // deletar

        //buscar
        //  List<Clientes> lista = cliDao.Buscar(cli);
        //   for(int x=0; x < lista.size(); x++){
        //      System.out.println("Nome: "+lista.get(x).getNome());
        //  }
        
        //atualizar
      //  cliDao.Update(cli);
    }

}
