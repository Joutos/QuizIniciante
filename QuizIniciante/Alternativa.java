/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizaoo;

/**
 *
 * @author jpd00
 */
public class Alternativa extends Perguntas{
    
  private String txtAlternativa;
  private String indAlternativa;

  public Alternativa(int idPergunta, String txtAlternativa, String indAlternativa) {
    super(idPergunta);
    this.txtAlternativa = txtAlternativa;
    this.indAlternativa = indAlternativa;
  }

  public String getTxtAlternativa() {
    return txtAlternativa;
  }

  public void setTxtAlternativa(String txtAlternativa) {
    this.txtAlternativa = txtAlternativa;
  }

  public String getIndAlternativa() {
    return indAlternativa;
  }
    
}
