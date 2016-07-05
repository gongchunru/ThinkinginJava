package com.java.innerclasses.controller;

/**
 * @author gongchunru
 * @Package com.java.innerclasses.controller
 * @date 16/6/29 12:55
 */
public class GreenhouseControls extends Controller {

    private boolean light = false;

    public class LightOn extends Event{
        public LightOn(long delayTime ){super(delayTime);}
        public void action(){
            light = true;
        }
        public String toString(){return "light is on";}
    }

    public class LightOff extends Event{
        public LightOff(long delayTime){super(delayTime);}
        public void action(){
            light = false;
        }
        public String toString(){return "light is off";}
    }

    private boolean water = false;

    public class WaterOn extends Event{
        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = true;
        }
        public String toString (){
            return "Greenhouse water is on";
        }
    }

    public class WaterOff extends Event{
        public WaterOff(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            water = false;
        }
        public String toString(){
            return "GreenHouse water is off";
        }
    }

    private String thermostat = "Day";

    public class ThermostatNight extends Event{
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Night";
        }
        public String toString(){
            return "thermostat on night setting";
        }
    }

    public class ThermostatDay extends Event{
        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Day";
        }

        public String toString(){
            return "ThermostatDay on day setting";
        }
    }

    //在事件列表中创建一个新的时间插入进入,
    public class Bell extends Event{
        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }
        public String toString(){return "Bing!";}
    }

    public class Restart extends Event{
        private Event[] eventList;
        public Restart(long delayTime,Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            for (Event e:eventList){
                addEvent(e);
            }
        }

        @Override
        public void action() {
            for (Event e:eventList){
                e.start();
                addEvent(this);
            }
            start();
            addEvent(this);
        }

        public String toString(){
            return "Restarting system";
        }
    }

    public static class Terminate extends Event{
        public Terminate(long delayTime) {
            super(delayTime);
        }
        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Termination";
        }
    }


}
