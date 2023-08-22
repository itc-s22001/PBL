package jp.ac.it_college.std.s22001.pbl

import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.switchmaterial.SwitchMaterial
import jp.ac.it_college.std.s22001.pbl.databinding.MenuRowBinding

class MenuListAdapter(private val data: List<Menu>, private val callback: (String) -> Unit) :
    RecyclerView.Adapter<MenuListAdapter.ViewHolder>() {

    class ViewHolder(val binding: MenuRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ViewHolder = ViewHolder(
        MenuRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun getItemCount(): Int = data.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val menu = data[position]
//        val switchMaterial = findViewById<SwitchMaterial>(R.id.switchMaterial)
        holder.binding.apply {
            tvName.text = menu.name
            root.setOnClickListener {
                callback(menu.name)
            }
            showPopupButton.setOnClickListener {
                val popup = PopupMenu(it.context, it)
                val inflater: MenuInflater = popup.menuInflater
                inflater.inflate(R.menu.menu_items, popup.menu)
                popup.show()
            }
            switchMaterial.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    println("SwitchMaterialがONになったでーーーーー")
                    // メソッドの場所を指定してメソッド呼び出し
                    //　ここでアラーム鳴らす？　それでアラーム停止画面に遷移させる？
                    // アラーム停止画面の方でやっている?

                    // 明日やること　ー＞　アラームをどう鳴らすか・どう画面遷移させるか
                } else {
                    println("SwitchMaterialがOFFになったでーーーーー")
                    // isCheckedがfalseだったら何もしない
                    // ここは何もしなくて良いんじゃないかな？コードとか
                }
            }
        }

    }

}