class GPGBS
{
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
};


class Main_class
{
	public static void main(String[] args)
	{
		GPGBS gpgbsObj = new GPGBS();
		String rcvData = "$GPGBS,015509.00,-0.031,-0.186,0.219,19,0.000,-0.354,6.972*4D";
		String[] dataExtr = rcvData.split(",");
		gpgbsObj.setData(dataExtr);
		gpgbsObj.display();
		
	}

};





