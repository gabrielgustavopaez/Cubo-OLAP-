# Proyecto Final Cubo Olap Grupo 9

## Configuraciones
Definir la estructura para guardar toda la data necesaria para cargar el cubo
* urls de los archivos csv
* nombres para los archivos
* tipos de datos para las columnas de cada uno
* jerarquias de las dimensiones
* los hechos se manejan aparate
* definir los metricas asociadas a los hechos (suma, count, promedio, min, max) (ENUM)
* guardar las medidas asociadas a los tabla de hechos(cantidad, valor_unitario, valor_total, costo)
* metodos para obtener la info
* un contructor.
* se divide en 3 Sub - Configuraciones: Configuracion Cubo, Configuracion Dimension, ***Configuracion Proyeccion***

## Dimension
Definir la estrutura para manejar toda la informacion
* contructor para crear la dimension: completo e incompleto.
* datos necesarios para un dimension: nombre, tabla, jeraquias.
* tipos de datos asociados: nombre-columna -> tipo dato
* tipo de dato en ENUM
* getters de la data de la dimension.
* funcion de informacion de dimension

## Cubo
* Hechos
* lista de dimensiones
* metodos asociados: (crear proyeccion)
* crear metodo para cargar toda la informacion recibida por la configuracion.
* metodo de informacion del estado del cubo.
* crear proyecciones -> pendientes.

## Proyecciones
* Deberia los argumentos necesarios para poder crear una proyeccion especifica del cubo.
* definir como proyectar o la firma del constructor


## ***En todos los casos hay que crear semi Historias de Usuario y anotar los problemas e inconvenientes que vayan surgiendo.***

constructor vacio, que inicialice los tipos de datos de la clase, un constructor que use inicial, y modificque.
