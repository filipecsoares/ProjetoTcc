/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle.virtual.enumerador;

public enum TipoUsuario {

    USUARIO(1, "Usuário"), ADMINISTRADOR(2, "Administrador");

    private final int valor;
    private final String descricao;

    TipoUsuario(int valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public int getValor() {
        return this.valor;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
