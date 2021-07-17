package com.aemiralfath.myintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.aemiralfath.myintentapp.databinding.ActivityMoveForResultBinding

class MoveForResultActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMoveForResultBinding

    companion object{
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoveForResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChoose.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btn_choose) {
            if (binding.rgNumber.checkedRadioButtonId > 0) {
                val value = when (binding.rgNumber.checkedRadioButtonId) {
                    R.id.rb_50 -> 50
                    R.id.rb_100 -> 100
                    R.id.rb_150 -> 150
                    R.id.rb_200 -> 200
                    else -> 0
                }

                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }
    }
}