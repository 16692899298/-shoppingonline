package util;
import java.util.Properties;
import java.util.Random;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.sun.mail.util.MailSSLSocketFactory;

public class SendMail {

	public static String sendMail(String sb) {
		//动态获取
		String tosb=sb;
		//String tosb="254557307@qq.com";//发送给的人 
		    //产生随机数	
		    int x;//定义两变量
	        Random ne=new Random();//实例化一个random的对象ne
	        x=ne.nextInt(9999-1000+1)+1000;//为变量赋随机值1000-9999
	        String string = Integer.toString(x);
	        System.out.println("产生的随机数是:"+x);//输出
		
		//初始化参数
		String username="1598538038@qq.com";//邮箱地址
		String password="mlhfipulgpiibaba";//通过短信获取的授权码
		String host="smtp.qq.com";//端口号
		String protocal="smtp";//协议
		//属性文件
		Properties prop=new Properties();
		try {
			//1,构造邮件发送工厂
			MailSSLSocketFactory msf= new MailSSLSocketFactory();
			//2,将所有的授权信息打开
			msf.setTrustAllHosts(true);
			//3,将授权文件信息赋值，授权信息全部打开
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.ssl.enable", "true");
			prop.put("mail.smtp.socketFactory", "true");
			//4,将配置好的信息放在session中
			Session session=Session.getDefaultInstance(prop);
			//5,构建massage消息模板
			MimeMessage message= new MimeMessage(session);
			//6,构建邮件发送
			message.setFrom(new InternetAddress(username));//邮件发送人
			message.setSubject("验证码");//邮件标题
			message.setText(string, "UTF-8");//内容，编码
			message.setRecipients(RecipientType.TO, tosb);//发送给的人
			//7,发送邮件
			Transport transport= session.getTransport(protocal);//协议
			transport.connect(host,username,password);//端口号，用户名，授权码
			transport.sendMessage(message, message.getAllRecipients());//发送邮件
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return string;

	}

}
