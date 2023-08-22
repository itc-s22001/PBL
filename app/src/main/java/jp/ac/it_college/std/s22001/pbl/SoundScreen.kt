package jp.ac.it_college.std.s22001.pbl

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import jp.ac.it_college.std.s22001.pbl.databinding.ActivitySoundScreenBinding
import java.io.IOException

class SoundScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySoundScreenBinding
    private var _player: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("SoundScreen", "Sub onCreate() called.")
        super.onCreate(savedInstanceState)
        binding = ActivitySoundScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvLavelInput.setOnClickListener(::onPreviousClick)

        // フィールドのメディアプレーヤーオブジェクトを生成
        _player = MediaPlayer()
        // 音声ファイルのURI文字列を作成
        val mediaFileUriStr = "android.resource://${packageName}/${R.raw.alarm1}"
        // 音声ファイルのURI文字列を元にURIオブジェクトを生成
        val mediaFieldUri = Uri.parse(mediaFileUriStr)

        try {
            //メディアプレーヤーに音声ファイルを指定
            _player?.setDataSource(applicationContext, mediaFieldUri)
            //非同期でのメディア再生準備が完了した際のリスナを設定
            _player?.setOnPreparedListener(PlayerPreparedLister())
            //メディア再生が終了した際のリスナ設定
            _player?.setOnCompletionListener(PlayerCompletionLister())
            //非同期でメディア再生準備
            _player?.prepareAsync()
        }
        catch (ex: IllegalAccessException) {
            Log.e("Alarm_SoundScreen", "メディアプレーヤー準備時の例外発生", ex)
        }
        catch (ex: IOException) {
            Log.e("Alarm_SoundScreen", "メディアプレーヤー準備時の例外発生", ex)
        }
    }

    //再生準備ができたときのリスナクラス
    private inner class PlayerPreparedLister : MediaPlayer.OnPreparedListener {
        override fun onPrepared(p0: MediaPlayer?) {
           //再生準備ができたら再生開始
            AlarmStart()
        }
    }
    //再生が終了したときのリスなクラス
    private inner class PlayerCompletionLister : MediaPlayer.OnCompletionListener {
        override fun onCompletion(p0: MediaPlayer?) {
            //再生が終了したときの処理を書く

        }
    }
    //再生開始
    fun AlarmStart() {
        //フィールドのプレーヤーがnullじゃなかったら
        _player?.let {
            //プレーヤーが再生中でないなら再生開始
            if(!it.isPlaying) {
                //ループ設定する
                it.isLooping = true
                //再生開始
                it.start()
            }
        }
    }

    //停止
    fun OnAlarmStop(view: View) {
        //フィールドのプレーヤーがnullじゃなかったら
        _player?.let{
            //プレーヤーが再生中の場合
            if(it.isPlaying) {
                //再生停止
                it.stop()
            }
            //プレーヤーを開放
            it.release()
            //プレーヤー用フィールドをnull
            _player = null
        }
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

    private fun onPreviousClick(view: View) {
        finish()
    }
}