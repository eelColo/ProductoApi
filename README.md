##  Producto Api

Api rest de gestion de productos basica.


![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)  ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)  ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)


#### Instalacion

- Copiar el SSH y clonar en local con git clone

- Dentro encontraras un archivo .sql ejecutalo para iniciar la base de datos.

- Deberan abrir su ide de preferencia y seleccionar el proyecto.

- Seleccionar el proyecto en el Boot dashboard e iniciarlo, spring se encargara de levantar el tomcat.


#### Uso

La api cumple funciones basicas para administrar productos, para comprobarlas una vez el proyecto este inicializado simplemente utilizamos las siguientes peticiones en **PostMan**:

- Creacion **POST /producto**
- Borrado **DELETE /producto/{:id}**
- Edicion **PUT /producto/{id}**
- Listar producto por id **GET /producto/{id}**
- Listar todos los productos por precio **GET /productoporprecio**

