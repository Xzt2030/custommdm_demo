package com.tool.mdm.custom.dialogs;

import android.content.Context;

import com.custom.mdm.CustomAPI;
import com.tool.mdm.custom.R;

public class RotationDialog extends AbsBaseDialog {
    public RotationDialog(Context context) {
        super(context, R.layout.rotation_dialog_view);
    }

    @Override
    void buttonClickAction(int id) {
        switch (id) {
            case R.id.btn_auto_rotation:
                CustomAPI.autoRotations(true);
                break;
            case R.id.btn_lock_rotation:
                CustomAPI.autoRotations(false);
                break;
            case R.id.btn_lock_landscape:
                CustomAPI.lockLandscape();
                break;
        }
    }
}
