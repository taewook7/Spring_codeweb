package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")

//Java Config
// @ContextConfiguration(classes = {org.zerock.config.RootConfig.class } )
@Log4j
public class ReplyMapperTests {
	@Setter(onMethod_=@Autowired)
	private ReplyMapper mapper;
	
//	@Test
	public void testMapper() {
		log.info(mapper);
	}
	
	//테스트 전에 해당 번호의 게시물이 존재하는지 반드시 확인할 것
	private Long[] bnoArr = {1266745L, 1266744L,1266743L,1266742L,1266741L };
	
//	@Test
	public void testCreate() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			ReplyVO vo = new ReplyVO();
			
			//게시물의 번호
			vo.setBno(bnoArr[i%5]);
			vo.setReply("댓글 테스트" +i);
			vo.setReplyer("replyer" + i);
			mapper.insert(vo);
		});
	}
	
	@Test
	public void testRead() {
		Long targetRno = 5L;
		ReplyVO vo=mapper.read(targetRno);
		log.info(vo);
	}
	
	@Test
	public void testDelete() {
		Long targetRno = 2L;
		mapper.delete(targetRno);
	}
	
	@Test
	public void testUpdate() {
		Long targetRno =11L;
		ReplyVO vo=mapper.read(targetRno);
		vo.setReply("업데이트 리플라이 387fsdp");
		int count=mapper.update(vo);
		log.info("업데이트 카운트:" +count);
	}
	
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		log.info("여기부터 시작이란다");
		List<ReplyVO> replies= mapper.getListWithPaging(cri, bnoArr[0]);
		replies.forEach(reply -> log.info(reply));
		log.info("여기가 끝이란다");
	}
	
	@Test
	public void testList2() {
		Criteria cri = new Criteria(2,10);
		
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 77L);
		replies.forEach(reply -> log.info(reply));
	}
}



















