package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MemberVO;


public interface IMemberService{
	//특정 학생의 정보를 넣어 값을 받아올 메서드.
	public MemberVO memberInfo(Map<String, String> params);
	//모든 학생의 정보를 받아올 메서드
	public List<MemberVO> memberList();
	//퍼시스턴스 레이어에 입력할 메서드들 생성
	public void insertMemberInfo(MemberVO memberInfo);
	public void updateMemberInfo(MemberVO memberInfo);
	public void deleteMemberInfo(Map<String, String> params);


	
}
