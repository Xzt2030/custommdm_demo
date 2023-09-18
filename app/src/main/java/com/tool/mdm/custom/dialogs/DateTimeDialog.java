package com.tool.mdm.custom.dialogs;

import android.content.Context;
import android.widget.Toast;

import com.custom.mdm.CustomAPI;
import com.tool.mdm.custom.R;
import com.tool.mdm.custom.Utils.Util;

public class DateTimeDialog extends AbsBaseDialog {
    public DateTimeDialog(Context context) {
        super(context, R.layout.date_time_dialog_view);
    }

    @Override
    void buttonClickAction(int id) {
        switch (id) {
            case R.id.btn_set_datetime:
                String dateTime = getEditTest(R.id.et_set_datetime);
                String dateFormate = getEditTest(R.id.et_set_date_formate);
                if (Util.checkStringIsNull(dateTime)) {
                    Toast.makeText(mContext, "dataTime is null\nEx: 19990823", Toast.LENGTH_SHORT).show();
                } else if (Util.checkStringIsNull(dateFormate)) {
                    Toast.makeText(mContext, "dateFormate is null\nEx: yyyyMMddHHmmss", Toast.LENGTH_SHORT).show();
                }
                CustomAPI.setDateTime(dateTime, dateFormate);
                break;
            case R.id.btn_set_time:
                int year = Integer.parseInt(getEditTest(R.id.et_set_year));
                int month = Integer.parseInt(getEditTest(R.id.et_set_month));
                int day = Integer.parseInt(getEditTest(R.id.et_set_day));
                int hour = Integer.parseInt(getEditTest(R.id.et_set_hour));
                int minute = Integer.parseInt(getEditTest(R.id.et_set_minute));
                int second = Integer.parseInt(getEditTest(R.id.et_set_second));
                CustomAPI.setSystemTime(year, month, day, hour, minute, second);
                break;
        }
    }
}
