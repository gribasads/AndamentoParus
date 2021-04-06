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
E a data de entrega sera no dia seguinte
E o estoque sera de 1 unidade

Cenario: Não deve alugar filme sem estoque
Dado um filme com estoque de 0 unidade
Quando alugar
Entao não sera possivel por falta de estoque
E o estoque do filme sera 0 unidade

Cenario: Deve dar condições especiais para a categoria extendida
Dado um filme com estoque de 2 unidades
E que o preço seja R$ 4
E que o tipo do aluguel seja extendido
Quando alugar
Entao o preço do aluguel sera R$8
E a data de entrega será em 3 dias
E a pontuação recebida será de 2 pontos