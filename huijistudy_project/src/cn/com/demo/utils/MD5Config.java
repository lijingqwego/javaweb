package cn.com.demo.utils;

import java.security.NoSuchAlgorithmException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;



/**
* @Title: <p> MD5Config.java <p>
* @Description: <p> 类说明 <p>
* @author    尚勇军
* @version   1.0 
* @date      2017年4月19日 下午2:18:11
* @Company: <p> 慧极科技  </p> 
*/
public class MD5Config {
	private static final Log logger = LogFactory.getLog(MD5Config.class);
	public static String md5(String password) {     
        Md5PasswordEncoder md5 = new Md5PasswordEncoder();     
        // false 表示：生成32位的Hex版, 这也是encodeHashAsBase64的, Acegi 默认配置; true  表示：生成24位的Base64版     
        md5.setEncodeHashAsBase64(false);     
        String pwd = md5.encodePassword(password, null);     
        logger.debug("MD5: " + pwd + " len=" + pwd.length());  
        return pwd;
    }  
    public static String sha_256(String password) throws NoSuchAlgorithmException {       
        ShaPasswordEncoder sha = new ShaPasswordEncoder(256);     
        sha.setEncodeHashAsBase64(true);     
        String pwd = sha.encodePassword(password, null);     
        logger.debug("哈希算法 256: " + pwd + " len=" + pwd.length());     
       return pwd;
    }     
         
    public static String sha_SHA_256(String password) {     
        ShaPasswordEncoder sha = new ShaPasswordEncoder();     
        sha.setEncodeHashAsBase64(false);     
        String pwd = sha.encodePassword(password, null);      
        logger.debug("哈希算法 SHA-256: " + pwd + " len=" + pwd.length());     
        return pwd;
    }     
         
        
    public static String md5_SystemWideSaltSource (String password,String username) {     
        Md5PasswordEncoder md5 = new Md5PasswordEncoder();     
        md5.setEncodeHashAsBase64(false);     
             
        // 使用动态加密盐的只需要在注册用户的时候将第二个参数换成用户名即可     
        String pwd = md5.encodePassword(password, username);     
        logger.debug("MD5 SystemWideSaltSource: " + pwd + " len=" + pwd.length());     
       return pwd;
    }     
    public static void main(String[] args) throws NoSuchAlgorithmException {  
        md5("admin"); // 使用简单的MD5加密方式     
          
        sha_256("admin"); // 使用256的哈希算法(SHA)加密     
             
        sha_SHA_256("admin"); // 使用SHA-256的哈希算法(SHA)加密     
             
        md5_SystemWideSaltSource("admin","admin"); // 使用MD5再加全局加密盐加密的方式加密      
    }  
    
}
