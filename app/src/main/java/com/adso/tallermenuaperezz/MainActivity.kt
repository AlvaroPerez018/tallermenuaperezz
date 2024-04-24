package com.adso.tallermenuaperezz

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.adso.tallermenuaperezz.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.game_menu, menu)
        return true

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        registerForContextMenu(textView)

        binding.textView2.setOnClickListener {
            val popup = PopupMenu(this, it)
            menuInflater.inflate(R.menu.poup_menu, popup.menu)

            popup.show()
            popup.setOnMenuItemClickListener(::manageItemClick)

        }
    }
    private fun manageItemClick(menuItem: MenuItem?): Boolean {
        return when (menuItem?.itemId) {
            R.id.action_delete -> {
                Toast.makeText( this, "eliminar", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_edit -> {
                Toast.makeText(this, "editar", Toast.LENGTH_SHORT).show()
                true
            }
            else -> false
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_settings -> {
                true
            }

            R.id.item_logout -> {
                true
            }

            else -> super.onContextItemSelected(item)
        }

    }


}






