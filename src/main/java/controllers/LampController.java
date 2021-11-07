package controllers;

import exceptions.LampException;

public interface LampController {

    public void lampOn() throws LampException;

    public void whiteOn() throws LampException;

    public void whiteOff() throws LampException;

    public void flashOn() throws LampException;

    public void lampOff() throws LampException;


}
