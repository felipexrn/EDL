### Como compilar e executar os testes das árvores

A estrutura dos diretórios do projeto segue esse padrão: 

```
Arvore/
├── src/
|   ├── binaria/
|   │   ├── Classe.java
│   │   └── OutraClasse.java
│   └── avl/
│       ├── Classe.java
│       └── OutraClasse.java
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
   javac -d Arvore/bin Arvore/src/binaria/*.java
   ```

2. **Para executar** (supondo que `MinhaClasse` tenha o método `main`):
   ```bash
   java -cp Arvore/bin MinhaClasse [argumentos se houverem]
   ```

### Compilação e execução específica (gera arquivos class no local da execução)

1. Entre no diretório da estrutura desejada.

2. Rode comando `javac Classe.java OutraClasse.java` no terminal.

3. Execute a estrutura com o comando `java Classe` no terminal.


### Compilação e execução em lote (gera arquivos class no local da execução)

1. Entre no diretório da estrutura desejada.

2. Crie um arquivo de texto e coloque nele os nomes das classes.java separados por espaço `MinhaClasse.java OutraClasse.java`)

3. Rode comando `javac @<nome do arquivo>` no terminal. 

4. Execute a estrutura com o comando `java Classe` no terminal.