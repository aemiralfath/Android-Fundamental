package com.aemiralfath.mytestingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import com.aemiralfath.mytestingapp.databinding.ActivityMainBinding
import com.bumptech.glide.Glide
import java.lang.StringBuilder

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    private var names = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this).load(R.drawable.fronalpstock_big).into(binding.imgPreview)
        binding.btnSetValue.setOnClickListener(this)

        names.add("Emir")
        names.add("Kevin")
        names.add("Cahyo")
    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btn_set_value) {
            Log.d("MainActivity", names.toString())
            val name = StringBuilder()
            for (i in names.indices) {
                name.append(names[i]).append("\n")
            }
            binding.tvText.text = name.toString()
        }
    }
}