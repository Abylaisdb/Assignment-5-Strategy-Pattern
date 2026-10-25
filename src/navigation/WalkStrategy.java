package navigation;

public class WalkStrategy implements RouteStrategy {

    private static final double PEDESTRIAN_DETOUR_FACTOR = 1.15;
    private static final double WALKING_SPEED_KMH = 5.0;

    @Override
    public Route buildRoute(Location from, Location to) {
        double distanceKm = GeoMath.straightLineKm(from, to) * PEDESTRIAN_DETOUR_FACTOR;
        int minutes = GeoMath.minutesFor(distanceKm, WALKING_SPEED_KMH);
        return new Route("Walk", distanceKm, minutes,
                "Walk from " + from.name() + " to " + to.name() + " using sidewalks and paths");
    }
}
