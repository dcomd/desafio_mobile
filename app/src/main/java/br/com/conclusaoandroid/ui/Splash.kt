package br.com.conclusaoandroid.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.content.ContextCompat
import br.com.conclusaoandroid.R
import com.google.firebase.auth.FirebaseAuth

class Splash : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()
        window.statusBarColor = ContextCompat.getColor(baseContext, R.color.splash_screen)

        auth = FirebaseAuth.getInstance()
        Handler(Looper.getMainLooper()).postDelayed({
            onDelayedAction()
        }, 3000)
    }

    private fun onDelayedAction() {
        val currentUser = auth.currentUser
        val targetActivity = if (currentUser != null) Mapsctivity::class.java else Login::class.java
        startTargetActivity(targetActivity)
    }

    private fun startTargetActivity(activity: Class<out AppCompatActivity>) {
        val intent = Intent(this, activity)
        startActivity(intent)
        finish()
    }
}
