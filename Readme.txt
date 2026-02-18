CAFETERÍA DIGITAL - MVC
Autor: Jose
Versión: 1.0

DESCRIPCIÓN
-----------
Aplicación de consola desarrollada en Java siguiendo el patrón MVC.
Permite gestionar productos, pedidos y pagos con tarjeta.

REQUISITOS
----------
- Java JDK 21 o superior
- Maven instalado

COMPILACIÓN
-----------
Desde la raíz del proyecto ejecutar:

    mvn clean compile

EJECUCIÓN
---------
Desde la raíz del proyecto ejecutar:

    mvn exec:java

O ejecutar la clase:

    CafeteriaDig.Main

desde el IDE.

GENERAR JAVADOC
---------------
Desde la raíz del proyecto ejecutar:

    javadoc -d doc src/main/java/**/*.java

La documentación se genera en la carpeta /doc.

ESTRUCTURA DEL PROYECTO
-----------------------
Modelo  -> Clases de dominio (Producto, Pedido, Pagar)
Logica  -> Clase Cafeteria (lógica de negocio)
Vista   -> Interfaz de usuario CLI
Utils   -> Clase InputReader

