/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aismsgdecode;

import static aismsgdecode.PostnReport.strbuildtodec;

/**
 *
 * @author Rintu Daniel
 */
class AIVDM
{
	private String packetName;
	private int fragCount;
	private int fragNum;
	private int seqMsgID;
	private char channelCode;
	private String payload;
	private String eod;

        AIVDM()
        {
            	packetName = null;
		fragCount = -1;
		fragNum = -1;
		seqMsgID = -1;
		channelCode = '-';
		payload = null;
		eod = null;
        
        }
       
	public void setData(String[] dataExtr)
	{
		packetName = dataExtr[0];
		fragCount = Integer.parseInt(dataExtr[1]);
		fragNum = Integer.parseInt(dataExtr[2]);
		seqMsgID = (("".equals(dataExtr[3]))? -1 : Integer.parseInt(dataExtr[3]));
		channelCode = dataExtr[4].charAt(0);
		payload = dataExtr[5];
		eod = dataExtr[6].split("\\*")[1];				
	}	

	public void decodePayload()
	{

		char[] array = payload.toCharArray();
		StringBuilder binary = new StringBuilder();
	
		//converting to ascii
		for(char ch : array)
		{
			int val = (int)ch;
			int value = asciitodec(val);
			String binVal = String.format("%6s",Integer.toString(value,2)).replace(' ','0');
//			System.out.print(binVal + "\n");
//			System.out.print("val: " + value + "\n");	
			binary.append(binVal);
		}

		msgTypedecoding(binary);
	}

	public void msgTypedecoding(StringBuilder bin)
	{

		PostnReport posObj = new PostnReport();
	        int num = (int)strbuildtodec(0,5,6,bin,int.class);			
		switch(num)
		{
			case 1 : 
			case 2 :
			case 3 :
				posObj.setData(bin);
				posObj.display();
				break;

		}		


	}

	public int asciitodec(int val)
	{
		val = val - 48;
		if(val > 40)
			val -= 8;
		return val;
	}

	public void display()
	{
		System.out.println("packetname: " + packetName);
		System.out.println("fragcount: " + fragCount);
		System.out.println("fragNum: " + fragNum);
		System.out.println("seqMsgID: " + seqMsgID);
		System.out.println("channelCode: " + channelCode);
		System.out.println("payload: " + payload);
		System.out.println("eod: " + eod);
	}
};


class PostnReport
{
	private int msgInd;
	private int repeatInd;
	private long mmsi;
	private int status;
	private int turn;
	private int speed;
	private int accuracy;
	private double lon;
	private double lat;
	private long course;
	private int heading;
	private int sec;
	private int maneuver;
	private int raim;
	private long radio;

        public PostnReport()
	{
//		System.out.println(bin);
		msgInd = -1;
		repeatInd = -1;
		mmsi =  -1;
		status = -1;
		turn = -1;
		speed = -1;
		accuracy = -1;
		lon = -1;
		lat = -1;
		course = -1;
		heading = -1;
		sec = -1;
		maneuver = -1;
		raim = -1;
		radio = -1;

	}
	public void setData(StringBuilder bin)
	{
//		System.out.println(bin);
		msgInd = (int)strbuildtodec(0,5,6,bin,int.class);
		repeatInd = (int)strbuildtodec(6,7,2,bin,int.class);
		mmsi =  (long)strbuildtodec(8,37,30,bin,long.class);
		status = (int)strbuildtodec(38,41,4,bin,int.class);
		turn = (int)strbuildtodec(42,49,8,bin,int.class);
		speed = (int)strbuildtodec(50,59,10,bin,int.class);
		accuracy = (int)strbuildtodec(60,60,1,bin,int.class);
		lon = (long)strbuildtodec(61,88,28,bin,long.class)/600000.0;
		lat = (long)strbuildtodec(89,115,27,bin,long.class)/600000.0;
		course = (long)strbuildtodec(116,127,12,bin,long.class);
		heading = (int)strbuildtodec(128,136,9,bin,int.class);
		sec = (int)strbuildtodec(137,142,6,bin,int.class);
		maneuver = (int)strbuildtodec(143,144,2,bin,int.class);
		raim = (int)strbuildtodec(148,148,1,bin,int.class);
		radio = (long)strbuildtodec(149,167,19,bin,long.class);

	}

	public static <T> Object strbuildtodec(int begin, int end, int len, StringBuilder binLocal, Class<?> type)
	{
		char[] array = new char[len];
		binLocal.getChars(begin,(end + 1),array,0);

                long decimal = 0;
		for(int pow = len; pow > 0; pow--)
		{
			if(array[pow - 1] == '1')
				decimal += Math.pow(2,len - pow);
		}
//		System.out.println("dec: " + decimal);
                if(type == int.class)
                    return (int)(long)decimal;
                else
                    return decimal;
		//return Integer.parseInt(new String(array));
		
	}

	public void display()
	{
		System.out.println("msdInd: " + msgInd);
		System.out.println("repeatInd: " + repeatInd);
		System.out.println("mmsi: " + mmsi);
		System.out.println("status: " + status);
		System.out.println("turn: " + turn);
		System.out.println("speed: " + speed);
		System.out.println("accuracy: " + accuracy);
		System.out.println("lon: " + lon);
		System.out.println("lat: " + lat);
		System.out.println("course: " + course);
		System.out.println("heading: " + heading);
		System.out.println("sec: " + sec);
		System.out.println("maneuver: " + maneuver);
		System.out.println("raim: " + raim);
		System.out.println("radio: " + radio);
	}

};


class Aismsgdecode
{
	public static void main(String[] args)
	{
		AIVDM aivdmObj = new AIVDM();
		String rcvData = "!AIVDM,1,1,,B,15UDQt001aPT136NlWiD93E20<<P,0*30";
		String[] dataExtr = rcvData.split(",");
		aivdmObj.setData(dataExtr);
		aivdmObj.display();
		aivdmObj.decodePayload();
		
	}

};






