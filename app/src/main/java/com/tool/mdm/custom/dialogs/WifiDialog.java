package com.tool.mdm.custom.dialogs;

import android.content.Context;
import android.widget.Toast;

import com.custom.mdm.CustomAPI;
import com.tool.mdm.custom.R;
import com.tool.mdm.custom.Utils.Util;

public class WifiDialog extends AbsBaseDialog {
    private static final String TAG = "WifiDialog";
    public WifiDialog(Context context) {
        super(context, R.layout.wifi_dialog_view);
    }

    @Override
    void buttonClickAction(int id) {
        switch (id) {
            case R.id.btn_wifi_enable:
                CustomAPI.setWifiEnabled(true);
                break;
            case R.id.btn_wifi_disable:
                CustomAPI.setWifiEnabled(false);
                break;
            case R.id.btn_wifi_ip:
                Toast.makeText(mContext, CustomAPI.getWifiIP(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_wifi_mac:
                Toast.makeText(mContext, CustomAPI.getMac(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_wifi_intensity:
                Toast.makeText(mContext, CustomAPI.getIntensity(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_wifi_dhcp:
                CustomAPI.setWifiDHCP();
                Toast.makeText(mContext, CustomAPI.getWifiIP(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_wifi_static:
                String wifiIp = getEditTest(R.id.et_wifi_ip);
                String wifiGateway = getEditTest(R.id.et_wifi_gateway);
                String wifiLength = getEditTest(R.id.et_wifi_length);
                String wifiDns = getEditTest(R.id.et_wifi_dns);
                if (Util.checkStringIsNull(wifiIp)) {
                    Toast.makeText(mContext, "wifiIp is null", Toast.LENGTH_SHORT).show();
                } else if (Util.checkStringIsNull(wifiGateway)) {
                    Toast.makeText(mContext, "wifiGateway is null", Toast.LENGTH_SHORT).show();
                } else if (Util.checkStringIsNull(wifiLength)) {
                    Toast.makeText(mContext, "wifiLength is null", Toast.LENGTH_SHORT).show();
                } else if (Util.checkStringIsNull(wifiDns)) {
                    Toast.makeText(mContext, "wifiDns is null", Toast.LENGTH_SHORT).show();
                } else {
                    CustomAPI.setWifiStatic(wifiIp,
                            wifiGateway, Integer.parseInt(wifiLength), wifiDns);
                }
                break;
        }
    }
}
