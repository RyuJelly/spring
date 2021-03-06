package kosta.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class WriteService implements Service {
	
	@Autowired
	@Qualifier("oracleDao")
	private Dao dao;
	
	public WriteService() {}

	public WriteService(Dao dao) {
		super();
		this.dao = dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@Override
	public void insert() {
				System.out.println("WriteService insert 호출");
				dao.insertBoard();
	}

}
