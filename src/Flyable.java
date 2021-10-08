public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
    String getName();
    long getId();
    String getType();
}
