# Linketinder - Jocelin Nunes
## Modelo Lógico do Software
<p align="center">
  <img alt="modelo" src="/modelagem.JPG" width="100%">
</p>

Modelo criado pelo site brmodeloweb.

## Implantação de endpoints - APIs REST

Nesse projeto, criou-se endpoints no backend, seguindo os princípios de APIs REST, sem a utilização de frameworks.

Para a implantação de tais endpoints, sem o auxílio de frameworks, foi necessário utilizar alguns recursos de mais baixo nível. O caminho adotado foi valer-se do Apache Tomcat para subir um servidor local com páginas e conteúdo dinâmico. Além disso, para criar os endpoints, utilizou-se a biblioteca Servlet que disponibiliza recursos para mapear endpoints, tais como annotations.

Para a configuração do servidor Tomcat, foi necessário realizar o build do arquivo war da aplicação. Após isso, na configuração do servidor, foi “apontado” um artefato relativo a este war. Desta forma, ao rodar o servidor tomcat, ele consume o arquivo war indicado e faz o deploy em um servidor local.