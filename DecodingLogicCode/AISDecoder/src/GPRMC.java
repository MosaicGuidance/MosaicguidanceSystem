/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rintu
 */
class GPRMC {
    private String packetName;
    private String UTC;
    private String status;
    private String lat;
    private String lat_dir;
    private String lon;
    private String lon_dir;
    private String SOG;
    private String trackangle;
    private String date;
    private String magvar;
    private String checksum;
    
     public String getPacketName()
    {
        return packetName;        
    }
    
    public String getUTC()
    {
        return UTC;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public String getLatitude()
    {
        return lat;
    }
    
    public String getLat_dir()
    {
        return lat_dir;
    }
    
    public String getLongitude()
    {
        return lon;
    }
    
    public String getLon_dir()
    {
        return lon_dir;
    }
    
    public String getSOG()
    {
        return SOG;
    }
    
    public String getTrackangle()
    {
        return trackangle;
    }
    
    public String getDate()
    {
        return date;
    }
    
    public String getMagvar()
    {
        return magvar;        
    }
    
    public String getChecksum()
    {
        return checksum;
    }

    public void setData(String[] dataExtr)
    {
        packetName = dataExtr[0];
        UTC = dataExtr[1];
        status = dataExtr[2];
        lat = dataExtr[3];
        lat_dir = dataExtr[4];
        lon = dataExtr[5];
        lon_dir = dataExtr[6];
        SOG = dataExtr[7];
        trackangle = dataExtr[8];
        date = dataExtr[9];
        magvar = dataExtr[10];
        checksum = dataExtr[12].split("\\*")[1];				
    }	

    public void display()
    {
        System.out.println("packetname: " + packetName);
        System.out.println("UTC: " + UTC);
        System.out.println("status: " + status);
        System.out.println("lat: " + lat);
        System.out.println("lat_dir: " + lat_dir);
        System.out.println("lon: " + lon);
        System.out.println("lon_dir: " + lon_dir);
        System.out.println("SOG: " + SOG);
        System.out.println("trackangle: " + trackangle);
        System.out.println("date: " + date);
        System.out.println("magvar: " + magvar);
        System.out.println("checksum: " + checksum);
    }    
}
