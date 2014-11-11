/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle.virtual.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author filipe_soares
 */
@Entity
@Table(name = "ficha")
public class Ficha implements Serializable {

    @Id
    @GeneratedValue
    @Column
    private Integer id;
    @Column
    private String objetivo;
    @Column(name = "dt_cadastro")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtCadastro;
    @Column(name = "dt_mudanca_prevista")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dtMudancaPrevista;
    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "fk_administrador")
    private Usuario administrador;

    public Ficha() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Date getDtMudancaPrevista() {
        return dtMudancaPrevista;
    }

    public void setDtMudancaPrevista(Date dtMudancaPrevista) {
        this.dtMudancaPrevista = dtMudancaPrevista;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Usuario administrador) {
        this.administrador = administrador;
    }
}
