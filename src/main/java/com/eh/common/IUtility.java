package com.eh.common;

import java.security.Key;
import java.util.Locale;
import java.util.logging.*;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.context.MessageSource;
import org.springframework.util.DigestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**
 * @Class        : IUtility.java
 * @Description  : 공통기능을 정리한다. 
 * @Modification : Information
 * @since        : 2020-12-12
 * @author       : 김은호
 * @version      : 1.0
 */
public class IUtility {
	private static final Logger LOG = Logger.getLogger(IUtility.class.getName());
    
    public static String gs_ErrMsg = "처리 중 오류가 발생하였습니다.";
    
    /**
     * Object를 String으로 변환한다. String이 아니거나 null 일 경우 기본값을 반환한다.
     * @param  (Object) obj
     * @param  (String) def
     * @return (String) str
     */
    public static String parseNull(Object obj){
        return parseNull(obj, "");
    }
    
    public static String parseNull(Object obj, String def){
        if(obj == null)           return def;
        if(obj instanceof String) return (String)obj;
        if(obj.getClass().getName().contains("JSONNull")) return def;

        String str = null;

        str = String.valueOf(obj);

        return str;
    }
    
    /**
     * HttpServletRequest 반환함수
     * 현재 요청받은 HttpServletRequest를 사용하기 위하여 사용되는 함수
     * @return
     * @throws Exception
     */
    public static HttpServletRequest getRequest() {    	
		ServletRequestAttributes servletContainer = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes(); 
		HttpServletRequest request = servletContainer.getRequest();		
		return request;
	}
    
    /**
	 * 사용자 IP 주소 반환함수
	 * @return
	 * @throws Exception
	 */
	public static String getRemoteAddr() throws Exception{
		HttpServletRequest request = getRequest();
		return getRemoteAddr(request);
	}
    
    /**
     * 사용자 IP 주소 반환함수
     * @param request
     * @return
     * @throws Exception
     */
	public static String getRemoteAddr(HttpServletRequest request) throws Exception{
	    String ip = null;
	    ip = request.getHeader("X-Forwarded-For");
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getHeader("Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getHeader("WL-Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getHeader("HTTP_CLIENT_IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getHeader("X-Real-IP"); 
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getHeader("X-RealIP"); 
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getHeader("REMOTE_ADDR");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	        ip = request.getRemoteAddr(); 
	    }
	    return ip;
	}
	
	/**
	 * Session value 값 반환함수
	 * @param key : (String) 반환할 Session key
	 * @return
	 * @throws Exception
	 */
    public static Object getSessionValue(HttpServletRequest request, String key) throws Exception{
    	return EgovSessionCookieUtil.getSessionAttribute(request, key);
    }
	
    /**
	 * 공통 메시지 반환함수(locale 포함)
	 * @param messageSource : (MessageSource) messageSource bean
	 * @param key : (String)messageSource 구분키
	 * @param objs : (String) 메시지 변환 파라메터
	 * @return
	 * @throws Exception
	 */
	public static String getCommonMessage(MessageSource messageSource, String key, Object... objs) throws Exception {
		HttpServletRequest request = getRequest();
		return getCommonMessage(request, messageSource, key, objs);
	}
    
	/**
	 * 공통 메시지 반환함수(locale 포함)
	 * @param messageSource : (MessageSource) messageSource bean
	 * @param key : (String)messageSource 구분키
	 * @param objs : (String) 메시지 변환 파라메터
	 * @return
	 * @throws Exception
	 */
	public static String getCommonMessage(HttpServletRequest request, MessageSource messageSource, String key, Object... objs) throws Exception {
		Object[] args = null;
		if(objs != null) {
			int len = objs.length;
			args = new Object[len];
			for(int i = 0; i < len; i++) {
				args[i] = objs[i];
			}
		}
		
		String language = parseNull(getSessionValue(request, "SESSION_LOCALE"));
		if("".equals(language)) {
			language = "ko";
		}
		Locale locale = new Locale(language);
		return messageSource.getMessage(key, args, locale);
	}
    
	/**
	 * DB 암호화(DBMS_CRYPTO.HASH(STR, 2) java function
	 * @param str : 패스워드
	 * @return
	 */
    public static String encryptPwdString(String str) {
    	String encStr = "";
    	try {
	    	byte[] bytesInput = str.getBytes("UTF-8");
	    	encStr = DigestUtils.md5DigestAsHex(bytesInput);
    	} catch (Exception e) {
    		encStr = "";
		}
    	return encStr.toUpperCase();
    }
    
    /**
     * 시스템 구분 코드를 리턴한다.
     * @return (String) 시스템 구분 코드
     */
    public static String getSysSeCode() {
        return "01";
    }
    
    /**
	 * AES256 복호화 함수
	 * @param encStr : (String) 암호화된 문자열
	 * @param key : (String) 암호화 key
	 * @return
	 * @throws Exception
	 */
	public static String getDecStr(String encStr, String key) {
		String strRtn = "";
		String iv = key.substring(0, 16);
		try {
		    Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		    Key keySpec = getAES256KeySpec(key);
		    c.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes("UTF-8")));
		 
		    byte[] byteStr = Base64.decodeBase64(encStr.getBytes());
		 
		    strRtn = new String(c.doFinal(byteStr),"UTF-8");
		} catch (Exception e) {
			strRtn = "";
		}
		return strRtn;
	}
	
	/**
	 * AES256 key spec
	 * @param key : (String) 암호화 key
	 * @return
	 * @throws Exception
	 */
	public static Key getAES256KeySpec(String key) throws Exception {
        String iv = key.substring(0, 16);
        
        byte[] keyBytes = new byte[16];
        byte[] b = key.getBytes("UTF-8");
        int len = b.length;
        if (len > keyBytes.length) {
            len = keyBytes.length;
        }
        System.arraycopy(b, 0, keyBytes, 0, len);
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        
        return keySpec;
	}
}
