package com.luv.cricket;

public class Model {
    private static String australia;
    private static String india;
    private static String westIndies;
    private static String pakistan;
    private static String sriLanka;
    private static String southAfrica;
    private static String newZealand;
    private static String zimbabawe;
    private static String afganistan;
    private static String bangladesh;
    private static String ireland;
    private static String nambia;
    private static String unitedArabEmirates;
    private static String england;
    private static String scotland;
    private static String canada;
    private static String kenya;
    private static String papuaNewGuinea;
    private static String nepal;
    private static String unitedStates;
    private static String netherlands;
    private static String qatar;
    private static String wales;
    private static String hongKong;

    public Model(String australia, String india, String westIndies, String pakistan, String sriLanka, String southAfrica, String newZealand, String zimbabawe, String afganistan, String bangladesh
    ,String ireland, String nambia, String unitedArabEmirates, String england, String scotland, String canada, String kenya, String papuaNewGuinea, String nepal, String unitedStates
    ,String netherlands, String qatar, String wales, String hongKong) {
        Model.australia = australia;
        Model.india = india;
        Model.westIndies = westIndies;
        Model.pakistan = pakistan;
        Model.sriLanka = sriLanka;
        Model.southAfrica = southAfrica;
        Model.newZealand = newZealand;
        Model.zimbabawe = zimbabawe;
        Model.afganistan = afganistan;
        Model.bangladesh = bangladesh;
        Model.ireland = ireland;
        Model.nambia = nambia;
        Model.unitedArabEmirates = unitedArabEmirates;
        Model.england = england;
        Model.scotland = scotland;
        Model.canada = canada;
        Model.kenya = kenya;
        Model.papuaNewGuinea = papuaNewGuinea;
        Model.nepal = nepal;
        Model.unitedStates = unitedStates;
        Model.netherlands = netherlands;
        Model.qatar = qatar;
        Model.wales = wales;
        Model.hongKong = hongKong;

    }

    public Model(String uniqueId, String team1, String team2, String matchType, String matchStatus, String dateTime) {

    }

    public static String getAustralia(){ return australia; }

    public static String getIndia(){
        return india;
    }

    public static String getWestIndies(){
        return westIndies;
    }

    public static String getPakistan(){
        return pakistan;
    }

    public static String getSriLanka(){
        return sriLanka;
    }

    public static String getSouthAfrica(){
        return southAfrica;
    }

    public static String getNewZealand(){
        return newZealand;
    }

    public static String getZimbabawe(){
        return zimbabawe;
    }

    public static String getAfganistan(){
        return afganistan;
    }

    public static String getBangladesh(){
        return bangladesh;
    }

    public static String getIreland(){
        return ireland;
    }

    public static String getNambia(){
        return nambia;
    }

    public static String getUnitedArabEmirates(){
        return unitedArabEmirates;
    }

    public static String getEngland(){
        return england;
    }

    public static String getScotland(){
        return scotland;
    }

    public static String getCanada(){
        return canada;
    }

    public static String getKenya(){
        return kenya;
    }

    public static String getPapuaNewGuinea(){
        return papuaNewGuinea;
    }

    public static String getNepal(){
        return nepal;
    }

    public static String getUnitedStates(){
        return unitedStates;
    }

    public static String getNetherlands(){
        return netherlands;
    }

    public static String getQatar(){
        return qatar;
    }

    public static String getWales(){
        return wales;
    }

    public static String getHongKong(){
        return hongKong;
    }

}
