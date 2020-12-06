// 1. 라이브러리 가져오기
var http = require("http");
var u = require("url");
var qs = require("querystring");
 
// File Stream: 파일을 열기 위한 라이브러리
var fs = require("fs");
 
// 2. 서버 생성
var server = http.createServer(function(request, response) {
  // 주소를 제외한 url 추출
  // console.log(request.url);
  var url = request.url;
 
  var strucedUrl = u.parse(url);
 
  var path = strucedUrl.pathname;
  var cmds = path.split("/");
 
  // console.log(cmds[1]);
  // console.log("Create Server OK");
 
  // RESTFul의 'html' 이라면
  if (cmds[1] == "html") {
    console.log("Html OK");
    if (request.method == "GET") {
      console.log("OK");
 
      // '/' 문자 제거
      var filePath = path.substring(1);
      console.log(path);
 
      // 파일을 연다.
      fs.readFile(filePath, 'utf-8',function(error, data){
              if(error){
          // 파일이 없다면 오류 메시지로 응답
                  response.writeHead(404,{'Content-Type':'text/html'});
                  response.end("<h1>404 Page not found!</h1>");
              }else{
          // 파일이 존재하면 해당 파일로 응답
                  response.writeHead(200,{'Content-Type':'text/html'});
                  response.end(data);
              }
          });
    }
  } else if (cmds[1] == "signin") {
    // 서버 내에 변수로 rootId와 rootPw 설정
    var rootId = "heepie";
    var rootPw = "123456789";
 
    // GET Method 처리
    if (request.method == "GET") {
      var datas = qs.parse(strucedUrl.query);
      var id = datas.id;
      var pw = datas.pw;
 
      console.log(id + " " + pw);
      // id와 pw 확인
      if (rootId == id && rootPw == pw) {
        response.end("Welcome " + id);
      } else {
        response.end("Check Id or Pw");
      }
    // POST Method 처리
    } else if (request.method == "POST") {
      var postData = "";
      // "data"를 로드하는 리스너 추가, "data"는 예약어
      request.on("data", function(fragment) {
        postData += fragment;
      });
 
      // "end" data가 모두 로드 되면 호출되는 리스너 추가, "end"는 예약어
      request.on("end", function() {
        // 로드한 데이터를 structed 형태로 가공
        var datas = qs.parse(postData);
 
        var id = datas.id;
        var pw = datas.pw;
 
        console.log(id + " " + pw);
        // id와 pw 확인
        if (rootId == id && rootPw == pw) {
          response.end("Welcome " + id);
        } else {
          response.end("Check Id or Pw");
        }
 
      });
    }
  }
});
 
// 3. 클라이언트 대기
server.listen(3000, function() {
  console.log("Server listening ...");
});
