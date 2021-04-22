# IPConsulting project

Este proyecto consume 3 apis externas de las cuales obtenemos, a partir de una IP,
el nombre el pais, codigos ISO, moneda y ratios de conversion contra el dolar y el euro.

Se exponen 2 endpoint HTTP GET:
- Para realizar la consulta
  - localhost:8080/checkip/{ip}
  
- Para bloquear que realize la consulta una IP
  - localhost:8080/blockip/{ip}

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

Para levantar el proyecto:
- Generar el artefacto .jar
    - mvn clean package 
- Crear la imagen
    - docker build -t ip-consulting:1.0 .
- Levantar la imagen  
    - sudo docker run -d -p 8080:8080 -t ip-consulting:1.0
