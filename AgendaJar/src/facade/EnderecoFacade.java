/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.EnderecoDAO;
import dominio.Endereco;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class EnderecoFacade {
    private EnderecoDAO enderecoDAO;
    
    public EnderecoFacade() {}
    
    public Endereco carregar(Integer id) {
        return enderecoDAO.carregar(id);
    }
    
    public Endereco gravar(Endereco u) {
        return enderecoDAO.gravar(u);
    }
    
    public void excluir(Endereco u) {
        enderecoDAO.excluir(u);
    }
    
    public List obterTodos() {
        return enderecoDAO.obterTodos();
    }
    
}
