package com.example.lab5


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.lab5.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {

    private lateinit var binding: FragmentTitleBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_title,
            container,
            false
        )
        viewModel = activity?.run {
            ViewModelProviders.of(this).get(MainViewModel::class.java)
        } ?: throw Exception("HOOLA")
        /*viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)*/
        binding.floatingActionButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_titleFragment_to_optionFragment)
        }
        binding.button2.setOnClickListener{
            it.findNavController().navigate(R.id.action_titleFragment_to_agregarPregunta)
        }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_principal, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId)
        {
            R.id.titleFragment ->  {
            findNavController().navigate(R.id.action_titleFragment_to_acercaDe)
            }
        }
        return super.onOptionsItemSelected(item)
    }








}
