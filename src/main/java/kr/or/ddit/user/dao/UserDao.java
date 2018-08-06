package kr.or.ddit.user.dao;

import kr.or.ddit.user.model.UserVo;

public class UserDao implements UserDaoInf{
	/**
	* Method : getUser
	* 최초작성일 : 2018. 7. 4.
	* 작성자 : PC16
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 상세 조회(fake)
	*/
	@Override
	public UserVo getUser(String userId) {
		//원래대로면 orm, jdbc등을 이용하여 db를 통해 조회한 결과를 반환하는데
		//servlet 테스트 목적으로 임의의 고정된 값을 반환
		UserVo userVo = new UserVo();
		userVo.setUserId("id");
		userVo.setPassword("pw");
		userVo.setUserNm("사용자");
		return userVo;
	}

}
