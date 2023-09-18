package com.tool.mdm.custom.dialogs;

import android.content.Context;
import android.widget.Toast;

import com.custom.mdm.CustomAPI;
import com.tool.mdm.custom.R;
import com.tool.mdm.custom.Utils.Util;

public class LauncherDialog extends AbsBaseDialog {
    public LauncherDialog(Context context) {
        super(context, R.layout.launcher_dialog_view);
    }

    @Override
    void buttonClickAction(int id) {
        switch (id) {
            case R.id.btn_set_launcher:
                String packageName = getEditTest(R.id.et_set_launcher_pkg);
                String activityName = getEditTest(R.id.et_set_launcher_activity);
                if (Util.checkStringIsNull(packageName)) {
                    Toast.makeText(mContext, "packageName is null", Toast.LENGTH_SHORT).show();
                } else if (Util.checkStringIsNull(activityName)) {
                    Toast.makeText(mContext, "activityName is null", Toast.LENGTH_SHORT).show();
                } else {
                    if (!CustomAPI.queryAppInfo(packageName).isInstalled()) {
                        Toast.makeText(mContext, "this apk has not installed", Toast.LENGTH_SHORT).show();
                    } else {
                        CustomAPI.setLauncher(packageName, activityName);
                    }
                }
                break;
        }
    }
}
