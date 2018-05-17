/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rintu
 */
class GPGBS {
    private String packetName;
    private String UTC;
    private String errLat;
    private String errLon;
    private String errAlt;
    private String fSatID;
    private String probDetFsat;
    private String extBias;
    private String stdDev;
    private String checksum;
    
    public String getPacketName()
    {
        return packetName;        
    }
    
    public String getUTC()
    {
        return UTC;
    }
    
    public String getErrLat()
    {
        return errLat;
    }
    
    public String getErrLon()
    {
        return errLon;
    }
    
    public String getErrAlt()
    {
        return errAlt;
    }
    
    public String getFSatID()
    {
        return fSatID;
    }
    
    public String getProbDetFsat()
    {
        return probDetFsat;
    }
    
    public String getExtBias()
    {
        return extBias;
    }
    
    public String getStdDev()
    {
        return stdDev;
    }
    
    public String getChecksum()
    {
        return checksum;
    }
    
    public void setData(String[] dataExtr)
    {
            packetName = dataExtr[0];
            UTC = dataExtr[1];
            errLat = dataExtr[2];
            errLon = dataExtr[3];
            errAlt = dataExtr[4];
            fSatID = dataExtr[5];
            probDetFsat = dataExtr[6];
            extBias = dataExtr[7];
            stdDev = dataExtr[8];
            checksum = dataExtr[8].split("\\*")[1];
    }	

    public void display()
    {
            System.out.println("packetname: " + packetName);
            System.out.println("UTC: " + UTC);
            System.out.println("errLat: " + errLat);
            System.out.println("errLon: " + errLon);
            System.out.println("errAlt: " + errAlt);
            System.out.println("fSatID: " + fSatID);
            System.out.println("probDetFsat: " + probDetFsat);
            System.out.println("extBias: " + extBias);
            System.out.println("stdDev: " + stdDev);
            System.out.println("checksum: " + checksum);

    }
}
