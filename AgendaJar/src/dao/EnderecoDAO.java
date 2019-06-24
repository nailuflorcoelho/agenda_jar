/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Endereco;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Aluno
 */
public class EnderecoDAO {

    public EntityManager em;

    public EnderecoDAO() {
        // Construtor Default sem parâmetros
    }

    public Endereco gravar(Endereco endereco) throws DataAccessException {
        return em.merge(endereco);
    }

    public void excluir(Endereco endereco) throws DataAccessException {
        em.remove(carregar(endereco.getIdEndereco()));
    }

    public Endereco carregar(Integer id) throws DataAccessException {
        return em.find(Endereco.class, id);
    }

    public List obterTodos(Integer idContato) throws DataAccessException {
        Query qry = em.createQuery("SELECT e FROM Endereco e WHERE e.idContato.ideContaot =: idContato");
        qry.setParameter("idContato", idContato);
        return qry.getResultList();
    }

    public List obterPorEndereco(Integer idContato, String endereco) {
        Query qry = em.createQuery("SELECT e FROM Endereco e WHERE e.idContato.ideContaot =: idContato"
                + " AND e.endereco LIKE :endereco");
        qry.setParameter("idContato", idContato);
        qry.setParameter("endereco", endereco);

        return qry.getResultList();
    }

    public List obterPorCidade(Integer idContato, String cidade) {
        Query qry = em.createQuery("SELECT e FROM Endereco e WHERE e.idContato.ideContaot =: idContato");
        qry.setParameter("idContato", idContato);
        qry.setParameter("cidade", cidade);
        
        return qry.getResultList();
    }

    public List obterPorBairro(Integer idContato, String bairro) {
        Query qry = em.createQuery("SELECT e FROM Endereco e WHERE e.idContato.idContato =: idContato"
                + " AND e.bairro LIKE :bairro");
        qry.setParameter("idContato", idContato);
        qry.setParameter("bairro", bairro);
        
        return qry.getResultList();
    }
    
    public List obterPorTipoContato(Integer idContato, String contato) {
        // TODO
        return null;
    }

}
