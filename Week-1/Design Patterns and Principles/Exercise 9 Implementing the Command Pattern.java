// Exercise 9: Implementing the Command Pattern
public class Exercise9_CommandPattern {

    public interface Command {
        void execute();
    }

    public static class Light {
        public void turnOn() {
            System.out.println("Light is ON");
        }
        public void turnOff() {
            System.out.println("Light is OFF");
        }
    }

    public static class LightOnCommand implements Command {
        private Light light;
        public LightOnCommand(Light light) { this.light = light; }
        @Override public void execute() { light.turnOn(); }
    }

    public static class LightOffCommand implements Command {
        private Light light;
        public LightOffCommand(Light light) { this.light = light; }
        @Override public void execute() { light.turnOff(); }
    }

    public static class RemoteControl {
        private Command command;
        public void setCommand(Command command) { this.command = command; }
        public void pressButton() {
            if (command != null) command.execute();
        }
    }

    public static void main(String[] args) {
        Light livingRoomLight = new Light();
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
