/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Contato;
import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Aluno
 */
public class ContatoDAO {

    public EntityManager em;

    public ContatoDAO() {
        // Construtor Default sem parâmetros
    }

    public Contato gravar(Contato contato) throws DataAccessException {
        return em.merge(contato);
    }

    public void excluir(Contato contato) throws DataAccessException {
        em.remove(carregar(contato.getIdContato()));
    }

    public Contato carregar(Integer id) throws DataAccessException {
        return em.find(Contato.class, id);
    }

    public List obterTodos() throws DataAccessException {
        return em.createQuery("SELECT c FROM CONTATO u").getResultList();
    }

    public List obterPorNome(Integer idUsuario, String nome) throws DataAccessException {
        Query qry = em.createQuery("SELECT c FROM CONTATO c WHERE u.nome LIKE:nome");
        
        qry.setParameter("idUsuario", idUsuario);
        qry.setParameter("nome", "%" + nome + "%");
        return qry.getResultList();
    }
    
    public List obterPorEmpresa(Integer idUsuario, String empresa) throws DataAccessException {
        Query qry = em.createQuery("SELECT c FROM CONTATO c WHERE u.empresa LIKE:empresa");
        
        qry.setParameter("idUsuario", idUsuario);
        qry.setParameter("empresa", "%" + empresa + "%");
        return qry.getResultList();
    }
    
    public List obterPorCargo(Integer idUsuario, String cargo) throws DataAccessException {
        Query qry = em.createQuery("SELECT c FROM CONTATO c WHERE u.cargo LIKE:cargo");
        
        qry.setParameter("idUsuario", idUsuario);
        qry.setParameter("cargo", "%" + cargo + "%");
        return qry.getResultList();
    }
    
    public List obterPorAniversario(Integer idUsuario, Date aniversario) throws DataAccessException {
        Query qry = em.createQuery("SELECT c"
                + " FROM CONTATO c"
                + " WHERE c.idUsuario.idUsuario =:"
                + " idUsuario AND c.dataAniversario =:aniversario");
        
        qry.setParameter("idUsuario", idUsuario);
        qry.setParameter("aniversario", aniversario);
        return qry.getResultList();    }

}
