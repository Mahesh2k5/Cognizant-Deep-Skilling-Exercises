import java.util.ArrayList;
import java.util.List;

// Exercise 7: Implementing the Observer Pattern
public class Exercise7_ObserverPattern {

    public interface Observer {
        void update(double price);
    }

    public interface Stock {
        void register(Observer o);
        void deregister(Observer o);
        void notifyObservers();
    }

    public static class StockMarket implements Stock {
        private List<Observer> observers = new ArrayList<>();
        private double price;

        public void setPrice(double price) {
            this.price = price;
            notifyObservers();
        }

        @Override
        public void register(Observer o) {
            observers.add(o);
        }

        @Override
        public void deregister(Observer o) {
            observers.remove(o);
        }

        @Override
        public void notifyObservers() {
            for (Observer o : observers) {
                o.update(price);
            }
        }
    }

    public static class MobileApp implements Observer {
        @Override
        public void update(double price) {
            System.out.println("MobileApp: Stock price updated to $" + price);
        }
    }

    public static class WebApp implements Observer {
        @Override
        public void update(double price) {
            System.out.println("WebApp: Stock price updated to $" + price);
        }
    }

    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        market.register(mobile);
        market.register(web);

        market.setPrice(150.0);
        market.setPrice(155.5);
    }
}
