# Mediana Calculator

Proyecto utilizado para el desafio de Diseño de Lenguaje de Consultas (DLC), 
materia de Universidad Tecnológica Nacional - Facultad Regional Córdoba.

El objetivo de dicho desafío es calcular la mediana parcial, leyendo los numeros
de un archivo.txt que contiene números enteros, utilizando dos Heaps para
lograr el calculo de la mediana parcial en tiempo logaritmico.

## Extra
Como extra al desafío agregue un menu para obtener la cantidad de numeros a procesar
para obtener la mediana parcial de dicho conjunto, y la utilización de otro algoritmo
más sencilo (y con tiempo lineal) para realizar la misma tarea.

## Conclusión
Como conclusión, el algoritmo que utiliza dos heaps, uno ascendente y otro descendente,
si bien es mas complejo, realiza el calculo en tiempos logaritmicos (como se indicó).
Pero utilizando un algoritmo mucho mas sencillo, usando un array auxiliar para
guardar los numeros del conjunto, y luego ordenandolos (incluso usando un bubble sort),
se logró procesar 100000 (cien mil) números en menos de un minuto, y calcular la mediana.
Claramente, cien mil números son muy pocos, por ende, no justifica utilizar el algoritmo
con heaps, salvo claro, que sea un requerimiento (como en el desafío desarrollado).