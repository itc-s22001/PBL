package jp.ac.it_college.std.s22001.pbl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.switchmaterial.SwitchMaterial
import jp.ac.it_college.std.s22001.pbl.databinding.ActivityMainBinding

import android.view.View
import androidx.fragment.app.DialogFragment\

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val nextButton = findViewById<FloatingActionButton>(R.id.nextButton)  //--------


        //recyclerViewの要素を押したら AaaActivity に飛ぶ
        binding.lvMenu.apply {
            adapter = MenuListAdapter(menuList) { name ->
                val intentSetting = Intent(
                    this@MainActivity,
                    SettingActivity::class.java
                )
                intentSetting.putExtra("menuName", name)

                startActivity(intentSetting)
            }
            LinearLayoutManager(this@MainActivity).let {
                layoutManager = it
                addItemDecoration(DividerItemDecoration(this@MainActivity, it.orientation))
            }
        }

        //BtnNext ボタン押したらSettingに飛ぶ

        nextButton.setOnClickListener {
            val intent = Intent(this, AaaActivity::class.java)

            startActivity(intent)
        }
    }
}