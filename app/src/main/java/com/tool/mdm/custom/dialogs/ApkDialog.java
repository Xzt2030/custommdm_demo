package com.tool.mdm.custom.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;

import com.custom.mdm.CustomAPI;
import com.custom.mdm.InstallReceiver;
import com.tool.mdm.custom.R;
import com.tool.mdm.custom.Utils.Util;

public class ApkDialog extends AbsBaseDialog {
    private static final String TAG = "ApkDialog";

    private AlertDialog dialog;

    public ApkDialog(Context context) {
        super(context, R.layout.apk_dialog_view);
    }

    @Override
    void buttonClickAction(int id) {
        switch (id) {
            case R.id.btn_apk_install:
                String apk_path = getEditTest(R.id.et_apk_path);
                if (Util.checkStringIsNull(apk_path)) {
                    Toast.makeText(mContext, "file path is null", Toast.LENGTH_SHORT).show();
                } else {
                    CustomAPI.install(apk_path,
                            new InstallReceiver.InstallListener() {
                                @Override
                                public void onInstallSuccess(String s) {
                                    Toast.makeText(mContext, "Install success!\n" + s, Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onInstallFail(String s, String s1) {
                                    Toast.makeText(mContext, "Install fail!\n" + s + "\n" + s1, Toast.LENGTH_SHORT).show();
                                }
                            });
                }
                break;
            case R.id.btn_apk_uninstall:
                String pkgName = getEditTest(R.id.et_apk_pkgname);
                if (Util.checkStringIsNull(pkgName)) {
                    Toast.makeText(mContext, "package name is null", Toast.LENGTH_SHORT).show();
                } else {
                    CustomAPI.uninstall(pkgName,
                            new InstallReceiver.UninstallListener() {
                                @Override
                                public void onUninstallSuccess(String s) {
                                    Toast.makeText(mContext, "Uninstall success\n" + s, Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onUninstallFail(String s, String s1) {
                                    Toast.makeText(mContext, "Uninstall fail\n" + s + "\n" + s1, Toast.LENGTH_SHORT).show();
                                }
                            });
                }
                break;
            case R.id.btn_apk_enable:
                String appenable = getEditTest(R.id.et_app_enable);
                if (Util.checkStringIsNull(appenable)) {
                    Toast.makeText(mContext, "package name is null", Toast.LENGTH_SHORT).show();
                } else {
                    CustomAPI.setAppEnable(appenable, true);
                }
                break;
            case R.id.btn_apk_disable:
                String appdisable = getEditTest(R.id.et_app_enable);
                if (Util.checkStringIsNull(appdisable)) {
                    Toast.makeText(mContext, "package name is null", Toast.LENGTH_SHORT).show();
                } else {
                    CustomAPI.setAppEnable(appdisable, false);
                }
                break;
            case R.id.btn_apk_cache:
                String appClearCache = getEditTest(R.id.et_cache_pkg);
                if (Util.checkStringIsNull(appClearCache)) {
                    Toast.makeText(mContext, "package name is null", Toast.LENGTH_SHORT).show();
                } else {
                    CustomAPI.cleanAppCache(appClearCache);
                }
                break;
            case R.id.btn_apk_size:
                String appSizePkg = getEditTest(R.id.et_apk_size);
                if (Util.checkStringIsNull(appSizePkg)) {
                    Toast.makeText(mContext, "package name is null", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, "" + CustomAPI.getAppSize(appSizePkg), Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_apk_info:
                String appInfoPkg = getEditTest(R.id.et_apk_info);
                if (Util.checkStringIsNull(appInfoPkg)) {
                    Toast.makeText(mContext, "package name is null", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(mContext, CustomAPI.queryAppInfo(appInfoPkg).toString(), Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_apk_signature:
                CustomAPI.setApkSignature(true);
                break;
            case R.id.btn_apk_nosignature:
                CustomAPI.setApkSignature(false);
                break;

        }
    }
}
