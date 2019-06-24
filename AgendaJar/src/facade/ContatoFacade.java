/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.ContatoDAO;
import dominio.Contato;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class ContatoFacade {
    private ContatoDAO contatoDAO;
    
    public ContatoFacade() {}
    
    public Contato carregar(Integer id) {
        return contatoDAO.carregar(id);
    }
    
    public Contato gravar(Contato c) {
        return contatoDAO.gravar(c);
    }
    
    public void excluir(Contato c) {
        contatoDAO.excluir(c);
    }
    
    public List obterTodos() {
        return contatoDAO.obterTodos();
    }
    
    public List obterPorAniversario(Integer id, Date aniversario) {
        return contatoDAO.obterPorAniversario(id, aniversario);
    }
    
    public List obterPorEmpresa(Integer id, String empresa) {
        return contatoDAO.obterPorEmpresa(id, empresa);
    }
    
    public List obterPorCargo(Integer id, String cargo) {
        return contatoDAO.obterPorCargo(id, cargo);
    }
}
