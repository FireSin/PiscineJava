package edu.school21.classes;

import java.util.StringJoiner;

public class Car {
    private String _model;
    private String _color;
    private int _power;

    public Car() {
        this._model = "Default model";
        this._color = "Default color";
        this._power = 0;
    }

    public Car(String _model, String _color, int _power) {
        this._model = _model;
        this._color = _color;
        this._power = _power;
    }

    public Integer powerUp(int value) {
        this._power += value;
        return _power;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Car.class . getSimpleName() + "[", "]")
                . add("_model='" + _model + "'")
                . add("_color='" + _color + "'")
                . add("_power=" + _power)
                . toString();
    }
}
