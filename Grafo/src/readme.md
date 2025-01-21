### Como compilar e executar os testes

A estrutura dos diretórios do projeto segue esse padrão: 

```
Grafo/
├── src/
|   ├── Classe.java
│   └── OutraClasse.java
│ 
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
   javac -d Grafo/bin Grafo/src/*.java
   ```

2. **Para executar** (supondo que `MinhaClasse` tenha o método `main`). `Argumentos e saída para log de erro`:
   ```bash
   java -cp Grafo/bin MinhaClasse [argumentos se houverem] [2> erros.log]
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