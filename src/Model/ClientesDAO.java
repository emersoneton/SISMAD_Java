package Model;

import Controller.Clientes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ClientesDAO {

    EntityManagerFactory emf; // abetura de conexão com o banco de dados
    EntityManager em;         // realizar as operações

    public ClientesDAO() {
        emf = Persistence.createEntityManagerFactory("sismed"); // abrir a sessão no banco de dados
        em = emf.createEntityManager();                        // gerenciador
    }

    public void Salvar(Clientes cli) {
        em.getTransaction().begin(); // iniciar a conexão do banco
        em.merge(cli); // Salva o Objeto no banco
        em.getTransaction().commit();
        emf.close();
    }

    public void Deletar(Clientes cli) {
        em.getTransaction().begin(); // iniciar a conexão do banco
        Query delete = em.createNativeQuery("delete from clientes where nome = '" + cli.getNome() +"'");
        delete.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }
    
    public List<Clientes> Buscar(Clientes cli) {
        em.getTransaction().begin(); // iniciar a conexão do banco
        
        Query buscar = em.createQuery("SELECT clientes from Clientes clientes Order by nome");
        List<Clientes> lista = buscar.getResultList();
        
        em.getTransaction().commit();      
        emf.close();
        
        return lista;
    }
    
    public void Update(Clientes cli){
        em.getTransaction().begin(); // iniciar a conexão do banco
        Query update = em.createNativeQuery("update clientes set nome = '" + cli.getNome() +"' where id = 4");
        update.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }
}
