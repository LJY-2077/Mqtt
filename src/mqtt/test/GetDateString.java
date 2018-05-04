/**  
* @Title: GetDateString.java
* @Package mqtt.test
* @Description: TODO(用一句话描述该文件做什么)
* @author lijingyang   
* @date 2018年5月2日 下午5:12:25
* @version V1.0  
*/ 
package mqtt.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
* @ClassName: GetDateString
* @Description: TODO(这里用一句话描述这个类的作用)
* @author li jingyang  
* @date 2018年5月2日 下午5:12:25
*
*/
public class GetDateString
{
	
	public  String getDate()
	{
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式


		String hehe = dateFormat.format( now ); 
		
		System.out.println(hehe); 

		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改

		 


		int year = c.get(Calendar.YEAR); 
		int month = c.get(Calendar.MONTH); 
		int date = c.get(Calendar.DATE); 
		int hour = c.get(Calendar.HOUR_OF_DAY); 
		int minute = c.get(Calendar.MINUTE); 
		int second = c.get(Calendar.SECOND); 
		System.out.println(year + "/" + month + "/" + date + " " +hour + ":" +minute + ":" + second);
		return hehe;
		} 
		
	}
	
