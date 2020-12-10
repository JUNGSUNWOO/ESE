package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class myinformation extends AppCompatActivity {

    private ListView LV2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinformation);

        LV2 = (ListView)findViewById(R.id.list2);
//        new JSONTask().execute("http://192.168.0.6:3000/post");

    }

    public class JSONTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... urls) {
            try {
                //JSONObject를 만들고 key value 형식으로 값을 저장해준다.
                JSONObject jsonObject = new JSONObject();
                jsonObject.accumulate("id", "jsw2");
                jsonObject.accumulate("pw", "1234");
                HttpURLConnection con = null;
                BufferedReader reader = null;
                BufferedWriter writer = null;

                try {
                    //URL url = new URL("http://192.168.0.4:3000/Users");
                    URL url = new URL(urls[0]);//url을 가져온다.
                    con = (HttpURLConnection) url.openConnection();
                    //추가된부분
                    con.setRequestMethod("POST");
                    con.setRequestProperty("Cache-Control", "no-cache");//캐시 설정
                    con.setRequestProperty("Content-Type", "application/json");//application JSON 형식으로 전송
                    con.setRequestProperty("Accept", "text/html");//서버에 response 데이터를 html로 받음
                    con.setDoOutput(true);//Outstream으로 post 데이터를 넘겨주겠다는 의미
                    con.setDoInput(true);//Inputstream으로 서버로부터 응답을 받겠다는 의미
                    //
                    con.connect();//연결 수행

                    //입력 스트림 생성
//                    OutputStream outputStream = con.getOutputStream();
//                    writer = new BufferedWriter((new OutputStreamWriter(outputStream)));
//                    Log.d("test2", jsonObject.toString());
//                    writer.write(jsonObject.toString());
//                    writer.flush();
//                    writer.close();//버퍼를 받아줌

                    //속도를 향상시키고 부하를 줄이기 위한 버퍼를 선언한다.
                    InputStream stream = con.getInputStream();

                    reader = new BufferedReader(new InputStreamReader(stream));
                    //실제 데이터를 받는곳
                    StringBuffer buffer = new StringBuffer();
                    //line별 스트링을 받기 위한 temp 변수
                    String line = "";
                    Log.d("check point", "buffer");
                    //아래라인은 실제 reader에서 데이터를 가져오는 부분이다. 즉 node.js서버로부터 데이터를 가져온다.
                    while ((line = reader.readLine()) != null) {
                        Log.d("line", line);
                        buffer.append(line);
                    }
                    Log.d("buffer check", String.valueOf(buffer));
                    //다 가져오면 String 형변환을 수행한다. 이유는 protected String doInBackground(String... urls) 니까
                    return buffer.toString();
                    //아래는 예외처리 부분이다.
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    //종료가 되면 disconnect메소드를 호출한다.
                    if (con != null) {
                        con.disconnect();
                    }
                    Log.d("check point", "finally");
                    try {
                        //버퍼를 닫아준다.
                        if (reader != null) {
                            reader.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }//finally 부분
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        //doInBackground메소드가 끝나면 여기로 와서 텍스트뷰의 값을 바꿔준다.
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            String json = result;
            JSONObject jObj = null;
            try {
                jObj = new JSONObject(json);
//                ArrayList<String> ar = new ArrayList<String>();

//집어넣어줌 추후에 custom listview에서도 비슷하게 사용가능
                myinformationAdapter adapter = new myinformationAdapter();
                LV2.setAdapter(adapter);
                Iterator iter = jObj.keys();
                ArrayList<String> key_list = new ArrayList<>();
                while(iter.hasNext()){
                    String key = iter.next().toString();
                    key_list.add(key);
                    Log.d("key", key);
                }
                for( String key :  key_list ) {
                    // do whatever
                    JSONObject jObj2 = (JSONObject) jObj.get(key);
                    adapter.addItem(new myinformation_item(String.valueOf(jObj2.get("10maxspeed")), String.valueOf(jObj2.get("10lowspeed")), String.valueOf(jObj2.get("10avespeed")), String.valueOf(jObj2.get("10time")), "temp"));
                }
                adapter.notifyDataSetChanged();

            } catch (JSONException e) {
                Log.d("JSONPARSERerr", e.toString());
            }
        }
    }
    class myinformationAdapter extends BaseAdapter {

        ArrayList<myinformation_item> items = new ArrayList<myinformation_item>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(myinformation_item item){
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            myinformation_itemView view = new myinformation_itemView(getApplicationContext());

            myinformation_item item2 = items.get(position);
            view.setA(item2.getDate());
            view.setB(item2.getDistance());
            view.setC(item2.getBest_race());
            view.setD(item2.getWorst_race());
            view.setE(item2.getNormal_race());


            return view;
        }
    }
}