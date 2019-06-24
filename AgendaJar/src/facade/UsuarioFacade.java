/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.UsuarioDAO;
import dominio.Usuario;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class UsuarioFacade {
    private UsuarioDAO usuarioDAO;
    
    public UsuarioFacade() {}
    
    public Usuario carregar(Integer id) {
        return usuarioDAO.carregar(id);
    }
    
    public Usuario gravar(Usuario u) {
        return usuarioDAO.gravar(u);
    }
    
    public void excluir(Usuario u) {
        usuarioDAO.excluir(u);
    }
    
    public List obterTodos() {
        return usuarioDAO.obterTodos();
    }
    
    public List obterPorNome(String n) {
        return usuarioDAO.obterPorNome(n);
    }
    
    public List obterPorLogin(String login) {
        return usuarioDAO.obterPorlogin(login);
    }
    
    public Usuario obterPorLoginSenha(String l, String s) {
        return usuarioDAO.obterPorloginSenha(l, s);
    }
    
}
