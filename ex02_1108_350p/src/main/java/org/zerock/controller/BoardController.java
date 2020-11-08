package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	private BoardService service;
	
//	@GetMapping("/list")
//	public void list(Model model) {
//		log.info("list");
//		
//		log.info("test....................................");
//		
//		model.addAttribute("list", service.getList());
//	}
	
	
////	300p
//	@GetMapping("list")
//	public void list(Criteria cri,Model model) {
//		log.info("조건을 매개변수로 받은 리스트"+cri);
//		model.addAttribute("list",service.getList(cri));
//	}
//	
	@GetMapping("/register")
	public void register() {
		
	}

//	307p  리스트메서드에 pageDTO를 사용할수있게 model 에 담아서 화면에 전달해준다
//	324p getTotal()을 호출하도록 변경
	@GetMapping("list")
	public void list(Criteria cri,Model model) {
		log.info("list: "+cri);
		model.addAttribute("list", service.getList(cri));
//		model.addAttribute("pageMaker", new PageDTO(cri, 123));
		
		int total=service.getTotal(cri);
		log.info("total: "+total);
		model.addAttribute("pageMaker",new PageDTO(cri,total));
	}
	
	
//	@GetMapping({"/get","/modify"})
//	public void get(@RequestParam("bno") Long bno, Model model) {
//		
//		log.info("/get or modify");
//		model.addAttribute("board", service.get(bno));
//	}
	
//	316p
	@GetMapping( { "/get", "/modify" })
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("get 또는 modify 매핑이다.");
		model.addAttribute("board", service.get(bno));
	}
	
	
	
	@PostMapping("/register")
	public String register(BoardVO board,RedirectAttributes rttr) {
		log.info("register: "+board);
		service.register(board);
		rttr.addFlashAttribute("result",board.getBno());
		return "redirect:/board/list";
	}
	
//	@GetMapping("/get")
	//파라미터와 변수이름으롣 동작하기때문에 @RequestParam 어노테이션 굳이 안써도 된단다. 
	// 또한 화면 쪽으로 해당 번호의 게시물을 전달해야하므로 Model을 파라미터로 지정한다. 
//	public void get(@RequestParam("bno") Long bno,Model model) {
//			
//			log.info("/get");
//			model.addAttribute("board",service.get(bno));
//			
//		}
	
	
// 350p uricomponentsbuilder  처리 
	@PostMapping("/modify")
	public String modify(BoardVO board,@ModelAttribute("cri") Criteria cri,RedirectAttributes rttr) {
		log.info("modify: " +board);
		if (service.modify(board)) {
			rttr.addFlashAttribute("result","success");
		}
//		rttr.addAttribute("pageNum",cri.getPageNum());
//		rttr.addAttribute("amount",cri.getAmount());
//		rttr.addAttribute("type", cri.getType());
//		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/board/list" + cri.getListLink();
	}
//	@PostMapping("/remove")
//	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
//		log.info("컨트롤러의 remove..." +bno);
//		if (service.remove(bno)) {
//			rttr.addFlashAttribute("result","success");
//		}
//		return "redirect:/board/list";
//	}
	
	 @PostMapping("/remove")
		 public String remove(@RequestParam("bno") Long bno,@ModelAttribute("cri") Criteria cri ,RedirectAttributes rttr)
		 {
		 log.info("remove..." + bno);
		 if (service.remove(bno)) {
		 rttr.addFlashAttribute("result", "success");
		 }
		 
//		 rttr.addAttribute("pageNum",cri.getPageNum());
//		 rttr.addAttribute("amount",cri.getAmount());
//		 rttr.addAttribute("type", cri.getType());
//		 rttr.addAttribute("keyword", cri.getKeyword());
		 return "redirect:/board/list"+cri.getListLink();
		 }
	
	
}












