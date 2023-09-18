package com.tool.mdm.custom.Utils;

import android.content.Context;
import android.content.res.XmlResourceParser;

import com.tool.mdm.custom.R;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Util {
    public static ArrayList<Classification> parseClassificationsFromXml(Context context, int id) {
        XmlResourceParser parser = context.getResources().getXml(id);
        ArrayList<Classification> classifications = new ArrayList<>();
        String name = "";
        String icon = "";
        String className = "";
        try {
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT){
                if (eventType == XmlPullParser.START_TAG) {
                    String tagName = parser.getName();
                    if (tagName.equals("item")) {
                        name = parser.getAttributeValue(null, "name");
                        icon = parser.getAttributeValue(null , "icon");
                        className = parser.getAttributeValue(null, "className");
                    }
                } else if (eventType == XmlPullParser.END_TAG) {
                    String tagName = parser.getName();
                    if (tagName.equals("item")) {
                        Classification classification = new Classification(name, icon, className);
                        classifications.add(classification);
                    }
                }
                eventType = parser.next();
            }
        } catch (XmlPullParserException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return classifications;
    }

    public static boolean checkStringIsNull(String s) {
        if (s.equals("") || s == null) {
            return true;
        } else {
            return false;
        }
    }
}
