// 1. 라이브러리 가져오기
var http = require("http");
var u = require("url");
var qs = require("querystring");
 
// 2. 서버 생성
var server = http.createServer(function(request, response) {
  // 주소를 제외한 url 추출
  // console.log(request.url);
  var url = request.url;
 
  var strucedUrl = u.parse(url);
  // console.log(strucedUrl);
 
  var strucedQuery = qs.parse(strucedUrl.query);
  console.log(strucedQuery);
  
  response.end("Connected");
});
 
// 3. 클라이언트 대기
server.listen(9000, function() {
  console.log("Server listening ...");
});
