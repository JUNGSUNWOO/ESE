package com.example.myapplication;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import android.app.ListFragment;

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

public class page_4_Fragment3 extends ListFragment {
    page4_adapter adapter;
    String per_url = public_url.getInstance().getPer_url();

    public page_4_Fragment3() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        // Adapter 생성 및 Adapter 지정.
        adapter = new page4_adapter();
        page_4_Fragment3 fragment3 = (page_4_Fragment3) getFragmentManager().findFragmentById(R.id.frame);
        fragment3.setListAdapter(adapter);

        new JSONTask().execute(per_url);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    //page_4_Fragment1 과 동일한 메소드를 사용하며 server에서 불러오는 data만 달라진다
    //{100m. 1km. 3km}
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
                    URL url = new URL(urls[0]);//url을 가져온다.
                    con = (HttpURLConnection) url.openConnection();
                    //추가된부분
                    con.setRequestMethod("POST");
                    con.setRequestProperty("Cache-Control", "no-cache");//캐시 설정
                    con.setRequestProperty("Content-Type", "application/json");//application JSON 형식으로 전송
                    con.setRequestProperty("Accept", "text/html");//서버에 response 데이터를 html로 받음
                    con.setDoOutput(true);//Outstream으로 post 데이터를 넘겨주겠다는 의미
                    con.setDoInput(true);//Inputstream으로 서버로부터 응답을 받겠다는 의미
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
            JSONObject jObj_tmp = null;
            JSONObject jObj = null;
            try {
                jObj_tmp = new JSONObject(json);
                jObj = (JSONObject) jObj_tmp.get("3km");
                Log.d("jobh", String.valueOf(jObj));

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
                    Log.d("jobh", String.valueOf(jObj2));
                    adapter.addItem(String.valueOf(jObj2.get("30maxspeed")), String.valueOf(jObj2.get("30lowspeed")), String.valueOf(jObj2.get("30avespeed")), String.valueOf(jObj2.get("30time")), String.valueOf(jObj2.get("id")));
                }
                adapter.notifyDataSetChanged();

            } catch (JSONException e) {
                Log.d("JSONPARSERerr", e.toString());
            }
        }
    }
    @Override
    public void onListItemClick(ListView l, @NonNull View v, int position, long id) {
        // get TextView's Text.
        page4_Item item = (page4_Item) l.getItemAtPosition(position);

        String MaxSpeed = item.getMax();
        String LowSpeed = item.getLow();
        String AveSpeed = item.getAve();
        String Time = item.getTime();

        // TODO : use item data.
    }

    // ... 코드 계속
    public void addItem(String max, String low, String ave, String time, String id) {
        adapter.addItem(max, low, ave, time, id);
    }

}