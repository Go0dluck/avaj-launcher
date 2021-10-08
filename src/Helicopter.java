public class Helicopter extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions(){
        String getWeather = weatherTower.getWeather(coordinates);
        switch (getWeather){
            case ("RAIN"):
                //System.out.println(getType() + "#" + getName() + "(" + getId() + "): Heck! I can't see anything because of this rain !");
                Message.write(getType() + "#" + getName() + "(" + getId() + "): Heck! I can't see anything because of this rain !\n");
                coordinates.setLongitude(coordinates.getLongitude() + 5);
                break;
            case ("FOG"):
                //System.out.println(getType() + "#" + getName() + "(" + getId() + "): What a nightmare of fog, you can't see anything !");
                Message.write(getType() + "#" + getName() + "(" + getId() + "): What a nightmare of fog, you can't see anything !\n");
                coordinates.setLongitude(coordinates.getLongitude() + 1);
                break;
            case ("SUN"):
//                System.out.println(getType() + "#" + getName() + "(" + getId() + "): Finally, the beautiful weather !");
                Message.write(getType() + "#" + getName() + "(" + getId() + "): Finally, the beautiful weather !\n");
                coordinates.setLongitude(coordinates.getLongitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                if (coordinates.getHeight() > 100)
                    coordinates.setHeight(100);
                break;
            case ("SNOW"):
//                System.out.println(getType() + "#" + getName() + "(" + getId() + "): Brrrrr how cold it is here !");
                Message.write(getType() + "#" + getName() + "(" + getId() + "): Brrrrr how cold it is here !\n");
                coordinates.setHeight(coordinates.getHeight() - 12);
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
        return "Helicopter";
    }

    public long getId(){
        return super.getId();
    }
}
