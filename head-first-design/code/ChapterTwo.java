
// 自行实现观察者模式
import java.util.ArrayList;

/**
 * 被观察者接口
 * 
 * 问：为什么要设立被观察者接口？
 * 答：不同的数据源有不同的被观察者，但注册，移除，通知是必要存在的动作，所以抽象一个接口作为规范
 * 
 * 问：能不能用抽象类来定义？
 * 答：可以，但是会导致被观察者类无法继承别的超类，限制性大
 */
interface Subject {
  // 组册观察者
  public void registerObserver(Observer o);

  // 移除观察者
  public void removeObserver(Observer o);

  // 通知观察者数据变更
  public void notifyObservers();
}

/**
 * 观察者共同依赖的方法，用于数据变更
 * 
 * 问：为什么要定义一个观察者接口？
 * 答：因为要在被观察者类中使用组合，被观察者并不在意具体的观察者是什么，只需要知道他实现了数据更新接口
 */
interface Observer {
  public void update(float temp, float humidity, float pressure);
}

// 继承被观察者接口，被观察者类
class WeatherData implements Subject {
  // 用于记录已组册的观察者
  private ArrayList<Observer> observers = new ArrayList<Observer>();
  private float temperature;
  private float humidity;
  private float pressure;

  // 实现Subject接口
  public void registerObserver(Observer o) {
    observers.add(o);
  }

  // 实现Subject接口
  public void removeObserver(Observer o) {
    int i = observers.indexOf(o);
    if (i >= 0) {
      observers.remove(i);
    }
  }

  // 实现Subject接口
  public void notifyObservers() {
    for (int i = 0; i < observers.size(); i++) {
      Observer observer = (Observer) observers.get(i);
      observer.update(temperature, humidity, pressure);
    }
  }

  public void measurementsChanged() {
    notifyObservers();
  }

  public void setMeasurements(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;
    this.pressure = pressure;
    measurementsChanged();
  }
}

// 继承观察者接口
class CurrentConditionsDisplay implements Observer {
  private float temperature;
  private float humidity;
  // 保留该对象是为了可以退出观察者
  private Subject weatherData;

  // 组册成观察者
  CurrentConditionsDisplay(Subject weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  // 用于被观察者数据变更时自动触发的接口
  public void update(float temperature, float humidity, float pressure) {
    this.temperature = temperature;
    this.humidity = humidity;

    System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
  }
}

public class ChapterTwo {
  public static void main(String[] args) {
    WeatherData weatherData = new WeatherData();
    CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);

    weatherData.setMeasurements(80, 65, 30.4f);
    weatherData.setMeasurements(82, 70, 29.2f);
  }
}