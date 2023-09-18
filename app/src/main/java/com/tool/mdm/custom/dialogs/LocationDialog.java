package com.tool.mdm.custom.dialogs;

import android.content.Context;
import android.widget.Toast;

import com.custom.mdm.CustomAPI;
import com.tool.mdm.custom.R;

public class LocationDialog extends AbsBaseDialog {
    private static final String TAG = "LocationDialog";

    public LocationDialog(Context context) {
        super(context, R.layout.location_dialog_view);
    }

    @Override
    void buttonClickAction(int id) {
        switch (id) {
            case R.id.btn_location_enable:
                CustomAPI.setLocationEnabled(true);
                break;
            case R.id.btn_location_disable:
                CustomAPI.setLocationEnabled(false);
                break;
            case R.id.btn_get_location:
                Toast.makeText(mContext, "have no completed", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
