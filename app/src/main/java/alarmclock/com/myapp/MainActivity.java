package alarmclock.com.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView; // классы что есть перечилить
    ArrayList <String> arrayList;
    EditText searchEditText;
    Button searchBtn;
    Word word;

    CardsAdapter adapter;

    String URL="https://lingua-robot.p.rapidapi.com/language/v1/entries/en/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // путь к идентификатору (верстки) Р.лейаут папка и имя идентификатора.

        //Скрыть верх (строку состояния)
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initView (); //инициализация с помощью отдельного метода инитвью

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(searchEditText.getText().toString().isEmpty()){
                    FancyToast.makeText(MainActivity.this,"input word", Toast.LENGTH_SHORT,FancyToast.CONFUSING, false).show();
                }else{
                    try {
                        word=jsonUtils.getWordFromJson(URL, searchEditText.getText().toString());

                        if (word.getWord()==null){
                            FancyToast.makeText(MainActivity.this,"No results", Toast.LENGTH_SHORT,FancyToast.ERROR, false).show();
                        } else makeCards(word);

                    } catch (InterruptedException | ExecutionException | JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        });// инициализация с помощью отдельного метода инитвью
        
    }

    private void makeCards(Word word) {
        adapter = new CardsAdapter(word.getDifinition());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initView() { // инициализация отдельных класов
        recyclerView=findViewById(R.id.rv);
        searchEditText=findViewById(R.id.searchTxt);
        searchBtn=findViewById(R.id.seartBtn);

    }


}
