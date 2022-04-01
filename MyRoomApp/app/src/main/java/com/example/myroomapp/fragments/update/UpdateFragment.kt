package com.example.myroomapp.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myroomapp.R
import com.example.myroomapp.databinding.FragmentListBinding
import com.example.myroomapp.databinding.FragmentUpdateBinding
import com.example.myroomapp.fragments.model.User
import com.example.myroomapp.viewmodel.UserViewModel


class UpdateFragment : Fragment() {

    lateinit var binding: FragmentUpdateBinding
    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.updateTextTextPersonName.setText(args.currentUser.firstName)
        binding.updateTextTextPersonName2.setText(args.currentUser.lastName)
        binding.updateTextTextPersonName3.setText(args.currentUser.age.toString())

        binding.buttonUpdate.setOnClickListener {
            updateItem()
        }

        //Add Menu
        setHasOptionsMenu(true)
    }

    private fun updateItem() {
        val firstName = binding.updateTextTextPersonName.text.toString()
        val lastName = binding.updateTextTextPersonName2.text.toString()
        val age = Integer.parseInt(binding.updateTextTextPersonName3.text.toString())

        if (inputCheck(firstName, lastName, binding.updateTextTextPersonName3.text)) {
            val updateUser = User(args.currentUser.id, firstName, lastName, age)
            mUserViewModel.updateUser(updateUser)
            Toast.makeText(requireContext(), "Done Updated", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all field", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mUserViewModel.deleteUser(args.currentUser)
            Toast.makeText(requireContext(), "Successfully removed", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete ${args.currentUser.firstName}?")
        builder.setMessage("Are you sure you want to delete ${args.currentUser.firstName}?")
        builder.create().show()
    }
}