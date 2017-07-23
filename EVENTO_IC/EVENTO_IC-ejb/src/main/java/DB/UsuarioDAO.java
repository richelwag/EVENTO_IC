/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

/**
 *
 * @author perigo
 */

import EJB.Usuario;
import javax.persistence.EntityManager;
  import javax.persistence.EntityManagerFactory;
  import javax.persistence.NoResultException;
  import javax.persistence.Persistence;
   
 
   
  public class UsuarioDAO {
   
        private EntityManagerFactory factory = Persistence
                    .createEntityManagerFactory("ADA_LOVELACE_EVENTO_IC");
        private EntityManager em = factory.createEntityManager();
   
        public Usuario getUsuario(String nomeUsuario, String senha) {
   
              try {
                    Usuario usuario = (Usuario) em
                               .createQuery(
                                           "SELECT u FROM Usuario u WHERE u.nomeUsuario = :name and u.senha = :senha")
                               .setParameter("name", nomeUsuario)
                               .setParameter("senha", senha).getSingleResult();
   
                    return usuario;
              } catch (NoResultException e) {
                    return null;
              }
        }
   
      public boolean inserirUsuario(Usuario usuario) {
              try {
                    em.persist(usuario);
                    return true;
              } catch (Exception e) {
                    e.printStackTrace();
                    return false;
              }
        }
        
        public boolean deletarUsuario(Usuario usuario) {
              try {
                    em.remove(usuario);
                    return true;
              } catch (Exception e) {
                    e.printStackTrace();
                    return false;
              }
        }
   
  }
