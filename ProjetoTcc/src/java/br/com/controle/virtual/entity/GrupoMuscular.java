package br.com.controle.virtual.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "grupomuscular")
public class GrupoMuscular implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;

    public GrupoMuscular() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}