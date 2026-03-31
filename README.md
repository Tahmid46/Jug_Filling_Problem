# Jug Filling Problem

A Java application that solves the classic **Water Jug Problem** using **Breadth-First Search (BFS)** to find the shortest sequence of steps.

## Problem Description

You have two water jugs:
- A **3-liter** jug (no markings)
- A **5-liter** jug (no markings)

You also have access to a running tap. Using only these two jugs and the tap, you must measure **exactly 4 liters** of water.

Allowed operations:
1. Fill either jug completely from the tap
2. Empty either jug
3. Pour water from one jug into the other (until the source is empty or the destination is full)

## How It Works

The program models the problem as a **state-space search**:

- Each **state** represents the current water level in both jugs as `(x, y)`, where `x` is the amount in the 3-liter jug and `y` is the amount in the 5-liter jug.
- Starting from the initial state `(0, 0)` (both jugs empty), BFS explores all reachable states level by level.
- The goal state is `(3, 4)` — exactly 4 liters in the 5-liter jug (the 3-liter jug happens to be full as well).
- BFS guarantees the **shortest path** (fewest steps) to the solution.

### Classes

| Class | Description |
|---|---|
| `State` | Represents a `(x, y)` state and generates all possible next states from a given state |
| `BFS` | Implements Breadth-First Search to find the shortest path from the initial state to the goal |
| `Jug_Filling_Problem` | Entry point — creates the initial state, runs BFS, and prints the solution |

### Solution Steps

The expected solution (one of possibly several) is:

1. Fill the 5-liter jug → `(0, 5)`
2. Pour from 5-liter into 3-liter → `(3, 2)`
3. Empty the 3-liter jug → `(0, 2)`
4. Pour 2 liters from 5-liter into 3-liter → `(2, 0)`
5. Fill the 5-liter jug → `(2, 5)`
6. Fill remaining space in 3-liter from 5-liter → `(3, 4)` ✓

**Result:** 4 liters in the 5-liter jug.

## Prerequisites

- **Java Development Kit (JDK) 8 or higher**
- **Apache Ant** (for building with the provided `build.xml`)
  - Or an IDE such as **NetBeans** (the project was created with NetBeans)

## How to Build and Run

### Option 1: Using Apache Ant

```bash
# Build the project
ant build

# Run the project
ant run
```

### Option 2: Using NetBeans IDE

1. Open NetBeans IDE.
2. Go to **File → Open Project** and select the `Jug_Filling_Problem` folder.
3. Click the **Run** button (or press `F6`).

### Option 3: Manual Compilation with javac

```bash
# Compile
javac -d build/classes src/jug_filling_problem/*.java

# Run
java -cp build/classes jug_filling_problem.Jug_Filling_Problem
```

## Expected Output

```
Solution Found !
00
05
32
02
20
25
34
```

Each line represents a state `(x)(y)` — the water level in the 3-liter jug followed by the water level in the 5-liter jug. The final state `34` means 3 liters in the 3-liter jug and **4 liters in the 5-liter jug**, which is the required measurement.

## Project Structure

```
Jug_Filling_Problem/
├── src/
│   └── jug_filling_problem/
│       ├── Jug_Filling_Problem.java   # Main entry point
│       ├── BFS.java                   # BFS algorithm implementation
│       └── State.java                 # State representation and transitions
├── build/                             # Compiled class files (generated)
├── build.xml                          # Ant build script
├── manifest.mf                        # JAR manifest file
├── nbproject/                         # NetBeans project configuration
└── Problem Statement.txt              # Original problem description
```
