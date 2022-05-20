package kr.co.rmsoft.bms.bookuser.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import kr.co.rmsoft.bms.announcement.mapper.LookupMapper;
import kr.co.rmsoft.bms.announcement.model.Lookup;
import kr.co.rmsoft.bms.announcement.model.Present;
import kr.co.rmsoft.bms.bookuser.mapper.bookuserMapper;
import kr.co.rmsoft.bms.bookuser.model.bookuser;
import kr.co.rmsoft.bms.common.model.PaginatedResponse;
import kr.co.rmsoft.bms.coreframework.service.BaseService;
import kr.co.rmsoft.bms.database.bid.BidPrsancVO;
import kr.co.rmsoft.bms.hnp.model.Constituent;
import kr.co.rmsoft.bms.hnp.model.ConstituentMapping;
import kr.co.rmsoft.bms.security.model.LoginUser;
import kr.co.rmsoft.bms.standard.model.CnstnManage;
import kr.co.rmsoft.bms.standard.model.HnpCnstnVo;
import kr.co.rmsoft.bms.standard.model.HnpCntpstMapngVo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class bookuserService extends BaseService {

	@Autowired
      bookuserMapper mapper;

	public PaginatedResponse<bookuser> getbookuserList(bookuser model) {
		
		log.debug("model ===>" + model);
		PageHelper.startPage(model.getPageNumber(), model.getPageSize());
		Page<bookuser> list = mapper.getbookuserList(model);
		
		return PaginatedResponse
                .<bookuser>builder()
                .pageNumber(model.getPageNumber())
                .pageSize(model.getPageSize())
                .total(list.getTotal())
                .rows(list.getResult())
                .build();


	}
	
	public int mergeBookUser(bookuser param) {

			return	mapper.insertBookUser(param);

			}
		

	}






