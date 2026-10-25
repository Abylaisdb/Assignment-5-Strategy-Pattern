package navigation;

public class CarStrategy implements RouteStrategy {

    private static final double ROAD_DETOUR_FACTOR = 1.3;
    private static final double AVERAGE_CITY_SPEED_KMH = 40.0;

    @Override
    public Route buildRoute(Location from, Location to) {
        double distanceKm = GeoMath.straightLineKm(from, to) * ROAD_DETOUR_FACTOR;
        int minutes = GeoMath.minutesFor(distanceKm, AVERAGE_CITY_SPEED_KMH);
        return new Route("Car", distanceKm, minutes,
                "Drive from " + from.name() + " to " + to.name() + " via main roads");
    }
}
