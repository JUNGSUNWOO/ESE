var express = require('express');
var http = require('http');
 
var app = express();
 
// express 포트 설정 
app.set('port', process.env.PORT || 3000);
 
// 미들웨어 함수 등록 (클라이언트 요청이 들어 왔을 때, 호출 됨)
app.use(function(req, res, next){
    console.log('첫 번째 미들웨어 호출됨');
    
    res.writeHead(200, {"Content-Type" : "text/html;charset=utf8"});
    res.end('<h1>서버에서 응답한 결과입니다. </h1>');
});
 
// 서버 생성 
var server = http.createServer(app).listen(app.get('port') , function(){
    console.log('익스프레스로 웹 서버 실행 : ' + app.get('port'));
}); 