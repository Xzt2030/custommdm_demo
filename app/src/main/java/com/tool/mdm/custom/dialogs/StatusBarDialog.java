package com.tool.mdm.custom.dialogs;

import android.content.Context;

import com.custom.mdm.CustomAPI;
import com.tool.mdm.custom.R;

public class StatusBarDialog extends AbsBaseDialog {
    public StatusBarDialog(Context context) {
        super(context, R.layout.statusbar_dialog_view);
    }

    @Override
    void buttonClickAction(int id) {
        switch (id) {
            case R.id.btn_status_bar_enable:
                CustomAPI.setStatusBar(true);
                break;
            case R.id.btn_status_bar_disable:
                CustomAPI.setStatusBar(false);
                break;
        }
    }
}
