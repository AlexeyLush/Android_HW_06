package kz.step.android_hw_06

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.widget.Button
import android.widget.EditText
import java.util.*

class MainActivity : AppCompatActivity() {

    var textSpech: EditText? = null
    var button: Button? = null

    val spechRecongizer = SpeechRecognizer.createSpeechRecognizer(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
    }

    fun initializeViews(){
        textSpech = findViewById(R.id.editText_spech)
        button = findViewById(R.id.button)
    }

    fun initializeListeners(){
        button?.setOnClickListener{
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())

        }
    }
    fun onResults(bundle: Bundle) {
        val data = bundle.getStringArray(SpeechRecognizer.RESULTS_RECOGNITION)
        textSpech?.setText(data?.get(0))
    }

}