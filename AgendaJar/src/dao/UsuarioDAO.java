/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dominio.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Aluno
 */
public class UsuarioDAO {

    public EntityManager em;

    public UsuarioDAO() {
        // Construtor Default sem parâmetros
    }

    public Usuario gravar(Usuario usuario) throws DataAccessException {
        return em.merge(usuario);
    }

    public void excluir(Usuario usuario) throws DataAccessException {
        em.remove(carregar(usuario.getIdUsuario()));
    }

    public Usuario carregar(Integer id) throws DataAccessException {
        return em.find(Usuario.class, id);
    }

    public List obterTodos() throws DataAccessException {
        return em.createQuery("SELECT u FROM USUARIO u").getResultList();
    }

    public List obterPorNome(String nome) throws DataAccessException {
        Query qry = em.createQuery("SELECT u FROM USUARIO u WHERE u.nome LIKE:nome");
        qry.setParameter("nome", "%" + nome + "%");
        return qry.getResultList();
    }

    public List obterPorlogin(String login) throws DataAccessException {
        Query qry = em.createQuery("SELECT u FROM USUARIO u WHERE u.login LIKE:login");
        qry.setParameter("login", "%" + login + "%");
        return qry.getResultList();
    }

    public Usuario obterPorloginSenha(String login, String senha) throws DataAccessException {
        Query qry = em.createQuery("SELECT u FROM USUARIO u WHERE"
                + " u.login =:login"
                + " AND"
                + " u.senha =:senha");
        qry.setParameter("login", login);
        qry.setParameter("senha", senha);

        List resultados = qry.getResultList();
        if (resultados.size() > 0) {
            return (Usuario) resultados.get(0);
        } else {
            return null;
        }
    }
}
