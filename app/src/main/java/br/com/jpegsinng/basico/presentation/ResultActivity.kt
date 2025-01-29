package br.com.jpegsinng.basico.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.jpegsinng.basico.R
import br.com.jpegsinng.basico.databinding.ActivityResultBinding
import br.com.jpegsinng.basico.domain.Client
import br.com.jpegsinng.basico.domain.Person

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nome = intent.getStringExtra("nome")
        val idade = intent.getIntExtra("idade", -1)
        val client = intent.getParcelableExtra<Client>("client")
        val person = intent.getSerializableExtra("person") as Person?
        binding.textMessage.text = if (client != null) {
            getString(R.string.result_screen_text1, client.name, client.codigo)
        } else if (person != null) {
            getString(R.string.result_screen_text2, person.name, person.age)
        } else {
            getString(R.string.result_screen_text2, nome, idade)
        }
    }
}
