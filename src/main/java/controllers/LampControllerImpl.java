package controllers;

import exceptions.LampException;

public class LampControllerImpl implements LampController{

    private boolean redOn = false;
    private boolean whiteOn = false;


    @Override
    public void lampOn() throws LampException {
        if(redOn == false && whiteOn == false) {
            try {
                LampDriver.redOn();
                redOn = true;
            } catch (Exception e){
                throw new LampException(e.getMessage());
            }
        }
    }

    @Override
    public void whiteOn() throws LampException {
        if(redOn == true){
            if(whiteOn == false) {
                try {
                    LampDriver.whiteOn();
                    redOn = false;
                    whiteOn = true;
                } catch (Exception e) {
                    throw new LampException(e.getMessage());
                }
            }
        }
    }

    @Override
    public void whiteOff() throws LampException {
        if(whiteOn == true){
            try {
                LampDriver.redOn();
                whiteOn = false;
                redOn = true;
            } catch (Exception e){
                throw new LampException(e.getMessage());
            }
        }
    }

    @Override
    public void flashOn() throws LampException {
        if(redOn == true){
            try {
                LampDriver.redFlash();
            } catch (Exception e){
                throw new LampException(e.getMessage());
            }
        } else if(whiteOn == true){
            try {
                LampDriver.whiteFlash();
            } catch (Exception e){
                throw new LampException(e.getMessage());
            }
        }
    }

    @Override
    public void lampOff() throws LampException {
        if(redOn == true || whiteOn == true){
            try {
                LampDriver.ledOff();
                redOn = false;
                whiteOn = false;
            } catch (Exception e){
                throw new LampException(e.getMessage());
            }
        }
    }
}
