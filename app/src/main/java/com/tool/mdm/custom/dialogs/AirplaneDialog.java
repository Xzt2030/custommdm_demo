package com.tool.mdm.custom.dialogs;

import android.content.Context;

import com.custom.mdm.CustomAPI;
import com.tool.mdm.custom.R;

public class AirplaneDialog extends AbsBaseDialog {
    public AirplaneDialog(Context context) {
        super(context, R.layout.airplane_dialog_view);
    }

    @Override
    void buttonClickAction(int id) {
        switch (id) {
            case R.id.btn_airplane_enable:
                CustomAPI.setAirplaneMode(true);
                break;
            case R.id.btn_airplane_disable:
                CustomAPI.setAirplaneMode(false);
                break;
        }
    }
}
