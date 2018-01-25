package com.example.mikhan808.svarka;

/**
 * Created by МишаИОля on 08.01.2018.
 */

public class Preset {
    public static final int NAME = 0;
    public static final int FIRST_LEVEL = 1;
    public static final int SECOND_LEVEL = 2;
    public static final int DURATION = 3;
    public static final int PRESSURE = 4;
    public static final String[] elements = {"name", "first_level", "second_level", "duration", "pressure"};
    String name;
    int first_level;
    int second_level;
    int duration;
    int pressure;

    public Object getObjectOfNumber(int number) {
        switch (number) {
            case NAME:
                return getName();
            case FIRST_LEVEL:
                return getFirst_level();
            case SECOND_LEVEL:
                return getSecond_level();
            case DURATION:
                return getDuration();
            case PRESSURE:
                return getPressure();
            default:
                return null;
        }
    }

    public void setObjectOfNumber(int number, Object object) {
        switch (number) {
            case NAME:
                setName((String) object);
                break;
            case FIRST_LEVEL:
                setFirst_level((int) object);
                break;
            case SECOND_LEVEL:
                setSecond_level((int) object);
                break;
            case DURATION:
                setDuration((int) object);
                break;
            case PRESSURE:
                setPressure((int) object);
                break;
            default:
                break;
        }
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getFirst_level() {
        return first_level;
    }

    public void setFirst_level(int first_level) {
        this.first_level = first_level;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getSecond_level() {
        return second_level;
    }

    public void setSecond_level(int second_level) {
        this.second_level = second_level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
