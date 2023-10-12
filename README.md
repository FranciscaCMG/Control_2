# TBD_2023-2_Grupo_4

Control numero 2 de Taller de Base de Datos 2023-2

# Control 2 - Sistema de Gestión de Tareas

# Integrantes 

```
- Felipe Solís 
- Francisca Márquez
- Moisés Godoy
- Felipe Pinela
- Yuyunisse Careño
```

La estructura del codigo se presenta de la siguiente manera:
```
---------------------------------------------------------------------------------------------------------------
Control_2-main -> - Demo ->  - src/main/java ->     - controllers
                                                    - models      
                                                    - repositories
                                                    - services
                                                    - DemoApplication.java
                                                    -SecurityConfig.java                                                          
                            - src/main/resources -> - application.properties                  -
                            - front_c2 -> - src ->
                                                    - assets
                                                    - components
                                                    - router
                                                    - views
                                                    - App.vue
                                                    - main.js
---------------------------------------------------------------------------------------------------------------
```
# Prerequisitos
 - Cargar la base de datos, creacionDeTablas.sql y ajustar la contraseña de la base de datos en el documento resources -> application.properties.
 - npm, java 17, maven, node js, vue, postgres, intellij.

# INSTRUCCIONES DE USO

  - Descargar el repositorio en su formato zip y descomprimirlo en una carpeta destino (ejemplo escritorio) o clonar usando "git clone https://github.com/FranciscaCMG/Control_2.git" en la carpeta destino (ejemplo escritorio).
  - Antes de Comenzar a levantar el proyecto, se debe tener en cuenta que se necesita tener postgres configurado en una conexion local en un puerto a eleccion.
  - Abrir una terminal (a preferencia del usuario) y dirigirse a la carpeta del proyecto (ejemplo: escritorio/Control_2-main).
  - Ya teniendo todos los requisitos para ejecutar el proyecto, y estando en la terminal en la carpeta destino, realizamos el levantamiento del backend, desde Intellij (Tener en cuenta que este editor de texto debe estar instalado en su computador), luego abrir la carpeta demo y asegurarse de elegir JDK 17, finalmente apretar el boton de run.
  - Lo anterior levantara el apartado de backend en el puerto 8086 en localhost (http://localhost:8086).
  - En caso de que el mensaje de exito no se genere o no se visualize una base de datos llamada "test" en su GUI de conveniencia, debera comprobar su conexion de postgres. Una vez arreglado, se guardan los cambios y se vuelve a levantar.
  - Ya levantado el apartado del backend en el puerto 8086 (http://localhost:8086), en una segunda parte en una terminal, estando en la carpeta destino del proyecto ingresamos "cd front_c2" y enter.
  - Luego de estar dentro front_c2_ debemos levantar la parte del frontend del proyecto, ingresando "npm install" se instalaran las dependencias necesarias para correr el proyecto (Asegurarse de descargar Node.js), luego de que las dependencias se instalen, se ingresa "npm run serve" esto levantara el frontend en el puerto 8080 en el localhost(http://localhost:8080), en caso de errores de que falte un modulo, por ejemplo: "axios", debera correr "npm install nombre_modulo", en este caso, "npm install axios".
  - Ya realizando estos pasos podra interactuar con la aplicacion web en el la pagina http://localhost:8080.
 
