package kr.co.rmsoft.bms.bookuser.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import kr.co.rmsoft.bms.bookuser.model.bookuser;
import kr.co.rmsoft.bms.standard.model.ConstituentScreenAuth;

@Mapper
public interface bookuserMapper {

	Page<bookuser> getbookuserList(@Param("p") bookuser model); 
	
	int insertBookUser (bookuser param); 
}
