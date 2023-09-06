package com.emha.mybroadcastreceiver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emha.mybroadcastreceiver.databinding.ActivitySmsReceiverBinding

class SmsReceiverActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_SMS_NO = "extra_sms_no"
        const val EXTRA_SMS_MESSAGE = "extra_sms_message"
    }

    private lateinit var binding: ActivitySmsReceiverBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySmsReceiverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = getString(R.string.incoming_message)

        binding.btnClose.setOnClickListener {
            finish()
        }

        val senderNo = intent.getStringExtra(EXTRA_SMS_NO)
        val senderMessage = intent.getStringExtra(EXTRA_SMS_MESSAGE)

        binding.tvForm.text = getString(R.string.from, senderNo)
        binding.tvMessage.text = senderMessage
    }
}