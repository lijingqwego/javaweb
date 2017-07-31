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
	 * @param to 发送给谁
	 * @param code 激活码
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	public static void sendMail(String to,String code) throws Exception{
		
		Properties properties = new Properties(); 
		properties.put("mail.transport.protocol", "smtp");// 连接协议 
		properties.put("mail.smtp.host", "smtp.qq.com");// 主机名 
		properties.put("mail.smtp.port", 465);// 端口号
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.enable", "true");//设置是否使用ssl安全连接  ---一般都使用
		properties.put("mail.debug", "true");//设置是否显示debug信息  true 会在控制台显示相关信息  
		
		//1.创建连接对象，创建邮件服务器对象
		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("2623463347@qq.com", "rqmcpkhhgzowdhgb");
			}
		});
		//2.创建邮件对象
		Message message=new MimeMessage(session);
		//2.1发件人
		message.setFrom(new InternetAddress("2623463347@qq.com"));
		//2.2收件人
		message.setRecipients(RecipientType.TO, new InternetAddress[] {new InternetAddress(to)});
		//2.3主题
		message.setSubject("激活邮件");
		//2.4正文
		message.setContent("<h1>来自xx网站的激活邮件，激活请点击下载链接</h1><h3><a href='localhost:8080/register_user/ActiveServlet?code="+code+"'>localhost:8080/register_user/ActiveServlet?code="+code+"</a></h3>","text/html;charset=utf-8");
		//3.发送一封激活邮件 
		Transport.send(message);
	}
}
