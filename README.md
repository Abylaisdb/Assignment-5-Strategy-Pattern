# Strategy Pattern — Navigator / Route Planning

Assignment #5
Abylai Duisim (SE-2530). Java 17.

A `Navigator` (Context) plans a route using interchangeable `RouteStrategy` implementations
(car, walk, cycle, public transport). The strategy can be switched at runtime.

## Structure

```
src/navigation/
├── RouteStrategy.java           # Strategy interface
├── CarStrategy.java             # Concrete strategies
├── WalkStrategy.java
├── CycleStrategy.java
├── PublicTransportStrategy.java
├── Navigator.java               # Context (only delegates)
├── Main.java                    # Client (demo + interactive mode)
├── Location.java, Route.java    # data records
└── GeoMath.java                 # shared distance/time helper
```

## Build and run

```bash
mkdir out
javac -d out src/navigation/*.java
java -cp out navigation.Main
```

In interactive mode type `car`, `walk`, `cycle`, `bus` or `exit`.
Or open the folder in IntelliJ IDEA (JDK 17), mark `src` as Sources Root and run `Main`.

## How to add a new strategy

1. Create `src/navigation/ScooterStrategy.java` that `implements RouteStrategy`.
2. Register it in `Main`: `strategies.put("scooter", new ScooterStrategy());`
3. `Navigator` and the existing strategies are not modified.
   (`PublicTransportStrategy` was added exactly this way — see the commit history.)

## Sample output

```
car   -> [Car] 5.7 km, ~8 min
walk  -> [Walk] 5.0 km, ~60 min
cycle -> [Cycle] 5.2 km, ~21 min
bus   -> [Public transport] 6.1 km, ~23 min
```
