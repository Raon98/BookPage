$(function() {
   console.log(1);
   // 검색박스 엔터 이벤트 처리
   bindEnter($('#bookuser_searchText').textbox('textbox'), $('#bookuser_btnSearch'));
   
   //bindEnter($('#bookuser_searchPsitnManageNm').textbox('textbox'), $('#bookuser_btnSearch'));
   

   
   //검색일자 초기화
   $('#bookuser_searchStartDate').datebox({value: $.dateUtil.addDays(-7)});
   $('#bookuser_searchEndDate').datebox({value: $.dateUtil.getDate()});
   
   // 검색버튼 이벤트 처리
   $('#bookuser_btnSearch').bind('click', function () {
      bookuser_searchData(1);
   });
   
      $('#bookuser_egrid').datagrid({
      singleSelect: true,
      dataType: "json",
      method: 'get',
      pagination: true,
      pageNumber: 1,
      pageSize: 50,
      emptyMsg: '데이터가 없습니다.',
      pageList: [10, 20, 50, 100],
      loadFilter: function (result) {
         if (result.data) {
            return result.data;
         }
      },
      onLoadSuccess: function (data) {
         $('#bookuser_egrid').datagrid("getPager").pagination("refresh", {
            pageNumber: data.pageNumber,
            pageSize: data.pageSize
         });
      }
   });
   
   $('#bookuser_egrid').datagrid("getPager").pagination({
      onSelectPage: function (pageNumber, pageSize) {
         bookuser_searchData(pageNumber, pageSize);
      }
   });
   
   $(document).ready(function () {
      $('#bookuser_btnSearch').trigger("click");
   });
   
});



function bookuser_searchData(pageNumber, pageSize) {

	var startDate = $('#bookuser_searchStartDate').val();
	var endDate = $('#bookuser_searchEndDate').val();
	
	if(startDate > endDate) {
		$.messager.alert("info", "검색 시작일이 <br>종료일을 초과 합니다.");
		return false;
	}
		
    var popts = $('#bookuser_egrid').datagrid("getPager").pagination("options");
   
   if(!pageNumber) pageNumber = popts.pageNumber;
   if(!pageSize) pageSize = popts.pageSize;
   
   if(pageNumber == 0) {
      pageNumber = 1;
   }
   	var searchParamVal2 = searchParamChg("bookuser_searchText");
	$('input[name="searchName"]').val(searchParamVal2);
	
   $('#bookuser_searchForm').find('#pageSize').val(pageSize);
   $('#bookuser_searchForm').find('#pageNumber').val(pageNumber);
   $('#bookuser_egrid').datagrid('options').url = '/api/v1/bms/book/bookUserForm/list';
   $('#bookuser_egrid').datagrid('load', $('#bookuser_searchForm').serializeObject());
}

function bookuser_setCnstnPsitnCode(val){
	if(val == true){
		bookuser_searchData(1);
		}
	}
	
//활동보고서 작성완료 상태에 링크
function bookuser_rpConfirm(value, row, index) {
	console.log("value, row, index", value, row, index);
	
	if(value == "활동보고서 작성중"){
		return "활동보고서 작성중";
	}
	return `<a href="javascript:void(0)" onclick="bookuser_openPopupDetail('update', ` + index + `)" title="` + value + `">` + value + `</a>`;
}



function bookuser_openPopupDetail(type, index) {

	var row = null;

	var rows = $('#bookuser_egrid').datagrid('getRows');
	row = rows[index];
	

	var param = {
		bkTitle: row.bkTitle	//도서명
		, bkAuthor: row.bkAuthor //저자
		, bkPublisher: row.bkPublisher	//출판사
		, bkTagCode: row.bkTagCode	//도서코드
		, bkOutState: row.bkOutState // 상태					
	};
	
	
	let url = '/book/bookUserPopup' 
	$.window('open', url, param, "bookuser_gridReload", {width: 825, height: 600, title: '반출신청서'});

}
function bookuser_gridReload() {
		console.log('reload');
	$("#bookuser_egrid").datagrid('reload');
}
	
function popCallBack(param){
	console.log('reload');
	$('#bookuser_egrid').datagrid('reload');
}	