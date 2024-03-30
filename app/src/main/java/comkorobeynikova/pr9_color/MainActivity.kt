package comkorobeynikova.pr9_color

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AlertDialog
import comkorobeynikova.pr9_color.databinding.ActivityMainBinding
import comkorobeynikova.pr9_color.databinding.ColorpickBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bindings: ColorpickBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindings = ColorpickBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.colorbutton.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        val dialogView = layoutInflater.inflate(R.layout.colorpick, null)
        val dialogBuilder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setTitle("Выберите цвет")

        val dialog = dialogBuilder.show()

        bindings.RED.setOnSeekBarChangeListener (object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                bindings.RR.setText(progress)
            }
        }

        bindings.ok.setOnClickListener {
            val color = Color.rgb(
                bindings.RR.text.toString().toInt(),
                bindings.G.text.toString().toInt(),
                bindings.B.text.toString().toInt()
            )
            binding.colorBg.setBackgroundColor(color)
            dialog.dismiss()
        }

        bindings.cancel.setOnClickListener {
            dialog.dismiss()
        }
    }
}