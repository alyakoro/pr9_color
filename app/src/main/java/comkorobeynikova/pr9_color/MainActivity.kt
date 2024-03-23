package comkorobeynikova.pr9_color

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import comkorobeynikova.pr9_color.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
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

        dialogView.buttonOk.setOnClickListen
    }
}