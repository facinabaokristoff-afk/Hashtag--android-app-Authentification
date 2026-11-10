
package com.example.facinabao

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        val btnGetStarted = findViewById<Button>(R.id.btnGetStarted)
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        val btnAbout = findViewById<Button>(R.id.btnAbout)

        // Get Started Button
        btnGetStarted.setOnClickListener {

            Toast.makeText(
                this,
                "Secure Space Active!",
                Toast.LENGTH_SHORT
            ).show()
        }

        // Logout Button
        btnLogout.setOnClickListener {

            auth.signOut()

            Toast.makeText(
                this,
                "Logged out successfully",
                Toast.LENGTH_SHORT
            ).show()

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }


        btnAbout.setOnClickListener {

            Toast.makeText(
                this,
                "HASH • Secure Data Management",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onStart() {
        super.onStart()

        if (::auth.isInitialized && auth.currentUser == null) {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
