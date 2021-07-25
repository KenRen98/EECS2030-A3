package org.eecs.a3.teamafk.MLS;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.ModelMap;
import java.sql.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;

import static java.lang.Integer.parseInt;


/**
 * Spring Boot functions for the DB
 * @author Ken Ren
 * @version 1.0
 */
@Controller
public class MLSSpringBoot {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://mrleavesbbs.com:3306/mls";
    static final String USER = "mls";
    static final String PASS = "mls123456";

    Connection conn = null;
    Statement stmt = null;
    String sql;

    @RequestMapping("/time")
    public String hello(Model m) {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "hello";
    }

    /**
     * Start Test Connection
     */
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Succeeded！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Display the inside building search result
     * @param id the id for searching building
     */
    @RequestMapping(value = "/building/change")
    public String buildingdisplay(Model model,@RequestParam( value = "id", required = true) UUID id) {
        if (mlsLookup(id)==null){
            return "NoResultFound";
        }
        model.addAttribute("building", mlsLookup(id).getBuilding().Display());
        model.addAttribute("id",id);
        return "view-building";
    }

    /**
     * Display the changed building result
     */
    @PostMapping(value = "/building/changed")
    public String buildingchange(@RequestParam("size")String size,@RequestParam("address")String address,@RequestParam("country")String country,ModelMap model,Model mod){
        UUID id = ViewingID.getInstance().getid();
        model.put("size", size);
        model.put("address", address);
        model.put("country", country);
        if(size!="")
            mlsLookup(id).getBuilding().setSize(parseInt(size));
        if(address!="")
            mlsLookup(id).getBuilding().setAddress(address);
        if(country!="")
            mlsLookup(id).getBuilding().setCountry(country);
        return buildingdisplay(mod,id);
    }

