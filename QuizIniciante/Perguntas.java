/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizaoo;

/**
 *
 * @author jpd00
 */
public class Perguntas {
  
  public int idPergunta;
  public String txtPergunta;
  private String resposta;

  public Perguntas(int idPergunta, String txtPergunta, String resposta) {
    this.idPergunta = idPergunta;
    this.txtPergunta = txtPergunta;
    this.resposta = resposta;
  }
  
    public Perguntas(int idPergunta) {
    this.idPergunta = idPergunta;
  }

  public int getIdPergunta() {
    return idPergunta;
  }

  public void setIdPergunta(int idPergunta) {
    this.idPergunta = idPergunta;
  }

  public String getTxtPergunta() {
    return txtPergunta;
  }

  public void setTxtPergunta(String txtPergunta) {
    this.txtPergunta = txtPergunta;
  }

  public String getResposta() {
    return resposta;
  }

  public void setResposta(String resposta) {
    this.resposta = resposta;
  }
    
}
