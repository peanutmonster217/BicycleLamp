package controllers;

import enums.LightButtonPress;
import enums.OnButtonPress;
import exceptions.LampException;

public class ButtonControllerImpl implements ButtonController{

    OnButtonPress onButtonPress = OnButtonPress.OFF;
    LightButtonPress lightButtonPress = LightButtonPress.RED;
    LampController lampController = new LampControllerImpl();

    //Each button press changes the Enum to reflect the current state of the lamp
    @Override
    public void buttonOnePress() throws LampException {
        if(onButtonPress.equals(OnButtonPress.OFF)){
            lampController.lampOn();
            onButtonPress = OnButtonPress.PRESS_1;
        } else if(onButtonPress.equals(OnButtonPress.PRESS_1)){
            lampController.flashOn();
            onButtonPress = OnButtonPress.PRESS_2;
        } else if(onButtonPress.equals(OnButtonPress.PRESS_2)){
            lampController.lampOff();
            onButtonPress = OnButtonPress.OFF;
        }
    }

    //cycles through the current colours in the Enum - separate implementations required for both methods in case of lamps
    //with different states and colours
    @Override
    public void buttonTwoPress() throws LampException {
        if (lightButtonPress.equals(LightButtonPress.RED)) {
            lampController.whiteOn();
            lightButtonPress = LightButtonPress.WHITE;
        } else if (lightButtonPress.equals(LightButtonPress.WHITE)) {
            lampController.whiteOff();
            lightButtonPress = LightButtonPress.RED;
        }
    }
}
