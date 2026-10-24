package navigation;

public record Route(String travelMode, double distanceKm, int durationMinutes, String description) {

    @Override
    public String toString() {
        return String.format("[%s] %.1f km, ~%d min | %s", travelMode, distanceKm, durationMinutes, description);
    }
}
