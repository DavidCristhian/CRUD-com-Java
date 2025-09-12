# 🛒 CRUD de Produtos - Spark Framework

![Java](https://img.shields.io/badge/Java-11+-red?logo=openjdk&logoColor=white)  
![Maven](https://img.shields.io/badge/Maven-Build-blue?logo=apachemaven&logoColor=white)  
![Spark](https://img.shields.io/badge/Spark_Framework-Microframework-orange)  
![Eclipse](https://img.shields.io/badge/Eclipse-IDE-purple?logo=eclipseide&logoColor=white)   
  

Projeto desenvolvido em **Java**, utilizando o **Spark Framework** como microframework web, **Maven** para gerenciamento de dependências e rodando no **Eclipse IDE**.  
Este sistema implementa um CRUD (Create, Read, Update, Delete) para gerenciamento de produtos.

---

## 🚀 Tecnologias utilizadas
- **Java 11 (JRE System Library [JavaSE-11])**  
- **Maven** (gerenciamento de dependências e build)  
- **Spark Framework** (microframework para aplicações web)  
- **Eclipse IDE**  

---

## 📂 Estrutura do projeto
📦 produte-service
┣ 📂 src/main/java
┃ ┣ 📂 app
┃ ┃ ┗ 📜 Aplicacao.java # Classe principal (inicializa rotas Spark)
┃ ┣ 📂 dao
┃ ┃ ┗ 📜 ProdutoDAO.java # Classe responsável por persistência (DAO)
┃ ┣ 📂 model
┃ ┃ ┗ 📜 Produto.java # Classe de modelo (entidade Produto)
┃ ┗ 📂 service # (reservado para regras de negócio futuras)
┣ 📂 src/main/resources
┃ ┣ 📜 formulario.html # Página de formulário para produtos
┃ ┗ 📜 produtos.html # Página para exibir listagem de produtos
┣ 📂 src/test/java # (espaço para testes unitários)
┣ 📂 src/test/resources # (recursos de teste, se necessário)
┣ 📜 pom.xml # Configuração Maven
┗ 📜 README.md # Este arquivo

yaml
Copiar código

---

## ⚙️ Funcionalidades
- ✅ Criar novos produtos (formulário HTML)  
- ✅ Listar produtos cadastrados  
- ✅ Atualizar produtos existentes  
- ✅ Excluir produtos  

---

## ▶️ Como executar o projeto

### Pré-requisitos:
- **Java 11+** instalado  
- **Maven** configurado na sua máquina  
- **Eclipse IDE** (ou outra IDE de sua preferência)  

### Passos:
1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/produte-service.git
Abra o projeto no Eclipse como projeto Maven.

Compile e rode a classe principal:

css
Copiar código
src/main/java/app/Aplicacao.java
O servidor Spark será iniciado (por padrão na porta 4567).

Acesse no navegador:
http://localhost:4567/produtos
🔧 Rotas da API
Método	Endpoint	Descrição
GET	/produtos	Lista todos os produtos
GET	/produtos/:id	Busca produto por ID
POST	/produtos	Cria um novo produto
PUT	/produtos/:id	Atualiza produto
DELETE	/produtos/:id	Remove produto

📌 Melhorias futuras

Validações mais completas no formulário

Implementar camada service para regras de negócio

Interface mais amigável (HTML/CSS/JS)
