package com.example.a6repaso

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.a6repaso.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //cambiar el texto del boton al pulsarlo
        binding.button.setOnClickListener {
            if(binding.name.visibility == View.INVISIBLE){
                binding.name.visibility = View.VISIBLE
                binding.button.text = "FINALIZAR"
            }else{
                binding.name.visibility = View.INVISIBLE
                binding.button.text = "COMENZAR"
            }
        }

        binding.name.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus){
                binding.name.hint = ""
            }else{
                binding.name.hint = "Introduce tu nombre"
            }
        }


        binding.name.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // TODO Auto-generated method stub
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                if (binding.name.text.contains("Wayne")) {
                    binding.batman.visibility = View.VISIBLE
                    binding.joker.visibility = View.INVISIBLE
                    binding.root.setBackgroundColor(Color.parseColor("#ffffff"))
                    binding.button.setTextColor(Color.parseColor("#ffffff"))
                    binding.button.setBackgroundColor(Color.parseColor("#000000"))
                    binding.name.setTextColor(Color.parseColor("#000000"))
                    binding.name.setHintTextColor(Color.parseColor("#ffffff"))
                    binding.name.setBackgroundColor(Color.parseColor("#ffffff"))

                }else if(binding.name.text.contains("Joker")){
                    binding.batman.visibility = View.INVISIBLE
                    binding.joker.visibility = View.VISIBLE
                    binding.root.setBackgroundColor(Color.parseColor("#000000"))
                    binding.button.setTextColor(Color.parseColor("#982bff"))
                    binding.button.setBackgroundColor(Color.parseColor("#7eff00"))
                    binding.name.setTextColor(Color.parseColor("#7eff00"))
                    binding.name.setHintTextColor(Color.parseColor("#ffffff"))
                    binding.name.setBackgroundColor(Color.parseColor("#982bff"))
                }

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })


}
}