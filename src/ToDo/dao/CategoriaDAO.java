package ToDo.dao;

import javax.persistence.*;
import ToDo.entity.*;
import java.util.*;
import java.io.Serializable;

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * @generated
 */
public class CategoriaDAO extends BasicDAO<String, Categoria> implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = -725153524l;

  /**
   * Guarda uma cópia da EntityManager na instância
   * 
   * @param entitymanager
   *          Tabela do banco
   * @generated
   */
  public CategoriaDAO(EntityManager entitymanager) {
    super(entitymanager);
  }



  /**
   * Remove a instância de Categoria utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */  
  public int deleteById(java.lang.String id){
      Query query = this.entityManager.createQuery("DELETE FROM Categoria entity WHERE entity.id = :id");
      query.setParameter("id", id);
           
      return query.executeUpdate();	
  }
  
  /**
   * Obtém a instância de Categoria utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */  
  public Categoria findById(java.lang.String id){
      TypedQuery<Categoria> query = this.entityManager.createQuery("SELECT entity FROM Categoria entity WHERE entity.id = :id", Categoria.class);
      query.setParameter("id", id);
           
      return query.getSingleResult();	
  }

  /**
   * OneToMany Relation
   * @generated
   */
  public List<Item> findItem(java.lang.String id, int limit, int offset) {
      TypedQuery<Item> query = this.entityManager.createQuery("SELECT entity FROM Item entity WHERE entity.categoria.id = :id", Item.class);
      query.setParameter("id", id);

      return query.setFirstResult(offset).setMaxResults(limit).getResultList();	  
  }


  /**
   * NamedQuery list
   * @generated
   */
  public List<Categoria> list(int limit, int offset){
      return this.entityManager.createNamedQuery("categoriaList", Categoria.class).setFirstResult(offset).setMaxResults(limit).getResultList();		
  }
  
}