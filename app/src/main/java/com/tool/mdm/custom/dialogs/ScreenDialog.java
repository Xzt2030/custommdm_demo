package com.tool.mdm.custom.dialogs;

import android.content.Context;
import android.widget.Toast;

import com.custom.mdm.CustomAPI;
import com.tool.mdm.custom.R;
import com.tool.mdm.custom.Utils.Util;

public class ScreenDialog extends AbsBaseDialog {
    public ScreenDialog(Context context) {
        super(context, R.layout.screen_dialog_view);
    }

    @Override
    void buttonClickAction(int id) {
        switch (id) {
            case R.id.btn_set_brightness:
                String brightnessS = getEditTest(R.id.et_set_brightness);
                if (Util.checkStringIsNull(brightnessS)) {
                    Toast.makeText(mContext, "Recommended value: 10-255", Toast.LENGTH_SHORT).show();
                } else {
                    int brightness = Integer.parseInt(brightnessS);
                    if (brightness < 10 || brightness > 255) {
                        Toast.makeText(mContext, "Suggestion value: 10-255", Toast.LENGTH_SHORT).show();
                    } else {
                        CustomAPI.setScreenBrightness(brightness);
                    }
                }
                break;
            case R.id.btn_get_brightness:
                Toast.makeText(mContext, "" + CustomAPI.getScreenBrightness(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_set_screen_timeout:
                String timeoutS = getEditTest(R.id.et_set_screen_timeout);
                if (Util.checkStringIsNull(timeoutS)) {
                    Toast.makeText(mContext, "Recommended value: 10-18000000", Toast.LENGTH_SHORT).show();
                } else {
                    int screentimeout = Integer.parseInt(timeoutS);
                    if (screentimeout < 10 || screentimeout > 18000000){
                        Toast.makeText(mContext, "Recommended value: 10-18000000", Toast.LENGTH_SHORT).show();
                    }
                    CustomAPI.setScreenTimeOut(screentimeout);
                }
                break;
            case R.id.btn_get_screen_timeout:
                Toast.makeText(mContext, "" + CustomAPI.getScreenTimeOut(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_lock_screen:
                CustomAPI.sleep();
                break;
        }
    }
}
