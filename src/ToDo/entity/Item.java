package ToDo.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;

/**
 * Classe que representa a tabela ITEM
 * @generated
 */
@Entity
@Table(name = "\"ITEM\"")
@NamedQueries({
        @NamedQuery(name = "itemList", query = "select i from Item i")
})
@XmlRootElement
public class Item implements Serializable {

	/**
	 * UID da classe, necessário na serialização 
	 * @generated
	 */
	private static final long serialVersionUID = 2291501l;
	
	/**
	 * @generated
	 */
	@Id
    
	@Column(name = "id")
	private java.lang.String id = UUID.randomUUID().toString().toUpperCase();
	
	/**
	 * @generated
	 */
	@Column(name = "descricao", nullable = false, unique = false)
	private java.lang.String descricao;
	
	/**
	 * @generated
	 */
	@ManyToOne
	@JoinColumn(name="fk_categoria", referencedColumnName = "id")
	private Categoria categoria;
	
	
	/**
	 * Construtor
	 * @generated
	 */
	public Item(){
	}

	
	/**
	 * Obtém id
	 * @param id id
	 * return id
	 * @generated
	 */
	public java.lang.String getId(){
		return this.id;
	}
	
	/**
	 * Define id
	 * @param id id
	 * @generated
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	
	/**
	 * Obtém descricao
	 * @param descricao descricao
	 * return descricao
	 * @generated
	 */
	public java.lang.String getDescricao(){
		return this.descricao;
	}
	
	/**
	 * Define descricao
	 * @param descricao descricao
	 * @generated
	 */
	public void setDescricao(java.lang.String descricao){
		this.descricao = descricao;
	}
	
	/**
	 * Obtém categoria
	 * @param categoria categoria
	 * return categoria
	 * @generated
	 */
	public Categoria getCategoria(){
		return this.categoria;
	}
	
	/**
	 * Define categoria
	 * @param categoria categoria
	 * @generated
	 */
	public void setCategoria(Categoria categoria){
		this.categoria = categoria;
	}
	
	/**
	 * @generated
	 */
	@Override
	public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((id == null) ? 0 : id.hashCode());

        return result;
    }
	
	/**
	 * @generated
	 */	
	@Override
  	public boolean equals(Object obj) {
    
	    if(this == obj)
	      return true;
	    
	    if(obj == null)
	      return false;
	    
	    if(!(obj instanceof Item))
	      return false;
	    
	    Item other = (Item)obj;
	    
		if(this.id == null && other.id != null)
	    	return false;
	    else if(!this.id.equals(other.id))
	     	return false;
	

	    return true;
	    
	}
}