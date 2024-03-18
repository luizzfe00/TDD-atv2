| Gerador de Nota Fiscal     |
|----------------------------|

| Análise de Valores Limites  |
| --------------                 |

|  | Valor | Saída Esperada                 |
|-----------------------------|-------|--------------------------------|
| Valor Nulo                  | 0     | Nota fiscal criada com valor 0 |
| Valor Positivo              | 100 | 100                            |
| Valor Negativo              | -100 | Erro                           |


Não é possível fazer teste de valor limite superior pois a especificação não informa
nenhum valor limite.

| Partições de Equivalência |
|---------------------------|

| Tipo de Serviço           | Saida Esperada                  |
| --- |---------------------------------|
| Consultoria               | Nota fiscal gerada com 25% de imposto |
| Treinamento               | Nota fiscal gerada com 15% de imposto |   
| Outro                     | Nota fiscal gerada com 6% de imposto  |
| Vazio                     | Erro                                  |

| Dados do Cliente | Saida Esperada                                                                                                                                     |
|------------------|----------------------------------------------------------------------------------------------------------------------------------------------------|
| Dados de cliente válidos (nome, endereço, detalhes corretos)      | Nota fiscal gerada com sucesso, com imposto correto de acordo com o tipo de serviço, enviada por e-mail para o SAP e persistida no banco de dados. |
| Dados de cliente inválidos (nome vazio, endereço vazio, detalhes ausentes)      | Erro                            |


| Árvore de Decisão |
|-------------------|

| Valor da Fatura   | Serviço | Saida Esperada                        |
| ----------------- |---------| --- |
| 0                 | Consultoria       | Nota fiscal gerada com valor 0        |
| 10                | Consultoria      | Nota fiscal gerada com 25% de imposto |
| -1                | Consultoria      | Erro                                  |
| 0                 | Treinamento       | Nota fiscal gerada com valor 0        |
| 10                | Treinamento      | Nota fiscal gerada com 15% de imposto |   
| -1                | Treinamento      | Erro                                  |
| 0                 | Outro       | Nota fiscal gerada com valor 0        |
| 10.8              | Outro     | Nota fiscal gerada com 6% de imposto  |
| -2                | Outro      | Erro                                  |
| Vazio             |         | Erro                                  |

