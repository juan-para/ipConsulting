# IPConsulting project

Bienvenido! El objetivo de esta API REST es brindar en base a una IP dada, informacion de geolocalizacion
y monetaria. Los datos que se retornan son: Nombre del pais, codigos ISO, moneda del pais,
ratios de conversion de la moneda del pais contra el dolar y el euro.

Las tecnologias que utilice:
- Maven
- Spring
- Regex
- Lombok
- Arquitectura hexagonal
- Request Methods: GET
- Manejo unificado de excepciones con @RestControllerAdvice
- Serializacion y deserializacion con Jackson
- Base de datos en memoria H2
- Docker

Se exponen 2 endpoint HTTP GET:
- Para realizar la consulta
  - localhost:8080/checkip/{ip}
  
- Para bloquear determinada IP
  - localhost:8080/blockip/{ip}
    
Para levantar el proyecto:
- Generar el artefacto .jar
    - mvn clean package 
- Crear la imagen
    - docker build -t ip-consulting:1.0 .
- Levantar la imagen  
    - sudo docker run -d -p 8080:8080 -t ip-consulting:1.0
