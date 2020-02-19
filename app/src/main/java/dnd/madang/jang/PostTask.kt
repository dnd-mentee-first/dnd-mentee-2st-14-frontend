package dnd.madang.jang

import android.os.AsyncTask

import org.json.JSONObject
import java.io.*
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL


class PostTask : AsyncTask <String, String, String>(){
    override fun doInBackground(vararg urls: String?): String? {
        try { //JSONObject를 만들고 key value 형식으로 값을 저장해준다.
            val jsonObject = JSONObject()
            println("urls0"+ urls[0])
            println("urls1"+urls[1])
            println("urls2"+urls[2])
            println("urls3"+urls[3])
            println("urls4"+urls[4])
            jsonObject.accumulate("user_id", urls[1])
            jsonObject.accumulate("user_pw", urls[2])
            jsonObject.accumulate("user_name", urls[3])
            jsonObject.accumulate("user_nickname", urls[4])
            var con: HttpURLConnection? = null
            var reader: BufferedReader? = null
            try {
                val url = URL(urls[0])
                //연결을 함
                con = url.openConnection() as HttpURLConnection
                con.setRequestMethod("POST") //POST방식으로 보냄
                con.setRequestProperty("Cache-Control", "no-cache") //캐시 설정
                con.setRequestProperty(
                    "Content-Type",
                    "application/json"
                ) //application JSON 형식으로 전송
                con.setRequestProperty("Accept", "application/json") //서버에 response 데이터를 html로 받음
                con.setDoOutput(true) //Outstream으로 post 데이터를 넘겨주겠다는 의미
                con.setDoInput(true) //Inputstream으로 서버로부터 응답을 받겠다는 의미
                con.connect()

                //서버로 보내기위해서 스트림 만듬
                val outStream: OutputStream = con.getOutputStream()

                //버퍼를 생성하고 넣음
                val writer = BufferedWriter(OutputStreamWriter(outStream))
                writer.write(jsonObject.toString())
                writer.flush()
                writer.close() //버퍼를 받아줌
                //서버로 부터 데이터를 받음
                val stream: InputStream = con.getInputStream()
                reader = BufferedReader(InputStreamReader(stream))
                val buffer = StringBuffer()
                var line: String? = ""
                while (reader.readLine().also({ line = it }) != null) {
                    buffer.append(line)
                }
                return buffer.toString() //서버로 부터 받은 값을 리턴해줌 아마 OK!!가 들어올것임
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            } finally {
                if (con != null) {
                    con.disconnect()
                }
                try {
                    if (reader != null) {
                        reader.close() //버퍼를 닫아줌
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        //System.out.println(result);
    }

}