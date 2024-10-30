### Como compilar e executar os testes das árvores

A estrutura dos diretórios do projeto segue esse padrão: 

```
Arvore/
└── binaria/
    ├── src/
    │   ├── Classe.java
    │   └── OutraClasse.java
    └── bin/
        ├── Classe.class
        └── OutraClasse.class
```

Nesse caso:

- **`src/`**: conterá todos os seus arquivos `.java` (código fonte).
- **`bin/`**: conterá os arquivos `.class` (código compilado).

### Compilação e Execução

1. **Para compilar**:
   ```bash
   javac -d Arvore/binaria/bin Arvore/binaria/src/*.java
   ```

2. **Para executar** (supondo que `MinhaClasse` tenha o método `main`):
   ```bash
   java -cp Arvore/binaria/bin MinhaClasse
   ```

### Compilação e execução específica (gera arquivos class no local da execução)

1. Entre no diretório da estrutura desejada.

2. Rode comando `javac Classe.java OutraClasse.java` no terminal.

3. Execute a estrutura com o comando `java Classe` no terminal.


### Compilação e execução em lote (gera arquivos class no local da execução)

1. Entre no diretório da estrutura desejada.

2. Rode comando `javac @compile` no terminal. (coloque o nome das classes.java no arquivo compile)

3. Execute a estrutura com o comando `java Classe` no terminal.