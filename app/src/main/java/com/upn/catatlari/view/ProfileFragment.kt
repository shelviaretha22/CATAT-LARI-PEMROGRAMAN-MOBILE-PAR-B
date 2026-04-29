package com.upn.catatlari.view

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.upn.catatlari.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        val user = (activity as MainActivity).user

        binding.txtNameProfile.text = "User"
        binding.txtEmailProfile.text = user?.email

        binding.btnEditProfile.setOnClickListener {

            val inputName = EditText(requireContext())
            inputName.setText(binding.txtNameProfile.text.toString())

            AlertDialog.Builder(requireContext())
                .setTitle("Edit Nama")
                .setView(inputName)
                .setPositiveButton("Simpan") { _, _ ->
                    binding.txtNameProfile.text = inputName.text.toString()
                }
                .setNegativeButton("Batal", null)
                .show()
        }

        binding.btnLogout.setOnClickListener { requireActivity().finish() }

        return binding.root
    }

}