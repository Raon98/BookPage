package kr.co.rmsoft.bms.bookuser.model;

import java.util.List;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonProperty;

import kr.co.rmsoft.bms.coreframework.model.BaseObject;
import kr.co.rmsoft.bms.coreframework.model.PagingObject;
import kr.co.rmsoft.bms.recordmanagement.model.ClassMapping;
import kr.co.rmsoft.bms.standard.model.CnstnManage;
import kr.co.rmsoft.bms.standard.model.HnpCnstnVo;
import kr.co.rmsoft.bms.standard.model.HnpCntpstMapngVo;
import kr.co.rmsoft.bms.util.validation.DeleteMethod;
import kr.co.rmsoft.bms.util.validation.PostMethod;
import kr.co.rmsoft.bms.util.validation.PutMethod;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @ClassName User.java
 * @Description sample model, sample validation
 * @author Jaeho Kang
 * @since 2020. 8. 31.
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Alias("bookUser") // 별칭지정
public class bookuser extends PagingObject {

	// 기간
	private String searchStartDate; // 조회 -7일일자
	private String searchEndDate; // 조회 마지막일자

	// 데이터
	private String updateDt; //등록날짜
	private String bkTitle; //도서명
	private String bkAuthor; // 저자
	private String bkPublisher; // 출판사
	private String bkTagCode; //도서코드
	private String bkOutState; //반출상태
	private String bkOutStartDt; //반출시작일

	private String bkOutEndDt; // 반출 종료일
	private String bkOutReason; // 반출사유
	private String bkRegisterNm; //반출신청자
	
	
	// 검색조건
	private String searchName;
	private String bkmenu;
	 private String frstColOrdr;
	 private String frstSelOrdr;
	 private String scndColOrdr;
	 private String scndSelOrdr;
	 
	 private List<bookuser> bookuserVo;

}
