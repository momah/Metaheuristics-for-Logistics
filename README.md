# 🚚📦 Metaheuristics for Logistics 🚛🛤

This repository explores the application of metaheuristics to tackle challenging logistics problems, such as the BPP (Container Loading Problem) and VRP (Vehicle Routing Problem).

## 📋 Problem Descriptions

### 1. BPP (Container Loading Problem)
The Container Loading Problem involves optimizing the three-dimensional packing of rectangular objects into a large container. The goal is to maximize some criteria while adhering to a set of constraints. While this repository focuses on one-dimensional solutions, it's important to consider the container's area and objects with area and priority.

### 2. VRP (Vehicle Routing Problem)
The Vehicle Routing Problem is a combinatorial optimization problem widely encountered in logistics. It involves efficiently serving geographically dispersed customers with vehicles departing from a central depot. The objective is to minimize transportation costs, with a focus on a single vehicle. This problem is akin to the STP but with a double-directed graph and different weights/costs between vertices.

## 🧩 Development

The code is designed for extensibility and ease of future growth. It employs abstract structures and design patterns to facilitate the creation of new problem types, concrete problems, and metaheuristics.

## 🧬 Algorithms

### 1. Local Search
Local search iteratively explores neighboring solutions, selecting improved ones. This repository employs HillClimbing with two variations for each problem:
- FirstImprovement: For BPP, the algorithm stops when it finds an improving solution.
- BestImprovement: For VRP, it explores all possible neighboring solutions and selects the best.

### 2. Simulated Annealing
Simulated Annealing is a probabilistic local search algorithm that allows moves to worse solutions. It gradually reduces the probability of accepting worse solutions to balance exploration and exploitation.

### 3. Tabu Search
Tabu Search uses memory to improve performance. It avoids revisiting the same search areas by maintaining a short-term memory of solutions.

### 4. Greedy (Randomized)
The Greedy algorithm iteratively selects a random neighbor and replaces the current solution if an improvement is found.

### 5. GRASP (Greedy Randomized Adaptive Search Procedure)
GRASP combines greedy construction with local search to tackle combinatorial optimization problems. It randomly selects elements from a candidate list to build solutions.

## 🔬 Experimentation and Results Analysis

### 4.1. Problem Instances
- Instances for BPP: Two types - input from files and randomly generated.
- Instances for VRP: Vary in the number of cities.

### 4.2. Results
- Simulated Annealing proved effective in optimizing container size but with lower package priority.
- Greedy excelled at prioritizing packages and optimizing container size.
- GRASP provided a slightly improved solution for time and distance between two versions.

### 4.3. Results Analysis
- For BPP, Simulated Annealing excelled in optimizing the container size.
- For VRP, HillClimbing executed much faster than Simulated Annealing and yielded a competitive solution in terms of distance between nodes.

The choice of metaheuristic depends on various factors, including problem objectives and constraints. Different metaheuristics perform differently for different problems, and there's no one-size-fits-all solution.

## :busts_in_silhouette: Authors
This proyect is a modified copy from the original author. Done by:
- Laura Inés González González
- Eduardo Barrios García
- Paula Regalado De León
