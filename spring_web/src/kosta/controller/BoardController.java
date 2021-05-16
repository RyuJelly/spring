package kosta.controller;

import java.io.File;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kosta.model.Board;
import kosta.model.BoardDao;

@Controller
public class BoardController {
	@Autowired
	private BoardDao dao;
	private String uploadDir = "D://upload";

	//   /board_insert.do  => insert_form.jsp
	//@RequestMapping(value="/board_insert", method=RequestMethod.GET)
	@GetMapping("/board_insert")
	public String insertForm(@ModelAttribute("boardCommand") Board board){
		return "insert_form";
	}
	
	//@RequestMapping(value="/board_insert", method=RequestMethod.POST)
	@PostMapping("/board_insert")
	public String board_insert(@ModelAttribute("boardCommand") @Valid Board board, 
			BindingResult errors){
		
		if(errors.hasErrors()){
			System.out.println("에러발생");
			
			return "insert_form";
		}
		
		MultipartFile multipartFile = board.getUploadFile();
		if(multipartFile != null){
			String fname = multipartFile.getOriginalFilename();
			board.setFname(fname);
			
			try {
				multipartFile.transferTo(new File(uploadDir, fname));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		dao.insert(board);
				
		return "redirect:board_list";
	}
	
	@RequestMapping("/board_list")
	public String board_list(Model model){
		List<Board> list = dao.list();
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@RequestMapping("/board_detail{seq}")
	public String board_detail(@PathVariable int seq, Model model){
		Board board = dao.detail(seq);
		model.addAttribute("board", board);
		
		return "detail";
	}
	
	@RequestMapping("/board_download")
	public String board_download(
			@RequestParam("filename") String filename, Model model)throws Exception{
		File file = new File(uploadDir, filename);
		model.addAttribute("downloadFile", file);
		
		return "downloadView";
	}
	
}