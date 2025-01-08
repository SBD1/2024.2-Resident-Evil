# Normalização

### Introdução
Normalização do projeto de SB1, Resident Evil.
A normalização se diz a respeito sobre uma das principais técnicas para evitar redundâncias e garantir a consistência do banco. A normalização garante a integralidade e confiança no banco, provendo uma maneira formal de melhoria de projeto e desenvolve e a intuição de projetos de melhor qualidade. 
O processo de normalização se dá em torno de 5 etapas, chamadas de Formas Normais (NF). 

### Conceitos
+ **Superchave: conjunto**: com um ou mais atributos que identifica uma tupla unicamente.
+ **Superchave mínima**: superchave que, se tiver um atributo removido, deixa se ser superchave.
+ **Chave candidata**: qualquer uma das superchaves mínimas existente em uma relação.
+ **Atributo primo**: pertence a uma chave candidata • Atributo comum ou ordinário: atributo não primo.

### Dependência Funcional - (DF)
O valor de um conjunto de atributos A permite descobrir o valor de um outro conjunto B, dizemos que A determina funcionalmente B, ou que B depende de A, e denotamos: A → B.

Chaves determinam funcionalmente todos os outros atributos, mas nem toda dependência funcional parte de uma chave.

### Propriedades DF
1. **Reflexiva**: Se B é subconjunto de A, então A → B 
2. **Aumentativa**: Se A → B então AX → B, e também Se A → B então AX → BX 
3. **Transitiva**: Se A → B, B → C então A → C 
4. **Decomposição**: Se A → BC então A → B, A → C 
5. **Aditiva**: Se A → B, A → C então A → BC 
6. **Pseudo-Transitiva**: Se AB → D e C→ A então CB → D

### Formas Normais
+ **1ª Forma Normal (1FN)**: Todos os atributos são Monovalorados e Atômicos, ou seja, não há relações aninhadas.
+ **2ª Forma Normal (2FN)**: Atributos comuns não dependem parcialmente de qualquer chave.
+ **3ª Forma Normal (3FN)**: Atributos comuns não dependem transitivamente de qualquer superchave.
+ **Forma Normal de Boyce-Codd (FNBC)**: Consiste na 3FN mais “forte” ou rigorosa, a fim de evitar algumas anomalias na base de dados. Uma relação está na FNBC se, para toda dependência funcional onde X→ A, X é uma chave candidata.
+ **4ª Forma Normal (4FN)**: Uma relação R está na quarta forma normal se, para todas as dependências multivaloradas não triviais AB, A é uma chave candidata. Ou seja, ela garante que não haja dependências multivaloradas.



| Versão |     Descrição      |                     Autor(es)                     |    Data    |
| :----: | :----------------: | :-----------------------------------------------: | :--------: |
|  1.0   | Criação | [Bruno Cruz](https://github.com/Brunocrzz) | 08/01/2025 |
