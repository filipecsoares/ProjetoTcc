/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle.virtual.enumerador;

public enum TipoUsuario {

    USUARIO(1), ADMINISTRADOR(2);

    private final int valor;

    TipoUsuario(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }
}