package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import jdk.internal.org.jline.utils.Log;
import lombok.Setter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> Log.info(board));
	}
	
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로작성하는글 제목");
		board.setContent("새로작성하는글 내용");
		board.setWriter("김태욱");
		
		mapper.insert(board);
		Log.info(board);
	}
	
	
	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("새로작성하는글 select key");
		board.setContent("새로작성하는내용 셀렉트키");
		board.setWriter("새롲가성하는 태욱");
		mapper.insertSelectKey(board);
		Log.info(board);
	}
	
	@Test
	public void testRead() {
		//존재하는 게시물 번호로 테스트
		BoardVO board=mapper.read(5L);
		
		Log.info(board);
	}
	
	@Test
	public void testDelete() {
		Log.info("DELETE COUNT: "+mapper.delete(17L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		//실행전 존재하는 번호인지 확인할 것
		board.setBno(1L);
		board.setTitle("수정된제목");
		board.setContent("수정된 내용");
		board.setWriter("user00");
		
		int count=mapper.update(board);
		Log.info("UPDATE COUNT: "+count);
	}
}




















