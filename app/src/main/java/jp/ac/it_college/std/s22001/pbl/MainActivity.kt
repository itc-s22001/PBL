package jp.ac.it_college.std.s22001.pbl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import jp.ac.it_college.std.s22001.pbl.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("SoundScreen", "Sub onCreate() called.")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btSound.setOnClickListener(::onNextClick)
    }

    override fun onStart() {
        Log.i("SoundScreen", "Sub onStart() called.")
        super.onStart()
    }

    override fun onRestart() {
        Log.i("SoundScreen", "Sub onRestart() called.")
        super.onRestart()
    }

    override fun onResume() {
        Log.i("SoundScreen", "Sub onResume() called.")
        super.onResume()
    }

    override fun onPause() {
        Log.i("SoundScreen", "Sub onPause() called.")
        super.onPause()
    }

    override fun onStop() {
        Log.i("SoundScreen", "Sub onStop() called.")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i("SoundScreen", "Sub onDestroy() called.")
        super.onDestroy()
    }

    private fun onNextClick(view: View) {
        val intent = Intent(this, SoundScreen::class.java)
        startActivity(intent)
    }
}
