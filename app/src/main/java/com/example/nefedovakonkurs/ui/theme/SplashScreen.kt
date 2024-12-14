package com.example.nefedovakonkurs.ui.theme

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.nefedovakonkurs.MainActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Создаем экран с текстом "MATULE ME"
        val textView = TextView(this).apply {
            text = "MATULE ME"
            textSize = 36f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }

        // Устанавливаем этот экран как содержимое активности
        setContentView(textView)

        // Через 1 секунду переход на MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()  // Закрываем SplashScreen после перехода
        }, 1000)  // Задержка 1 секунда
    }
}