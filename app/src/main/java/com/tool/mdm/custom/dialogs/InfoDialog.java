package com.tool.mdm.custom.dialogs;

import android.content.Context;
import android.widget.Toast;

import com.custom.mdm.CustomAPI;
import com.tool.mdm.custom.R;

public class InfoDialog extends AbsBaseDialog {
    private static final String TAG = "InfoDialog";

    public InfoDialog(Context context) {
        super(context, R.layout.info_dialog_view);
    }

    @Override
    void buttonClickAction(int id) {
        switch (id) {
            case R.id.btn_get_rom:
                Toast.makeText(mContext, CustomAPI.getRomVersion(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_get_android:
                Toast.makeText(mContext, CustomAPI.getAndroidVersion(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_get_sn:
                Toast.makeText(mContext, CustomAPI.getSerialNo(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_get_sp:
                Toast.makeText(mContext, CustomAPI.getFirmwareVersion(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_get_brand:
                Toast.makeText(mContext, CustomAPI.getBrand(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_get_manufacture:
                Toast.makeText(mContext, CustomAPI.getManufacture(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_get_model:
                Toast.makeText(mContext, CustomAPI.getModel(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_get_hardware:
                Toast.makeText(mContext, CustomAPI.getHardwareVersion(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_get_storage:
                Toast.makeText(mContext, CustomAPI.getStorageSize(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_get_unused_storage:
                Toast.makeText(mContext, CustomAPI.getUsedStorage(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_get_memory:
                Toast.makeText(mContext, CustomAPI.getMemory(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_get_used_memory:
                Toast.makeText(mContext, CustomAPI.getMemoryPercent(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_get_cpu:
                Toast.makeText(mContext, CustomAPI.getCpu(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_get_cpu_percent:
                Toast.makeText(mContext, CustomAPI.getCpuPercent(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_get_prop:
                String propName = getEditTest(R.id.et_get_prop);
                Toast.makeText(mContext, CustomAPI.getSystemProperty(propName), Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(mContext, TAG + "btn error", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
