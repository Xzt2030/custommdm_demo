package com.tool.mdm.custom.dialogs;

import android.content.Context;
import android.widget.Toast;

import com.custom.mdm.CustomAPI;
import com.tool.mdm.custom.R;
import com.tool.mdm.custom.Utils.Util;

public class SimDialog extends AbsBaseDialog {
    public SimDialog(Context context) {
        super(context, R.layout.sim_dialog_view);
    }

    @Override
    void buttonClickAction(int id) {
        switch (id) {
            case R.id.btn_sim_enable:
                CustomAPI.setSimDataEnabled(true);
                break;
            case R.id.btn_sim_disable:
                CustomAPI.setSimDataEnabled(false);
                break;
            case R.id.btn_get_imei:
                String imei_slotindexS = getEditTest(R.id.et_get_imei);
                if (Util.checkStringIsNull(imei_slotindexS)) {
                    Toast.makeText(mContext, "slotindex is null", Toast.LENGTH_SHORT).show();
                } else {
                    int imei_slotindex = Integer.parseInt(imei_slotindexS);
                    Toast.makeText(mContext, "" + CustomAPI.getIMEI(imei_slotindex), Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_get_imsi:
                String imsi_subidS = getEditTest(R.id.et_get_imsi);
                if (Util.checkStringIsNull(imsi_subidS)) {
                    Toast.makeText(mContext, "subid is null", Toast.LENGTH_SHORT).show();
                } else {
                    int imsi_subid = Integer.parseInt(imsi_subidS);
                    Toast.makeText(mContext, "" + CustomAPI.getIMSI(imsi_subid), Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_get_iccid:
                String iccid_subidS = getEditTest(R.id.et_get_iccid);
                if (Util.checkStringIsNull(iccid_subidS)) {
                    Toast.makeText(mContext, "subid is null", Toast.LENGTH_SHORT).show();
                } else {
                    int iccid_subid = Integer.parseInt(iccid_subidS);
                    Toast.makeText(mContext, "" + CustomAPI.getICCID(iccid_subid), Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_get_subid:
                String subid_slotindexS = getEditTest(R.id.et_get_subid);
                if (Util.checkStringIsNull(subid_slotindexS)) {
                    Toast.makeText(mContext, "slotindex is null", Toast.LENGTH_SHORT).show();
                } else {
                    int subid_slotindex = Integer.parseInt(subid_slotindexS);
                    Toast.makeText(mContext, "" + CustomAPI.getSubId(subid_slotindex), Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_get_datasim:
                Toast.makeText(mContext, "" + CustomAPI.getDataSimSlotIndex(), Toast.LENGTH_SHORT).show();
        }
    }
}
