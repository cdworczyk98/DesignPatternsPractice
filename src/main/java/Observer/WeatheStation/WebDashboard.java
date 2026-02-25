package Observer.WeatheStation;

public class WebDashboard implements Observer {

    public void update(float temperature, float humidity) {
        System.out.println("[WebDashboard] Temp: " + temperature + "C, Humidity: " + humidity + "%");
    }

}
