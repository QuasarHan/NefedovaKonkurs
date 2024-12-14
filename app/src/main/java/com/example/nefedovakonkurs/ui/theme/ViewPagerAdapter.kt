package com.example.nefedovakonkurs.ui.theme

import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.nefedovakonkurs.R

class ViewPagerAdapter(
    private val viewPager: ViewPager2
) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    private val screens = listOf(
        ScreenData(
            "Добро пожаловать",  // Название для второго экрана
            R.drawable.group_1000000797,  // Здесь укажите правильный ресурс изображения
            "Начать",  // Кнопка на втором экране
            "#2196F3"  // Цвет фона
        ),
        ScreenData(
            "Начнем путешествие",
            R.drawable.spring_prev_ui_1,
            "Далее",
            "#2196F3"
        ),
        ScreenData(
            "У вас есть сила, чтобы изменить мир",
            R.drawable.group_1000000799,
            "Завершить",
            "#2196F3"
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LinearLayout(parent.context).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val screen = screens[position]
        val context = holder.itemView.context

        val layout = holder.itemView as LinearLayout
        layout.removeAllViews()

        layout.setBackgroundColor(android.graphics.Color.parseColor(screen.backgroundColor))

        val imageView = ImageView(context).apply {
            setImageResource(screen.imageRes)
            layoutParams = LinearLayout.LayoutParams(300, 300).apply {
                gravity = Gravity.CENTER
            }
        }

        val textView = TextView(context).apply {
            text = screen.title
            textSize = 24f
            gravity = Gravity.CENTER
            setTextColor(android.graphics.Color.WHITE)
        }

        val button = Button(context).apply {
            text = screen.buttonText
            setOnClickListener {
                if (position < screens.size - 1) {
                    viewPager.currentItem = position + 1
                } else {
                    // Логика завершения
                }
            }
        }

        layout.addView(imageView)
        layout.addView(textView)
        layout.addView(button)
    }

    override fun getItemCount(): Int = screens.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    data class ScreenData(
        val title: String,
        val imageRes: Int,
        val buttonText: String,
        val backgroundColor: String
    )
}