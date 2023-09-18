package com.tool.mdm.custom.dialogs;

import android.content.Context;
import android.widget.Toast;

import com.custom.mdm.CustomAPI;
import com.tool.mdm.custom.R;

public class OtaDialog extends AbsBaseDialog {
    private static final String TAG = "OtaDialog";
    public OtaDialog(Context context) {
        super(context, R.layout.ota_dialog_view);
    }

    @Override
    void buttonClickAction(int id) {
        switch (id) {
            case R.id.btn_ota:
                String filePath = getEditTest(R.id.et_ota_path);
                if (filePath == null || filePath.equals("")) {
                    filePath = "sdcard/Download/update.zip";
                    Toast.makeText(mContext, "use defalut file path: " + filePath, Toast.LENGTH_SHORT).show();
                }
                CustomAPI.systemUpdate(filePath);
                break;
            case R.id.btn_ota_result:
                Toast.makeText(mContext, CustomAPI.getOTAResult().toString(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
