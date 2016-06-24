package ToDo.dao;

import javax.persistence.*;
import ToDo.entity.*;
import java.util.*;
import java.io.Serializable;

/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * @generated
 */
public class ItemDAO extends BasicDAO<String, Item> implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = 2291501l;

  /**
   * Guarda uma cópia da EntityManager na instância
   * 
   * @param entitymanager
   *          Tabela do banco
   * @generated
   */
  public ItemDAO(EntityManager entitymanager) {
    super(entitymanager);
  }



  /**
   * Remove a instância de Item utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */  
  public int deleteById(java.lang.String id){
      Query query = this.entityManager.createQuery("DELETE FROM Item entity WHERE entity.id = :id");
      query.setParameter("id", id);
           
      return query.executeUpdate();	
  }
  
  /**
   * Obtém a instância de Item utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */  
  public Item findById(java.lang.String id){
      TypedQuery<Item> query = this.entityManager.createQuery("SELECT entity FROM Item entity WHERE entity.id = :id", Item.class);
      query.setParameter("id", id);
           
      return query.getSingleResult();	
  }



  /**
   * NamedQuery list
   * @generated
   */
  public List<Item> list(int limit, int offset){
      return this.entityManager.createNamedQuery("itemList", Item.class).setFirstResult(offset).setMaxResults(limit).getResultList();		
  }
  
}