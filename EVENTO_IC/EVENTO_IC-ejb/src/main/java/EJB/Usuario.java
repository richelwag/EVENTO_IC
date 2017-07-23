/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.Date;
   
  import javax.persistence.Column;
  import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
  import javax.persistence.Id;
  import javax.persistence.Temporal;
  import javax.persistence.TemporalType;
   
  @Entity
  public class Usuario {
        private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        
        @Column(name="userName")
        private String nomeUsuario;
        
        @Column(name="password")
        private String senha;
   
        @Column(name="lastAccess")
        @Temporal(TemporalType.DATE)
        private Date ultimoAcesso;
        
        public String getNomeUsuario() {
              return nomeUsuario;
        }
        
        public void setNomeUsuario(String nomeUsuario) {
              this.nomeUsuario = nomeUsuario;
        }
        
        public String getSenha() {
              return senha;
        }
        
        public void setSenha(String senha) {
              this.senha = senha;
        }
        
        public Date getUltimoAcesso() {
              return ultimoAcesso;
        }
        
        public void setUltimoAcesso(Date ultimoAcesso) {
              this.ultimoAcesso = ultimoAcesso;
        }
   }