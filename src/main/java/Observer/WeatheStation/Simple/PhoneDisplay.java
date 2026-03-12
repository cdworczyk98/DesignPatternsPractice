package Observer.WeatheStation.Simple;

public class PhoneDisplay implements Observer {

    public void update(float temperature, float humidity) {
        System.out.println("[Phone] Temp: " + temperature + "C, Humidity: " + humidity + "%");
    }

}
