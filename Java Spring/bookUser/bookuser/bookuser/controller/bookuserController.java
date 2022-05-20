package kr.co.rmsoft.bms.bookuser.controller;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.rmsoft.bms.announcement.model.Lookup;
import kr.co.rmsoft.bms.announcement.model.Present;
import kr.co.rmsoft.bms.announcement.service.LookupService;
import kr.co.rmsoft.bms.bookuser.model.bookuser;
import kr.co.rmsoft.bms.bookuser.service.bookuserService;
import kr.co.rmsoft.bms.common.model.PaginatedResponse;
import kr.co.rmsoft.bms.coreframework.controller.BaseController;
import kr.co.rmsoft.bms.database.bid.BidPrsancVO;
import kr.co.rmsoft.bms.standard.model.CnstnManage;



@RestController
@RequestMapping("/api/v1/bms/book/bookUserForm" )
public class bookuserController extends BaseController{

	  @Autowired
	    bookuserService Service;

	  
		@GetMapping("/list")
		public PaginatedResponse<bookuser> getbookuserList(bookuser model) {
			
			String startDate = model.getSearchStartDate() +"000000"; 
			String endDate   = model.getSearchEndDate() +"235959";
			startDate =	startDate.replace("/", "");
			endDate   =	endDate.replace("/", "");
			
			model.setSearchStartDate(startDate);
			model.setSearchEndDate(endDate);

			return Service.getbookuserList(model);
		}
	  
		// 자사 구성원 저장
	    @PostMapping("/mergeBookUser")
	    public void mergeBookUser(@RequestBody bookuser model) {
	    	Service.mergeBookUser(model);
	    }

}

