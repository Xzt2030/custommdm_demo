package com.tool.mdm.custom.dialogs;

import android.content.Context;
import android.widget.Toast;

import com.custom.mdm.CustomAPI;
import com.tool.mdm.custom.R;
import com.tool.mdm.custom.Utils.Util;

public class TimeZoneDialog extends AbsBaseDialog {
    public TimeZoneDialog(Context context) {
        super(context, R.layout.timezone_dialog_view);
    }

    @Override
    void buttonClickAction(int id) {
        switch (id) {
            case R.id.btn_set_timezone:
                String timeZone = getEditTest(R.id.et_set_timezone);
                if (Util.checkStringIsNull(timeZone)) {
                    Toast.makeText(mContext, "timeZone is null\nEx: Asia/Shanghai", Toast.LENGTH_SHORT).show();
                } else {
                    CustomAPI.setTimeZone(timeZone);
                }
                break;
            case R.id.btn_get_timezone:
                Toast.makeText(mContext, CustomAPI.getTimeZone(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
