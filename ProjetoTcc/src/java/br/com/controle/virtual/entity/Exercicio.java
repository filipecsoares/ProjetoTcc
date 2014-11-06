package br.com.controle.virtual.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exercicio")
public class Exercicio implements Serializable {

    @Id
    @GeneratedValue
    @Column
    private Integer id;
    @Column
    private String nome;

    @ManyToOne
    @JoinColumn(name = "fk_grupo")
    private GrupoMuscular grupo;

    public Exercicio() {

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

    public GrupoMuscular getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoMuscular grupo) {
        this.grupo = grupo;
    }
}
