package com.mycompany.quizaoo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jpd00
 */
public class Jogador {
    
  private int indJogador;
  private int vida;
  boolean ativo;
  private String respostaTurno;
  private String nomePersonagem;

  public Jogador(int indJogador) {
    this.indJogador = indJogador;
    this.vida = 100;
    this.ativo = true;
  }

  public int getIndJogador() {
    return indJogador;
  }

  public int getVida() {
    return vida;
  }

  public void setVida(int vida) {
    this.vida = vida;
  }
  
  public void setNomePersonagem(String nomePersonagem) {
    this.nomePersonagem = nomePersonagem;
  }
    public String getNomePersonagem() {
    return nomePersonagem;
  }
  
  public String getRespostaTurno() {
    return respostaTurno;
  }

  public void setRespostaTurno(String respostaTurno) {
    this.respostaTurno = respostaTurno;
  }
    
  public boolean getAtivo() {
    return ativo;
  }
  
  public void setAtivo(boolean ativo) {
    this.ativo = ativo;
  }
  
}
