# PROJETO: gerenciamento-cadastro (avaliacao-mirante)
 Projeto realizado para a avaliação da Mirante

## Configurações iniciais

### Banco de dados
1. O banco ultilizado foi o MySql

2. É necessário baixar o conector do MySql diretamente no site: https://www.mysql.com/downloads/connector/j
3. Criar conexão com o banco de dados a partir do WildFly é necessário executar os comandos atravéz de uma conexão do jboss-cli:

	- Para se conectar atravéz de uma conexão jboss-cli, basta executar o seguinte comando estando na pasta bin do wildfly. "Ex: ../wildfly-15.0.1.Final/bin"
			jboss-cli.bat --connect

	- Para adicionar o JAR como module use: 
			module add --name=com.mysql --resources=/path/to/mysql-connector-java-8.0.15.jar --dependencies=javax.api,javax.transaction.api
	*Ou adicionar manualmente criando as pastas "com", "mysql" e "main" dentro da pasta modules do wildfly. Ex: ../wildfly-15.0.1.Final/modules/com/mysql/main"*

	- Para definir o module como driver:
			/subsystem=datasources/jdbc-driver=mysql:add(driver-name=mysql,driver-module-name=com.mysql,driver-xa-datasource-class-name=com.mysql.cj.jdbc.MysqlXADataSource)
	*Ou criando manualmente o arquivo module.xml no mesmo diretorio do driver*

	- Para definir o datasource:
			/subsystem=datasources/jdbc-driver=mysql:add(driver-name=mysql,driver-module-name=com.mysql,driver-xa-datasource-class-name=com.mysql.cj.jdbc.MysqlXADataSource)
	*Ou diretamente no arquivo standalone-full.xml "Ex:  ../wildfly-15.0.1.Final/standalone/configuration/standalone-full.xml (tags: datasource e driver)"*

3. Queries:

	- Para criação do banco de dados
			CREATE DATABASE gerenciamento_cadastro;

	- Para inserir usuario administrador
			INSERT INTO operador (id, nome, login, senha, dataCadastro) VALUES (1, Administrador, admin, admin, '2020-05-02-00.00.00 -0300') ;

	- Observação: As tabelas são geradas automaticamente pela JPA.

### Back-end
1. Utilização do WildFly como servidor de aplição, baixado diretamente do site: https://wildfly.org/downloads/

	- É necessário fazer a instalação do JBoss tools no eclipse.
	- A pasta do WildFly precisa estar em um diretório com permissão de acesso.
	- A versão utilizada foi a 15.0.1.Final	- Java EE Full & Web Distribution.
	- Está sendo utlizado o arquivo "standalone-full.xml" nas configurações do Runtime Environment.
	


### OBSERVAÇÕES IMPORTANTES

1. #### ROTAS
- Não foi possível concluir a parte da autenticação, portanto as todas devem ser inseridas diretamente pela URL.

	- Rotas:
			LOGIN: /login
			LISTAR OPERADORES: /operador/listar
			CADASTRAR OPERADORE: /operador/cadastrar
			EDITAR OPERADORE: /operador/editar/{id}
			LISTAR PESSOAS: /pessoa/listar
			CADASTRAR PESSOA: /pessoa/cadastrar
			EDITAR PESSOA: /pessoa/editar/{id}
