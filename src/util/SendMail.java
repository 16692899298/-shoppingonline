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
		//��̬��ȡ
		String tosb=sb;
		//String tosb="254557307@qq.com";//���͸����� 
		    //���������	
		    int x;//����������
	        Random ne=new Random();//ʵ����һ��random�Ķ���ne
	        x=ne.nextInt(9999-1000+1)+1000;//Ϊ���������ֵ1000-9999
	        String string = Integer.toString(x);
	        System.out.println("�������������:"+x);//���
		
		//��ʼ������
		String username="1598538038@qq.com";//�����ַ
		String password="mlhfipulgpiibaba";//ͨ�����Ż�ȡ����Ȩ��
		String host="smtp.qq.com";//�˿ں�
		String protocal="smtp";//Э��
		//�����ļ�
		Properties prop=new Properties();
		try {
			//1,�����ʼ����͹���
			MailSSLSocketFactory msf= new MailSSLSocketFactory();
			//2,�����е���Ȩ��Ϣ��
			msf.setTrustAllHosts(true);
			//3,����Ȩ�ļ���Ϣ��ֵ����Ȩ��Ϣȫ����
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.ssl.enable", "true");
			prop.put("mail.smtp.socketFactory", "true");
			//4,�����úõ���Ϣ����session��
			Session session=Session.getDefaultInstance(prop);
			//5,����massage��Ϣģ��
			MimeMessage message= new MimeMessage(session);
			//6,�����ʼ�����
			message.setFrom(new InternetAddress(username));//�ʼ�������
			message.setSubject("��֤��");//�ʼ�����
			message.setText(string, "UTF-8");//���ݣ�����
			message.setRecipients(RecipientType.TO, tosb);//���͸�����
			//7,�����ʼ�
			Transport transport= session.getTransport(protocal);//Э��
			transport.connect(host,username,password);//�˿ںţ��û�������Ȩ��
			transport.sendMessage(message, message.getAllRecipients());//�����ʼ�
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return string;

	}

}
