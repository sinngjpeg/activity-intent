package br.com.jpegsinng.basico.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.jpegsinng.basico.databinding.ActivityMainBinding
import br.com.jpegsinng.basico.domain.Client
import br.com.jpegsinng.basico.domain.Person

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editText = binding.editText
        val buttonToast = binding.buttonToast
        buttonToast.setOnClickListener {
            val texto = editText.text.toString()
            Toast.makeText(this, texto, Toast.LENGTH_SHORT).show()
        }

        val buttonTela = binding.ButtonTela
        buttonTela.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("nome", "Ingrid")
            intent.putExtra("idade", 29)
            startActivity(intent)
        }

        val buttonParcel = binding.buttonParcel
        buttonParcel.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            val client = Client(1, "Ingrid")
            intent.putExtra("client", client)
            startActivity(intent)
        }

        val buttonSerializable = binding.buttonSerializable
        buttonSerializable.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            val person = Person("Ingrid", 29)
            intent.putExtra("person", person)
            startActivity(intent)
        }
    }
}