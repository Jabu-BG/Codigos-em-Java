# Exemplo de classe DAO com Java, JDBC e SQLite

Projeto executável usado como complemento da apresentação sobre DAO. O exemplo implementa a entidade `Produto` e as quatro operações CRUD:

- **Create**: inserir um produto;
- **Read**: buscar um produto por id e listar todos;
- **Update**: atualizar nome, preço e estoque;
- **Delete**: remover um produto.

## Estrutura

```text
src/main/java/br/edu/dao/
├── app/Main.java
├── dao/ProdutoDAO.java
├── dao/ProdutoDAOImpl.java
├── infra/ConexaoSQLite.java
├── infra/DatabaseInitializer.java
└── model/Produto.java
```

### Responsabilidade de cada classe

- `Produto`: entidade de domínio com os dados do produto.
- `ProdutoDAO`: contrato que define as operações de persistência.
- `ProdutoDAOImpl`: implementação do contrato usando `Connection`, `PreparedStatement` e `ResultSet`.
- `ConexaoSQLite`: abre a conexão JDBC e habilita `PRAGMA foreign_keys = ON`.
- `DatabaseInitializer`: cria a tabela `produto` automaticamente.
- `Main`: executa uma demonstração completa do CRUD.

## Requisitos

- JDK 17 ou superior;
- Maven 3.9 ou superior;
- acesso à internet na primeira execução para baixar o driver `org.xerial:sqlite-jdbc`.

## Execução

Na pasta do projeto:

```bash
mvn clean compile exec:java
```

O programa cria automaticamente o ficheiro `dados/loja.db` e mostra no terminal as operações `CREATE`, `READ`, `UPDATE` e `DELETE`.

Para começar com uma base limpa, interrompa o programa e remova o ficheiro local:

```bash
rm -f dados/loja.db
```

No Windows PowerShell:

```powershell
Remove-Item dados/loja.db -ErrorAction SilentlyContinue
```

## Observações didáticas

A implementação usa `PreparedStatement` para parametrizar os valores e `try-with-resources` para fechar os recursos JDBC. Os métodos lançam `SQLException` para tornar o fluxo visível na aula; numa aplicação maior, a camada DAO pode traduzir a exceção para uma exceção própria do domínio.

O SQLite habilita chaves estrangeiras por conexão. Por isso, o `PRAGMA foreign_keys = ON` é executado dentro de `ConexaoSQLite.abrir()`.
