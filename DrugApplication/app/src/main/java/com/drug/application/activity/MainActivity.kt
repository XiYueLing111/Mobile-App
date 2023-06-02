package com.drug.application.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu

import com.drug.application.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        menu_img.setOnClickListener {
            val popupMenu = PopupMenu(this, it)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId){
                    R.id.edit_profile -> {
                        startActivity(Intent(this,EditProfileActivity::class.java))
                        true
                    }
                    R.id.about_this_app -> {
                        startActivity(Intent(this,AboutActivity::class.java))
                        true
                    }
                    R.id.log_out -> {
                        val intent = Intent(this,LoginActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        startActivity(Intent(intent))
                        finish()
                        true
                    }
                    else -> false
                }
            }
            popupMenu.inflate(R.menu.menu_main)
            try {
                val fieldMPopup = PopupMenu::class.java.getDeclaredField("mPopup")
                fieldMPopup.isAccessible = true
                val mPopup = fieldMPopup.get(popupMenu)
                mPopup.javaClass
                    .getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                    .invoke(mPopup, true)
            } catch (e: Exception){
            } finally {
                popupMenu.show()
            }
        }



        knox_wing_drugs_room.setOnClickListener {
            startActivity(Intent(this,KnoxWDRActivity::class.java))


        }



        check_historty.setOnClickListener {

            startActivity(Intent(this,CheckHistoryActivity::class.java))

        }
    }


}