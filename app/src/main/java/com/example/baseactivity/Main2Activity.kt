package com.example.baseactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Main2Activity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        setScreenTitle("Manoj")
    }
}
