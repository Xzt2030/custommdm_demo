package com.tool.mdm.custom.dialogs;

import android.content.Context;
import android.widget.Toast;

import com.custom.mdm.CustomAPI;
import com.tool.mdm.custom.R;
import com.tool.mdm.custom.Utils.Util;

public class PasswordDialog extends AbsBaseDialog {
    public PasswordDialog(Context context) {
        super(context, R.layout.password_dialog_view);
    }

    @Override
    void buttonClickAction(int id) {
        switch (id) {
            case R.id.btn_set_app_pwd:
                String appPwd = getEditTest(R.id.et_app_pwd);
                if (Util.checkStringIsNull(appPwd)) {
                    Toast.makeText(mContext, "appPwd is null", Toast.LENGTH_SHORT).show();
                } else if (appPwd.length() < 4) {
                    Toast.makeText(mContext, "Recommanded length >= 6", Toast.LENGTH_SHORT).show();
                } else {
                    CustomAPI.setAppsPwd(appPwd);
                }
                break;
            case R.id.btn_set_storage_pwd:
                String storagePwd = getEditTest(R.id.et_storage_pwd);
                if (Util.checkStringIsNull(storagePwd)) {
                    Toast.makeText(mContext, "storagePwd is null", Toast.LENGTH_SHORT).show();
                } else if (storagePwd.length() < 4) {
                    Toast.makeText(mContext, "Recommanded length >= 6", Toast.LENGTH_SHORT).show();
                } else {
                    CustomAPI.setStoragePwd(storagePwd);
                }
                break;
            case R.id.btn_set_reset_pwd:
                String resetPwd = getEditTest(R.id.et_reset_pwd);
                if (Util.checkStringIsNull(resetPwd)) {
                    Toast.makeText(mContext, "resetPwd is null", Toast.LENGTH_SHORT).show();
                } else if (resetPwd.length() < 4) {
                    Toast.makeText(mContext, "Recommanded length >= 6", Toast.LENGTH_SHORT).show();
                } else {
                    CustomAPI.setResetPwd(resetPwd);
                }
                break;
            case R.id.btn_set_development_pwd:
                String devPwd = getEditTest(R.id.et_development_pwd);
                if (Util.checkStringIsNull(devPwd)) {
                    Toast.makeText(mContext, "devPwd is null", Toast.LENGTH_SHORT).show();
                } else if (devPwd.length() < 4) {
                    Toast.makeText(mContext, "Recommanded length >= 6", Toast.LENGTH_SHORT).show();
                } else {
                    CustomAPI.setDevelopmentPwd(devPwd);
                }
                break;
            case R.id.btn_set_security_pwd:
                String securityPwd = getEditTest(R.id.et_security_pwd);
                if (Util.checkStringIsNull(securityPwd)) {
                    Toast.makeText(mContext, "securityPwd is null", Toast.LENGTH_SHORT).show();
                } else if (securityPwd.length() < 4) {
                    Toast.makeText(mContext, "Recommanded length >= 6", Toast.LENGTH_SHORT).show();
                } else {
                    CustomAPI.setSecurityPwd(securityPwd);
                }
                break;
            case R.id.btn_set_settings_pwd:
                String settingsPwd = getEditTest(R.id.et_settings_pwd);
                if (Util.checkStringIsNull(settingsPwd)) {
                    Toast.makeText(mContext, "settingsPwd is null", Toast.LENGTH_SHORT).show();
                } else if (settingsPwd.length() < 4) {
                    Toast.makeText(mContext, "Recommanded length >= 6", Toast.LENGTH_SHORT).show();
                } else {
                    CustomAPI.setSettingsPwd(settingsPwd);
                }
                break;
        }
    }
}
