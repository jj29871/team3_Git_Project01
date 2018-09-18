package service;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.MemberDao;
import vo.Member;


@Service
public class JoinService {

	@Autowired
	private SqlSession sqlsession;
	
	@Transactional
	public int insertMember(Member member) throws ClassNotFoundException, SQLException{
		int result = 0;
		MemberDao dao = sqlsession.getMapper(MemberDao.class);
		
		try {
			dao.insert(member);
			result = dao.insertRole(member);
			
		}catch(Exception e) {
			throw e;
		}
		return result;
	}
	
	
	
	
	public int idCheck(String userid){
		MemberDao dao = sqlsession.getMapper(MemberDao.class);
		int result = dao.idCheck(userid);
		return result;
	}
	
	public int loginCheck(String username, String password){
		MemberDao dao = sqlsession.getMapper(MemberDao.class);
		int result = dao.loginCheck(username, password);
		return result;
	}
}
