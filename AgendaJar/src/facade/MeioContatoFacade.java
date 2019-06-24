/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.MeioContatoDAO;
import dominio.MeioContato;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class MeioContatoFacade {
    private MeioContatoDAO meioContatoDAO;
    
    public MeioContatoFacade() {}
    
    public MeioContato carregar(Integer id) {
        return meioContatoDAO.carregar(id);
    }
    
    public MeioContato gravar(MeioContato u) {
        return meioContatoDAO.gravar(u);
    }
    
    public void excluir(MeioContato u) {
        meioContatoDAO.excluir(u);
    }
    
    public List obterTodos() {
        return meioContatoDAO.obterTodos();
    }
    
}
