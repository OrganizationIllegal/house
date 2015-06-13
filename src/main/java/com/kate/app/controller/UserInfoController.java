package com.kate.app.controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.kate.app.dao.UserInfoDao;
import com.kate.app.model.User;

@Controller
public class UserInfoController {
	@Autowired
	private UserInfoDao userInfoDao;
	
	private static char[] base64EncodeChars = new char[] { 'A', 'B', 'C', 'D',
        'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
        'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
        'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
        'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
        '4', '5', '6', '7', '8', '9', '+', '/', };

private static byte[] base64DecodeChars = new byte[] { -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59,
        60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
        10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1,
        -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37,
        38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1,
        -1, -1 };
	
	/*寮�珛璐︽埛*/
	@RequestMapping({ "/UserInfo/AddAccount" })
	public String addAccount(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String nick_name = req.getParameter("nick_name");
		String pwd = req.getParameter("pwd");
		String tel = req.getParameter("tel");
		String email = req.getParameter("email");
		String account = req.getParameter("account");
		String msg = req.getParameter("msg");
		int flag = userInfoDao.addAccount(nick_name, pwd, tel, email, account, msg);
		if(flag==0){
			System.out.println("娣诲姞澶辫触锛�");
		}else{
			System.out.println("娣诲姞鎴愬姛锛�");
		}
		return "/overseas.jsp"; 
	}
	
	/*绱㈠彇瀹屾暣浠锋牸鍗�/
	@RequestMapping({ "/UserInfo/AddAllPrice" })
	public void addAllPrice(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String nick_name = req.getParameter("nick_name");
		String pwd = req.getParameter("pwd");
		String tel = req.getParameter("tel");
		String email = req.getParameter("email");
		String allprice = req.getParameter("allprice");
		String msg = req.getParameter("msg");
		int flag = userInfoDao.addAllPrice(nick_name, pwd, tel, email, allprice, msg);
		if(flag==0){
			System.out.println("娣诲姞澶辫触锛�);
		}else{
			System.out.println("娣诲姞鎴愬姛锛�);
		} 
	}
	
	/*闇�眰*/
	@RequestMapping({ "/UserInfo/AddNeed" })
	public void addNeed(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String nick_name = req.getParameter("nick_name");
		String tel = req.getParameter("tel");
		String email = req.getParameter("email");
		String need = req.getParameter("need");
		String msg = req.getParameter("msg");
		int flag = userInfoDao.addNeed(nick_name,tel, email, need, msg);
		if(flag==0){
			System.out.println("娣诲姞澶辫触锛�");
		}else{
			System.out.println("娣诲姞鎴愬姛锛�");
		}
	}
	
	/*璇︽儏鍜ㄨ*/
	@RequestMapping({ "/UserInfo/AddAsk" })
	public void addAsk(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String nick_name = req.getParameter("nick_name");
		String pwd = req.getParameter("pwd");
		String tel = req.getParameter("tel");
		String email = req.getParameter("email");
		String ask = req.getParameter("ask");
		String msg = req.getParameter("msg");
		int flag = userInfoDao.addAsk(nick_name, pwd, tel, email, ask, msg);
		if(flag==0){
			System.out.println("娣诲姞澶辫触锛�");
		}else{
			System.out.println("娣诲姞鎴愬姛锛�");
		}
	}
	
	/*鏈�柊浠锋牸*/
	@RequestMapping({ "/UserInfo/AddNewestPrice" })
	public void addNewestPrice(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String nick_name = req.getParameter("nick_name");
		String pwd = req.getParameter("pwd");
		String tel = req.getParameter("tel");
		String email = req.getParameter("email");
		String newestprice = req.getParameter("newestprice");
		String msg = req.getParameter("msg");
		int flag = userInfoDao.addNewestPrice(nick_name, pwd, tel, email, newestprice, msg);
		if(flag==0){
			System.out.println("娣诲姞澶辫触锛�");
		}else{
			System.out.println("娣诲姞鎴愬姛锛�");
		}
	}
	
	/*瀹屾暣鎴峰瀷*/
	@RequestMapping({ "/UserInfo/AddHouseType" })
	public void addHouseType(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String nick_name = req.getParameter("nick_name");
		String pwd = req.getParameter("pwd");
		String tel = req.getParameter("tel");
		String email = req.getParameter("email");
		String housetype = req.getParameter("housetype");
		String msg = req.getParameter("msg");
		int flag = userInfoDao.addHouseType(nick_name, pwd, tel, email, housetype, msg);
		if(flag==0){
			System.out.println("娣诲姞澶辫触锛�:");
		}else{
			System.out.println("娣诲姞鎴愬姛锛�");
		}
	}
	
	/*娉ㄥ唽璐︽埛*/
	@RequestMapping({ "/Register" })
	public String register(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		int flag=0;
		String telemail = req.getParameter("telemail");
		String pwd = req.getParameter("pwd");
		if(isEmail(telemail)){
			flag=userInfoDao.register2(telemail, pwd);
		}else if(isPhoneNumberValid(telemail)){
			flag=userInfoDao.register1(telemail, pwd);
		}
		if(flag==0){
			System.out.println("注册失败");
		}else{
			System.out.println("注册成功");
		}
		return "/index01";
	}
	
