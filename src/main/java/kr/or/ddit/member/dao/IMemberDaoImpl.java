package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.MemberVO;

import com.ibatis.sqlmap.client.SqlMapClient;

//public class IMemberDaoImpl implements IMemberDao,
//ApplicationContextAware{
//자동 빈 등록
//<bean id=iMemberDaoImpl class=....IMemberDaoImpl/>

@Repository
public class IMemberDaoImpl implements IMemberDao {
	@Autowired
	private SqlMapClient client;
//	public IMemberDaoImpl(SqlMapClient client){
//	this.client = client;
//}
	
	@Override
	public MemberVO memberInfo(Map<String, String> params) throws SQLException {
		return (MemberVO) client.queryForObject("member.memberInfo", params);//queryForObject는 Object로 return해주기 때문에,
											//리턴값인 MemberVO로 downCasting해서 return해야한다.
	}

	@Override
	public List<MemberVO> memberList() throws SQLException{
		return client.queryForList("member.memberList");
	}
	@Override
	public void insertMemberInfo(MemberVO memberInfo) throws SQLException {
		client.insert("member.insertMember", memberInfo);
	}

	@Override
	public void updateMemberInfo(MemberVO memberInfo) throws SQLException {
		// 동적인 테이블 생성, 시퀀스 생성, 뷰 생성, 유저 생성...
		client.update("member.updateMember", memberInfo);
	}

	@Override
	public void deleteMemberInfo(Map<String, String> params) throws SQLException {
		client.update("member.deleteMember",params);
	}

/*	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
			this.client = applicationContext.getBean("sqlMapClient", SqlMapClient.class);
	}*/

}
