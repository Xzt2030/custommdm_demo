package com.tool.mdm.custom.dialogs;

import android.content.Context;

import com.custom.mdm.CustomAPI;
import com.tool.mdm.custom.R;

public class SystemModeDialog extends AbsBaseDialog {
    public SystemModeDialog(Context context) {
        super(context, R.layout.system_mode_dialog_view);
    }

    @Override
    void buttonClickAction(int id) {
        switch (id) {
            case R.id.btn_safe_mode:
                CustomAPI.setDebugMode(false);
                break;
            case R.id.btn_unsafe_mode:
                CustomAPI.setDebugMode(true);
                break;
        }
    }
}
