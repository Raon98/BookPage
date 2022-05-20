package kr.co.rmsoft.bms.bookuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.rmsoft.bms.announcement.model.BidReview;
import kr.co.rmsoft.bms.bookuser.model.bookuser;
import kr.co.rmsoft.bms.coreframework.controller.BaseController;

/**
 * 본공고 ViewController 클래스
 * 
 * @ClassName ViewController.java
 * @Description 권한 ViewController 클래스
 * @author Dong O Yoo
 * @since 2020. 11. 10.
 *
 */
@Controller
public class bookuserViewController extends BaseController {

    // 화면 오픈
    @GetMapping("/book/bookUserForm")
    public String view(Model model) {
        return "bms/book/bookUserForm";
    }
    
    @GetMapping("/book/bookUserPopup")
    public String bookUserPopup(Model model, bookuser vo) {
        model.addAttribute("vo", vo);
    	return "bms/book/bookUserPopup";
    }
}
