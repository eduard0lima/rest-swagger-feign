#### Instruções para instalação da aplicação:

##### Pré-requisitos:
- Docker
- Git
- Maven
- Fazer clone do projeto com o comando 
``` 
$ git clone https://github.com/eduard0lima/rest-swagger-feign.git
``` 

##### Banco de dados:
- Executar os comandos:
``` 
$ cd docker/postgresql
$ docker build -t my-postgres-image .
$ docker run -d --name my-postgres-container -p 5555:5432 my-postgres-image
```
O banco de dados estará acessível em:

    url: jdbc:postgresql://localhost:5555/testdb
    username: postgres
    password: postgres

##### Jaeger tracing:
- Executar o comando:
``` 
$ docker run -d --name jaeger \
  -e COLLECTOR_ZIPKIN_HTTP_PORT=9411 \
  -p 5775:5775/udp \
  -p 6831:6831/udp \
  -p 6832:6832/udp \
  -p 5778:5778 \
  -p 16686:16686 \
  -p 14268:14268 \
  -p 14250:14250 \
  -p 9411:9411 \
  jaegertracing/all-in-one:1.17
```
O Jaeger estará disponível em: http://localhost:16686/

##### Grafana e Prometheus:

Editar o arquivo <code>docker/prometheus-grafana/prometheus.yml</code> para que o valor 'HOST' (última linha do arquivo) seja substituído pelo IP que o Docker está rodando. Esse arquivo será usado para configurar o prometheus logo abaixo.

- Executar os comandos:
``` 
$ cd docker/prometheus-grafana
$ docker run -d --name prometheus -p 9090:9090 -v prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus --config.file=/etc/prometheus/prometheus.yml
$ docker run -d --name grafana -p 3000:3000 grafana/grafana
``` 
Grafana: http://localhost:3000  
Prometheus: http://localhost:9090

##### API de Cotação do Dólar:

- Executar os comandos:
``` 
$ cd cotacao-api
$ mvn clean install
$ java -jar target/cotacao-1.0.0.war
``` 
A aplicação com sua API Swagger irá rodar em: http://localhost:8081/swagger-ui.html
