package com.tool.mdm.custom.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public abstract class AbsBaseDialog implements View.OnClickListener {
    private static final String TAG = "AbsBaseDialog";
    protected Context mContext;
    protected View view;
    protected AlertDialog dialog;
    protected ArrayList<Button> buttonList;
    protected ArrayList<EditText> editTextList;

    protected AbsBaseDialog(Context context, int layout) {
        mContext = context;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(layout, null);
        builder.setView(view);
        dialog = builder.create();
        Window window = dialog.getWindow();
        window.setLayout(view.getWidth(), view.getHeight());
        initComponent();
    }

    public void show() {
        dialog.show();
    }

    protected void initComponent() {
        buttonList = new ArrayList<>();
        editTextList = new ArrayList<>();
        ViewGroup group = (ViewGroup) view;
        findAllComponents(view, buttonList, editTextList);
        for (Button btn : buttonList) {
            addButtonOnclick(btn.getId());
        }
    }

    protected void findAllComponents(View view, ArrayList<Button> buttonList, ArrayList<EditText> editTextList) {
        Log.d(TAG, "view: " + view.getId());
        if (view instanceof Button) {
            buttonList.add((Button) view);
        } else if (view instanceof EditText) {
            editTextList.add((EditText) view);
        } else if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            int childCount = group.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childView = group.getChildAt(i);
                findAllComponents(childView, buttonList, editTextList);
            }
        }
    }

    protected void addButtonOnclick(int id) {
        Button btn = view.findViewById(id);
        btn.setOnClickListener(this);
    }

    protected String getEditTest(int id) {
        EditText et = view.findViewById(id);
        return et.getText().toString();
    }

    @Override
    public void onClick(View v) {
        buttonClickAction(v.getId());
    }

    abstract void buttonClickAction(int id);
}
