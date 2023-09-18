package com.tool.mdm.custom.dialogs;

import android.content.Context;

import com.custom.mdm.CustomAPI;
import com.tool.mdm.custom.R;

public class VolumeDialog extends AbsBaseDialog {
    public VolumeDialog(Context context) {
        super(context, R.layout.volume_dialog_view);
    }

    @Override
    void buttonClickAction(int id) {
        switch (id) {
            case R.id.btn_set_volume:
                int type = Integer.parseInt(getEditTest(R.id.et_volume_type));
                int volmue = Integer.parseInt(getEditTest(R.id.et_volume));
                int flags = Integer.parseInt(getEditTest(R.id.et_volume_flags));
                CustomAPI.setVolume(type, volmue, flags);
                break;
            case R.id.btn_get_volume:
                int getType = Integer.parseInt(getEditTest(R.id.et_volume_type));
                CustomAPI.getVolume(getType);
                break;
        }
    }
}
