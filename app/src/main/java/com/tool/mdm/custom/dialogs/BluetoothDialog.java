package com.tool.mdm.custom.dialogs;

import android.content.Context;

import com.custom.mdm.CustomAPI;
import com.tool.mdm.custom.R;

public class BluetoothDialog extends AbsBaseDialog {
    public BluetoothDialog(Context context) {
        super(context, R.layout.bluetooth_dialog);
    }

    @Override
    void buttonClickAction(int id) {
        switch (id) {
            case R.id.btn_set_bluetooth_enable:
                CustomAPI.setBluetoothEnabled(true);
                break;
            case R.id.btn_set_bluetooth_disable:
                CustomAPI.setBluetoothEnabled(false);
                break;
            case R.id.btn_open_bluetooth:
                CustomAPI.enabledBluetooth(true);
                break;
            case R.id.btn_forbidden_bluetooth:
                CustomAPI.setBluetoothEnabled(false);
                CustomAPI.enabledBluetooth(false);
                break;
        }
    }
}
