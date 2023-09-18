package com.tool.mdm.custom;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.custom.mdm.CustomAPI;
import com.tool.mdm.custom.Utils.Classification;
import com.tool.mdm.custom.Utils.Util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    private static Context mContext;
    private static ArrayList<Classification> classifications;

    private static ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_listview);
        CustomAPI.init(this);
        mContext = this;
        classifications = Util.parseClassificationsFromXml(mContext, R.xml.test_classifications);
        for (Classification c : classifications) {
            Log.d(TAG, c.toString());
        }
        setupListView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CustomAPI.release();
    }

    public void setupListView() {
        listView = findViewById(R.id.main_list_view);
        ArrayAdapter<Classification> adapter = new ArrayAdapter<Classification>(mContext, R.layout.classification_item, classifications){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.classification_item, parent, false);
                }
                Classification classification = (Classification) getItem(position);
                TextView tv = convertView.findViewById(R.id.tv_classification_name);
                Button btn = convertView.findViewById(R.id.btn_classification_start);
                tv.setText(classification.getName());

                if (classification.getIcon().equals("START")) {
                    btn.setText("START");
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            doFunction(classification.getName());
                        }
                    });
                } else if (classification.getIcon().equals("MORE")) {
                    btn.setText("▶");
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            showMyDialog(classification.getClassName());
                        }
                    });
                }
                return convertView;
            }
        };
        listView.setAdapter(adapter);
    }

    public static void doFunction(String funcName) {
        switch (funcName) {
            case "REBOOT":
                CustomAPI.reboot();
                break;
            case "SHUTDOWN":
                CustomAPI.shutdown();
                break;
            case "FACTORY RESET":
                CustomAPI.factoryReset();
                break;
            default:
                Log.d(TAG, "doFunction: btn error");
                break;
        }
    }

    public static void showMyDialog(String dialogName) {
        Log.d(TAG, dialogName);
        switch (dialogName) {
            case "InfoDialog":
            case "ApkDialog":
            case "OtaDialog":
            case "WifiDialog":
            case "LocationDialog":
            case "AirplaneDialog":
            case "SimDialog":
            case "BluetoothDialog":
            case "RotationDialog":
            case "KeysDialog":
            case "StatusBarDialog":
            case "NavigationBarDialog":
            case "ScreenDialog":
            case "VolumeDialog":
            case "LanguageDialog":
            case "DateTimeDialog":
            case "TimeZoneDialog":
            case "ApnDialog":
            case "PukDialog":
            case "PropertyDialog":
            case "LauncherDialog":
            case "PasswordDialog":
            case "SystemModeDialog":
                try {
                    Class<?> clazz = Class.forName("com.tool.mdm.custom.dialogs." + dialogName);
                    Constructor<?> constructor = clazz.getConstructor(Context.class);
                    Object instance = constructor.newInstance(mContext);
                    Method method = clazz.getMethod("show");
                    method.invoke(instance);
                } catch (ClassNotFoundException e) {
                    Log.d(TAG, "showMyDialog: ClassNotFoundException");
                } catch (IllegalAccessException e) {
                    Log.d(TAG, "showMyDialog: IllegalAccessException");
                } catch (InstantiationException e) {
                    Log.d(TAG, "showMyDialog: InstantiationException");
                } catch (NoSuchMethodException e) {
                    Log.d(TAG, "showMyDialog: NoSuchMethodException  " + dialogName);
                } catch (InvocationTargetException e) {
                    Log.d(TAG, "showMyDialog: InvocationTargetException");
                }
                break;
            default:
                Log.d(TAG, "showMyDialog: error");
                break;
        }
    }
}