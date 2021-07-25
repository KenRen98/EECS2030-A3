package org.eecs.a3.teamafk.MLS;

public class Townhouse extends Building implements MLSInterface{
    private String type = "Townhouse";
    private int size = 0;
    private String address = null;
    private String country = null;
    private String schooldistrict = null;
    private int bedrooms = 0;
    private int livingroom = 0;
    private int totalrooms = 0;
    private String expenses = null;
    private String builtdate = "";
    private int floorlevel = 0;
    private boolean pool = false;
    private boolean cableready = false;
    private boolean furnished = false;
    private boolean hassecurity = false;
    private boolean hasgarden = false;
    private int gardensize = 0;
    private String description = null;

    Townhouse(int size, String address, String country, String schooldistrict, int bedrooms, int livingroom, int totalrooms, String expenses, String builtdate, int floorlevel, boolean pool, boolean cableready, boolean furnished, boolean hassecurity, boolean hasgarden, int gardensize, String description) {
        this.size = size;
        this.address = address;
        this.country = country;
        this.schooldistrict = schooldistrict;
        this.bedrooms = bedrooms;
        this.livingroom = livingroom;
        this.totalrooms = totalrooms;
        this.expenses = expenses;
        this.builtdate = builtdate;
        this.floorlevel = floorlevel;
        this.pool = pool;
        this.cableready = cableready;
        this.furnished = furnished;
        this.hassecurity = hassecurity;
        this.hasgarden = hasgarden;
        this.gardensize = gardensize;
        this.description = description;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String getSchooldistrict() {
        return schooldistrict;
    }

    @Override
    public void setSchooldistrict(String schooldistrict) {
        this.schooldistrict = schooldistrict;
    }

    @Override
    public int getBedrooms() {
        return bedrooms;
    }

    @Override
    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    @Override
    public int getLivingroom() {
        return livingroom;
    }

    @Override
    public void setLivingroom(int livingroom) {
        this.livingroom = livingroom;
    }

    @Override
    public int getTotalrooms() {
        return totalrooms;
    }

    @Override
    public void setTotalrooms(int totalrooms) {
        this.totalrooms = totalrooms;
    }

    @Override
    public String getExpenses() {
        return expenses;
    }

    @Override
    public void setExpenses(String expenses) {
        this.expenses = expenses;
    }

    @Override
    public String getBuiltdate() {
        return builtdate;
    }

    @Override
    public void setBuiltdate(String builtdate) {
        this.builtdate = builtdate;
    }

    @Override
    public int getFloorlevel() {
        return floorlevel;
    }

    @Override
    public void setFloorlevel(int floorlevel) {
        this.floorlevel = floorlevel;
    }

    @Override
    public boolean isPool() {
        return pool;
    }

    @Override
    public void setPool(boolean pool) {
        this.pool = pool;
    }

    @Override
    public boolean isCableready() {
        return cableready;
    }

    @Override
    public void setCableready(boolean cableready) {
        this.cableready = cableready;
    }

    @Override
    public boolean isFurnished() {
        return furnished;
    }

    @Override
    public void setFurnished(boolean furnished) {
        this.furnished = furnished;
    }

    @Override
    public boolean isHassecurity() {
        return hassecurity;
    }

    @Override
    public void setHassecurity(boolean hassecurity) {
        this.hassecurity = hassecurity;
    }

    @Override
    public boolean isHasgarden() {
        return hasgarden;
    }

    @Override
    public void setHasgarden(boolean hasgarden) {
        this.hasgarden = hasgarden;
    }

    @Override
    public int getGardensize() {
        return gardensize;
    }

    @Override
    public void setGardensize(int gardensize) {
        this.gardensize = gardensize;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String Display(){
        String s="General information：<br/>";
        s=s+"Property Type: Townhouse<br/>";
        s=s+"Property Address: "+address+"<br/>";
        s=s+"Property Country: "+country+"<br/>";
        s=s+"Property School District: "+schooldistrict+"<br/><br/>";
        s=s+"Property Detail:<br/>";
        s=s+"Total Area: "+size+"sq.ft<br/>";
        s=s+"Bedrooms: "+bedrooms+"<br/>";
        s=s+"Livingrooms: "+livingroom+"<br/>";
        s=s+"Totalrooms: "+totalrooms+"<br/>";
        s=s+"Major Expenses for holding: "+expenses+"<br/>";
        s=s+"Built Date: "+builtdate+"<br/>";
        s=s+"Unit Level: "+floorlevel+"<br/>";
        s=s+"Cable: "+stringhelper(cableready)+"<br/>";
        s=s+"Furnished: "+stringhelper(furnished)+"<br/>";
        s=s+"Security: "+stringhelper(hassecurity)+"<br/>";
        s=s+"Garden: "+stringhelper(hasgarden)+"<br/><br/>";
        s=s+"Description:<br/>"+description;
        return s;
    }

}
