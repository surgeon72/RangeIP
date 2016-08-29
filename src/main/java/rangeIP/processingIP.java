package rangeIP;
import java.util.regex.Matcher;  
import java.util.regex.Pattern;
public class processingIP {
	private Pattern pattern;  
    private Matcher matcher;
    private String subIp1;
    private int startAddress;
    private int endAddress;
    
    private static final String ipAdr_pattern =
    		"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
    				"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
    				"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
    				"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    
    processingIP(){
    	pattern = Pattern.compile(ipAdr_pattern);
    }
    
    boolean validIP(String ip){
		matcher = pattern.matcher(ip);
		return matcher.matches();
	}
    
    void showAddress(String ip1,String ip2){
    	//строка подсети
    	subIp1 = ip1.substring(0, ip1.lastIndexOf("."));
    	//совпадают ли подсети введенных ip
		if(ip2.startsWith(subIp1)){
			//индексы адресов ip1 и ip2
			startAddress = Integer.parseInt(ip1.substring(ip1.lastIndexOf(".")+1));
			endAddress = Integer.parseInt(ip2.substring(ip2.lastIndexOf(".")+1));
    	
			if(startAddress<endAddress){	
				System.out.println("Доступные IP адреса в введенном диапазоне:");
				for(startAddress++;startAddress<endAddress;startAddress++)
					System.out.println(subIp1+"."+startAddress);
			}
			else{
				System.out.println("Доступные IP адреса в введенном диапазоне:");
				for(endAddress++;endAddress<startAddress;endAddress++)
					System.out.println(subIp1+"."+endAddress);
			}
		}
		else
			System.out.println("Подсети не совпадают!");
    }
}
