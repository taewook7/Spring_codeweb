package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	
// XML에 SQL문이 처리되었으니 여기서는 제거(주석처리) 한다.
	//인터페이스 수정후에는 반드시 기존의 테스트 코드를 통해서 기존과 동일하게 동작하는지 확인해야 한다.
//	@Select("select * from tbl_board where bno>0 ")
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
}
