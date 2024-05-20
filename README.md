# Proyecto Final Cubo Olap Grupo 9

## Configuracion
Definir la estructura para guardar toda la data necesaria para cargar el cubo
* urls de los archivos csv
* nombres para los archivos
* tipos de datos para las columnas de cada uno
* jerarquias de las dimensiones
* los hechos se manejan aparate
* definir los metricas asociadas a los hechos (suma, count, promedio, min, max) (ENUM)
* guardar las medidas asociadas a los tabla de hechos(4)
* metodos para obtener la info
* un contructor.

## Dimension
Definir la estrutura para manejar toda la informacion
* contructor para crear la dimension: completo e incompleto.
* datos necesarios para un dimension: nombre, tabla, jeraquias.
* tipos de datos asociados: nombre-columna -> tipo dato
* tipo de dato en ENUM
* getters de la data de la dimension.

## Cubo
* Hechos
* lista de dimensiones
* metodos asociados: (crear proyeccion)
* crear metodo para cargar toda la informacion recibida por la configuracion.

# En todos los casos hay que crear semi Historias de Usuario y anotar los problemas e inconvenientes que vayan surgiendo.

constructor vacio, que inicialice los tipos de datos de la clase, un constructor que use inicial, y modificque.
