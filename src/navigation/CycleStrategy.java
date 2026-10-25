package navigation;

public class CycleStrategy implements RouteStrategy {

    private static final double BIKE_LANE_DETOUR_FACTOR = 1.2;
    private static final double CYCLING_SPEED_KMH = 15.0;

    @Override
    public Route buildRoute(Location from, Location to) {
        double distanceKm = GeoMath.straightLineKm(from, to) * BIKE_LANE_DETOUR_FACTOR;
        int minutes = GeoMath.minutesFor(distanceKm, CYCLING_SPEED_KMH);
        return new Route("Cycle", distanceKm, minutes,
                "Cycle from " + from.name() + " to " + to.name() + " along bike lanes");
    }
}
