package com.tool.mdm.custom.dialogs;

import android.content.Context;
import android.widget.Toast;

import com.custom.mdm.CustomAPI;
import com.tool.mdm.custom.R;
import com.tool.mdm.custom.Utils.Util;

import java.util.Locale;

public class LanguageDialog extends AbsBaseDialog {
    public LanguageDialog(Context context) {
        super(context, R.layout.language_dialog_view);
    }

    @Override
    void buttonClickAction(int id) {
        switch (id) {
            case R.id.btn_set_language:
                String language = getEditTest(R.id.et_set_language);
                String country = getEditTest(R.id.et_set_country);
                if (Util.checkStringIsNull(language)) {
                    Toast.makeText(mContext, "language is null\nRecommanded value: ex:zh", Toast.LENGTH_SHORT).show();
                } else if (Util.checkStringIsNull(country)) {
                    Toast.makeText(mContext, "country is null\nRecommanded value: ex:CN", Toast.LENGTH_SHORT).show();
                } else {
                    Locale locale = new Locale(language, country);
                    CustomAPI.setLanguage(locale);
                }
                break;
            case R.id.btn_get_language:
                Toast.makeText(mContext, CustomAPI.getLanguage(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
