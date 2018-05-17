class GPRMC
{
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
		checksum = dataExtr[11].split("\\*")[1];				
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
};


class Main_class
{
	public static void main(String[] args)
	{
		GPRMC gprmcObj = new GPRMC();
		String rcvData = "$GPRMC,123519,A,4807.038,N,01131.000,E,022.4,084.4,230394,003.1,W*6A";
		String[] dataExtr = rcvData.split(",");
		gprmcObj.setData(dataExtr);
		gprmcObj.display();
		
	}

};





