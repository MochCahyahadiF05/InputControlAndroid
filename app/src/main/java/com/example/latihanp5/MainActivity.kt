package com.example.latihanp5

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnDatePicker = findViewById<Button>(R.id.date_picker)
        val selectedDate = findViewById<TextView>(R.id.selectedDate)
        val btnShowAlert = findViewById<Button>(R.id.btn_showAlert)
        val phoneNumber = findViewById<EditText>(R.id.phoneNumber)
        val submitPhone = findViewById<Button>(R.id.btnSubmitPhone)

        btnDatePicker.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    selectedDate.text = "Tanggal dipilih: $date"
                },
                year, month, day)

            datePickerDialog.show()
        }
        btnShowAlert.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)
                .setTitle("Peringatan")
                .setMessage("Ini adalah alert dialog.")
                .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                .create()
            alertDialog.show()
        }
        submitPhone.setOnClickListener {
            val phone = phoneNumber.text.toString()
            if (phone.isNotEmpty()) {
                Toast.makeText(this, "Nomor HP: $phone", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Masukkan nomor HP terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }
    }
}