package com.example.nefedovakonkurs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.nefedovakonkurs.ui.theme.ViewPagerAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Создаем ViewPager2
        val viewPager = ViewPager2(this)

        // Устанавливаем ViewPager2 как содержимое активности
        setContentView(viewPager)

        // Устанавливаем адаптер для ViewPager2
        viewPager.adapter = ViewPagerAdapter(viewPager)
    }
}