    /**
     * The actual method for searching building
     * @param id the id for searching building
     */
    @RequestMapping (value = "/building", method = RequestMethod.GET)
    public @ResponseBody
    Building buildingLookup(@RequestParam( value = "id", required = true) int id) {
        try {
            try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("Connecting...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Succeeded！");
            stmt = conn.createStatement();
            sql = "SELECT * FROM building WHERE id="+id;
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            if(rs==null){
                return null;
            }
            String type = rs.getString("type");
            int size = rs.getInt("size");
            String address = rs.getString("address");
            String country = rs.getString("country");
            String schooldistrict = rs.getString("schooldistrict");
            int bedrooms = rs.getInt("bedrooms");
            int livingroom = rs.getInt("livingrooms");
            int totalrooms = rs.getInt("totalrooms");
            String expenses = rs.getString("expenses");
            String builtdate ="NOT AVAILABLE";
            if(rs.getDate("builtdate")!=null){
                builtdate = rs.getDate("builtdate").toString();
            }
            int floorlevel = rs.getInt("floorlevel");;
            boolean pool = rs.getBoolean("pool");
            boolean cableready = rs.getBoolean("cableready");
            boolean furnished = rs.getBoolean("furnished");
            boolean hassecurity = rs.getBoolean("hassecurity");
            boolean hasgarden = rs.getBoolean("hasgarden");
            int gardensize = rs.getInt("gardensize");
            String description = rs.getString("description");
            switch (type) {
                case "Condo":
                    BuildCondo condo = new Building.BuildingBuilder().type(type).size(size).address(address).country(country).schooldistrict(schooldistrict).bedrooms(bedrooms).livingroom(livingroom).totalrooms(totalrooms).expenses(expenses).builtdate(builtdate).floorlevel(floorlevel).pool(pool).cableready(cableready).furnished(furnished).hassecurity(hassecurity).hasgarden(hasgarden).gardensize(gardensize).description(description).buildcondo();
                    return condo;
                case "Detached":
                    Detached deta = new Building.BuildingBuilder().type(type).size(size).address(address).country(country).schooldistrict(schooldistrict).bedrooms(bedrooms).livingroom(livingroom).totalrooms(totalrooms).expenses(expenses).builtdate(builtdate).floorlevel(floorlevel).pool(pool).cableready(cableready).furnished(furnished).hassecurity(hassecurity).hasgarden(hasgarden).gardensize(gardensize).description(description).builddetached();
                    return deta;
                case "Semi-Detached":
                    Semi_Detached semi  = new Building.BuildingBuilder().type(type).size(size).address(address).country(country).schooldistrict(schooldistrict).bedrooms(bedrooms).livingroom(livingroom).totalrooms(totalrooms).expenses(expenses).builtdate(builtdate).floorlevel(floorlevel).pool(pool).cableready(cableready).furnished(furnished).hassecurity(hassecurity).hasgarden(hasgarden).gardensize(gardensize).description(description).buildSemi_Detached();
                    return semi;
                case "Townhouse":
                    Townhouse town  = new Building.BuildingBuilder().type(type).size(size).address(address).country(country).schooldistrict(schooldistrict).bedrooms(bedrooms).livingroom(livingroom).totalrooms(totalrooms).expenses(expenses).builtdate(builtdate).floorlevel(floorlevel).pool(pool).cableready(cableready).furnished(furnished).hassecurity(hassecurity).hasgarden(hasgarden).gardensize(gardensize).description(description).buildtownhouse();
                    return town;
                case "Land":
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * Display the inside owner search result
     * @param model the id for searching owner
     */
    @RequestMapping(value = "/owner/change")
    public String ownerdisplay(Model model,@RequestParam(value = "id", required = true) UUID id) {
        if (mlsLookup(id)==null){
            return "NoResultFound";
        }
        model.addAttribute("owner", mlsLookup(id).getOwner().Display());
        model.addAttribute("id",id);
        return "view-owner";
    }
    /*
    @RequestMapping(value = "/owner/display", method = RequestMethod.GET)
    public @ResponseBody
    String ownerdisplay(@RequestParam(value = "id", required = true) int id) {
        if (ownerLookup(id)==null){
            return "No Result Found";
        }
        return ownerLookup(id).Display();
    }
    */

    /**
     * Display the changed owner result
     */
    @PostMapping(value = "/owner/changed")
    public String ownerchange(@RequestParam("firstname")String firstname,@RequestParam("lastname")String lastname,@RequestParam("phone")String phone,@RequestParam("email")String email,ModelMap model,Model mod){
        UUID id = ViewingID.getInstance().getid();
        model.put("firstname", firstname);
        model.put("lastname", lastname);
        model.put("phone", phone);
        model.put("email", email);
        if(firstname!="")
        mlsLookup(id).getOwner().setFirstname(firstname);
        if(lastname!="")
        mlsLookup(id).getOwner().setLastname(lastname);
        if(phone!="")
        mlsLookup(id).getOwner().setPhone(phone);
        if(email!="")
        mlsLookup(id).getOwner().setEmail(email);
        return ownerdisplay(mod,id);
    }


    /**
     * The actual method for searching owner
     * @param id the id for searching owner
     */
    @GetMapping(value = "/owner")
    public Owner ownerLookup(@RequestParam(value = "id", required = true)int id) {
        try {
            try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("Connecting...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Succeeded！");
            stmt = conn.createStatement();
            sql = "SELECT * FROM owner WHERE id="+id;
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            if(rs==null){
                return null;
            }
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String phone = rs.getString("phone");
            String email = rs.getString("email");
            Owner owner = new Owner.Builder().firstnameOfOwner(firstname).lastnameOfOwner(lastname).phoneNumber(phone).emailAddress(email).build();
            return owner;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * Display the inside parking search result
     * @param id the id for searching parking
     */
    @RequestMapping(value = "/parking/change", method = RequestMethod.GET)
    public String parkingdisplay(Model model, @RequestParam(value = "id", required = true) UUID id) {
        if (mlsLookup(id)==null){
            return "NoResultFound";
        }
        model.addAttribute("parking", mlsLookup(id).getParking().Display());
        model.addAttribute("id",id);
        return "view-parking";
    }

    /**
     * Display the changed parking result
     */
    @PostMapping(value = "/parking/changed")
    public String parkingchange(@RequestParam("type")String type,@RequestParam("size")String size,@RequestParam("rvok")String rvok,ModelMap model,Model mod){
        UUID id = ViewingID.getInstance().getid();
        model.put("type", type);
        model.put("size", size);
        model.put("rvok", rvok);
        if(size!="")
            mlsLookup(id).getParking().setSize(parseInt(size));
        if(type!="")
            mlsLookup(id).getParking().setType(type);
        if(rvok=="YES")
            mlsLookup(id).getParking().setIsRVok(true);
        else
            mlsLookup(id).getParking().setIsRVok(false);
        return parkingdisplay(mod,id);
    }

    /**
     * The actual method for searching parking
     * @param id the id for searching parking
     */
    public Parking parkingLookup(int id) {
        try {
            try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("Connecting...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Succeeded！");
            stmt = conn.createStatement();
            sql = "SELECT * FROM parking WHERE id="+id;
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            if(rs==null){
                return null;
            }
            String type = rs.getString("type");
            int size = rs.getInt("size");
            Boolean rvok = rs.getBoolean("rvok");
            Parking parking = new Parking.Builder().typeofParking(type).sizeofParking(size).RVofParking(rvok).build();
            return parking;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * Display the inside mls search result
     * @param id the id for searching mls
     */
    @RequestMapping(value = "/mlschange", method = RequestMethod.GET)
    public String mlsdisplay(Model model, @RequestParam(value = "id", required = true) UUID id) {
        if (mlsLookup(id)==null){
            return "NoResultFound";
        }
        model.addAttribute("mls", mlsLookup(id).Display());
        model.addAttribute("id",id);
        return "view-mls";
    }

    /**
     * Display the changed mls result
     */
    @PostMapping(value = "/mlschanged")
    public String mlschange(@RequestParam("name")String name,@RequestParam("type")String type,@RequestParam("date")String date,ModelMap model,Model mod){
        UUID id = ViewingID.getInstance().getid();
        model.put("name", name);
        model.put("type", type);
        model.put("date", date);
        if(name!="")
            mlsLookup(id).setMlsname(name);
        if(type!="")
            mlsLookup(id).setListtype(type);
        if(date!="")
            mlsLookup(id).setListdate(date);
        return mlsdisplay(mod,id);
    }

    /**
     * The actual method for searching owner
     * @param id the id for searching owner
     */
    @RequestMapping(value = "/mls", method = RequestMethod.GET)
    public @ResponseBody
    MLS mlsLookup(@RequestParam(value = "id", required = true)UUID id) {
        if (SingletonCache.getInstance().getByID(id) != null){
            System.out.println("Cached");
            return SingletonCache.getInstance().getByID(id);
        }
        try {
            try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("Connecting...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Succeeded！");
            stmt = conn.createStatement();
            sql = "SELECT * FROM mls WHERE uuid=\'"+id+"\'";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            if(rs==null){
                return null;
            }
            int ownerid = rs.getInt("ownerid");
            int buildingid = rs.getInt("buildingid");
            int parkingid = rs.getInt("parkingid");
            String mlsname = rs.getString("mlsname");
            String listtype = rs.getString("listtype");
            int price = rs.getInt("price");
            String listdate ="NOT AVAILABLE";
            if(rs.getDate("listdate")!=null){
                listdate = rs.getDate("listdate").toString();
            }
            String enddate = null;
            if(rs.getDate("enddate")!=null){
                enddate = rs.getDate("enddate").toString();
            }
            boolean sold = rs.getBoolean("sold");
            String brokerage = rs.getString("brokerage");
            String listingurl = rs.getString("listingurl");
            MLS mls = new MLS.Builder(id).Owneris1(ownerLookup(ownerid)).Buildingis2(buildingLookup(buildingid)).Parkingis3(parkingLookup(parkingid)).Listingnameis4(mlsname).Listtypeis5(listtype).Priceis6(price).Listdateis7(listdate).enddateis7a(enddate).soldis7b(sold).Brokerageis8(brokerage).listingurlis9(listingurl).build();
            SingletonCache.getInstance().putValue(id,mls);
            ViewingID.getInstance().putid(id);
            return mls;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * create new mls record
     */
    @RequestMapping("/mlsnew")
    public String CreateMLS(Model model) {
        UUID id = UUID.randomUUID();
        BuildCondo condo = new Building.BuildingBuilder().buildcondo();
        MLS newMLS = new MLS.Builder(id).Owneris1(new Owner()).Buildingis2(condo).Parkingis3(new Parking()).build();
        SingletonCache.getInstance().putValue(id,newMLS);
        ViewingID.getInstance().putid(id);
        return mlsdisplay(model,id);
    }

    /**
     * Get user the index html
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    /**
     * Return search result
     */
    @PostMapping(value = "/mlssearch")
    public String mlsseach(@RequestParam("id")String id,ModelMap model,Model mod){
        model.addAttribute("id",id);
        return mlsdisplay(mod,UUID.fromString(id));
    }

    /**
     * help to view building modify page
     */
    @RequestMapping(value = "/building/changed")
    public String buildinghelper(Model mod){
        UUID id = ViewingID.getInstance().getid();
        return buildingdisplay(mod,id);
    }

    /**
     * help to view user modify page
     */
    @RequestMapping(value = "/owner/changed")
    public String ownerhelper(Model mod){
        UUID id = ViewingID.getInstance().getid();
        return ownerdisplay(mod,id);
    }

    /**
     * help to view parking modify page
     */
    @RequestMapping(value = "/parking/changed")
    public String parkinghelper(Model mod){
        UUID id = ViewingID.getInstance().getid();
        return parkingdisplay(mod,id);
    }

    /**
     * help to view mls modify page
     */
    @RequestMapping(value = "/mlschanged")
    public String mlshelper(Model mod){
        UUID id = ViewingID.getInstance().getid();
        return mlsdisplay(mod,id);
    }
}
