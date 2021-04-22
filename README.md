# IPConsulting project

Bienvenido! El objetivo de esta API REST es brindar en base a una IP dada, informacion de geolocalizacion
y monetaria. Los datos que se retornan son: Nombre del pais, codigos ISO, moneda del pais y el valor de 
de la moneda respecto del dolar/euro.

**Las tecnologias que utilice:**
- Maven
- Spring
- Regex
- Lombok
- Arquitectura hexagonal    
- Manejo unificado de excepciones con @RestControllerAdvice
- Serializacion y deserializacion con Jackson
- Base de datos en memoria H2
- Docker

**Para levantar el proyecto:**
- Generar el artefacto .jar
  - ```
    mvn clean package
    ```
- Crear la imagen
  - ```
    docker build -t ip-consulting:1.0 .
    ```
- Levantar la imagen
  - ```
    sudo docker run -d -p 8080:8080 -t ip-consulting:1.0
    ```
  
**Se exponen 2 endpoint HTTP GET:**
- Para realizar la consulta
  - ```
    localhost:8080/checkip/{ip}
    ```
  - Su respuesta JSON seria
    ```
    Completar...
    ```  
- Se pueden visualizar los datos en la base, configurando el jdbc con "jdbc:h2:mem:docker"
  ```
  localhost:8080/h2-console
  ```
  
- Para bloquear determinada IP
  - ```
    localhost:8080/blockip/{ip}
    ```
  - Su respuesta JSON seria
    ```
    {
    "ip": "5.6.7.8",
    "blockedStatus": true
    }
    ```
**La respuesta generica de error:**
```
  {
  "errorType": "Generic error",
  "description": descripcion del error...
  }
```