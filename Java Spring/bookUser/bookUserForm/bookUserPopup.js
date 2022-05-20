/* 팝업 */
let bookUserPopup_successFuncName; //전역변수

function modelWindowInit(row, funcName) {
	if (row) {
		$('#bookUserPopup_Form').form('load', {
			bkTitle: row.bkTitle,
			bkAuthor: row.bkAuthor,
			bkPublisher: row.bkPublisher,
			bkTagCode: row.bkTagCode 
		});
		
	}
	if (funcName) {
		bookUserPopup_successFuncName = funcName;
		//funcRun(UISLE22300M_successFuncName, row); //(함수명, 변수,변수 ...)
	}

	$(document).ready(function() {
		bookUserPopup_pageLoad(row, funcName);
	});
}


function bookUserPopup_pageLoad(row, funcName) {
	console.log('bookUserPopup_pageLoad');

	var param = {
			bkTitle: row.bkTitle,
			bkAuthor: row.bkAuthor,
			bkPublisher: row.bkPublisher,
			bkTagCode: row.bkTagCode,

		   }
		successFuncName : bookUserPopup_successFuncName

}



$(function() {

	// 저장버튼 이벤트처리
	$('#btnSave').bind('click', function(){
		saveData();
	});

	//오늘일자세팅
	$('#bookUserPopup_bkOutStartDt').datebox({value: $.dateUtil.getDate()});
   $('#bookUserPopup_bkOutEndDt').datebox({value: $.dateUtil.addDays(+3)});

});



// 게시판 저장
function saveData() {

	
	let submitData = $('bookUserPopup_Form').serializeObject();
	
	var bookUserPopup_editIndex = undefined;
	var bookUserPopup_bkTagCode;
	var bookUserPopup_rows;
	var param = [];
	

	// 상단정보
	var bkRegisterNm = $('#bookUserPopup_bkRegisterNm').val();
	var bkTitle = $('#bookUserPopup_bkTitle').val();
	var bkAuthor = $('#bookUserPopup_bkAuthor').val();
	var bkPublisher = $('#bookUserPopup_bkPublisher').val();
	var bkTagCode = $('#bookUserPopup_bkTagCode').val();
	var bkOutStartDt = $('#bookUserPopup_bkOutStartDt').val();
	var bkOutEndDt = $('#bookUserPopup_bkOutEndDt').val();
	var bkOutReason = $('#bookUserPopup_bkOutReason').val();
	var bkOutState = $('#bookUserPopup_bkOutState').val();

	
	// 정보를 입력하지 않을시 예외처리
	if(bkRegisterNm == '' || bkRegisterNm == null || bkRegisterNm == undefined){
		$.messager.alert('info', '이름을 추가하세요.');
		return false;	
	}

	// 정보를 입력하지 않을시 예외처리
	if(bkOutReason == '' || bkOutReason == null || bkOutReason == undefined){
		$.messager.alert('info', '신청사유를입력하세요.');
		return false;	
	}
	
	
	var param = {
		 'bkRegisterNm' : bkRegisterNm 
		,'bkTitle' : bkTitle				
		,'bkAuthor' : bkAuthor	
		,'bkPublisher' : bkPublisher	
		,'bkTagCode' : bkTagCode			
		,'bkOutStartDt' : bkOutStartDt		
		,'bkOutEndDt' : bkOutEndDt			
		,'bkOutReason' : bkOutReason
		,'bkOutState': bkOutState	
	};



	//return false;
	$.messager.confirm("", "저장 하시겠습니까?", function (r) {
		if (r) {
			$.ajax({
				method: "post",
				url: '/api/v1/bms/book/bookUserForm/mergeBookUser',
				data: JSON.stringify(param),
				dataType: "json",
				contentType: 'application/json'
			})
			.done(function (json) {
				$.messager.alert({
					title: '',
					msg: '저장 되었습니다',
					fn: function () {
			  console.log(param);
						funcRun(bookUserPopup_successFuncName, param);
					$.window('close');	
				}
				});
				
			})
                
		}
			
	});
}



