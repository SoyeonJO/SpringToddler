package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.IMemberDaoImpl;
import kr.or.ddit.vo.MemberVO;


/*public class IMemberServiceImpl implements IMemberService,
										ApplicationContextAware{*/

//자동 빈등록 
// <bean id ="iMemberServiceImpl" class="...IMemberServiceImpl">
@Service
public class IMemberServiceImpl implements IMemberService{
	
	@Autowired
	private IMemberDao dao;

//	public IMemberServiceImpl(IMemberDao dao){
//	this.dao = dao;
//}
	
	
	@Override
	public MemberVO memberInfo(Map<String, String> params) {
		MemberVO memberInfo = null;
			try {
				memberInfo = dao.memberInfo(params);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return memberInfo;
	}
	
	@Override
	public List<MemberVO> memberList(){
		List<MemberVO> memberList = null;
		try {
			memberList = dao.memberList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}

	@Override
	public void insertMemberInfo(MemberVO memberInfo) {
		try {
			dao.insertMemberInfo(memberInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateMemberInfo(MemberVO memberInfo) {
		try {
			dao.updateMemberInfo(memberInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMemberInfo(Map<String, String> params) {
		try {
			dao.deleteMemberInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

/*	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
        this.dao = applicationContext.getBean("memberDao", IMemberDao.class);		
	}
*/


}
