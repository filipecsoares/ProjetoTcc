/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle.virtual.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author filipe_soares
 */
public class Ficha implements Serializable{

    private Integer id;
    private String objetivo;
    private Date dtCadastro;
    private Date dtMudancaPrevista;
    private Integer fkUsuario;
    private Integer fkAdministrador;
    private Usuario usuario;
    private Administrador administrador;

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

    public Integer getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Integer fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public Integer getFkAdministrador() {
        return fkAdministrador;
    }

    public void setFkAdministrador(Integer fkAdministrador) {
        this.fkAdministrador = fkAdministrador;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
}