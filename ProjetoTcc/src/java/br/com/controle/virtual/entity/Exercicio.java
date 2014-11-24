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
    
    @Override
    public String toString() {
        return this.nome;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Exercicio exercicio = (Exercicio) o;
        if (id == null) {
            if (exercicio.id != null) {
                return false;
            }
        } else if (!id.equals(exercicio.id)) {
            return false;
        }
        return true;
    }
}
