# IPConsulting project

Bienvenido! El objetivo de esta API REST es brindar en base a una IP dada, informacion de geolocalizacion
y monetaria. Los datos que se retornan son: Nombre del pais, codigos ISO, moneda del pais y el valor de 
de la moneda respecto del dolar/euro.

**Las tecnologias que utilice:**
- Maven
- Spring
- Validaciones con Regex
- Lombok
- Arquitectura hexagonal    
- Manejo unificado de excepciones con @RestControllerAdvice
- Serializacion y deserializacion con Jackson
- Base de datos en memoria H2
- Docker
- Nginx como balanceador de carga
- JUnit + Mockito

**Para levantar el proyecto:**
- Checkear la clase GetFixerGatewayImpl y cambiar el token segun corresponda
- Generar el artefacto .jar
  - ```
    mvn clean package
    ```
- Levantar la imagen (2 servicios de esta app) y el balanceador de carga
  - ```
    sudo docker-compose up
    ```
  
**Se exponen 2 endpoint HTTP GET:**
- Para realizar la consulta
  - ```
    localhost:8080/checkip/{ip}
    ```
  - Su respuesta JSON de ejemplo seria
    ```
    {
      "ip": "216.58.211.206",
        "country": {
            "name": "United States of America",
            "iso2": "US",
            "iso3": "USA",
                "currency": {
                "code": "USD",
                    "rates": {
                    "usd": 1,
                    "eur": 0.83025515
                }
            }
        }
    }
    ```  
- Se pueden visualizar los datos en la base, configurando el jdbc con "jdbc:h2:mem:docker"
  ```
  localhost:8080/h2-console
  ```
  
- Para bloquear determinada IP
  - ```
    localhost:8080/blockip/{ip}
    ```
  - Su respuesta JSON de ejemplo seria
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
