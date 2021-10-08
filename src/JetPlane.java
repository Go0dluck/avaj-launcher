public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions(){
        String getWeather = weatherTower.getWeather(coordinates);
        switch (getWeather){
            case ("RAIN"):
//                System.out.println(getType() + "#" + getName() + "(" + getId() + "): This rain we will quickly fly by");
                Message.write(getType() + "#" + getName() + "(" + getId() + "): This rain we will quickly fly by\n");
                coordinates.setLatitude(coordinates.getLatitude() + 5);
                break;
            case ("FOG"):
//                System.out.println(getType() + "#" + getName() + "(" + getId() + "): As long as you don't crash into anything in this fog");
                Message.write(getType() + "#" + getName() + "(" + getId() + "): As long as you don't crash into anything in this fog\n");
                coordinates.setLatitude(coordinates.getLatitude() + 1);
                break;
            case ("SUN"):
//                System.out.println(getType() + "#" + getName() + "(" + getId() + "): Here it is the perfect weather");
                Message.write(getType() + "#" + getName() + "(" + getId() + "): Here it is the perfect weather\n");
                coordinates.setLatitude(coordinates.getLatitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                if (coordinates.getHeight() > 100)
                    coordinates.setHeight(100);
                break;
            case ("SNOW"):
//                System.out.println(getType() + "#" + getName() + "(" + getId() + "): As long as the engine is not clogged with snow");
                Message.write(getType() + "#" + getName() + "(" + getId() + "): As long as the engine is not clogged with snow\n");
                coordinates.setHeight(coordinates.getHeight() - 7);
                break;
        }
        if (coordinates.getHeight() <= 0){
//            System.out.println(getType() + "#" + getName() + "(" + getId() + "): landing");
            Message.write(getType() + "#" + getName() + "(" + getId() + "): landing\n");
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }

    public String getName(){
        return super.getName();
    }

    public String getType() {
        return "JetPlane";
    }

    public long getId(){
        return super.getId();
    }
}
