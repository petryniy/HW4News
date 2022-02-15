package selitskiyapp.hometasks.hw4news.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import selitskiyapp.hometasks.hw4news.R
import selitskiyapp.hometasks.hw4news.databinding.FragmentNewsNetworkBinding
import selitskiyapp.hometasks.hw4news.domain.OnNewsClickListener
import selitskiyapp.hometasks.hw4news.presentation.recyclershared.NewsAdapter
import selitskiyapp.hometasks.hw4news.presentation.viewmodels.NewsSharedViewModel

class NewsNetworkFragment : Fragment(R.layout.fragment_news_network) {
    private val binding: FragmentNewsNetworkBinding
            by viewBinding(FragmentNewsNetworkBinding::bind)
    private val sharedViewModel: NewsSharedViewModel by sharedViewModel()
    private val adapter by lazy { NewsAdapter(newsClickListener) }

    private val newsClickListener: OnNewsClickListener = object : OnNewsClickListener {
        override fun onIconClickListener(position: Int) {
            sharedViewModel.onNewsItemClicked(position)

            if (sharedViewModel.news.value!![position].isChecked) {
                sharedViewModel.saveNews(sharedViewModel.news.value!![position])
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news_network, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()

        initObservers()

        sharedViewModel.loadNetworkNews()
    }

    private fun initObservers() {
        sharedViewModel.news.observe(viewLifecycleOwner) { news ->
            adapter.submitList(news)
        }
    }

    private fun initRecycler() {
        binding.recycler.adapter = adapter
    }
}