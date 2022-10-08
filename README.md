<h1 align="center">Sistema de agendamento de transferências financeiras</h1>
  <br/><br/>
  <strong>Aplicação:</strong>
  <p>
  Este projeto tem como objetivo calcular a taxa sobre uma transferência de valores, armazenar os dados referentes a essa transferência em um banco de dados e exibir todas as transferências agendadas. 
  </p>
  <p>
    *Os dados são persistidos em banco de dados em memória, então ao encerrar ou reiniciar o servidor do back-end os dados serão apagados*
  </p>
  <p>
  A arquitetura escolhida para o desenvolvimento do projeto foi a MVC. Como o MVC permite a separação da aplicação em camadas, isso possibilita que o projeto fique mais escalável, trazendo ao projeto organização, segurança, reaproveitamento de código e facilidade na criação e manutenção de recursos. 
  </p>
  <br/>
  <strong>Linguagens:</strong>
  <p>
  Para o desenvolvimento do projeto foram utilizadas as seguintes linguagens: 
  </p>
  <ol>
    <li>Java - Versão 17.0.4 </li>
    <li>Angular - Versão 14.2.4 </li>
    <li>Spring Boot - Versão 2.7.4</li>
    <li>TypeScript - Versão 4.7.4 </li>
  </ol>
  
  <strong>Ferramentas: </strong>
  <p>
    Foram utilizadas as seguintes ferramentas no desenvolvimento do projeto:  
  </p>
  <ol>
    <li>IntelliJ IDEA Community Edition</li>
    <li>Postman</li>
    <li>Visual Studio Code</li>
  </ol>
  
  <strong>Deploy do Projeto:</strong>
  <p>
    Para realizar a subida do projeto, são necessárias duas etapas, realizar a subida do back-end e realizar a subida do front-end. 
  </p>
  <p>
    Para realizar a subida do back-end, clone o projeto em sua máquina, depois abra a pasta projeto-agendamento-backend em uma IDE de sua 
    preferência e selecione a classe “ProjetoAgendamentoBackendApplication”, ela se encontra no pacote “br.com.tokiomarine.projetoagendamentobackend”. 
    Após selecionar a classe é necessário rodar ela para que todas as dependências sejam baixadas e para que o servidor se inicie, para isso basta clicar 
    com o botão direito do mouse em cima da classe “ProjetoAgendamentoBackendApplication” e selecionar a opção “Run ProjetoAgendamentoBackendApplication”. 
  </p>
  <p>
    Já para realizar a subido do front-end, clone o projeto em sua máquina caso não esteja clonado, depois será necessário acessar a pasta
    projeto-agendamento-frontend pelo terminal, então basta abrir o terminal, ir até o diretório onde se encontra o projeto-agendamento-frontend e 
    executar o comando “ng serve“, esse comando irá compilar e iniciar o servidor para a parte de front-end. Após executar o comando, aparecerá a seguinte mensagem: 
  </p>
  <p>
    ** Angular Live Development Server is listening on localhost:4200, open your browser on http://localhost:4200/ ** 
  </p>
  <p>
    O endereço http://localhost:4200/ será o endereço a ser acessado no navegador para a utilização do projeto. 
  </p>
  
  
  ---------------
  <p>Desenvolvido por: [Christopher Alexander](https://www.linkedin.com/in/christopher-alexander-70b6b1107/) </p>
