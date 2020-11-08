package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	//spring 4.3 이상에서 자동 처리
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	
//	private BoardMapper mapper;
	
	public void register(BoardVO board) {
		log.info("register...."+board);
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get...."+bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify...." + board);
		return mapper.update(board) ==1;
	
	}
	@Override
	public boolean remove(Long bno) {
	log.info("서비스의 remove...." +bno);	
	return mapper.delete(bno) ==1;
	}
	

//	@Override
//	public List<BoardVO> getList() {
//		log.info("getList");
//		return mapper.getList();
//	}

//	299p
	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("조건을 매개변수로 받은 겟리스트다!!"+cri);
		return mapper.getListWithPaging(cri);
		
	}
// 323p
	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return mapper.getTotalCount(cri);
	
	}
	
	
	


}
