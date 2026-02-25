package Observer.WeatheStation;

public class WeatherStation {

    private float temperature;
    private float humidity;

    private PhoneDisplay phoneDisplay; // tightly coupled: only one display

    public WeatherStation(PhoneDisplay phoneDisplay) {
        this.phoneDisplay = phoneDisplay;
    }

    public void setMeasurements(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;

        // hard-coded "push" to a single display
        phoneDisplay.update(temperature, humidity);
    }

}
