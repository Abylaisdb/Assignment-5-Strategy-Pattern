package navigation;

public class PublicTransportStrategy implements RouteStrategy {

    private static final double BUS_ROUTE_DETOUR_FACTOR = 1.4;
    private static final double BUS_SPEED_KMH = 25.0;
    private static final int AVERAGE_WAIT_MINUTES = 8;

    @Override
    public Route buildRoute(Location from, Location to) {
        double distanceKm = GeoMath.straightLineKm(from, to) * BUS_ROUTE_DETOUR_FACTOR;
        int minutes = GeoMath.minutesFor(distanceKm, BUS_SPEED_KMH) + AVERAGE_WAIT_MINUTES;
        return new Route("Public transport", distanceKm, minutes,
                "Take a bus from " + from.name() + " to " + to.name() + " (includes waiting time)");
    }
}
