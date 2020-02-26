package dev7.id.pluginappsclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout

class EditProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        //load animation
        val stb = AnimationUtils.loadAnimation(this,
            R.anim.stb)
        // action
        val test = findViewById(R.id.test) as LinearLayout
        val avatar = findViewById(R.id.avatar) as ImageView
        // start animation
        test.startAnimation(stb)
        avatar.startAnimation(stb)
    }
}
