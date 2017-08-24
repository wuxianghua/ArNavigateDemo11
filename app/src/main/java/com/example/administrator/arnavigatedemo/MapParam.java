package com.example.administrator.arnavigatedemo;

import android.text.TextUtils;

import com.palmaplus.nagrand.data.DataElement;
import com.palmaplus.nagrand.data.Param;
import com.palmaplus.nagrand.geos.Coordinate;

/**
 * Created by Administrator on 2017/7/31/031.
 */

public final class MapParam {
    private static final Param<String> LOCATION_TYPE = new Param<>("location_type", String.class);
    private static final Param<Long> ID = new Param<>("id", Long.class);
    private static final Param<Long> POI = new Param<>("poi", Long.class);
    private static final Param<String> NAME = new Param<>("name", String.class);
    private static final Param<String> DISPLAY = new Param<>("display", String.class);
    private static final Param<String> address = new Param<>("address", String.class);
    private static final Param<String> english_name = new Param<>("englishName", String.class);
    private static final Param<String> english_name2 = new Param<>("english_name", String.class);
    private static final Param<Long> categoryId = new Param<>("category", Long.class);

    public static long getId(DataElement dataElement) {
        return ID.get(dataElement);
    }
    public static long getPOI(DataElement dataElement){
        return POI.get(dataElement);
    }
    public static String getName(DataElement dataElement){
        return NAME.get(dataElement);
    }
    public static String getDisplay(DataElement dataElement){
        return DISPLAY.get(dataElement);
    }
    public static long getCategoryId(DataElement dataElement){return categoryId.get(dataElement);}
    public static String getAddress(DataElement dataElement){return address.get(dataElement);}
    public static String getEnglishName(DataElement dataElement) {
        String result = english_name.get(dataElement);
        if (TextUtils.isEmpty(result)) return english_name2.get(dataElement);
        return result;
    }
}
