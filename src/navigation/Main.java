package navigation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Location from = new Location("Astana IT University", 51.0900, 71.4180);
        Location to = new Location("Baiterek", 51.1283, 71.4305);

        Map<String, RouteStrategy> strategies = new LinkedHashMap<>();
        strategies.put("car", new CarStrategy());
        strategies.put("walk", new WalkStrategy());
        strategies.put("cycle", new CycleStrategy());
        strategies.put("bus", new PublicTransportStrategy());

        Navigator navigator = new Navigator(strategies.get("car"));
        System.out.println("=== Runtime strategy switching ===");
        for (Map.Entry<String, RouteStrategy> entry : strategies.entrySet()) {
            navigator.setStrategy(entry.getValue());
            System.out.println(entry.getKey() + " -> " + navigator.planRoute(from, to));
        }

        System.out.println("\n=== Interactive mode ===");
        System.out.println("Available modes: " + strategies.keySet() + "  (type 'exit' to quit)");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Choose mode: ");
            if (!scanner.hasNextLine()) {
                break;
            }
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("exit")) {
                break;
            }
            RouteStrategy chosen = strategies.get(input);
            if (chosen == null) {
                System.out.println("Unknown mode. Try: " + strategies.keySet());
                continue;
            }
            navigator.setStrategy(chosen);
            System.out.println(navigator.planRoute(from, to));
        }
    }
}
