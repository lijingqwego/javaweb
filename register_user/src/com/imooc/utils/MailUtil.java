package com.imooc.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailUtil {
	/**
	 * 
	 * @param to ���͸�˭
	 * @param code ������
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	public static void sendMail(String to,String code) throws Exception{
		
		Properties properties = new Properties(); 
		properties.put("mail.transport.protocol", "smtp");// ����Э�� 
		properties.put("mail.smtp.host", "smtp.qq.com");// ������ 
		properties.put("mail.smtp.port", 465);// �˿ں�
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.enable", "true");//�����Ƿ�ʹ��ssl��ȫ����  ---һ�㶼ʹ��
		properties.put("mail.debug", "true");//�����Ƿ���ʾdebug��Ϣ  true ���ڿ���̨��ʾ�����Ϣ  
		
		//1.�������Ӷ��󣬴����ʼ�����������
		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("2623463347@qq.com", "rqmcpkhhgzowdhgb");
			}
		});
		//2.�����ʼ�����
		Message message=new MimeMessage(session);
		//2.1������
		message.setFrom(new InternetAddress("2623463347@qq.com"));
		//2.2�ռ���
		message.setRecipients(RecipientType.TO, new InternetAddress[] {new InternetAddress(to)});
		//2.3����
		message.setSubject("�����ʼ�");
		//2.4����
		message.setContent("<h1>����xx��վ�ļ����ʼ�������������������</h1><h3><a href='localhost:8080/register_user/ActiveServlet?code="+code+"'>localhost:8080/register_user/ActiveServlet?code="+code+"</a></h3>","text/html;charset=utf-8");
		//3.����һ�⼤���ʼ� 
		Transport.send(message);
	}
}
