package alarmclock.com.myapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class jsonUtils {

    private static JSONObject getJsonObject(String URL,String input) throws ExecutionException, InterruptedException, JSONException {
        MyAsingTask asyncTask = new MyAsingTask();
        asyncTask.execute(URL,input);

        return new JSONObject(asyncTask.get());

    }

    static Word getWordFromJson(String URL, String input) throws InterruptedException, ExecutionException, JSONException {
        JSONObject obj=getJsonObject(URL,input);

        Word word = new Word();

        if(obj.getJSONArray("entries").isNull(0 )){
            return word;
        } else {
            JSONArray lexemes = obj.getJSONArray("entries").getJSONObject(0).getJSONArray("lexemes");
            JSONArray senses = lexemes.getJSONObject(0).getJSONArray("senses");

            ArrayList<String>definitionsList = new ArrayList<>();

            for (int i = 0; i < senses.length(); i++) {

                definitionsList.add(senses.getJSONObject(i).getString("definition"));

            }

            word.setWord(obj.getJSONArray("entries").getJSONObject(0).getString("entry"));
            word.setDifinition(definitionsList);
        }

        return word;

    }
}
