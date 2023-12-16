# Correção

## Nota obtida 10

## Observações
  - exceção no menu principal
  - informação para usuário: espaçamento, sinal monetário R$ etc
  - relatório da frota não fala de gastos
  - frota usando vetor em lugar de coleção
  - não escolhi combustível para o veículo
  - não deixa adicionar rota corretamente (dia, mes, ano em separado???)
  - deixou eu abastecer um veículo com tanque cheio várias vezes
  - não mostrou/atualizou valor de abastecimento
  - case 11: matando todo o OCP e LSP. vejam que o código é igual para todos. 
  - de modo parecido:
```
double combustiveltotal = frota.localizadorVeiculo(input).calcDespesaCombustivel();
double periodicatotal = frota.localizadorVeiculo(input).calcDespesaManutencao();
double pecastotal = frota.localizadorVeiculo(input).calcDespesaPecas();
```

por

```
Veiculo v = frota.localizadorVeiculo(input);
if(v!=null){
    combustivel = v.calcDespesaCombustivel();
    periodica = v.calcDespesaManutencao();
    pecas = v.calcDespesaPecas();
}
```