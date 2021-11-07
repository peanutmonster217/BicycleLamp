package controllers;

import exceptions.LampException;

public interface ButtonController {

    public void buttonOnePress() throws LampException;

    public void buttonTwoPress() throws LampException;

}
