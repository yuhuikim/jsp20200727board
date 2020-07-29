package member.service;

import java.sql.Connection;
import java.util.Date;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class JoinService {
	private MemberDao memberDao = new MemberDao();

	// 값이 4개 들어있고 패스워드 값의 일치여부도 갖고있는 join 메소드
	public void join(JoinRequest joinReq) {
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			// 중복되면 안되므로 이미 있는지를 확인하는 절차
			Member member = memberDao.selectById(conn, joinReq.getId());
			if (member != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException(); // 만약에 있다면 중복됐다고 오류메세지 발생시킴
			}
			// 확인 후에 조건에 위배되지 않으면 insert 시켜서 회원가입을 할 수 있게 해준다.
			memberDao.insert(conn, new Member(
					joinReq.getId(), 
					joinReq.getName(), 
					joinReq.getPassword(), 
					new Date()
					));
			conn.commit();

		} catch (Exception e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
