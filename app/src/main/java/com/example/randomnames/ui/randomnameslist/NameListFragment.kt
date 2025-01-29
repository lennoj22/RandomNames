package com.example.randomnames.ui.randomnameslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.randomnames.R
import com.example.randomnames.contract.NameContract
import com.example.randomnames.databinding.FragmentNameListBinding
import com.example.randomnames.models.Results
import com.example.randomnames.network.Retrofit
import com.example.randomnames.ui.adapter.NameAdapter
import com.example.randomnames.ui.randomnamesdetails.NameDetailsFragment

class NameListFragment : Fragment(), NameContract.View {

    private lateinit var presenter: NamePresenter
    private var fragmentNameListBinding: FragmentNameListBinding? = null
    private val binding get() = fragmentNameListBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        fragmentNameListBinding = FragmentNameListBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        binding.swipeRefreshLayout.setOnRefreshListener {
            presenter.fetchUsers()
        }

        presenter = NamePresenter(this, Retrofit.apiService)
        presenter.fetchUsers()

        return binding.root
    }

    override fun showUsers(users: List<Results>) {
        binding.recyclerView.adapter = NameAdapter(users) { user ->
            val fragment = NameDetailsFragment()
            val bundle = Bundle()
            bundle.putSerializable("user", user)
            fragment.arguments = bundle

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }

        binding.swipeRefreshLayout.isRefreshing = false
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        binding.swipeRefreshLayout.isRefreshing = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentNameListBinding = null
    }
}
