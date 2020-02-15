package dnd.madang.jang

import android.os.AsyncTask
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL


class APITask : AsyncTask<String, String , String>() {

    override fun doInBackground(vararg urls: String?): String? {
        try { //JSONObject를 만들고 key value 형식으로 값을 저장해준다.
            var con: HttpURLConnection? = null
            var reader: BufferedReader? = null
            try {
                val url = URL(urls[0])
                con = url.openConnection() as HttpURLConnection
                con.setRequestProperty("Accept", "application/json")
                con.connect() //연결 수행
                //입력 스트림 생성
                val stream: InputStream = con.getInputStream()
                //속도를 향상시키고 부하를 줄이기 위한 버퍼를 선언한다.
                reader = BufferedReader(InputStreamReader(stream))
                //실제 데이터를 받는곳
                val buffer = StringBuffer()
                //line별 스트링을 받기 위한 temp 변수
                var line: String? = ""
                //아래라인은 실제 reader에서 데이터를 가져오는 부분이다. 즉 node.js서버로부터 데이터를 가져온다.
                while (reader.readLine().also({ line = it }) != null) {
                    buffer.append(line)
                }
                //다 가져오면 String 형변환을 수행한다. 이유는 protected String doInBackground(String... urls) 니까
                return buffer.toString()
                //아래는 예외처리 부분이다.
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            } finally { //종료가 되면 disconnect메소드를 호출한다.
                if (con != null) {
                    con.disconnect()
                }
                try { //버퍼를 닫아준다.
                    if (reader != null) {
                        reader.close()
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            } //finally 부분
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    //doInBackground메소드가 끝나면 여기로 와서 텍스트뷰의 값을 바꿔준다.
    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
    }
}