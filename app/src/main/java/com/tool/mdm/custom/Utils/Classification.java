package com.tool.mdm.custom.Utils;

public class Classification {
    private String name;
    private String icon;
    private String className;

    public Classification(String name, String icon, String className) {
        this.name = name;
        this.icon = icon;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public String getClassName() {
        return className;
    }

    public String toString() {
        return "Classification: " + "name: " + name + "  icon: " + icon + "  className: " + className;
    }
}
