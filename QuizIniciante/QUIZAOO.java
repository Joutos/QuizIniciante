/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.quizaoo;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author jpd00
 */
public class QUIZAOO {

    public static void main(String[] args) {

        /*
        * TELA INICIAL
         */
        System.out.println("----------------------------------------");
        System.out.println("----------- SEJA BEM VINDO -------------");
        System.out.println("--------------- AO ---------------------");
        System.out.println("---------- SHOW DO MILHÃO  -------------");
        System.out.println("----------------------------------------");

        Scanner scanner = new Scanner(System.in);

        Jogador jogador1 = new Jogador(1);
        Jogador jogador2 = new Jogador(2);

        ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
        jogadores.add(jogador1);
        jogadores.add(jogador2);

        int escolhamenu = 0;

        /*
        * MENU ESCOLHA
         */
        System.out.println("----------------------------------------");
        System.out.println("|1-Jogar   |2-Desenvolvedores   |3-Sair|");
        System.out.println("----------------------------------------");
        System.out.println("");

        while (escolhamenu != 1) {

            //MENU ESCOLHA (Só passa ao Iniciar o jogo ou Sair do jogo)
             
            System.out.println("Digite: ");
            escolhamenu = scanner.nextInt();
            switch (escolhamenu) {
                case 1:

                    
                    //Inicia a lista de personagens
                    ArrayList<String> personagens = new ArrayList<>();
                    personagens.add("Harry Miller");
                    personagens.add("Kirigaya Shiroi");
                    personagens.add("Sonic");
                    personagens.add("Mario");
                    personagens.add("Bob Esponja");

                    //Loop para cada jogador escolher o personagem, sempre o Jogador 1 primeiro
                    for (Jogador y : jogadores) {
                        System.out.println("Jogador " + y.getIndJogador() + " escolha seu personagem:");
                        for (int i = 0; i < personagens.size(); i++) {
                            System.out.println((i + 1) + "-" + personagens.get(i));
                        }

                        int escolhaJogador = scanner.nextInt();

                        //Seta o personagem escolhido e retira ele da lista de escolha
                        String personagemSelecionado = personagens.get(escolhaJogador - 1);
                        System.out.println("Jogador selecionado: " + personagemSelecionado);
                        y.setNomePersonagem(personagemSelecionado);
                        personagens.remove(escolhaJogador - 1);
                    }
                    break;
                case 2:
                    //Lista os desenvolvedores
                    System.out.println("Desenvolvedores:");
                    System.out.println("- Joao Paulo Demeto Leão");
                    System.out.println("- Lucas Lopes");
                    System.out.println("- Felipe Santos");
                    System.out.println("- Giovanna Altair");
                    System.out.println("-----------Descrição do trabalho----------");
                    break;

                case 3:
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Digite novamente.");
                    break;
            }
        }
        ArrayList<Alternativa> alternativas = new ArrayList<Alternativa>();
        ArrayList<Perguntas> perguntas = new ArrayList<Perguntas>();
        int idPergunta = 0;
        try {
            //Instancia o objeto para ler o arquivos pergunta.txt
            File myObj = new File("DIRETORIO DO ARQUIVO DE PERGUNTAS");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                int indParte = 3;
                String data = myReader.nextLine();
                //Divide a linha usando o ; como separador
                String[] parts = data.split(";");
                //Enunciado fica no index 1
                String txtPergunta = parts[1];
                //Identificador da pergunta fica no index 0
                idPergunta = Integer.parseInt(parts[0]);
                String resposta = parts[2];
                perguntas.add(new Perguntas(idPergunta, txtPergunta, resposta));
                while (indParte != 7) {
                    //Divide as parts relacionadas à alternativas usando " - " como separador
                    String[] partsAlternativa = parts[indParte].split(" - ");
                    //Adiciona à lista uma classe Alternativa
                    alternativas.add(new Alternativa(idPergunta, partsAlternativa[1], partsAlternativa[0]));

                    indParte++;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Scanner s = new Scanner(System.in);
        boolean acabou = false;
        //Loop de perguntas; simula o turno
        
        for (Perguntas i : perguntas) {
            //Verifica se um dos jogadores foi eliminado
            for (Jogador n : jogadores) {
                if (!n.getAtivo()) {
                    System.out.println(n.getNomePersonagem() + " você foi eliminado!");
                    acabou = true;
                }
            }
            //Sai do loop de perguntas
            if (acabou) {
                break;
            }
            //Variavel de confirmação de resposta
            boolean confirmaResposta = false;

            //Enquanto a confirmação não for aceita continua a exibir a pergunta
            while (!confirmaResposta) {
                idPergunta = i.getIdPergunta();
                //Imprime o enunciado
                System.out.println(i.getTxtPergunta());
                //Printa as alternativas baseando-se no id da pergunta
                for (Alternativa j : alternativas) {
                    if (j.getIdPergunta() == idPergunta) {
                        System.out.println(j.getIndAlternativa() + " - " + j.getTxtAlternativa());
                    }
                }
                // Cada jogador responde a sua escolha para a mesma pergunta
                for (Jogador p : jogadores) {
                    System.out.println("Turno de " + p.getNomePersonagem() + "!! Digite sua resposta");
                    System.out.println("Sua vida atual é de: " + p.getVida() + "%");
                    String resposta = s.nextLine().toUpperCase();
                    p.setRespostaTurno(resposta);
                }
                //Confirmação da resposta
                System.out.println("Tem certeza da resposta? (S/N)");

                String confirmacao = s.nextLine().toUpperCase();

                switch (confirmacao) {
                    case "S":
                        confirmaResposta = true;
                        break;
                    case "N":
                        confirmaResposta = false;
                        break;
                    default:
                        //Caso insira um valor invalido
                        System.out.println("Resposta inválida. Digite as suas respostas novamente");
                        break;
                }
            }
            //Validação da resposta e print informando que quem errou perdeu vida
            for (Jogador n : jogadores) {
                if (!n.getRespostaTurno().equals(i.getResposta())) {
                    System.out.println(n.getNomePersonagem() + " você errou e perdeu 45% da sua vida");
                    n.setVida(n.getVida() - 45);
                    if (n.getVida() <= 0) {
                        n.setAtivo(false);
                    }
                }
            }
        }
        //Validações e mensagens de vitória
        if (jogador1.getAtivo() && !jogador2.getAtivo()) {
            System.out.println(jogador1.getNomePersonagem() + " você ganhou! E ainda restaram " + jogador1.getVida() + "% de vida tirou onda!");
            System.out.println(jogador2.getNomePersonagem() + " que pena... Você foi eliminado... Boa sorte na próxima!");
        } else if (jogador2.getAtivo() && !jogador1.getAtivo()) {
            System.out.println(jogador2.getNomePersonagem() + " você ganhou! E ainda restaram " + jogador2.getVida() + "% de vida tirou onda!");
            System.out.println(jogador1.getNomePersonagem() + " que pena... Você foi eliminado... Boa sorte na próxima!");
        } else if (!jogador1.getAtivo() && !jogador2.getAtivo()) {
            System.out.println("Ambos foram eliminados... Talvez seja melhor dar uma revisada no assunto");
        } else if (jogador1.getVida() == jogador2.getVida()) {
            System.out.println("Uau! Nenhum de vocês empataram! Que surpresa, vocês entenderam tudo sobre o assunto");
        } else {
            int vida1 = jogador1.getVida();
            int vida2 = jogador2.getVida();

            if (vida1 > vida2) {
                System.out.println("Ningúem foi eliminado! Porém " + jogador1.getNomePersonagem() + " tem " + jogador1.getVida() + " e se sente mais vivo e vence a troca de soco! Vitória dele!");
            } else {
                System.out.println("Ningúem foi eliminado! Porém " + jogador2.getNomePersonagem() + " tem " + jogador2.getVida() + " e se sente mais vivo e vence a troca de soco! Vitória dele!");
            }
        }

    }
}
