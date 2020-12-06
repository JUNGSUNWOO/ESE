const { response } = require('express');
const express = require('express');
const app = express();

//기존코드에서 달라진 부분"""
//db connection 부분
var mysql = require('mysql');
var db = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: '0924',
  database: 'running_app',
  multipleStatements : true
});
db.connect();
//기존코드에서 달라진 부분"""

var users = {}
// var test = {}
// test['id'] = "jsw";
// test['pw'] = "1234";
// users['first'] = test;


//javascript dict에 추가하는 방법
// users.push({
//   id:"ESE team",
//   name:"random"
// })


// 기존코드에서 달라진 부분"""
// db 접근해서 users dict에 (key,value)푸쉬해준다

db.query('SELECT * FROM 100mspeed', function (error, topics) {
  var i = 0;
  var container = {}

  while (true) {
    var tmp = {}
    // console.log(topics[i]['key_']);
    tmp['1maxspeed'] = topics[i]['1maxspeed'];
    tmp['1lowspeed'] = topics[i]['1lowspeed'];
    tmp['1avespeed'] = topics[i]['1avespeed'];
    tmp['1time'] = topics[i]['1time'];
    container[topics[i]['1speedkey']] = tmp;
    i++;
    if (topics[i] == null) break;
  }
  users["100m"] = container;
});

db.query('SELECT * FROM 1000mspeed', function (error, topics) {
  var i = 0;
  var container = {}

  while (true) {
    var tmp = {}
    // console.log(topics[i]['key_']);
    tmp['10maxspeed'] = topics[i]['10maxspeed'];
    tmp['10lowspeed'] = topics[i]['10lowspeed'];
    tmp['10avespeed'] = topics[i]['10avespeed'];
    tmp['10time'] = topics[i]['10time'];
    container[topics[i]['10speedkey']] = tmp;
    i++;
    if (topics[i] == null)  break;
  }
  users["1km"] = container;
});

db.query('SELECT * FROM 3000mspeed', function (error, topics) {
  var i = 0;
  var container = {}

  while (true) {
    var tmp = {}
    // console.log(topics[i]['key_']);
    tmp['30maxspeed'] = topics[i]['30maxspeed'];
    tmp['30lowspeed'] = topics[i]['30lowspeed'];
    tmp['30avespeed'] = topics[i]['30avespeed'];
    tmp['30time'] = topics[i]['30time'];
    container[topics[i]['30speedkey']] = tmp;
    i++;
    if (topics[i] == null) break;
  }
  users["3km"] = container;
  console.log(users);
});

// 기존코드에서 달라진 부분"""

//get은 없어도됨
app.get('/users', (req, res) => {
  console.log('who get in here/map');
  res.json(users)

});


//post사용할 것임
app.post('/post', (req, res) => {
  console.log('who get in here post /users');
  var inputData;

  req.on('data', (data) => {
    inputData = JSON.parse(data);
  });

  req.on('end', () => {
    //try-catch문으로 예외처리 inputData가 null값일 때
    //or android상에서 처리
    // var sql = 'INSERT INTO login (id, pw) VALUES(?, ?)'
    // var params = [inputData.id, inputData.pw];
    // db.query(sql, params, function(err, rows, fields){
    //   if(err){
    //     console.log(err);
    //   } else {
    //     console.log(rows.insertId);
    //   }
    // });
    // console.log("input : id : " + inputData.id + " , pw : " + inputData.pw);

  });
  res.json(users);
  //res.write(users);
  res.end()
});

app.listen(3000, () => {
  console.log('Example app listening on port 3000!');
});