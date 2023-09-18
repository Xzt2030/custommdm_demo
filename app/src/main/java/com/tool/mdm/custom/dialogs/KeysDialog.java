package com.tool.mdm.custom.dialogs;

import android.content.Context;

import com.custom.mdm.CustomAPI;
import com.tool.mdm.custom.R;

public class KeysDialog extends AbsBaseDialog {
    public KeysDialog(Context context) {
        super(context, R.layout.keys_dialog_view);
    }

    @Override
    void buttonClickAction(int id) {
        switch (id) {
            case R.id.btn_volume_enable:
                CustomAPI.setVolumeKey(true);
                break;
            case R.id.btn_volumme_disable:
                CustomAPI.setVolumeKey(false);
                break;
            case R.id.btn_back_enable:
                CustomAPI.setBackKey(true);
                break;
            case R.id.btn_back_disable:
                CustomAPI.setBackKey(false);
                break;
            case R.id.btn_home_enable:
                CustomAPI.setHomeKey(true);
                break;
            case R.id.btn_home_disable:
                CustomAPI.setHomeKey(false);
                break;
            case R.id.btn_recent_enable:
                CustomAPI.setRecentKey(true);
                break;
            case R.id.btn_recent_disable:
                CustomAPI.setRecentKey(false);
                break;
            case R.id.btn_power_enable:
                CustomAPI.disablePowerKey(false);
                break;
            case R.id.btn_power_disable:
                CustomAPI.disablePowerKey(true);
                break;
        }
    }
}
