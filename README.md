# 🚚📦 Metaheuristics for Logistics 🚛🛤

Este repositorio explora la aplicación de metaheurísticas para abordar problemas logísticos desafiantes, como el BPP (Container Loading Problem) y el VRP (Vehicle Routing Problem).

## 📋 Descripción de problemas

### 1. BPP (Problema de Carga de Contenedores)
El problema de carga de contenedores consiste en optimizar el embalaje tridimensional de objetos rectangulares en un gran contenedor. El objetivo es maximizar algunos criterios mientras se adhiere a un conjunto de restricciones. Aunque este repositorio se centra en soluciones unidimensionales, es importante considerar el área del contenedor y los objetos con área y prioridad.

### 2. VRP (Problema de enrutamiento de vehículos)
El Problema de Enrutamiento de Vehículos es un problema de optimización combinatoria ampliamente encontrado en logística. Consiste en servir eficientemente a clientes geográficamente dispersos con vehículos que parten de un depósito central. El objetivo es minimizar los costes de transporte, centrándose en un único vehículo. Este problema es similar al STP pero con un grafo de doble dirección y diferentes pesos/costes entre vértices.

## 🧩 Desarrollo

El código está diseñado para la extensibilidad y la facilidad de crecimiento futuro. Emplea estructuras abstractas y patrones de diseño para facilitar la creación de nuevos tipos de problemas, problemas concretos y metaheurísticas.

El estado del proyecto desde SonarCloud puede revisarse en el siguiente enlace: [SonarCloud Metaheuristics for Logistics Lab](https://sonarcloud.io/organizations/metaheuristics-for-logistics-lab/projects)


## 🧬 Algoritmos

### 1. Búsqueda local
La búsqueda local explora iterativamente las soluciones vecinas, seleccionando las mejoradas. Este repositorio emplea HillClimbing con dos variaciones para cada problema:
- FirstImprovement: Para BPP, el algoritmo se detiene cuando encuentra una solución que mejora.
- BestImprovement: Para VRP, explora todas las posibles soluciones vecinas y selecciona la mejor.

### 2. Simulated Annealing
El Simulated Annealing es un algoritmo probabilístico de búsqueda local que permite pasar a soluciones peores. Reduce gradualmente la probabilidad de aceptar soluciones peores para equilibrar la exploración y la explotación.

### 3. Búsqueda Tabu
La búsqueda Tabu utiliza la memoria para mejorar el rendimiento. Evita volver a visitar las mismas áreas de búsqueda manteniendo una memoria de soluciones a corto plazo.

### 4. Greedy (aleatorio)
El algoritmo Greedy selecciona iterativamente un vecino aleatorio y reemplaza la solución actual si se encuentra una mejora.

### 5. GRASP (Procedimiento de Búsqueda Adaptativa Aleatoria Greedy)
GRASP combina la construcción greedy con la búsqueda local para abordar problemas de optimización combinatoria. Selecciona aleatoriamente elementos de una lista de candidatos para construir soluciones.

## 🔬 Experimentación y Análisis de Resultados

### 4.1. Instancias del problema
- Instancias para BPP: Dos tipos - entrada desde ficheros y generadas aleatoriamente.
- Instancias para VRP: Varían en el número de ciudades.

### 4.2. Resultados
- Simulated Annealing demostró ser eficaz en la optimización del tamaño de los contenedores, pero con una menor prioridad de los paquetes.
- Greedy destacó en la priorización de paquetes y en la optimización del tamaño del contenedor.
- GRASP proporcionó una solución ligeramente mejorada para el tiempo y la distancia entre dos versiones.

### 4.3. Análisis de resultados
- Para BPP, Simulated Annealing sobresalió en la optimización del tamaño del contenedor.
- Para VRP, HillClimbing se ejecutó mucho más rápido que Simulated Annealing y dio una solución competitiva en términos de distancia entre nodos.

La elección de la metaheurística depende de varios factores, como los objetivos y las restricciones del problema. Cada metaheurística funciona de forma distinta según el problema y no existe una solución única para todos.

## :busts_in_silhouette: Autores
Este proyecto es una copia modificada del autor original. Realizado por:
- Laura Inés González González
- Eduardo Barrios García
- Paula Regalado De León
