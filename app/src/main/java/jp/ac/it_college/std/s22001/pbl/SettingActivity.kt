package jp.ac.it_college.std.s22001.pbl

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import jp.ac.it_college.std.s22001.pbl.databinding.ActivitySettingBinding
import java.util.Calendar

class SettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding

    lateinit var datePickerDialog: DatePickerDialog

    var week_name = arrayOf(
        "（日）", "（月）", "（火）", "（水）",
        "（木）", "（金）", "（土）"
    )
    //日付設定時のリスナ登録
    val dateSetListener =
        DatePickerDialog.OnDateSetListener { datePicker, year, monthOfYear, dayOfMonth ->
            val cal = Calendar.getInstance()
            cal.set(year, monthOfYear, dayOfMonth);
            var _weekInt = cal.get(Calendar.DAY_OF_WEEK) - 1
            var _monthOfYear = monthOfYear + 1
            binding.textView.setText("$year 年 $_monthOfYear 月 $dayOfMonth 日" + week_name[_weekInt])
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listener = HelloListener()

        binding.checkBox.setOnClickListener(listener)

        // 戻るボタンをタップしたときの処理
        binding.button3.setOnClickListener {
            finish()
        }
        //日付を選択するカレンダーを表示
        binding.button4.setOnClickListener {
            //日付情報の初期設定
            val calendar: Calendar = Calendar.getInstance()
            val year: Int = calendar.get(Calendar.YEAR)
            val monthOfYear: Int = calendar.get(Calendar.MONTH)
            val dayOfMonth: Int = calendar.get(Calendar.DAY_OF_MONTH)

            //日付設定ダイアログの作成
            datePickerDialog =
                DatePickerDialog(this, dateSetListener, year, monthOfYear, dayOfMonth)

            //日付設定ダイアログの表示
            datePickerDialog.show()
        }
    }

    private inner class HelloListener : View.OnClickListener {
        override fun onClick(v: View?) {
            val input = findViewById<EditText>(R.id.etName)

            val output = findViewById<TextView>(R.id.tvOutput)

            val inputStr = input.text.toString()

//            output.text = "${inputStr}"

        }
    }

//    class showDialogFragment() : DialogFragment() {
//        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//            val dialog = Dialog((activity as Context?)!!)
//            // タイトル非表示
//            dialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
//            // フルスクリーン
//            dialog.window!!.setFlags(
//                WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
//            )
//            dialog.setContentView(R.layout.activity_setting)
//            return dialog
//        }
//    }
}