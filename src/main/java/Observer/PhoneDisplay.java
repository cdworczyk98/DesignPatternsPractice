package Observer;

public class PhoneDisplay {

    public void update(float temperature, float humidity) {
        System.out.println("[Phone] Temp: " + temperature + "C, Humidity: " + humidity + "%");
    }

}
