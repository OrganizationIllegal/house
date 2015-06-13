package com.kate.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kate.app.model.MessageVo;

@Repository 
public class MessageDao extends BaseDao {
	public List<MessageVo> getMessage(){
		List<MessageVo> messageList=new ArrayList<MessageVo>();
		try {
			String sql = "select t.id,t.message_content,t.message_time,t.project_id,t.type,t.viewed ,u.nick_name,u.email,u.tel from message t join user u on t.userid=u.id  where t.type=1";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			int id=0;
			String message_content=null;
			Date message_time=null;
			int project_id=0;
			int type=0;
			int viewed=0;
			String nick_name=null;
			String email=null;
			String tel=null;
			while(rs.next()){
				id=rs.getInt("id");
				message_content=rs.getString("message_content");
				message_time=rs.getDate("message_time");
				project_id=rs.getInt("project_id");
				type=rs.getInt("type");
				viewed=rs.getInt("viewed");
				nick_name=rs.getString("nick_name");
				email=rs.getString("email");
				tel=rs.getString("tel");
				MessageVo messageVo=new MessageVo(id,message_content,message_time,project_id,viewed,type,nick_name,email,tel);
				messageList.add(messageVo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messageList;
	}
	public List<MessageVo> getMessagePrice(){
		List<MessageVo> messageList=new ArrayList<MessageVo>();
		try {
			String sql = "select t.id,t.message_content,t.message_time,t.project_id,t.type,t.viewed ,u.nick_name,u.email,u.tel from message t join user u on t.userid=u.id  where t.type=2";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			int id=0;
			String message_content=null;
			Date message_time=null;
			int project_id=0;
			int type=0;
			int viewed=0;
			String nick_name=null;
			String email=null;
			String tel=null;
			while(rs.next()){
				id=rs.getInt("id");
				message_content=rs.getString("message_content");
				message_time=rs.getDate("message_time");
				project_id=rs.getInt("project_id");
				type=rs.getInt("type");
				viewed=rs.getInt("viewed");
				nick_name=rs.getString("nick_name");
				email=rs.getString("email");
				tel=rs.getString("tel");
				MessageVo messageVo=new MessageVo(id,message_content,message_time,project_id,viewed,type,nick_name,email,tel);
				messageList.add(messageVo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messageList;
	}
	public List<MessageVo> getMessagLatestPrice(){
		List<MessageVo> messageList=new ArrayList<MessageVo>();
		try {
			String sql = "select t.id,t.message_content,t.message_time,t.project_id,t.type,t.viewed ,u.nick_name,u.email,u.tel from message t join user u on t.userid=u.id  where t.type=3";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			int id=0;
			String message_content=null;
			Date message_time=null;
			int project_id=0;
			int type=0;
			int viewed=0;
			String nick_name=null;
			String email=null;
			String tel=null;
			while(rs.next()){
				id=rs.getInt("id");
				message_content=rs.getString("message_content");
				message_time=rs.getDate("message_time");
				project_id=rs.getInt("project_id");
				type=rs.getInt("type");
				viewed=rs.getInt("viewed");
				nick_name=rs.getString("nick_name");
				email=rs.getString("email");
				tel=rs.getString("tel");
				MessageVo messageVo=new MessageVo(id,message_content,message_time,project_id,viewed,type,nick_name,email,tel);
				messageList.add(messageVo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messageList;
	}
	public boolean saveView(int id){   //0是未查看，1是已经查看
		boolean flag = false;
		try{
			String sql = " update message set viewed=? where id=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 1);
			pstmt.setInt(2, id);
			int result = pstmt.executeUpdate();
			if(result == 0){
				flag = false;
			}
		}catch (Exception e) {
            e.printStackTrace();
        }
		return flag;
	}

}
