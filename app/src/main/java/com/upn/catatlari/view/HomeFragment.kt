package com.upn.catatlari.view

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.upn.catatlari.databinding.FragmentHomeBinding
import com.upn.catatlari.model.Run
import com.upn.catatlari.viewmodel.RunViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val runViewModel: RunViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val user = (activity as MainActivity).user
        binding.welcomingTxt.text = "Halo, ${user?.email}"

        binding.floatingBtnAddRun.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.Companion.actionHomeFragmentToAddRunFragment())
        }

        val runAdapter = RunAdapter(
            onDeleteClick = { position ->
                runViewModel.deleteRun(position)
            },
            onEditClick = { position, run ->

                val layout = LinearLayout(requireContext())
                layout.orientation = LinearLayout.VERTICAL
                layout.setPadding(50, 40, 50, 10)

                val lblDate = TextView(requireContext())
                lblDate.text = "Tanggal Lari"

                val etDate = EditText(requireContext())
                etDate.hint = "Masukkan tanggal"
                etDate.setText(run.runDate)

                val lblDistance = TextView(requireContext())
                lblDistance.text = "Jarak (Meter)"

                val etDistance = EditText(requireContext())
                etDistance.hint = "Masukkan jarak"
                etDistance.setText(run.runDistance.toString())

                val lblDuration = TextView(requireContext())
                lblDuration.text = "Durasi (Menit)"

                val etDuration = EditText(requireContext())
                etDuration.hint = "Masukkan durasi"
                etDuration.setText(run.runDuration.toString())

                layout.addView(lblDate)
                layout.addView(etDate)

                layout.addView(lblDistance)
                layout.addView(etDistance)

                layout.addView(lblDuration)
                layout.addView(etDuration)

                AlertDialog.Builder(requireContext())
                    .setTitle("Edit Data Lari")
                    .setView(layout)
                    .setPositiveButton("Simpan") { _, _ ->

                        val updatedRun = Run(
                            runDate = etDate.text.toString(),
                            runDistance = etDistance.text.toString().toInt(),
                            runDuration = etDuration.text.toString().toInt()
                        )

                        runViewModel.updateRun(position, updatedRun)
                    }
                    .setNegativeButton("Batal", null)
                    .show()
            }
        )

        binding.rvRunList.layoutManager = LinearLayoutManager(requireContext())

        runViewModel.runHistory.observe(viewLifecycleOwner) { runList ->
            runAdapter.setData(runList)
        }

        binding.rvRunList.adapter = runAdapter

        return binding.root
    }
}