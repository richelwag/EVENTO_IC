/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import DB.UsuarioDAO;
import EJB.Usuario;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author perigo
 */
@Named(value = "novoUsuarioMB")
@RequestScoped
public class NovoUsuarioManagedBean {

    /**
     * Creates a new instance of NovoUsuarioManagedBean
     */
    public NovoUsuarioManagedBean() {
    }
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
        
    private Usuario usuario = new Usuario();
    
    public String addUser() {
        boolean add = usuarioDAO.inserirUsuario(usuario);      
        if (!add){
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "falha ao adicionar Usuário!",
                            "Erro no Login!"));
            return "gerencia_usuarios.xhtml";
        }
        else {
            return "gerencia_usuarios.xhtml";
        }
        
        
    }
   
    public Usuario getUsuario() {
            return usuario;
      }

      public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
      }
}
