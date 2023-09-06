package ex01;

public class ForecastDisplay implements DisplayElement, Observer {
	private float humidity;
	private WeatherData weatherData;
	private int isRain = 0; // 0: NA, 1: rain, 2: sunny

	public ForecastDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this);
	}
	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.humidity = humidity;
		display();
	}
	
	@Override
	public void display() {
		if (humidity < 70) {
			if (isRain == 2) {
				System.out.println("지금과 비슷할 것 같습니다.");				
			}
			else {
				System.out.println("날씨가 좋아지고 있습니다.");	
			}
			isRain = 2;
		}
		else if (humidity >= 70) {
			if (isRain == 1) {
				System.out.println("지금과 비슷할 것 같습니다.");				
			}
			else {
				System.out.println("비가 올 것 같습니다.");	
			}
			isRain = 1;
		}
	}
}
