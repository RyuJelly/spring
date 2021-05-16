package kosta.di;

import org.springframework.stereotype.Repository;

@Repository
public class MySqlDao implements Dao {

	@Override
	public void insertBoard() {
		System.out.println("MysqlDao insertBoard() 호출");

	}

}
