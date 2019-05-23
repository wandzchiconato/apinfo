Feature: ConsultaVagas

Scenario:PesquisaVagasQA

Given Usuario acessa a APInfo
When pesquiso pela vaga "Analista de Testes"
Then Filtro as vagas por Cidade and seleciono "São Paulo" e clico em "Filtrar"
