import java.util.ArrayList;

public class ComponentDatabase {

    public static ArrayList<Component> getComponents() {

        ArrayList<Component> components = new ArrayList<>();

        components.add(new Component(
                "DHT11",
                "Sensor",
                "Measures temperature and humidity",
                "VCC, DATA, GND",
                "Weather monitoring, IoT projects",
                "Low cost and easy to use"
        ));

        components.add(new Component(
                "MQ-2",
                "Gas Sensor",
                "Detects smoke and combustible gases",
                "VCC, GND, A0, D0",
                "Gas leakage and smoke detection",
                "Useful for safety systems"
        ));

        components.add(new Component(
                "HC-SR04",
                "Ultrasonic Sensor",
                "Measures distance using ultrasonic waves",
                "VCC, Trig, Echo, GND",
                "Obstacle detection, robotics",
                "Non-contact distance measurement"
        ));

        components.add(new Component(
                "ESP32",
                "Microcontroller",
                "Controls electronic devices and provides Wi-Fi/Bluetooth",
                "Multiple GPIO pins",
                "IoT, robotics, automation",
                "Built-in Wi-Fi and Bluetooth"
        ));

        components.add(new Component(
                "LED",
                "Output Device",
                "Produces light when current flows through it",
                "Anode, Cathode",
                "Indicators, displays, lighting",
                "Low power consumption"
        ));

        components.add(new Component(
                "Servo Motor",
                "Actuator",
                "Provides controlled angular movement",
                "VCC, GND, Signal",
                "Robotics, automation",
                "Precise position control"
        ));

        components.add(new Component(
                "MPU6050",
                "Motion Sensor",
                "Measures acceleration and angular motion",
                "VCC, GND, SDA, SCL",
                "Drones, robotics, motion detection",
                "Combines accelerometer and gyroscope"
        ));

        return components;
    }
}