# language: pt
Funcionalidade: Alugar Filme
Como um usuario
Eu quero cadastrar aluguéis de filmes
Para controlar preços e datas de entrega

Cenario: Deve alugar um filme com sucesso
Dado um filme com estoque de 2 unidades
E que o preço do aluguel seja R$ 3
Quando alugar
Entao o preço do aluguel sera R$ 3
E a data de entrega sera em 1 dia
E o estoque sera de 1 unidade

Cenario: Não deve alugar filme sem estoque
Dado um filme com estoque de 0 unidade
Quando alugar
Entao não sera possivel por falta de estoque
E o estoque do filme sera 0 unidade


Esquema do Cenario: Deve dar condições conforme tipo de aluguel
Dado um filme com estoque de 2 unidades
E que o preço seja R$ <preco>
E que o tipo do aluguel seja <tipo>
Quando alugar
Entao o preço do aluguel sera R$<valor>
E a data de entrega será em <qtsDias> dias
E a pontuação recebida será de <pontuacao> pontos

Exemplos:
|preco | tipo     | valor | qtsDias | pontuacao |
| 4    | extendido|   8   |    3    |     2     | 
| 4    | comum    |   4   |    1    |     1     |
| 10   | extendido|  20   |    3    |     2     |
| 5    | semanal  |  15   |    7    |     3     |

