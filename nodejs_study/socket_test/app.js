var app = require('express')(); 
var http = require('http').Server(app); 
var io = require('socket.io')(http);

app.get('/', function(req, res){ 
//    res.sendfile('view.html');//default page 
res.sendFile( __dirname  + "/view.html" );
});

http.listen(3000, function(){ 
   console.log('listening on *:3000'); 
});

io.sockets.on('connection', function (socket){ 
   //원격에서 접속이 되면 기본 응답 
   socket.emit('message_from_server', 'hello, world');

  //메세지가 들어 오면 응답 
   socket.on('message_from_client', function (msg){ 
     console.log('message:', msg); 
     /*받은 메세지를 되돌려 주자. 
     아니면 받은 데이터를 이용 라즈베리파에서 뭐든 할 수 있다. 
     */ 
     socket.emit('message_from_server', '"' +msg+ '" 라고하셨군요.'); 
   });

});