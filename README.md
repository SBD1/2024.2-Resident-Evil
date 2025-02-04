# 2024.2-Resident-Evil
Repositório criado para o desenvolvimento do jogo Resident Evil, realizado pelo grupo 7 da disciplina de Sistema de Banco de Dados 1.
<div align="center"> <img src="docs\assets\resident_evil.png" height="auto" width="auto"/> </div>

# Sobre o jogo
Inspirado na atmosfera icônica de Resident Evil 4, este jogo desafia você a sobreviver em um cenário repleto de perigos e mistérios. Você assume o papel de um agente policial enviado a uma vila isolada na Espanha para cumprir uma missão crucial. A cada movimento, você enfrentará inimigos implacáveis, administrará recursos escassos e explorará ambientes desolados cheios de segredos.

# Como Rodar o Jogo (Java + MySQL)

Este documento explica como configurar e rodar o jogo feito em Java com um banco de dados MySQL.

## 📌 Pré-requisitos
Antes de começar, certifique-se de ter instalado:
- [MySQL](https://dev.mysql.com/downloads/)
- [Java JDK 8+](https://www.oracle.com/java/technologies/javase-downloads.html)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) ou outra IDE de sua preferência

---

## 🚀 Passo a Passo

### 1️⃣ Criar o banco de dados no MySQL
1. Abra o MySQL Workbench ou qualquer outro cliente MySQL.
2. Execute o seguinte comando para criar o banco de dados:
   ```sql
   CREATE DATABASE resident_evil;
   ```

### 2️⃣ Copiar e colar o DDL e DML no MySQL
1. Abra o banco de dados criado:
   ```sql
   USE resident_evil;
   ```
2. Copie o código SQL do DDL (estrutura das tabelas) e DML (dados iniciais) fornecido pelo projeto.
3. Cole e execute no MySQL para criar as tabelas e inserir os dados.

### 3️⃣ Configurar o projeto Java
1. Abra o IntelliJ IDEA (ou sua IDE preferida).
2. Importe o projeto Java.
3. Certifique-se de que as dependências necessárias estão instaladas, como o **MySQL Connector/J**.
4. Configure a conexão com o banco de dados no código Java. Normalmente, a string de conexão será algo assim:
   ```java
   String url = "jdbc:mysql://localhost:3306/resident_evil";
   String usuario = "root";
   String senha = "sua_senha_aqui";
   Connection conexao = DriverManager.getConnection(url, usuario, senha);
   ```

### 4️⃣ Executar o jogo
1. Compile e execute o projeto Java dentro da IDE.
2. O jogo deve iniciar e se conectar ao banco de dados automaticamente.

---

## 🛠 Solução de Problemas
- **Erro de conexão com o banco de dados**: Verifique se o MySQL está rodando e se as credenciais estão corretas.
- **Falta de dependências**: Caso a conexão com o banco falhe, certifique-se de que o **MySQL Connector/J** está adicionado ao projeto.
- **Banco de dados não encontrado**: Certifique-se de que o banco de dados foi criado com o nome correto (`resident_evil`).

Caso tenha dúvidas, abra uma issue no repositório. Boa diversão! 🎮


# Colaboradores
<center>
<table style="margin-left: auto; margin-right: auto;">
    <tr>
        <td align="center">
            <a href="https://github.com/nanecapde">
                <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/122893055?v=4" width="150px;"/>
                <h5 class="text-center">Anne de Capdeville</h5>
            </a>
        </td>
        <td align="center">
            <a href="https://github.com/YuriBre">
                <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/87884030?v=4" width="150px;"/>
                <h5 class="text-center">Breno Yuri</h5>
            </a>
        </td>
        <td align="center">
            <a href="https://github.com/Brunocrzz">
                <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/122310754?v=4" width="150px;"/>
                <h5 class="text-center">Bruno Cruz</h5>
            </a>
        </td>
        <td align="center">
            <a href="https://github.com/Jose1277">
                <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/132015244?v=4" width="150px;"/>
                <h5 class="text-center">Jose Felipe Duarte Guedes de Oliveira</h5>
            </a>
        </td>
        </td>
        <td align="center">
            <a href="https://github.com/Pabloo8">
                <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/121682371?v=4" width="150px;"/>
                <h5 class="text-center">Pablo Cunha de Jesus</h5>
            </a>
        </td>

</table>
</center>
