package com.tool.mdm.custom.dialogs;

import android.content.Context;

import com.custom.mdm.CustomAPI;
import com.tool.mdm.custom.R;

public class NavigationBarDialog extends AbsBaseDialog {
    public NavigationBarDialog(Context context) {
        super(context, R.layout.navigationbar_dialog_view);
    }

    @Override
    void buttonClickAction(int id) {
        switch (id) {
            case R.id.btn_nav_bar_enable:
                CustomAPI.setNavigationBar(true);
                break;
            case R.id.btn_nav_bar_disable:
                CustomAPI.setNavigationBar(false);
                break;
        }
    }
}
