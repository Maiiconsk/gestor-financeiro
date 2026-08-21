# Gestor Financeiro

Aplicação de console em Java para controle de gastos pessoais — permite cadastrar, listar, editar, excluir transações e consultar o saldo, com persistência dos dados em arquivo de texto.

Projeto desenvolvido como parte do portfólio durante o curso de Análise e Desenvolvimento de Sistemas (ADS).

## Funcionalidades

- ✅ Adicionar transação (descrição, valor, tipo, categoria e data)
- ✅ Listar todas as transações cadastradas
- ✅ Editar qualquer campo de uma transação existente
- ✅ Excluir uma transação
- ✅ Consultar o saldo atual (receitas − despesas)
- ✅ Persistência automática em arquivo de texto (`transactions.txt`)

## Tecnologias

- Java (JDK 21)
- Sem dependências externas — usa apenas bibliotecas padrão do Java (`java.util`, `java.io`)

## Como rodar

1. Clone o repositório:
   ```
   git clone https://github.com/Maiiconsk/gestor-financeiro.git
   ```
2. Abra o projeto em uma IDE Java (Eclipse, IntelliJ, VS Code com extensão Java)
3. Execute a classe `Home.java` (localizada em `src/gestorFinanceiro`)

## Como usar

Ao rodar o programa, um menu interativo aparece no console:

```
======== Controle de Gastos ========
1 - Adicionar uma Transação
2 - Listar suas Transações
3 - Editar uma Transação
4 - Excluir uma Transação
5 - Ver Saldo
0 - Fechar o programa
```

Basta digitar o número da opção desejada e seguir as instruções na tela. Os dados são salvos automaticamente em `transactions.txt` a cada alteração, e recarregados sempre que o programa é aberto novamente.

## Categorias disponíveis

Alimentação, Transporte, Moradia, Educação, Lazer, Saúde, Compras, Outros

## Roadmap

Este projeto está em evolução contínua, acompanhando o conteúdo aprendido ao longo do curso:

- [ ] Refatorar para orientação a objetos (classe `Transacao`)
- [ ] Migrar a persistência de arquivo texto para banco de dados (SQLite)
- [ ] Adicionar filtro de transações por categoria

## Autor

Desenvolvido por [Maicon Oliveira](https://github.com/Maiiconsk)
