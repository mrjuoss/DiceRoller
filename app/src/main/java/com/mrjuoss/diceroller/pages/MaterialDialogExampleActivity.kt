package com.mrjuoss.diceroller.pages

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.mrjuoss.diceroller.R
import kotlinx.android.synthetic.main.activity_material_dialog_example.*

class MaterialDialogExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_dialog_example)
    }

    private fun setupDemo() {
        success_toast.setOnClickListener {
            displayToast("You successfully did that thing")
        }

        error_toast.setOnClickListener {
            displayToast("Something went wrong...")
        }

        success_dialog.setOnClickListener {
            displaySuccessDialog("You Successfully")
        }

        error_dialog.setOnClickListener {
            displayErrorDialog("Ada Error")
        }

        are_you_sure.setOnClickListener {
            val areYouSureCallback = object : AreYouSureCallback {
                override fun proceed() {
                    displayToast("Success Bro")
                }

                override fun cancel() {
                    displayToast("Cancel Bro")
                }
            }

            areYouSureDialog("Are you sure want to do that ? this can't be un-done..", areYouSureCallback)
        }
    }

    fun displayToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun displaySuccessDialog(message: String?) {
        MaterialDialog(this).show {
            title(R.string.text_success)
            message(text = message)
            positiveButton(R.string.text_ok)
        }
    }

    fun displayErrorDialog(message: String?) {
        MaterialDialog(this).show {
            title(R.string.text_error)
            message(text = message)
            positiveButton(R.string.text_ok)
        }
    }

    fun areYouSureDialog(message: String, callback: AreYouSureCallback) {
        MaterialDialog(this)
            .show {
                title(R.string.are_you_sure)
                message(text = message)
                negativeButton(R.string.text_cancel) {
                    callback.cancel()
                }
                positiveButton(R.string.text_yes) {
                    callback.proceed()
                }
            }
    }

    interface AreYouSureCallback {
        fun proceed()
        fun cancel()
    }
}
