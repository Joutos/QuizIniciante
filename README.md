# QuizIniciante

- [Descrição](#descricao)
- [Desenvolvedores](#desenvolvedores)
- [Perguntas](#perguntas)
- [Como jogar](#como-jogar)


## Descrição

Modelo de quiz para iniciantes em programação, sem utilização de banco de dados.
O projeto foi proposto para a UC de Programação de Soluções Computacionais da UniBH.

Código feito em java.

## Desenvolvedores

- João Paulo Leão
- Felipe Santos
- Giovana Altair
- [Lucas Lopes](https://github.com/Lucaslopes47)

## Perguntas

A classe de perguntas é automaticamente populada pelo arquivo ```perguntas.txt```. Que se encontra no diretório raiz do repositório.

# Como incluir a sua pergunta

A inclusão de perguntas é feita pelas linhas do arquivo ```perguntas.txt```. Para adicionar a sua pergunta siga o exemplo:
Exemplo:

```
Pergunta 1
Quanto é 2+2?
A resposta correta é a letra C.
A - 6
B - 2
C - 4
D - 5
```

A linha correspondente a essa pergunta ficará do seguinte modo
```1;Quanto é 2+2?;C;A - 6;B - 2;C - 4;D - 5```

## Como jogar

Ao executar o código, na tela inicial serão exibidas 3 opções, Jogar, Desenvolvedores e Sair.

- Jogar: Inicia o jogo
- Desenvolvedores: Exibe os desenvolvedores do projeto
- Sair: Encerra o programa

Ao selecionar jogar. O programa exibe a lista de personagens. Cada um dos jogadores escolhe o seu, a escolha é o modo que o projeto irá se referir a eles no decorrer do jogo.

Em cada turno é exibida uma pergunta e suas alternativas. Cada jogador escolherá a opção que acredita estar correta, e seguirão para a tela de confirmação de respostas.

Se algum dos jogadores decidir que quer mudar a resposta. Ambos os jogadores terão que responder novamente.

Ao confirmarem a resposta, se você errou, será exibida uma mensagem que você errou e perdeu 45% da sua vida.
Se a vida chegar a 0%, você está eliminado e a vitória é dada ao outro jogador.
Em um caso que as perguntas terminam, aquele com a maior porcentagem de vida ganha. Caso a vida seja igual, é um empate.