	@RequestMapping({ "/login" })
	public String login(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		HttpSession session = req.getSession();
		//String username1 = (String)session.getAttribute("username");
		//session.getAttributeNames();
		//String name = HttpSession.getAttribute(username);
		String username = req.getParameter("username1");
		String password = req.getParameter("password1");
		String role = req.getParameter("role");
		byte [] username_str = decode(username);
		byte [] password_str = decode(password);
		String str_username = new String(username_str);
		String str_password = new String(password_str);
		session.setAttribute("username", str_username);
		session.setAttribute("role", role);
		return "/index01";
	}
	
	@RequestMapping({ "/loginPassChange" })
	public String loginPassChange(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		HttpSession session = req.getSession();
		//String username1 = (String)session.getAttribute("username");
		//session.getAttributeNames();
		//String name = HttpSession.getAttribute(username);
		String username = req.getParameter("username1");
		String password = req.getParameter("passNew1");
		String role = req.getParameter("role");
		byte [] username_str = decode(username);
		byte [] password_str = decode(password);
		String str_username = new String(username_str);
		String str_password = new String(password_str);
		boolean flag = userInfoDao.changePass(str_username, str_password);
		
		req.setAttribute("flag", flag);
		session.setAttribute("username", str_username);
		session.setAttribute("role", role);
		
		return "/index01";
	}
	
	
	
	@RequestMapping({ "/loginPanduan" })
	public void loginPanduan(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		List<User> list = userInfoDao.judge(username);
		JSONObject json = new JSONObject();
		if(list.size()<=0){
			json.put("user", "0");        //用户名不存在
		}
		else if(list.size()>0 && password.equals(list.get(0).getPwd())){
			json.put("user", "1");        //用户登录成功
			if(list.get(0).getRole()==0){
				json.put("role", "0");        //管理员
			}
			else{
				json.put("role", "1");        //普通用户
			}
		}
		else{
			json.put("user", "2");        //用户名和密码不符
		}
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping({ "/registerPanduan" })
	public void registerPanduan(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		List<User> list = userInfoDao.judge(username);
		JSONObject json = new JSONObject();
		if(list.size()>0){
			json.put("user", "0");        //用户已存在
		}
		else{			
			json.put("user", "1");        //用户可以进行注册			
		}
		try{
			writeJson(json.toJSONString(),resp);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static byte[] decode(String str) {
        byte[] data = str.getBytes();
        int len = data.length;
        ByteArrayOutputStream buf = new ByteArrayOutputStream(len);
        int i = 0;
        int b1, b2, b3, b4;

        while (i < len) {
                do {
                        b1 = base64DecodeChars[data[i++]];
                } while (i < len && b1 == -1);
                if (b1 == -1) {
                        break;
                }

                do {
                        b2 = base64DecodeChars[data[i++]];
                } while (i < len && b2 == -1);
                if (b2 == -1) {
                        break;
                }
                buf.write((int) ((b1 << 2) | ((b2 & 0x30) >>> 4)));

                do {
                        b3 = data[i++];
                        if (b3 == 61) {
                                return buf.toByteArray();
                        }
                        b3 = base64DecodeChars[b3];
                } while (i < len && b3 == -1);
                if (b3 == -1) {
                        break;
                }
                buf.write((int) (((b2 & 0x0f) << 4) | ((b3 & 0x3c) >>> 2)));

                do {
                        b4 = data[i++];
                        if (b4 == 61) {
                                return buf.toByteArray();
                        }
                        b4 = base64DecodeChars[b4];
                } while (i < len && b4 == -1);
                if (b4 == -1) {
                        break;
                }
                buf.write((int) (((b3 & 0x03) << 6) | b4));
        }
        return buf.toByteArray();
}
	
	public void writeJson(String json, HttpServletResponse response)throws Exception{
	    response.setContentType("text/html");
	    response.setCharacterEncoding("UTF-8");
	    PrintWriter out = response.getWriter();
	    if(StringUtils.isNotEmpty(json)){
	        out.println(json);
	    }
	    out.flush();
	    out.close();
	}
	
	/*判断是否为手机号*/
	public boolean isPhoneNumberValid(String phoneNumber) {
		boolean isValid = false;
		String expression = "((^(13|15|18)[0-9]{9}$)|(^0[1,2]{1}\\d{1}-?\\d{8}$)|(^0[3-9] {1}\\d{2}-?\\d{7,8}$)|(^0[1,2]{1}\\d{1}-?\\d{8}-(\\d{1,4})$)|(^0[3-9]{1}\\d{2}-? \\d{7,8}-(\\d{1,4})$))";
		CharSequence inputStr = phoneNumber;
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(inputStr);
		if (matcher.matches()) {
			isValid = true;
			}
			return isValid;


	}
	
	/*判断是否为邮箱*/
	public boolean isEmail(String email) {
		String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(email);
		return m.matches();
		} 

	
}
