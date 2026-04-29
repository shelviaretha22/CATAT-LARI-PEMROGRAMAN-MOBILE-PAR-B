package com.upn.catatlari.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.upn.catatlari.databinding.FragmentRegisterBinding
import com.upn.catatlari.model.User

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonRegister.setOnClickListener {

            val nama = binding.etNameSignup.text.toString()
            val email = binding.etEmailSignup.text.toString()
            val password = binding.etPasswordSignup.text.toString()
            val retypePassword = binding.etRetypePasswordSignup.text.toString()

            if (nama.isEmpty() || email.isEmpty() || password.isEmpty() || retypePassword.isEmpty()) {
                Toast.makeText(requireContext(), "Semua data wajib diisi", Toast.LENGTH_SHORT).show()
            } else if (password != retypePassword) {
                Toast.makeText(requireContext(), "Password tidak sama", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Registrasi berhasil", Toast.LENGTH_SHORT).show()

                val intent = Intent(requireContext(), MainActivity::class.java)
                intent.putExtra("user", User(email = email, password = password))
                startActivity(intent)
                requireActivity().finish()
            }
        }
    }

}