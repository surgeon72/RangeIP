package rangeIP;
import java.io.*;
public class rangeIP {
	public static void main (String args[]) throws IOException{
		byte IP1[] = new byte[15];
		byte IP2[] = new byte[15];
		String strIp1="";String strIp2="";
		System.out.println("������ ��������� ���������� ��� ���������� IP ������ � ��������� ���������.");
		System.out.println("������� IP 1:");
		System.in.read(IP1);
		
		for(int i = 0;i<IP1.length;i++)
			strIp1 +=(char) IP1[i];					
		strIp1 = strIp1.trim();
				
		processingIP procIp = new processingIP();
		if(procIp.validIP(strIp1)){
			System.out.println("������� IP 2:");
			System.in.read(IP2);
		
		for(int i = 0;i<IP2.length;i++)
			strIp2 +=(char) IP2[i];
		strIp2 = strIp2.trim();
		
		if(procIp.validIP(strIp2)){
			
			procIp.showAddress(strIp1,strIp2);
		}
		else
			System.out.println("��������� ����� �� ������������� ��������� IPv4!");
		
	}
		else
			System.out.println("��������� ����� �� ������������� ��������� IPv4!");
}
}
