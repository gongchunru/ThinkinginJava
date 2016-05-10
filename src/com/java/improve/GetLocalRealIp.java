package com.java.improve;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class GetLocalRealIp {

	public static void main(String[] args) throws SocketException {
		System.out.println(GetLocalRealIp.getRealIp());

	}
	
	public static String getRealIp() throws SocketException{
		String localip = null;//本地IP，
		String netip = null;//外网IP
		
		Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
		InetAddress ip = null;
		boolean finded = false;//是否找到外网IP
		while(netInterfaces.hasMoreElements() && !finded){
			NetworkInterface ni = netInterfaces.nextElement();
			Enumeration<InetAddress> address = ni.getInetAddresses();
			while(address.hasMoreElements()){
				ip = address.nextElement();
				if(!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1){//外网IP
					netip = ip.getHostAddress();
					finded = true;
					break;
				}else if(ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1 ){
					localip = ip.getHostAddress();
				}
			}
		}
		
		if(netip!=null && !"".equals(netip)){
			return netip;
		}else{
			return localip;
		}
	}
	

}
